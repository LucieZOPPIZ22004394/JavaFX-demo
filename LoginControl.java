package fr.amu.iut.exercice5;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button okBtn;
    @FXML
    private Button cancelBtn;

    /* Méthode invoquée automatiquement par le runtime JavaFX après la construction des objets du graphe de scène.
       Il est important de noter que si on l'utilise directement dans un constructeur explicite du contrôleur,
       cela risque de mal se passer, car les nœuds du graphe de scène ne seront pas encore instanciés, alors qu'on les
       utilise dans createBindings().
     */
    public void initialize() {
        createBindings();
    }

    private void createBindings() {
        // La propriété editable de la zone de texte pwd est liée à la condition : userId.textProperty().length() <= 6
        pwd.editableProperty().bind(Bindings.lessThanOrEqual(6, userId.textProperty().length()));

        // La propriété disable du bouton cancelBtn est liée à la condition :
        // pwd.textProperty().length() == 0 && userId.textProperty().length() == 0
        cancelBtn.disableProperty().bind(Bindings.and(
                Bindings.equal(0, pwd.textProperty().length()),
                Bindings.equal(0, userId.textProperty().length())));

        // Création d'une propriété booléenne basée sur une logique personnalisée
        // La propriété est liée à la condition définie dans la méthode computeValue()
        BooleanBinding containsLettersBinding = new BooleanBinding() {
            {
                super.bind(pwd.textProperty());
            }

            @Override
            protected boolean computeValue() {
                return pwd.getText().length() < 8
                        || pwd.getText().chars().noneMatch(Character::isUpperCase)
                        || pwd.getText().chars().noneMatch(Character::isDigit);
            }
        };

        // La propriété disable du bouton okBtn est liée à la propriété containsLettersBinding
        okBtn.disableProperty().bind(containsLettersBinding);
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}
