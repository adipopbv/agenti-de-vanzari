package clients;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import services.IServices;

public class JavaFxClient extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:springClient.xml");
        IServices services = (IServices) factory.getBean("services");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/signInWindow.fxml"));
        Parent root = loader.load();
        ((SignInController) loader.getController()).init(services, null);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign in!");
        primaryStage.show();
    }
}
