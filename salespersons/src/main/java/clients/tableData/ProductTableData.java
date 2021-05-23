package clients.tableData;

import javafx.scene.layout.HBox;

public class ProductTableData {
    private String name;
    private String details;
    private Integer price;
    private Integer amountLeft;
    private HBox actions;

    public ProductTableData(String name, String details, Integer price, Integer amountLeft, HBox actions) {
        this.name = name;
        this.details = details;
        this.price = price;
        this.amountLeft = amountLeft;
        this.actions = actions;
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

    public HBox getActions() {
        return actions;
    }

    public void setActions(HBox actions) {
        this.actions = actions;
    }
}
