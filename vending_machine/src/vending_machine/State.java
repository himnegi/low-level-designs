package vending_machine;

interface State {
    void selectProduct(int productId);
    void insertMoney(double amount);
    void dispenseProduct();
    void cancelTransaction();
}

class ReadyState implements State {
    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(int productId) {
        Product product = vendingMachine.getInventory().getProduct(productId);
        if (product != null && vendingMachine.getInventory().getStock(productId) > 0) {
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(vendingMachine.getHasMoneyState());
            vendingMachine.getDisplay().showMessage("Product selected: " + product.getName() + ". Please insert money.");
        } else {
            vendingMachine.getDisplay().showMessage("Product unavailable.");
        }
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.getDisplay().showMessage("Please select a product first.");
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.getDisplay().showMessage("Please select a product first.");
    }

    @Override
    public void cancelTransaction() {
        vendingMachine.getDisplay().showMessage("No transaction to cancel.");
    }
}

class HasMoneyState implements State {
    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(int productId) {
        vendingMachine.getDisplay().showMessage("Product already selected. Insert money or cancel transaction.");
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.getPayment().addMoney(amount);
        if (vendingMachine.getPayment().getBalance() >= vendingMachine.getSelectedProduct().getPrice()) {
            vendingMachine.setState(vendingMachine.getDispenseState());
            vendingMachine.getDisplay().showMessage("Sufficient money inserted. Dispensing product...");
            vendingMachine.dispenseProduct();
        } else {
            vendingMachine.getDisplay().showMessage("Insufficient money. Please insert more.");
        }
    }

    @Override
    public void dispenseProduct() {
        vendingMachine.getDisplay().showMessage("Insufficient money inserted.");
    }

    @Override
    public void cancelTransaction() {
        double refund = vendingMachine.getPayment().getBalance();
        vendingMachine.getPayment().resetBalance();
        vendingMachine.getDisplay().showMessage("Transaction cancelled. Refunding: " + refund);
        vendingMachine.setState(vendingMachine.getReadyState());
    }
}

class DispenseState implements State {
    private VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(int productId) {
        vendingMachine.getDisplay().showMessage("Please wait, dispensing the product.");
    }

    @Override
    public void insertMoney(double amount) {
        vendingMachine.getDisplay().showMessage("Please wait, dispensing the product.");
    }

    @Override
    public void dispenseProduct() {
        Product product = vendingMachine.getSelectedProduct();
        vendingMachine.getInventory().reduceStock(product.getId());
        double change = vendingMachine.getPayment().returnChange(product.getPrice());
        vendingMachine.getDisplay().showMessage("Dispensing: " + product.getName());
        if (change > 0) {
            vendingMachine.getDisplay().showMessage("Returning change: " + change);
        }
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setState(vendingMachine.getReadyState());
    }

    @Override
    public void cancelTransaction() {
        vendingMachine.getDisplay().showMessage("Product is being dispensed. Cannot cancel.");
    }
}
