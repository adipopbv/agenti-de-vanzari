package domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable {
    private Integer id;
    private Integer productCount;
    private LocalDateTime date;
    private String status;
    private Product product;

    public Order() {

    }

    public Order(Integer id, Integer productCount, LocalDateTime date, String status, Product product) {
        this.id = id;
        this.productCount = productCount;
        this.date = date;
        this.status = status;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
