package group44.pizza;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 450, 300);
        stage.setTitle("SunDevil Pizza");
        stage.setScene(scene);
        stage.setResizable(false);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * .5;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * .5;
        stage.setX(x);
        stage.setY(y);
        stage.show();
    }
    @FXML
    public void customerViewClick(ActionEvent event) throws Exception {
        try {
            CustomerViewController customerView = new CustomerViewController();
            customerView.customerViewStart(new Stage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void storeViewClick(ActionEvent event) throws Exception {
        try {
            StoreViewController storeView = new StoreViewController();
            storeView.storeViewStart(new Stage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}