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
    private void onField(KeyEvent e){
        try{
            greenSlider.setValue(Integer.parseInt(greenField.getText()));
            blueSlider.setValue(Integer.parseInt(blueField.getText()));
            redSlider.setValue(Integer.parseInt(redField.getText()));
            rectangle.setFill(Color.rgb((int) redSlider.getValue(), (int) greenSlider.getValue(), (int) blueSlider.getValue()));
        }
        catch(Exception exception){

        }
    }

}
