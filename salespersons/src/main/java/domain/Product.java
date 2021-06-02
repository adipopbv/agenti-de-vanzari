package domain;

import java.io.Serializable;

public class Product implements Serializable {
    private Integer id;
    private String name;
    private String details;
    private Integer price;
    private Integer amountLeft;

    public Product() {

    }

    public Product(Integer id, String name, String details, Integer price, Integer amountLeft) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.price = price;
        this.amountLeft = amountLeft;
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

    public Integer getAmountLeft() {
        return amountLeft;
    }

    public void setAmountLeft(Integer amountLeft) {
        this.amountLeft = amountLeft;
    }
}
