package com.example.project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main Driver file.
 * This file basically sets our staqe for the GUI of the project and runs it from the main method.
 * * @author Reiya Dave, Ifrah Sajjad
 */
public class GymManagerMain extends Application {

    /***
     * Start method is loading our fxml file for Gym Manager and setting the scene, the scene title,
     * and showing our GUI.
     * @param stage
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GymManagerMain.class.getResource("GymManagerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gym Manager");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method for the file. This is our main driver method.
     * @param args
     * */
    public static void main(String[] args) {

        launch();
    }


}