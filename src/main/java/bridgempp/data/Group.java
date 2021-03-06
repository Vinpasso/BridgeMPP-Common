/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgempp.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Version;

/**
 *
 * @author Vinpasso
 */
@Entity(name = "CHANNEL")
public class Group
{

	@Id
	@Column(name = "CHANNEL_NAME", nullable = false, length = 50)
	private String name;

	@ManyToMany
	@JoinTable(name = "SUBSCRIPTIONS", joinColumns = @JoinColumn(name = "CHANNEL_NAME", referencedColumnName = "CHANNEL_NAME"), inverseJoinColumns = @JoinColumn(name = "IDENTIFIER", referencedColumnName = "IDENTIFIER"))
	private Collection<Endpoint> endpoints;

	@Version
	@Column(name = "VERSION", nullable = false)
	private long version;

	/**
	 * Add a user/group to this groups recipients
	 * BI-DIRECTIONAL
	 * @param endpoint The endpoint to add to a Group
	 */
	public void addEndpoint(Endpoint endpoint)
	{
		getEndpoints().add(endpoint);
		endpoint.addGroupNonBidirectional(this);
	}

	// 
	/**
	 * Remove a user/group from this groups recipients
	 * BI-DIRECTIONAL
	 * @param endpoint The endpoint to remove from a Group
	 */
	public void removeEndpoint(Endpoint endpoint)
	{
		getEndpoints().remove(endpoint);
		endpoint.removeGroupNonBidirectional(this);
	}

	
	/**
	 * Remove all endpoints in preperation for Group destruction
	 * BI-DIRECTIONAL
	 */
	public void removeAllEndpoints()
	{
		Iterator<Endpoint> iterator = endpoints.iterator();
		while (iterator.hasNext())
		{
			Endpoint endpoint = iterator.next();
			iterator.remove();
			endpoint.removeGroupNonBidirectional(this);
		}
	}

	public String getName()
	{
		return name;
	}

	
	/**
	 * Initialize the group endpoints
	 * @param name The name of the Group
	 */
	public Group(String name)
	{
		this();
		this.name = name;
	}
	
	/**
	 * JPA Constructor
	 */
	protected Group()
	{
		endpoints = new ArrayList<>();
	}

	public boolean hasEndpoint(Endpoint endpoint)
	{
		return getEndpoints().contains(endpoint);
	}

	@Override
	// Prints out its Members
	public String toString()
	{
		String members = "";
		Iterator<Endpoint> iterator = endpoints.iterator();
		while (iterator.hasNext())
		{
			Endpoint endpoint = iterator.next();
			members += "Endpoint: " + endpoint.toString() + "\n";
			Iterator<User> userIterator = endpoint.getUsers().iterator();
			while (userIterator.hasNext())
			{
				User user = userIterator.next();
				members += "Member: " + user.toString() + "\n";
			}
		}
		return members;
	}

	/**
	 * @return the endpoints
	 */
	public Collection<Endpoint> getEndpoints()
	{
		return endpoints;
	}

}
