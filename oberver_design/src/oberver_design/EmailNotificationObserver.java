package oberver_design;

public class EmailNotificationObserver implements Observer {

	private String email;

	EmailNotificationObserver(String email) {
		this.email = email;
	}

	@Override
	public void addEmail() {
		System.out.println(" email added for notification " + email);
	}

}
