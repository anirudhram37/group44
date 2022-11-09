package group44.pizza;

import group44.pizza.storage.Database;
import group44.pizza.storage.Order;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PromptController {
    String asuId = "";
    Order currentOrder = new Order("", "", new ArrayList<String>(), "");

    @FXML
    public void promptStart(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Prompt.fxml"));
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

    private void displayCurrentState() {
        System.out.printf("\nPROMPT STATUS\n");
        System.out.printf("ASU ID: %s", this.asuId);
    }

    public void setAsuIdText(KeyEvent event) throws Exception {
        asuId =  ((TextField)event.getSource()).getText();
        this.currentOrder.setAsuID(asuId);
        displayCurrentState();
    }

    public void setOrder(Order order) {
        System.out.println("SET ORDER");
        System.out.println(order);
        this.currentOrder = order;
    }

    public void submitOrder() {
        System.out.println("SUBMIT ORDER");
        Database.addOrder(this.currentOrder);
    }
}
