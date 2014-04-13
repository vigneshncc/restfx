package com.liquidlab.restfx.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(new Scene(null, 300, 275));
        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
