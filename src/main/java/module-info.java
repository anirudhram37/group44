module group44.pizza {
    requires javafx.controls;
    requires javafx.fxml;


    opens group44.pizza to javafx.fxml;
    exports group44.pizza;
    exports group44.pizza.storage;
    opens group44.pizza.storage to javafx.fxml;
}