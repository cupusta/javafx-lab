package com.example.javafxlab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Task1 extends VBox {

    private boolean leftToRight = true;

    public Task1() {
        setSpacing(20);
        setPadding(new Insets(30));
        setAlignment(Pos.CENTER);

        TextField leftField = new TextField();
        leftField.setPromptText("Введите текст");

        TextField rightField = new TextField();
        rightField.setPromptText("Результат");
        rightField.setEditable(false);

        Button button = new Button("→");
        button.setPrefWidth(60);

        button.setOnAction(e -> {
            if (leftToRight) {
                rightField.setText(leftField.getText());
                leftField.clear();
                button.setText("←");
            } else {
                leftField.setText(rightField.getText());
                rightField.clear();
                button.setText("→");
            }
            leftToRight = !leftToRight;
        });

        HBox hBox = new HBox(15, leftField, button, rightField);
        hBox.setAlignment(Pos.CENTER);

        getChildren().add(hBox);
    }
}