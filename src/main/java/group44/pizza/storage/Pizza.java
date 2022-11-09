package group44.pizza.storage;

import java.util.ArrayList;

public class Pizza {
    private PizzaType pizzaType;
    private ArrayList<Topping> toppings;

    public Pizza(PizzaType pizzaType, ArrayList<Topping> toppings)
    {
        this.pizzaType = pizzaType;
        this.toppings = toppings;
    }

    public PizzaType getPizzaType()
    {
        return this.pizzaType;
    }

    public ArrayList<Topping> getToppings()
    {
        return this.toppings;
    }
}
