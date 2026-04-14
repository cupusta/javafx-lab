package com.example.javafxlab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class Task4 extends VBox {

    private final TextField display = new TextField("0");
    private double firstNumber = 0;
    private String operator = "";
    private boolean newInput = true;

    public Task4() {
        setSpacing(10);
        setPadding(new Insets(20));
        setAlignment(Pos.CENTER);

        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-font-size: 20px;");
        display.setPrefWidth(240);

        GridPane grid = new GridPane();
        grid.setHgap(8);
        grid.setVgap(8);
        grid.setAlignment(Pos.CENTER);

        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"C", "0", "=", "+"}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                Button btn = new Button(text);
                btn.setPrefSize(55, 45);
                btn.setStyle("-fx-font-size: 16px;");
                btn.setOnAction(e -> handleButton(text));
                grid.add(btn, col, row);
            }
        }

        getChildren().addAll(display, grid);
    }

    private void handleButton(String text) {
        switch (text) {
            case "C" -> {
                display.setText("0");
                firstNumber = 0;
                operator = "";
                newInput = true;
            }
            case "+" , "-", "*", "/" -> {
                firstNumber = Double.parseDouble(display.getText());
                operator = text;
                newInput = true;
            }
            case "=" -> {
                if (operator.isEmpty()) return;
                double second = Double.parseDouble(display.getText());
                double result = switch (operator) {
                    case "+" -> firstNumber + second;
                    case "-" -> firstNumber - second;
                    case "*" -> firstNumber * second;
                    case "/" -> {
                        if (second == 0) {
                            new Alert(Alert.AlertType.ERROR, "Деление на ноль!").showAndWait();
                            yield firstNumber;
                        }
                        yield firstNumber / second;
                    }
                    default -> 0;
                };
                // убираем .0 если число целое
                if (result == (long) result) {
                    display.setText(String.valueOf((long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
                operator = "";
                newInput = true;
            }
            default -> {
                if (newInput) {
                    display.setText(text);
                    newInput = false;
                } else {
                    if (display.getText().equals("0")) {
                        display.setText(text);
                    } else {
                        display.setText(display.getText() + text);
                    }
                }
            }
        }
    }
}