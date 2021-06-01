package domain;

import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private Integer productCount;
    private LocalDateTime date;
    private String status;

    public Order() {

    }

    public Order(Integer id, Integer productCount, LocalDateTime date, String status) {
        this.id = id;
        this.productCount = productCount;
        this.date = date;
        this.status = status;
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
}
