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

package com.liquidlab.restfx.widget;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Custom button widget with image
 *
 * @author tham
 */
public class ImageButton extends Button {
    private String imagePath = null;

    public ImageButton(String name, String imagePath) {
        super(name);
        this.imagePath = imagePath;
        setPrefWidth(WidgetConstant.BTN_MIN_WIDTH);

        renderUi();
    }

    public ImageButton(String name, String imagePath, EventHandler handler) {
        this(name, imagePath);
        if (handler != null) {
            setOnAction(handler);
        }
    }

    private void renderUi() {
        if (imagePath == null || imagePath.equals("")) {
            return;
        }

        setGraphic(new ImageView(new Image(ImageButton.class.getResourceAsStream(imagePath))));
    }
}
