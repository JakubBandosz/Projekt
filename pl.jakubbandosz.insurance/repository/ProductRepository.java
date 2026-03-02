import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ProductRepository {

    private final Map<UUID, Product> products = new HashMap<>();

    public void save(Product product) {
        products.put(product.getId(), product);
    }

    public Optional<Product> findById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }

    public void removeById(UUID id) {
        products.remove(id);
    }
}