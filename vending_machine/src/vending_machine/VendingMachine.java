package vending_machine;

public class VendingMachine {
    private State readyState;
    private State hasMoneyState;
    private State dispenseState;

    private State currentState;
    private Inventory inventory;
    private Payment payment;
    private Display display;
    private Product selectedProduct;

    public VendingMachine() {
        readyState = new ReadyState(this);
        hasMoneyState = new HasMoneyState(this);
        dispenseState = new DispenseState(this);

        currentState = readyState;
        inventory = new Inventory();
        payment = new Payment();
        display = new Display();
    }

    public void selectProduct(int productId) {
        currentState.selectProduct(productId);
    }

    public void insertMoney(double amount) {
        currentState.insertMoney(amount);
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }

    public void cancelTransaction() {
        currentState.cancelTransaction();
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getReadyState() {
        return readyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Payment getPayment() {
        return payment;
    }

    public Display getDisplay() {
        return display;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }
}
