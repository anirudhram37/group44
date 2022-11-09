package group44.pizza.storage;

import java.util.ArrayList;

public class Pizza {
    private String pizzaType;
    private ArrayList<String> toppings;
    private String time;

    public Pizza(String pizzaType, ArrayList<String> toppings, String time) {
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.time = time;
    }

    public String getPizzaType() {
        return this.pizzaType;
    }

    public ArrayList<String> getToppings() {
        return this.toppings;
    }
}
