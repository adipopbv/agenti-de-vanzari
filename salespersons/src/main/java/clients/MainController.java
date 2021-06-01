package clients;

import clients.tableData.OrderTableData;
import clients.tableData.ProductTableData;
import domain.User;
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
    ObservableList<ProductTableData> productsList = FXCollections.observableArrayList();
    ObservableList<OrderTableData> ordersList = FXCollections.observableArrayList();

    public MainController() throws RemoteException {
    }

    @Override
    public void init(IServices services, User signedUser) {
        super.init(services, signedUser);

        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productDetailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productAmountLeftColumn.setCellValueFactory(new PropertyValueFactory<>("amountLeft"));
        productActionColumn.setCellValueFactory(new PropertyValueFactory<>("actions"));
        Collection<ProductTableData> temp = new ArrayList<>();
        temp.add(new ProductTableData(
                "Aspirator 2000",
                "cel mai cel aspirator din lume",
                150,
                24,
                new HBox(
                        new ChoiceBox<String>(),
                        new Spinner<Integer>(),
                        new Button("Place order")
                )
        ));
        productsList.setAll(temp);
        productsTable.setItems(productsList);

        orderProductNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        orderProductCountColumn.setCellValueFactory(new PropertyValueFactory<>("productCount"));
        orderDateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        orderStatusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        orderActionColumn.setCellValueFactory(new PropertyValueFactory<>("actions"));
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
            services.signOutUser(signedUser.getUsername(), this);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "logged out successfully");
            alert.show();
            ((Stage) topLabel.getScene().getWindow()).close();
        } catch (Exception exception) {
            Alert alert = new Alert(Alert.AlertType.ERROR, exception.getMessage());
            alert.show();
        }
    }
}
