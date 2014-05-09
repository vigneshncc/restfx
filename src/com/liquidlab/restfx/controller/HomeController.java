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

package com.liquidlab.restfx.controller;

import com.liquidlab.restfx.manager.Screen;
import com.liquidlab.restfx.manager.ScreenControlManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

/**
 * Controller for home screen and handles button actions
 *
 * @author tham
 */
public class HomeController {
    private ScreenControlManager screenControlManager_;

    @FXML
    private BorderPane container;

    public BorderPane getContainer() {
        return container;
    }

    @FXML
    protected void onNew(ActionEvent event) {
        screenControlManager_.setScreen(Screen.NEW);
    }

    @FXML
    protected void onSaved(ActionEvent event) {
        screenControlManager_.setScreen(Screen.SAVED);
    }

    @FXML
    protected void onClose(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    protected void onAbout(ActionEvent event) {
        System.out.println("onAbout clicked");
    }

    @FXML
    protected void onChart(ActionEvent event) {
        System.out.println("On clicked called");
    }

    public void setScreenControlManager(ScreenControlManager screenControlManager) {
        screenControlManager_ = screenControlManager;
    }
}
