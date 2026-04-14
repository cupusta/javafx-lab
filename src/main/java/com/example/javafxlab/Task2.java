package com.example.javafxlab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Task2 extends VBox {

    public Task2() {
        setSpacing(15);
        setPadding(new Insets(30));
        setAlignment(Pos.TOP_LEFT);

        Button button = new Button("Нажми меня");
        CheckBox cb1 = new CheckBox("Показать кнопку");
        cb1.setSelected(true);
        cb1.setOnAction(e -> button.setVisible(cb1.isSelected()));

        Rectangle rect = new Rectangle(80, 40, Color.CORNFLOWERBLUE);
        CheckBox cb2 = new CheckBox("Показать прямоугольник");
        cb2.setSelected(true);
        cb2.setOnAction(e -> rect.setVisible(cb2.isSelected()));

        Circle circle = new Circle(25, Color.SALMON);
        CheckBox cb3 = new CheckBox("Показать круг");
        cb3.setSelected(true);
        cb3.setOnAction(e -> circle.setVisible(cb3.isSelected()));

        Label label = new Label("Привет, мир!");
        label.setStyle("-fx-font-size: 16px;");
        CheckBox cb4 = new CheckBox("Показать текст");
        cb4.setSelected(true);
        cb4.setOnAction(e -> label.setVisible(cb4.isSelected()));

        getChildren().addAll(
                new HBox(15, button, cb1),
                new HBox(15, rect, cb2),
                new HBox(15, circle, cb3),
                new HBox(15, label, cb4)
        );
    }
}