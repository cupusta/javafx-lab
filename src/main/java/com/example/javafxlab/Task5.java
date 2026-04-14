package com.example.javafxlab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Task5 extends VBox {

    private final String[] colors = {"Красный", "Синий", "Белый", "Зелёный", "Жёлтый"};

    public Task5() {
        setSpacing(15);
        setPadding(new Insets(20));
        setAlignment(Pos.TOP_LEFT);

        ToggleGroup group1 = new ToggleGroup();
        ToggleGroup group2 = new ToggleGroup();
        ToggleGroup group3 = new ToggleGroup();

        VBox strip1 = makeStrip("Верхняя полоса:", group1);
        VBox strip2 = makeStrip("Средняя полоса:", group2);
        VBox strip3 = makeStrip("Нижняя полоса:", group3);

        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button drawBtn = new Button("Нарисовать");
        drawBtn.setStyle("-fx-font-size: 14px;");
        drawBtn.setOnAction(e -> {
            String c1 = getSelected(group1);
            String c2 = getSelected(group2);
            String c3 = getSelected(group3);
            if (c1 == null || c2 == null || c3 == null) {
                resultLabel.setText("Выберите цвет для каждой полосы!");
            } else {
                resultLabel.setText(c1 + ", " + c2 + ", " + c3);
            }
        });

        getChildren().addAll(strip1, strip2, strip3, drawBtn, resultLabel);
    }

    private VBox makeStrip(String title, ToggleGroup group) {
        Label label = new Label(title);
        HBox radioBox = new HBox(10);
        for (String color : colors) {
            RadioButton rb = new RadioButton(color);
            rb.setToggleGroup(group);
            radioBox.getChildren().add(rb);
        }
        return new VBox(5, label, radioBox);
    }

    private String getSelected(ToggleGroup group) {
        Toggle selected = group.getSelectedToggle();
        if (selected == null) return null;
        return ((RadioButton) selected).getText();
    }
}