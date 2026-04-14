package com.example.javafxlab;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Task3 extends VBox {

    private final String[] dishes = {"Борщ", "Пицца", "Стейк", "Салат Цезарь", "Мороженое"};
    private final double[] prices = {5.50, 8.00, 15.00, 6.50, 3.00};
    private final CheckBox[] checkBoxes = new CheckBox[dishes.length];
    private final Spinner<Integer>[] spinners = new Spinner[dishes.length];

    public Task3() {
        setSpacing(10);
        setPadding(new Insets(20));

        Label title = new Label("Меню");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        getChildren().add(title);

        for (int i = 0; i < dishes.length; i++) {
            checkBoxes[i] = new CheckBox(dishes[i] + " — " + prices[i] + " руб.");
            spinners[i] = new Spinner<>(1, 10, 1);
            spinners[i].setPrefWidth(70);
            spinners[i].setDisable(true);

            final int index = i;
            checkBoxes[i].setOnAction(e ->
                    spinners[index].setDisable(!checkBoxes[index].isSelected())
            );

            HBox row = new HBox(15, checkBoxes[i], spinners[i]);
            row.setAlignment(Pos.CENTER_LEFT);
            getChildren().add(row);
        }

        Button orderButton = new Button("Оформить заказ");
        orderButton.setStyle("-fx-font-size: 14px;");
        orderButton.setOnAction(e -> showReceipt());
        getChildren().add(orderButton);
    }

    private void showReceipt() {
        StringBuilder sb = new StringBuilder();
        double total = 0;
        boolean anySelected = false;

        for (int i = 0; i < dishes.length; i++) {
            if (checkBoxes[i].isSelected()) {
                anySelected = true;
                int qty = spinners[i].getValue();
                double subtotal = qty * prices[i];
                total += subtotal;
                sb.append(dishes[i])
                        .append(" x").append(qty)
                        .append(" = ").append(String.format("%.2f", subtotal)).append(" руб.\n");
            }
        }

        if (!anySelected) {
            new Alert(Alert.AlertType.WARNING, "Выберите хотя бы одно блюдо!").showAndWait();
            return;
        }

        sb.append("\n——————————————\n");
        sb.append("Итого: ").append(String.format("%.2f", total)).append(" руб.");

        Stage modal = new Stage();
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.setTitle("Ваш чек");

        Label receiptLabel = new Label(sb.toString());
        receiptLabel.setStyle("-fx-font-size: 14px; -fx-font-family: monospace;");

        Button closeBtn = new Button("Закрыть");
        closeBtn.setOnAction(e -> modal.close());

        VBox layout = new VBox(15, receiptLabel, closeBtn);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        modal.setScene(new Scene(layout));
        modal.showAndWait();
    }
}