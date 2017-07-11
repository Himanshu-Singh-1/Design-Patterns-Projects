package spreadsheetUpdates.observer;
/**
 * 
 * @author Himanshu Singh
 * interface for subject
 */
public interface Subject{
	public void registerListener(Listener o);
	public void removeListener(Listener o);
	public void notifyListener();
}
