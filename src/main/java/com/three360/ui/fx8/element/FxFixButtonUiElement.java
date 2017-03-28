package com.three360.ui.fx8.element;

import com.three360.ui.common.element.IFixButtonUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class FxFixButtonUiElement implements IFixButtonUiElement<Button, EventHandler<ActionEvent>> {

    @Override
    public void setText(String label) {

    }

    @Override
    public Button create() {
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }

}
