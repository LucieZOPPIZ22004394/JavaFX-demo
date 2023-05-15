package com.example.partie1.Exercice2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class Exercice2 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        GridPane conteneur= new GridPane();

        Label label1 = new Label();
        Label label2 = new Label();
        Label label3 = new Label();
        Label label4 = new Label();
        Label label5 = new Label();
        Label label6 = new Label();
        Label label7 = new Label();
        Label label8 = new Label();
        Label label9 = new Label();

        Image CCroix= new Image(Exercice2.class.getResource("Croix.png").toString());
        Image RRond= new Image(Exercice2.class.getResource("Rond.png").toString());
        Image VVide=new Image(Exercice2.class.getResource("Vide.png").toString());
        ImageView Croix = new ImageView(CCroix);
        ImageView Rond = new ImageView(RRond);
        ImageView Vide = new ImageView(VVide);
        ImageView Tab[]={Croix,Rond,Vide};

       label1.setStyle("-fx-border-color: lightgrey;");
       label2.setStyle("-fx-border-color: lightgrey;");
       label3.setStyle("-fx-border-color: lightgrey;");
       label4.setStyle("-fx-border-color: lightgrey;");
       label5.setStyle("-fx-border-color: lightgrey;");
       label6.setStyle("-fx-border-color: lightgrey;");
       label7.setStyle("-fx-border-color: lightgrey;");
       label8.setStyle("-fx-border-color: lightgrey;");
       label9.setStyle("-fx-border-color: lightgrey;");

        conteneur.add(label1,0,0);
        conteneur.add(label2,0,1);
        conteneur.add(label3,0,2);
        conteneur.add(label4,1,0);
        conteneur.add(label5,1,1);
        conteneur.add(label6,1,2);
        conteneur.add(label7,2,0);
        conteneur.add(label8,2,1);
        conteneur.add(label9,2,2);

        Random random = new Random();
        label1.setGraphic(Tab[random.nextInt(3)]);
        label2.setGraphic(Tab[random.nextInt(3)]);
        label3.setGraphic(Tab[random.nextInt(3)]);
        label4.setGraphic(Tab[random.nextInt(3)]);
        label5.setGraphic(Tab[random.nextInt(3)]);
        label6.setGraphic(Tab[random.nextInt(3)]);
        label7.setGraphic(Tab[random.nextInt(3)]);
        label8.setGraphic(Tab[random.nextInt(3)]);
        label9.setGraphic(Tab[random.nextInt(3)]);

        Scene scene=new Scene(conteneur);
        primaryStage.setScene(scene);
        primaryStage.setTitle("tic tac toe");
        primaryStage.show();
    }
}
