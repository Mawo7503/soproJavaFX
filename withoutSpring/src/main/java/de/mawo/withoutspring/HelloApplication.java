package de.mawo.withoutspring;

import javafx.application.Application;
import org.kordamp.bootstrapfx.BootstrapFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start-Point of a JavaFX programm
 * You need both methods and the 'extends Application'
 * If you want to use e.g. JavaFX and Spring, refer to the other project in this repo
 * * */
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Noten verwalten");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}