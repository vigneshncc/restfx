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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Entry point for the application
 *
 * @author tham
 */
public class RestFXApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setScene(getMainScene());
//        primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    private Scene getMainScene() {
        BorderPane borderPane = new BorderPane();

        //Header Layout
        borderPane.setTop(getHeader());

        //Body Layout
        borderPane.setCenter(getBody());

        //Footer Layout
        borderPane.setBottom(getFooter());
        return new Scene(borderPane, 700, 500);
    }

    private HBox getHeader() {
        return new HeaderLayout();
    }

    private BorderPane getBody() {
        BorderPane bodyPane = new BorderPane();

        //Body left layout
        bodyPane.setLeft(getBodyLeft());

        //Body right layout
        bodyPane.setRight(getBodyRight());

        return bodyPane;
    }

    private VBox getBodyRight() {
        return new ContentLayout();
    }

    private FlowPane getBodyLeft() {
        FlowPane bodyLeftPane = new FlowPane();
        bodyLeftPane.setPadding(new Insets(5, 0, 5, 0));
        bodyLeftPane.setVgap(10);
        bodyLeftPane.setHgap(5);
        bodyLeftPane.setPrefWrapLength(70);
//        bodyLeftPane.setStyle("-fx-background-color: DAE6F3;");

//        ImageView requestImage = new ImageView(new Image(RestFXApplication.class.getResourceAsStream("/com/liquidlab/restfx/images/request.png")));
        bodyLeftPane.getChildren().add(new ImageButton("Request", null));

//        ImageView aboutImage = new ImageView(new Image(RestFXApplication.class.getResourceAsStream("/com/liquidlab/restfx/images/about.png")));
        bodyLeftPane.getChildren().add(new ImageButton("About", null));
//        bodyLeftPane.getChildren().add(aboutImage);
        return bodyLeftPane;
    }

    private HBox getFooter() {
        return new FooterLayout();
    }

    public static void main(String[] args) {
        launch(args);
    }
}