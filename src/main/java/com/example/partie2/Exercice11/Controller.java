package com.example.partie2.Exercice11;

import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button boutonA;
    private TextField Date1;
    private TextField Date2;
    private TextField Date3;

    @FXML
    private CategoryAxis AxeX;
    @FXML
    private NumberAxis AxeY;


    private void PopBaleine() {
    }

    @FXML
    private void handleButtonClick() {
        System.out.println("bouton cliqué");
    }

    @FXML
    private void RecupTexte() {
        String userInputD1 = Date1.getText();
        String userInputD2 = Date2.getText();
        String userInputD3 = Date3.getText();
    }
}