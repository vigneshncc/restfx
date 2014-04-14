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

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Renders header layout
 *
 * @author tham
 */
public class HeaderLayout extends HBox {
    public HeaderLayout() {
        this(LayoutConstant.MIN_HEIGHT);
    }

    public HeaderLayout(double minHeight) {
        super();
        setMinHeight(minHeight);
        setStyle("-fx-background-color: #336699;");
        setAlignment(Pos.CENTER_LEFT);

        renderUi();
    }

    private void renderUi() {
        Label titleLabel = new Label("RESTfx");
        this.getChildren().add(titleLabel);
    }
}
