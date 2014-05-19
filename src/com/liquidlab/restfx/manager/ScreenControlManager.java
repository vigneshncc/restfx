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

import javafx.animation.FadeTransition;
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

    /**
     * Method to show the current screen in the main application
     *
     * @param screen
     * @return true if successfully shown otherwise false
     */
    public boolean show(Screen screen) {
        Node currentNode = getScreen(screen);

        // Not added already in the stack
        if (currentNode == null) {
            currentNode = loadScreen(screen);
        }

        // current node should not be null. if null break further processing
        if (currentNode == null) {
            System.out.println("Screen with name " + screen.getView() + " is not available");
            return false;
        }

        // Removes the current children
        if (getChildren() != null && getChildren().size() > 0) {
            getChildren().remove(0);
        }

        getChildren().add(currentNode);

        //Animation to show the current screen
        FadeTransition transition = new FadeTransition(Duration.millis(3000), currentNode);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition.play();

        return true;
    }

    private Node loadScreen(Screen screen) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(screen.getView()));
        Parent node = null;
        try {
            node = (Parent)loader.load();
            ScreenController screenController = (ScreenController) loader.getController();
            screenController.setParent(this);
            addScreen(screen, node);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return node;
    }

    private void addScreen(Screen screen, Node node) {
        screens.put(screen, node);
    }

    private Node getScreen(Screen screen) {
        Node node = screens.get(screen);
        if (node != null) {
            return node;
        }

        return null;
    }

    /*public boolean loadScreen(Screen screen, String name) {
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
    }*/

    /*public boolean setScreen(Screen screen) {
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
    }*/
}
