package domain;

public class Product {
    private Integer id;
    private String name;
    private String details;
    private Integer price;
    private Order order;

    public Product() {

    }

    public Product(Integer id, String name, String details, Integer price, Order order) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.order = order;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
