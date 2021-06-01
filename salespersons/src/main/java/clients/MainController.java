package clients;

import clients.tableData.ClientTableData;
import clients.tableData.OrderTableData;
import clients.tableData.ProductTableData;
import domain.Client;
import domain.Product;
import domain.Salesperson;
import domain.observers.IObserver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.IServices;

import java.rmi.RemoteException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class MainController extends WindowController implements IObserver {
    @FXML
    public Text topLabel;

    @FXML
    public TableView<ProductTableData> productsTable;
    @FXML
    public TableColumn<ProductTableData, String> productNameColumn;
    @FXML
    public TableColumn<ProductTableData, String> productDetailsColumn;
    @FXML
    public TableColumn<ProductTableData, Integer> productPriceColumn;
    @FXML
    public TableColumn<ProductTableData, Integer> productAmountLeftColumn;
    @FXML
    public TableColumn<ProductTableData, HBox> productActionColumn;
    @FXML
    public TableView<OrderTableData> ordersTable;
    @FXML
    public TableColumn<OrderTableData, String> orderProductNameColumn;
    @FXML
    public TableColumn<OrderTableData, Integer> orderProductCountColumn;
    @FXML
    public TableColumn<OrderTableData, LocalDateTime> orderDateColumn;
    @FXML
    public TableColumn<OrderTableData, String> orderStatusColumn;
    @FXML
    public TableColumn<OrderTableData, HBox> orderActionColumn;
    ObservableList<ClientTableData> clientsList = FXCollections.observableArrayList();
    ObservableList<ProductTableData> productsList = FXCollections.observableArrayList();
    ObservableList<OrderTableData> ordersList = FXCollections.observableArrayList();

    public MainController() throws RemoteException {
    }

    @Override
    public void init(IServices services, Salesperson signedSalesperson) {
        super.init(services, signedSalesperson);

        updateClientList();

        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productAmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("amountLeft"));
        productActionColumn.setCellValueFactory(new PropertyValueFactory<>("actions"));
        updateProductTable();

        orderProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orderProductCountColumn.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        orderActionColumn.setCellValueFactory(new PropertyValueFactory<>("actions"));
        updateOrderTable();
    }

    private void updateClientList() {
        Collection<ClientTableData> clients = new ArrayList<>();
        for (Client client : services.getAllClients()) {
            clients.add(new ClientTableData(
                    client.getFirstName(),
                    client.getLastName()
            ));
        }
        clientsList.setAll(clients);
    }

    private void updateProductTable() {
        Collection<ProductTableData> products = new ArrayList<>();
        for (Product product : services.getAllProducts())
            products.add(new ProductTableData(
                    product.getName(),
                    product.getDetails(),
                    product.getPrice(),
                    product.getAmountLeft(),
                    clientsList
            ));
        productsList.setAll(products);
        productsTable.setItems(productsList);
    }

    private void updateOrderTable() {
        Collection<OrderTableData> temp2 = new ArrayList<>();
        temp2.add(new OrderTableData(
                "Aspirator 2000",
                2,
                LocalDateTime.now(),
                "PROCESSING",
                new HBox(new Button("Cancel"), new Button("Confirm Delivery"))
        ));
        ordersList.setAll(temp2);
        ordersTable.setItems(ordersList);
    }

    public void signOut() {
        try {
            services.signOutUser(signedSalesperson.getUsername(), this);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "logged out successfully");
            alert.show();
            ((Stage) topLabel.getScene().getWindow()).close();
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, exception.getMessage());
            alert.show();
        }
    }
}
