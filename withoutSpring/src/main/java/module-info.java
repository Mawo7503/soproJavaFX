module de.mawo.withoutspring {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens de.mawo.withoutspring to javafx.fxml;
    exports de.mawo.withoutspring;
}