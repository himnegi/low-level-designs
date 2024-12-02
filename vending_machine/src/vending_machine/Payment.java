package vending_machine;

public class Payment {
	private double currentBalance;

	public void addMoney(double amount) {
		currentBalance += amount;
	}

	public double getBalance() {
		return currentBalance;
	}

	public double returnChange(double cost) {
		if (currentBalance >= cost) {
			double change = currentBalance - cost;
			currentBalance = 0;
			return change;
		} else {
			return 0;
		}
	}

	public void resetBalance() {
		currentBalance = 0;
	}
}
