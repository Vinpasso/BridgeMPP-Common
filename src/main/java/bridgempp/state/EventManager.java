package bridgempp.state;

import java.util.ServiceLoader;

public class EventManager {

	public static <T> void loadEventListenerClass(EventListener<?> eventListener)
	{
		EventSubscribe annotation = eventListener.getClass().getAnnotation(EventSubscribe.class);
		if(annotation == null)
		{
			throw new IllegalArgumentException("Event Listener is missing Event Subscribe Annotation: " + eventListener.getClass().getName());
		}
		for(Event event : annotation.value())
		{
			StateManager.addListener(event, eventListener);
		}
	}
	
	public static <T> void fireEvent(Event event, Object eventParameter)
	{
		StateManager.fireEvent(event, eventParameter);
	}
	
	@SuppressWarnings("rawtypes")
	public static void loadCentralEventSubscribers()
	{
		StateManager.initializeEventSystem();
		
		ServiceLoader<EventListener> loader = ServiceLoader.load(EventListener.class);
		loader.forEach(el -> {
			loadEventListenerClass(el);
		});
	}
}
