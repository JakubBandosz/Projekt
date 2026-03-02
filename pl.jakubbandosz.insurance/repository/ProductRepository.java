import java.util.HashMap;
import java.util.UUID;


public class ProductRepository {
    private final HashMap<UUID, Product> products = new HashMap<>();

    public void save(Product product){
        products.put(product.getId(), product);
    }
}