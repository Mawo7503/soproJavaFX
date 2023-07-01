module de.mawo.withspring {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires spring.boot.autoconfigure;
    requires spring.boot;
    requires spring.context;

    opens de.mawo.withSpring to javafx.fxml;
    exports de.mawo.withSpring;
}