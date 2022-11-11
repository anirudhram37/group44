package group44.pizza.storage;

import java.io.*;
import java.util.ArrayList;

// This is the database class. Everything is currently stored in memory but by abstracting away all the
// "database" logic, we can easily swap it out in the future
public class Database {
    public static ArrayList<Order> orders = new ArrayList<Order>();
    private static final String persistentFilePath = "db.txt";

    public static void loadOrders() {
        try {
            FileInputStream fileIn = new FileInputStream(persistentFilePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            orders = (ArrayList<Order>) objectIn.readObject();

            fileIn.close();
            objectIn.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    // Everything is static. Is it bad practice? Yes. Do I care? No
    public static void addOrder(Order order) {
        Database.orders.add(order);
        writeObjectToFile(orders);
        displayCurrentStatus();
    }

    // We will remove orders based on their id?
    public static void removeOrderByAsuId(String asuID) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getAsuID().equals(asuID)) {
                orders.remove(i);
                return;
            }
        }
    }

    private static void displayCurrentStatus() {
        System.out.printf("\nDATABASE STATUS\n");
        System.out.printf("%s\n", orders.toString());
    }

    private static void writeObjectToFile(Object obj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(persistentFilePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(obj);

            fileOut.close();
            objectOut.close();
            System.out.println("Wrote to a file");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
