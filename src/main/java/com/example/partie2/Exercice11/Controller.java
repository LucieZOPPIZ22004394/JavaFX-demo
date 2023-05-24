package com.example.partie2.Exercice11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private TextField dateField;

    @FXML
    private TextField populationField;

    private ObservableList<XYChart.Data<String, Number>> data;

    @FXML
    public void initialize() {
        data = FXCollections.observableArrayList();
        barChart.getData().add(new XYChart.Series<>(data));
    }

    @FXML
    private void addButtonClicked(ActionEvent event) {
        try {
            String date = dateField.getText().trim();
            Number value = Double.parseDouble(populationField.getText().trim());
            data.add(new XYChart.Data<>(date, value));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        dateField.clear();
        populationField.clear();
    }
}
