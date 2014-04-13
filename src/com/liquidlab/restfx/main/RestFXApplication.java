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

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
        HBox header = new HBox();
        header.setMinHeight(40);
        header.setStyle("-fx-background-color: #336699;");

        Label headerLabel = new Label("RESTfx");
        headerLabel.setStyle("-fx-font-color: white;");
        header.getChildren().add(headerLabel);

        return header;
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
        VBox bodyRightPane = new VBox();
        bodyRightPane.setPadding(new Insets(10));
        bodyRightPane.setSpacing(5);
        bodyRightPane.setPrefWidth(600);
        bodyRightPane.setAlignment(Pos.TOP_LEFT);

        //Url
        bodyRightPane.getChildren().add(new Label("REST URL:"));
        TextField pathField = new TextField();
        pathField.setMinWidth(250);
        bodyRightPane.getChildren().add(pathField);

        //space
        VBox spaceBox = new VBox();
        spaceBox.setMinHeight(10);
        bodyRightPane.getChildren().add(spaceBox);

        //Http methods
        bodyRightPane.getChildren().add(new Label("HTTP Method:"));
        ComboBox<String> httpMethods = new ComboBox<String>();
        ObservableList<String> items = httpMethods.getItems();
        items.add("DELETE");
        items.add("GET");
        items.add("HEAD");
        items.add("POST");
        items.add("PUT");

        httpMethods.getSelectionModel().select(1);
        bodyRightPane.getChildren().add(httpMethods);

        return bodyRightPane;
    }

    private FlowPane getBodyLeft() {
        FlowPane bodyLeftPane = new FlowPane();
        bodyLeftPane.setPadding(new Insets(5, 0, 5, 0));
        bodyLeftPane.setVgap(4);
        bodyLeftPane.setHgap(4);
        bodyLeftPane.setPrefWrapLength(70);
        bodyLeftPane.setStyle("-fx-background-color: DAE6F3;");

        ImageView requestImage = new ImageView(new Image(RestFXApplication.class.getResourceAsStream("images/request.png")));
        bodyLeftPane.getChildren().add(requestImage);

        ImageView requestImage1 = new ImageView(new Image(RestFXApplication.class.getResourceAsStream("images/request.png")));
        bodyLeftPane.getChildren().add(requestImage1);
        return bodyLeftPane;
    }

    private HBox getFooter() {
        HBox footer = new HBox();
        footer.setMinHeight(40);
        footer.setStyle("-fx-background-color: #336699;");
        footer.getChildren().add(new Label("(C) Liquid Lab"));
        return footer;
    }

    public static void main(String[] args) {
        launch(args);
    }
}