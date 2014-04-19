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

package com.liquidlab.restfx.layout;

import com.liquidlab.restfx.widget.VSpace;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

/**
 * Renders main content layout
 *
 * @author tham
 */
public class ContentLayout extends AbstractVerticalLayout {
    public ContentLayout() {
        super();
    }

    @Override
    public void renderUi() {
        //REST Url
        getChildren().add(new Label("REST URL:"));
        TextField pathField = new TextField();
        pathField.setMinWidth(250);
        getChildren().add(pathField);

        //space
        getChildren().add(new VSpace());

        //Http methods
        getChildren().add(new Label("HTTP Method:"));
        ComboBox<String> httpMethods = new ComboBox<String>();
        ObservableList<String> items = httpMethods.getItems();
        items.add("DELETE");
        items.add("GET");
        items.add("HEAD");
        items.add("POST");
        items.add("PUT");

        httpMethods.getSelectionModel().select(1);
        getChildren().add(httpMethods);

        //space
        getChildren().add(new VSpace());

        //Request headers
        Group requestHeaderWidgets = new Group();
        ObservableList<Node> children = requestHeaderWidgets.getChildren();

        TitledPane requestHeadersPane = new TitledPane("Request Headers", new Button("Hello"));
        requestHeadersPane.setAnimated(true);
        requestHeadersPane.setExpanded(false);
        getChildren().add(requestHeadersPane);
    }
}