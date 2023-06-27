module de.mawo.withoutspring {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens de.mawo.withoutspring to javafx.fxml;
    exports de.mawo.withoutspring;
}