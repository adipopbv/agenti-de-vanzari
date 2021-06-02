package clients.tableData;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrderTableData {
    private String productName;
    private Integer productCount;
    private Timestamp date;
    private String status;
    private HBox actions;

    public OrderTableData(String productName, Integer productCount, Timestamp date, String status) {
        this.productName = productName;
        this.productCount = productCount;
        this.date = date;
        this.status = status;
        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            cancelOrder();
        });
        Button confirmButton = new Button("Confirm Delivery");
        confirmButton.setOnAction(e -> {
            confirmOrder();
        });
        this.actions = new HBox(
                cancelButton,
                confirmButton
        );
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

    public HBox getActions() {
        return actions;
    }

    public void setActions(HBox actions) {
        this.actions = actions;
    }

    private void cancelOrder() {
        System.out.println("order canceled");
    }

    private void confirmOrder() {
        System.out.println("order confirmed");
    }
}
