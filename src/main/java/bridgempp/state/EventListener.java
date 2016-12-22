package bridgempp.state;

public interface EventListener<T> {
	
	public void onEvent(T eventMessage);
	
}
