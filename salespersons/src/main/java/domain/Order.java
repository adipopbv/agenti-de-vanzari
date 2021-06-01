package domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {
    private Integer id;
    private Integer productCount;
    private Timestamp date;
    private String status;
    private Product product;
    private Client client;
    private Salesperson salesperson;

    public Order() {

    }

    public Order(Integer id, Integer productCount, Timestamp date, String status, Product product, Client client, Salesperson salesperson) {
        this.id = id;
        this.productCount = productCount;
        this.date = date;
        this.status = status;
        this.product = product;
        this.client = client;
        this.salesperson = salesperson;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Salesperson getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(Salesperson salesperson) {
        this.salesperson = salesperson;
    }
}
