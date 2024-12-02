package oberver_design;

import java.util.ArrayList;
import java.util.List;

public class mobileObeservable implements Observable {
	List<Observer> obj = new ArrayList<>();

	int stock;

	@Override
	public void updateStock(int count) {
		if (stock == 0) {
			notifyMe();
		}
		stock += count;
		System.out.println("stock added , new count " + stock);
	}

	@Override
	public void removeNotifyMe() {

	}

	@Override
	public void notifyMe() {
		for (Observer o : obj) {
			System.out.println("notification send to ");
			o.addEmail();
		}

	}

	@Override
	public void addNotifyMe(Observer o) {
		obj.add(o);

	}

}
