module com.example.javafxlab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafxlab to javafx.fxml;
    exports com.example.javafxlab;
}