package group44.pizza;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class NewOrderController {
    ArrayList<String> toppings = new ArrayList<String>();
    String pizzaType = "";
    String pickupTime = "";

    @FXML
    public void newOrderStart(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("NewOrder.fxml"));
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
    public void promptClick(ActionEvent event) throws Exception {
        try {
            PromptController prompt = new PromptController();
            prompt.promptStart(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // HI! Noel here, the classes below are to set the pizza types.
    // I made a class for each button because...because
    // I'm personally not too sure how to pass parameters and stuff into onAction functions but
    // this solutions isn't too shabby imo

    public void setPepperoni() {setPizzaType("Pepperoni");}
    public void setVegetable() {setPizzaType("Vegetable");}
    public void setCheese() {setPizzaType("Cheese");}

    private void setPizzaType(String pizzaType)
    {
        this.pizzaType = pizzaType;
        this.displayCurrentState();
    }

    public void addMushroom() {addTopping("Mushroom");}
    public void addOnion() {addTopping("Onion");}
    public void addOlives() {addTopping("Olives");}
    public void addExtraCheese() {addTopping("Extra Cheese");}

    // The functions below
    private void addTopping(String topping)
    {
        if (this.toppings.contains(topping)) this.toppings.remove(topping);
        else this.toppings.add(topping);

        // FOR DEBUGGING
        this.displayCurrentState();
    }

    // I MADE ONE FOR EACH TIME SMH
    public void set1200() {setTime("12:00pm");}
    public void set100() {setTime("1:00pm");}
    public void set200() {setTime("2:00pm");}
    public void set300() {setTime("3:00pm");}
    public void set400() {setTime("4:00pm");}
    public void set500() {setTime("5:00pm");}

    private void setTime(String pickupTime) {
        this.pickupTime = pickupTime;
        this.displayCurrentState();
    }

    private void displayCurrentState() {
        System.out.printf("\nCURRENT STATE\n");
        System.out.printf("Pizza type:  %s\n", this.pizzaType);
        System.out.printf("Toppings:    %s\n", this.toppings.toString());
        System.out.printf("Pickup time: %s\n", this.pickupTime);
    }
}