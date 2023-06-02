package tp1.exercice1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        // Création de la barre de menu
        MenuBar menuBar = new MenuBar();

        // Création du menu "File"
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");
        MenuItem exitItem = new MenuItem("Exit");
        fileMenu.getItems().addAll(newItem, openItem, saveItem, exitItem);

        // Création du menu "Edit"
        Menu editMenu = new Menu("Edit");
        MenuItem cutItem = new MenuItem("Cut");
        MenuItem copyItem = new MenuItem("Copy");
        MenuItem pasteItem = new MenuItem("Paste");
        editMenu.getItems().addAll(cutItem, copyItem, pasteItem);

        // Ajout des menus à la barre de menu
        menuBar.getMenus().addAll(fileMenu, editMenu, new Menu("Help"));

        // Ajout de la barre de menu à la racine du conteneur BorderPane
        root.setTop(menuBar);

        // Création de la section de gauche avec des boutons
        VBox leftBox = new VBox();
        leftBox.setAlignment(Pos.CENTER);
        leftBox.setSpacing(10);

        Label buttonLabel = new Label("Boutons :");

        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");
        Button button3 = new Button("Bouton 3");
        leftBox.getChildren().addAll(buttonLabel, button1, button2, button3);

        // Ajout d'un séparateur entre la section de gauche et la section centrale
        root.setLeft(new HBox(leftBox, new Separator(Orientation.VERTICAL)));

        // Création de la section centrale avec un formulaire
        GridPane grilleFormulaire = new GridPane();
        grilleFormulaire.setAlignment(Pos.CENTER);
        grilleFormulaire.setHgap(10);
        grilleFormulaire.setVgap(10);
        grilleFormulaire.setPadding(new Insets(10));

        grilleFormulaire.addRow(0, new Label("Name:"), new TextField());
        grilleFormulaire.addRow(1, new Label("Email:"), new TextField());
        grilleFormulaire.addRow(2, new Label("Password:"), new TextField());

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(10);

        buttonBox.getChildren().addAll(new Button("Submit"), new Button("Cancel"));

        grilleFormulaire.add(buttonBox, 0, 3, 2, 1);

        root.setCenter(grilleFormulaire);

        // Création de la section inférieure avec une étiquette de statut
        Label statusLabel = new Label("Ceci est un label de bas de page");
        VBox bas = new VBox(new Separator(O
