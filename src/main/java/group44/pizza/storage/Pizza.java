package group44.pizza.storage;

import java.util.ArrayList;

public class Pizza {
    private PizzaType pizzaType;
    private ArrayList<Topping> toppings;

    public Pizza(PizzaType pizzaType, ArrayList<Topping> topping)
    {
        this.pizzaType = pizzaType;
        this.topping = topping;
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
