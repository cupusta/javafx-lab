package com.example.javafxlab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("№1 Перекидыватель", new Task1());
        Tab tab2 = new Tab("№2 Чекбоксы", new Task2());
        Tab tab3 = new Tab("№3 Ресторан", new Task3());
        Tab tab4 = new Tab("№4 Калькулятор", new Task4());
        Tab tab5 = new Tab("№5 Флаг", new Task5());

        tab1.setClosable(false);
        tab2.setClosable(false);
        tab3.setClosable(false);
        tab4.setClosable(false);
        tab5.setClosable(false);

        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5);

        Scene scene = new Scene(tabPane, 600, 500);
        stage.setTitle("JavaFX Лабораторная работа");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}