package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginMain extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // Crée un objet FXMLLoader pour charger le fichier FXML "LoginView.fxml"
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("exercice5/LoginView.fxml"));

        // Charge le fichier FXML et crée un graphe de scène à partir de celui-ci
        Scene scene = new Scene(fxmlLoader.load());

        // Configure la scène sur la fenêtre principale (Stage)
        stage.setScene(scene);

        // Définit un titre pour la fenêtre principale
        stage.setTitle("FXML Custom Control");

        // Affiche la fenêtre principale
        stage.show();
    }
}
