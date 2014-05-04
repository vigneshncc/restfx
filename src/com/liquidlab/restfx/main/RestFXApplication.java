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

import com.liquidlab.restfx.layout.ContentLayout;
import com.liquidlab.restfx.layout.FooterLayout;
import com.liquidlab.restfx.layout.HeaderLayout;
import com.liquidlab.restfx.widget.ImageButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Entry point for the application
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
        Parent homeView = FXMLLoader.load(getClass().getResource("../layout/home.fxml"));

        Scene scene = new Scene(homeView);
        primaryStage.setScene(scene);

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}