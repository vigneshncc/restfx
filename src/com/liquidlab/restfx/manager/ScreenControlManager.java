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

package com.liquidlab.restfx.manager;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.HashMap;

/**
 * Handles the screens and its navigation
 *
 * @author tham
 */
public class ScreenControlManager extends StackPane {
    private static final HashMap<Screen, Node> screens = new HashMap<>();

    public ScreenControlManager() {
        super();
    }

    public void addScreen(Screen screen, Node node) {
        screens.put(screen, node);
    }

    public Node getScreen(Screen screen) {
        return screens.get(screen);
    }

    public boolean loadScreen(Screen screen, String name) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(name));
        try {
            Parent parent = (Parent)loader.load();
            ScreenController screenController = (ScreenController) loader.getController();
            screenController.setParent(this);

            addScreen(screen, parent);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }

        return true;
    }

    public boolean setScreen(Screen screen) {
        Node currentScreen = getScreen(screen);
        if (currentScreen == null) {
            return false;
        }

        //Screen is already available
        boolean isEmpty = getChildren().isEmpty();
        if (isEmpty) {

        }

        DoubleProperty opacity = opacityProperty();

        Timeline fade = new Timeline(
            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
            new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (getChildren() != null && getChildren().size() > 0) {
                        getChildren().remove(0);
                    }

                    getChildren().add(screens.get(screen));
                    Timeline fadeIn = new Timeline(
                            new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                            new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));
                    fadeIn.play();
                }
            }, new KeyValue(opacity, 0.0))
        );

        fade.play();
        return false;
    }
}
