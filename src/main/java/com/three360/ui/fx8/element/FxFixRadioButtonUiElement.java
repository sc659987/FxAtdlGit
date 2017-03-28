package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.RadioButtonT;
import com.three360.ui.common.element.IFixRadioButtonUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

public class FxFixRadioButtonUiElement implements IFixRadioButtonUiElement<RadioButton, EventHandler<ActionEvent>> {

    private RadioButtonT radioButtonT;
    private RadioButton radioButton;

    @Override
    public RadioButton create() {
        if (this.radioButtonT != null) {
            this.radioButton = new RadioButton(this.radioButtonT.getLabel());
            return this.radioButton;
        }
        return null;
    }

    @Override
    public void setRadioButtonT(RadioButtonT radioButtonT) {
        this.radioButtonT = radioButtonT;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }
}
