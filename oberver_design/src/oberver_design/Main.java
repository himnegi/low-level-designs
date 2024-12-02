package oberver_design;

public class Main {
	public static void main(String[] args) {
		EmailNotificationObserver email= new EmailNotificationObserver("himanshu.negi@abc.com");
		mobileObeservable mobileObj=  new mobileObeservable();
		mobileObj.addNotifyMe(email);
		mobileObj.updateStock(10);
		
	}

}
