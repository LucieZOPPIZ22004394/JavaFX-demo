module com.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.javafxdemo to javafx.fxml;
    opens com.example.partie2.Exercice11 to javafx.fxml;
    opens com.example.partie2.Whale to javafx.fxml;
    exports com.example.javafxdemo;
    exports com.example.partie1;
    exports com.example.partie2;
    exports com.example.partie2.Exercice4;
    exports com.example.partie1.Exercice2;
    exports com.example.partie2.Exercice5;
    exports com.example.partie2.Exercice11;
    exports com.example.partie2.Whale;

}