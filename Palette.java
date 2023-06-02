package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    // Variables de comptage pour chaque couleur
    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    // Éléments graphiques
    private Label texteDuHaut;
    private Button vert;
    private Button rouge;
    private Button bleu;
    private BorderPane root;
    private Pane panneau;
    private HBox boutons;
    private IntegerProperty nbFois; // Propriété représentant le nombre de fois qu'un bouton a été cliqué
    private StringProperty message; // Propriété représentant le message affiché dans le bas de l'interface
    private StringProperty couleurPanneau; // Propriété représentant la couleur de fond du panneau
    private Label texteDuBas;

    public Palette() {
        nbFois = new SimpleIntegerProperty();
        message = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* code ajouté pour la correction */

        // Événements de clic pour les boutons
        rouge.setOnAction(event -> {
            nbFois.setValue(++nbRouge);
            message.setValue("Rouge");
            couleurPanneau.setValue("#F21411");
        });
        vert.setOnAction(event -> {
            nbFois.setValue(++nbVert);
            message.setValue("Vert");
            couleurPanneau.setValue("#31BCA4");
        });
        bleu.setOnAction(event -> {
            nbFois.setValue(++nbBleu);
            message.setValue("Bleu");
            couleurPanneau.setValue("#3273A4");
        });

        createBindings();
        /* fin code ajouté pour la correction */

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void createBindings() {
        // Création d'une propriété booléenne pour vérifier si aucun bouton n'a encore été cliqué
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty();

        // La propriété pasEncoreDeClic est liée à l'égalité entre nbFois et 0
        pasEncoreDeClic.bind(Bindings.equal(0, nbFois));

        // La propriété textProperty de texteDuHaut est liée à un binding conditionnel :
        // Si pasEncoreDeClic est vrai, affiche le message "Cliquez sur un bouton",
        // Sinon concatène le message, le nombre de fois cliqué et le mot "fois"
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("Cliquez sur un bouton").otherwise(Bindings.concat(message, " choisi ", nbFois.asString(), " fois")));

        // La propriété styleProperty de panneau est liée à un binding conditionnel :
        // Si pasEncoreDeClic est vrai, conserve le style actuel du panneau,
        // Sinon concatène une nouvelle valeur de style avec la couleur de fond sélectionnée
        panneau.styleProperty().bind(Bindings.when(pasEncoreDeClic).then(panneau.getStyle()).
                otherwise(Bindings.concat("-fx-background-color: ", couleurPanneau)));

        // La propriété textProperty de texteDuBas est liée à un binding conditionnel :
        // Si pasEncoreDeClic est vrai, affiche une chaîne vide,
        // Sinon concatène le message "Le", le message sélectionné et la phrase "est une jolie couleur !"
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClic).
                then("").otherwise(Bindings.concat("Le ", message, " est une jolie couleur !")));

        // La propriété styleProperty de texteDuBas est liée à une concaténation de la couleur de fond sélectionnée
        // pour définir la couleur du texte ("-fx-text-fill: <couleur>")
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill: ", couleurPanneau));
    }

