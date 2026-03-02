import java.util.UUID;

public class Product {
    private final UUID id;
    private final String name;
    private final String description;
    private final double price;
    private final String category;
    private final String producer;
    private final int stock;
    private final double weight;


    public Product(String name, String description, double price, String category, String producer, int stock, double weight) {
        this(UUID.randomUUID(), name, description, price, category, producer, stock, weight);
    }


    private Product(UUID id, String name, String description, double price, String category, String producer, int stock, double weight) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (stock < 0) throw new IllegalArgumentException("Stock status cannot be negative");
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.producer = producer;
        this.stock = stock;
        this.weight = weight;
    }

    public UUID getId() {return id;}
    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getPrice() {return price;}
    public String getCategory() {return category;}
    public String getProducer() {return producer;}
    public int getStock() {return stock;}
    public double getWeight() {return weight;}


    public Product withPrice(double newPrice) {
        return new Product(this.id, this.name, this.description, newPrice, this.category, this.producer, this.stock, this.weight);
    }

    public Product withCategory(String newCategory) {
        return new Product(this.id, this.name, this.description, this.price, newCategory, this.producer, this.stock, this.weight);

    }
    public Product withProducer(String newProducer) {
        return new Product(this.id, this.name, this.description, this.price, this.category, newProducer, this.stock, this.weight);
    }

    public Product withStock(int newStock) {
        return new Product(this.id, this.name, this.description, this.price, this.category, this.producer, newStock, this.weight);
    }
    public Product withName(String newName) {
        return new Product(this.id, this.name, this.description, this.price, this.category, this.producer, this.stock, newName);
    }

    public Product withDescription(String newDescription) {
        return new Product(this.id, this.name, newDescription, this.price, this.category, this.producer, this.stock, this.weight);
    }

}