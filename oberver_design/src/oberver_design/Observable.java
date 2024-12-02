package oberver_design;

public interface Observable {
	
	public void updateStock(int count);

	public void removeNotifyMe();

	public void notifyMe();
	
	public void addNotifyMe(Observer ob);

}
