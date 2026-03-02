public abstract class Product {

    private final UUID id;
    private final String name;
    private final double price;

    protected Product(String name, double price) {
        this(UUID.randomUUID(), name, price);
    }

    protected Product(UUID id, String name, double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract double calculateShippingCost();
}