package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.RadioButtonT;
import com.three360.ui.common.element.IFixRadioButtonUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

import java.util.Collections;
import java.util.List;

public class FxFixRadioButtonUiElement implements IFixRadioButtonUiElement<RadioButton, EventHandler<ActionEvent>> {

    private RadioButtonT radioButtonT;
    private RadioButton radioButton;

    private ParameterT parameterT;

    @Override
    public RadioButton create() {
        if (this.radioButtonT != null) {
            this.radioButton = new RadioButton(this.radioButtonT.getLabel());
            this.radioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
                setFieldValueToParameter(newValue, this.parameterT);
            });
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

    @Override
    public void setParameters(List<ParameterT> parameterTList) {
        assert (parameterTList != null);
        this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }
}
