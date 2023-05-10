package com.example.Exercice4;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Exercice4 extends Application {

    // conteneur principal
    BorderPane borderpane = new BorderPane();
    Label ecriture= new Label("le label");
    VBox labello= new VBox(ecriture);

    Pane milieu=new Pane();


    Button vert = new Button("Vert");
    Button rouge = new Button("Rouge");
    Button bleu = new Button("Bleu");
    HBox LesBoutons = new HBox(vert,rouge,bleu);

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage){
        //taille du stage
        primaryStage.setWidth(400);
        primaryStage.setHeight(200);
        borderpane.setBottom();





        Scene scene = new Scene(gridpane);
        primaryStage.show();

        }
}
