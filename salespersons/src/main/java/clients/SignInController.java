package clients;

import domain.Salesperson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.rmi.RemoteException;

public class SignInController extends WindowController {
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;

    public SignInController() throws RemoteException {
    }

    @FXML
    public void signIn() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/mainWindow.fxml"));
            Parent parent = loader.load();
            MainController controller = loader.getController();

            Salesperson salesperson = services.signInUser(usernameField.getText(), passwordField.getText(), controller);

            controller.init(services, salesperson);
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.setTitle("Salespersons app!");
            stage.setOnCloseRequest(event -> {
                controller.signOut();
                System.exit(0);
            });
            stage.show();
            ((Stage) usernameField.getScene().getWindow()).close();
        } catch (Exception exception) {
            exception.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, exception.getMessage());
            alert.show();
        }
    }
}
