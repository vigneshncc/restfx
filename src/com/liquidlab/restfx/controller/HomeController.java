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

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * Controller for home screen
 *
 * @author tham
 */
public class HomeController {

    @FXML
    protected void onNew(ActionEvent event) {
        System.out.println("onNew clicked");
    }

    @FXML
    protected void onSaved(ActionEvent event) {
        System.out.println("onSaved clicked");
    }

    @FXML
    protected void onClose(ActionEvent event) {
        System.out.println("Called action");
        Platform.exit();
    }

    @FXML
    protected void onAbout(ActionEvent event) {
        System.out.println("onAbout clicked");
    }
}
