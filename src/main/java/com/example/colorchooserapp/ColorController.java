package com.example.colorchooserapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;

public class ColorController {

    @FXML
    private Slider greenSlider;
    @FXML
    private Slider redSlider;
    @FXML
    private Slider blueSlider;
    @FXML
    private TextField greenField;
    @FXML
    private TextField redField;
    @FXML
    private TextField blueField;
    @FXML
    private Rectangle rectangle;

    @FXML
    private void onSlider(MouseEvent e){
        greenField.setText(String.valueOf(greenSlider.getValue()));
        redField.setText(String.valueOf(redSlider.getValue()));
        blueField.setText(String.valueOf(blueSlider.getValue()));
        rectangle.setFill(Color.rgb((int)redSlider.getValue(), (int)greenSlider.getValue(), (int)blueSlider.getValue()));
    }

    @FXML
    private void onField(KeyEvent e) {
        TextField src = (TextField) e.getSource();
        String text = src.getText();

        // Allow user to type without errors when field is empty
        if (text == null || text.isEmpty()) {
            return;
        }

        try {
            int value = Integer.parseInt(text);
            value = Math.max(0, Math.min(255, value)); // clamp 0–255

            // Only update the slider that matches the field
            if (src == redField) {
                redSlider.setValue(value);
            } else if (src == greenField) {
                greenSlider.setValue(value);
            } else if (src == blueField) {
                blueSlider.setValue(value);
            }

            // Update rectangle color after any field change
            rectangle.setFill(Color.rgb(
                    (int) redSlider.getValue(),
                    (int) greenSlider.getValue(),
                    (int) blueSlider.getValue()
            ));
        } catch (NumberFormatException ex) {
            // Optional: let user finish typing without crashing
            System.out.println("Invalid number input, waiting for complete value");
        }
    }


}
