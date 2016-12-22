package bridgempp.data;

import java.time.Instant;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import bridgempp.service.BridgeService;

@Entity(name = "TIMEDENDPOINT")
@DiscriminatorValue("TimedEndpoint")
public class TimedEndpoint extends Endpoint {

	@Column(name = "CREATED", nullable = false)
	private Date creationDate;

	@Column(name = "EXPIRE", nullable = false)
	private Date expireDate;

	public TimedEndpoint(BridgeService service, String identifier, long expire,
			TemporalUnit timeUnit) {
		super(service, identifier);
		creationDate = Date.from(Instant.now());
		expireDate = Date.from(creationDate.toInstant().plus(expire, timeUnit));
	}
	
	public boolean checkExpired() {
		return Date.from(Instant.now()).after(expireDate);
	}

}
