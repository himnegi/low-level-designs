package vending_machine;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<Integer, Product> productMap = new HashMap<>();
    private Map<Integer, Integer> stockMap = new HashMap<>();

    public void addProduct(Product product, int quantity) {
        productMap.put(product.getId(), product);
        stockMap.put(product.getId(), stockMap.getOrDefault(product.getId(), 0) + quantity);
    }

    public Product getProduct(int productId) {
        return productMap.get(productId);
    }

    public int getStock(int productId) {
        return stockMap.getOrDefault(productId, 0);
    }

    public void reduceStock(int productId) {
        if (stockMap.containsKey(productId) && stockMap.get(productId) > 0) {
            stockMap.put(productId, stockMap.get(productId) - 1);
        }
    }
}
