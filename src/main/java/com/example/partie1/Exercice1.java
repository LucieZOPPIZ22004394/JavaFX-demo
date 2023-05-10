package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.security.cert.PolicyNode;

public class Exercice1 extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Création du conteneur principal
        VBox vbox;
        {
            vbox = new VBox();
        }


        //menu au desssus
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Options");
        Menu menu3 = new Menu("Help");
        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);

        //boutons sur le coté
        Label label = new Label("Boutons:");
        Button b1 = new Button("Bouton 1");
        Button b2 = new Button("Bouton 2");
        Button b3 = new Button("Bouton 3");
        Separator separator = new Separator(Orientation.HORIZONTAL);
        VBox LesBoutons = new VBox(label,b1,b2,b3,separator);

        //label de pas de page
        HBox topRightControls= new HBox();
        Label labelBasDePage = new Label("Ceci est un label de bas de page");
        topRightControls.setAlignment( Pos.CENTER );

        //vbox du milieu la
        GridPane gridpane = new GridPane();
        Button button = new Button();
        GridPane.setRowIndex(button, 0);
        GridPane.setColumnIndex(button, 1);




        topRightControls.getChildren().addAll(labelBasDePage);

        vbox.getChildren().addAll(menuBar,LesBoutons,topRightControls);



        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("VBox and HBox App");

        // Affichage de la fenêtre
        primaryStage.show();
    }

}



