package de.mawo.withSpring;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import org.kordamp.bootstrapfx.BootstrapFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * Start-Point of a JavaFX application AND Spring application
 * You need both methods and the 'extends Application'
 * * */
public class HelloApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws IOException {
        applicationContext = new SpringApplicationBuilder(HelloController.class).run();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        loader.setControllerFactory(applicationContext::getBean);   //ERROR: IllegalAccessError class de.mawo.withSpring.HelloApplication (in module de.mawo.withspring) cannot access class org.springframework.beans.factory.BeanFactory (in unnamed module @0x41b86131) because module de.mawo.withspring does not read unnamed module @0x41b86131
        Parent root = loader.load();
        HelloController controller = loader.getController();
    }

    @Override
    public void start(Stage stage) throws IOException {
        applicationContext.publishEvent(new StageReadyEvent(stage));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Noten Übersicht");
        stage.setScene(scene);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
    }
}
