package com.example.partie2.Exercice11;

import com.example.javafxdemo.HelloApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Exercice11 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(Exercice11.class.getResource("WhaleApp.fxml"));

        //scene
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Whale App");
        primaryStage.show();

    }
}
