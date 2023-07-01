package de.mawo.withSpring;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Needed if you want to use Spring
 * */
@SpringBootApplication
public class TheSpringApplication {

    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
        SpringApplication.run(TheSpringApplication.class, args);
    }
}
