package vending_machine;

public class Main {

		public static void main(String[] args) {
	        // Create a new vending machine
	        VendingMachine vendingMachine = new VendingMachine();

	        // Add products to the inventory
	        Product soda = new Product(1, "Soda", 1.50);
	        Product chips = new Product(2, "Chips", 2.00);
	        Product candy = new Product(3, "Candy", 0.75);

	        vendingMachine.getInventory().addProduct(soda, 5);
	        vendingMachine.getInventory().addProduct(chips, 3);
	        vendingMachine.getInventory().addProduct(candy, 10);

	        // Simulate selecting a product and inserting money
	        vendingMachine.selectProduct(1);  // Select "Soda"
	        vendingMachine.insertMoney(1.00); // Insert $1.00
	        vendingMachine.insertMoney(0.50); // Insert $0.50 (total $1.50)

	        // Product should be dispensed automatically after sufficient money is inserted
	        // Now, try to select another product and insert money
	        vendingMachine.selectProduct(2);  // Select "Chips"
	        vendingMachine.insertMoney(2.00); // Insert $2.00 (sufficient amount)

	        // Cancel the transaction before dispensing the product
	        vendingMachine.cancelTransaction();
	    }
		
}
