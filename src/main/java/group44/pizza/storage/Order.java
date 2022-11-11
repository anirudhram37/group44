package group44.pizza.storage;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private static long nextId = 0;
    private long id;
    private String asuID;
    private String pizzaType;
    private ArrayList<String> toppings;
    private String pickupTime;

    public Order(String asuID, String pizzaType, ArrayList<String> toppings, String pickupTime) {
        this.id = nextId++;
        this.asuID = asuID;
        this.pizzaType = pizzaType;
        this.toppings = toppings;
        this.pickupTime = pickupTime;
    }

    public long getId() {
        return this.id;
    }

    public String getAsuID() {
        return this.asuID;
    }

    public void setAsuID(String asuID) {
        this.asuID = asuID;
    }

    public String getPizzaType() {
        return this.pizzaType;
    }

    public ArrayList<String> getToppings() {
        return this.toppings;
    }

    public String getPickupTime() {
        return this.pickupTime;
    }

    public String toString() {
        String line0 = "ASU ID      :" + this.asuID + "\n";
        String line1 = "Pizza type  :" + this.pizzaType + "\n";
        String line2 = "Toppings    :" + this.toppings.toString() + "\n";
        String line3 = "Pickup time :" + this.pickupTime + "\n";

        return line0 + line1 + line2 + line3;
    }
}
