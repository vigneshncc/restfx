/*
 * Copyright 2014 RESTfx
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liquidlab.restfx.controller;

import com.liquidlab.restfx.main.RestFXApplication;
import com.liquidlab.restfx.manager.ScreenControlManager;
import com.liquidlab.restfx.manager.ScreenController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author tham
 */
public class NewController implements Initializable, ScreenController {
    private ScreenControlManager manager_;

    @FXML
    private GridPane headerGrid;

    @Override
    public void setParent(ScreenControlManager manager) {
        manager_ = manager;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        renderHeaderGridUi();
    }

    private void renderHeaderGridUi() {
        headerGrid.getChildren().clear();

        TextField keyField = new TextField();
        keyField.setPromptText("Enter a key");
        headerGrid.add(keyField, 0, 0);

        TextField valueField = new TextField();
        valueField.setPromptText("Enter a value");
        headerGrid.add(valueField, 1, 0);

        //Plus image view
        ImageView plusImage = new ImageView(new Image(
                RestFXApplication.class.getResourceAsStream("/com/liquidlab/restfx/images/plus.png")));
        headerGrid.add(plusImage, 2, 0);
    }
}
