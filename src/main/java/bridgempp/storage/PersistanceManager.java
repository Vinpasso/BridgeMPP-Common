package bridgempp.storage;

import java.util.Collection;

public abstract class PersistanceManager
{
	private static PersistanceManager instance;

	public abstract void updateState(Object... objects);
	public abstract void removeState(Object... objects);
	public abstract void shutdown();
	public abstract <T> Collection<T> getQuery(Class<T> className);
	public abstract <T> T getFromPrimaryKey(Class<T> className, Object primaryKey);
	public abstract boolean hasState(Object... objects);
	
	
	public static PersistanceManager getPersistanceManager()
	{
		if(instance == null)
		{
			throw new IllegalStateException("No default PersistanceManager set");
		}
		return instance;
	}
	
	public static void setPersistanceManager(PersistanceManager newInstance)
	{
		if(instance != null)
		{
			throw new IllegalStateException("PersistanceManager already set");
		}
		instance = newInstance;
	}

}
