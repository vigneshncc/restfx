/*
 * Copyright 2014 RESTfx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liquidlab.restfx.main;

import com.liquidlab.restfx.controller.HomeController;
import com.liquidlab.restfx.manager.Screen;
import com.liquidlab.restfx.manager.ScreenControlManager;
import com.liquidlab.restfx.util.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Entry point for the RESTfx application
 *
 * @author tham
 */
public class RestFXApplication extends Application {

    @Override
    public void init() {
        //TODO: THAM: screen loader should be added
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(View.HOME));

        Parent homeView = loader.load();
        Scene scene = new Scene(homeView);

        HomeController homeController = (HomeController)loader.getController();
        BorderPane container = homeController.getMainContainer();

        ScreenControlManager screenControlManager = new ScreenControlManager();
        container.setCenter(screenControlManager);
        screenControlManager.setAlignment(Pos.CENTER);
        homeController.setScreenControlManager(screenControlManager);

        primaryStage.setFullScreen(true);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}