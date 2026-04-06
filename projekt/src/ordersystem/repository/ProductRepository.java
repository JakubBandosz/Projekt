package ordersystem.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;
import java.util.Collection;
import ordersystem.model.Product;

public class ProductRepository {

    private final Map<UUID, Product> products = new HashMap<>();

    public void save(Product product) {
        Objects.requireNonNull(product, "Product cannot be null");
        products.put(product.getId(), product);
    }

    public Optional<Product> findById(UUID id) {
        Objects.requireNonNull(id, "Id cannot be null");
        return Optional.ofNullable(products.get(id));
    }

    public Collection<Product> findAll() {
        return products.values();
    }

    public boolean existsById(UUID id) {
        Objects.requireNonNull(id, "Id cannot be null");
        return products.containsKey(id);
    }

    public void removeById(UUID id) {
        Objects.requireNonNull(id, "Id cannot be null");
        products.remove(id);
    }

    public int count() {
        return products.size();
    }
}
