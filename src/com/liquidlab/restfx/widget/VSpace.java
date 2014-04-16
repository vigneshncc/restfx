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

import javafx.scene.layout.VBox;

/**
 * Provides empty height between 2 widgets
 * @author tham
 */
public class VSpace extends VBox {
    private static final double DEFAULT_HEIGHT = 10;
    public VSpace() {
        this(DEFAULT_HEIGHT);
    }

    public VSpace(double height) {
        super();
        setMinHeight(height);
    }
}
