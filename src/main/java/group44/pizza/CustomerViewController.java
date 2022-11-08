package group44.pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerViewController {
    @FXML
    public void customerViewStart(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setResizable(false);
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        double x = bounds.getMinX() + (bounds.getWidth() - scene.getWidth()) * .25;
        double y = bounds.getMinY() + (bounds.getHeight() - scene.getHeight()) * .4;
        stage.setX(x);
        stage.setY(y);
        stage.show();
    }

    @FXML
    public void newOrderClick(ActionEvent event) throws Exception {
        try {
            NewOrderController newOrder = new NewOrderController();
            newOrder.newOrderStart(new Stage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void orderStatusClick(ActionEvent event) throws Exception {
        try {
            OrderStatusController orderStatus = new OrderStatusController();
            orderStatus.orderStatusStart(new Stage());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
