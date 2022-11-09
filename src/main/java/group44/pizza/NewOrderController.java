package group44.pizza;

import group44.pizza.storage.PizzaType;
import group44.pizza.storage.Topping;
import javafx.application.Application;
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
    ArrayList<Topping> toppings;
    PizzaType pizzaType;

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
    public void setPepperoni(ActionEvent event) throws Exception {
        System.out.println("SET PEPPERONI");
        pizzaType = PizzaType.PEPPERONI;
    }

    public void setVegetable(ActionEvent event) throws Exception {
        System.out.println("SET VEGETABLE");
        pizzaType = PizzaType.VEGETABLE;
    }

    public void setCheese(ActionEvent event) throws Exception {
        System.out.println("SET VEGETABLE");
        pizzaType = PizzaType.CHEESE;
    }

    // The functions below
    private void addTopping(Topping topping)
    {
        if (this.toppings.contains(topping)) toppings.remove(topping);
        toppings.add(topping);

        // FOR DEBUGGING
        System.out.println(toppings);
    }

    public void addMushroom() {addTopping(Topping.MUSHROOM);}
    public void addOnion() {addTopping(Topping.ONION);}
    public void addOlives() {addTopping(Topping.OLIVES);}
    public void addExtraCheese() {addTopping(Topping.EXTRA_CHEESE);}
}