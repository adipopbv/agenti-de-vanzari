package clients.tableData;

import javafx.scene.layout.HBox;

import java.time.LocalDateTime;

public class OrderTableData {
    private String productName;
    private Integer productCount;
    private LocalDateTime date;
    private String status;
    private HBox actions;

    public OrderTableData(String productName, Integer productCount, LocalDateTime date, String status, HBox actions) {
        this.productName = productName;
        this.productCount = productCount;
        this.date = date;
        this.status = status;
        this.actions = actions;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public HBox getActions() {
        return actions;
    }

    public void setActions(HBox actions) {
        this.actions = actions;
    }
}
