package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.RadioButtonT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixRadioButtonUiElement;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FxFixRadioButtonUiElement implements IFixRadioButtonUiElement<RadioButton, String> {

    private RadioButtonT radioButtonT;

    private RadioButton radioButton;

    private ParameterT parameterT;


    private static final Map<String, ToggleGroup> TOGGLE_GROUPS = new HashMap<>();

    @Override
    public RadioButton create() {
        if (this.radioButtonT != null) {
            this.radioButton = new RadioButton(this.radioButtonT.getLabel());
            if (!Utils.isEmpty(this.radioButtonT.getRadioGroup())) {
                ToggleGroup toggleGroup = TOGGLE_GROUPS.get(this.radioButtonT.getRadioGroup());
                if (toggleGroup == null)
                    TOGGLE_GROUPS.put(this.radioButtonT.getRadioGroup(), toggleGroup = new ToggleGroup());
                this.radioButton.setToggleGroup(toggleGroup);
            }
            if (this.radioButtonT.isInitValue() != null) {
                this.radioButton.setSelected(this.radioButtonT.isInitValue());
            }
            this.radioButton.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (parameterT != null)
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
    public void setParameters(List<ParameterT> parameterTList) {
        if (parameterTList != null && parameterTList.size() > 0)
            this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }

    @Override
    public ObjectProperty<Pair<String, String>> listenChange() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void setValue(String s) {

    }

    @Override
    public void makeVisible(boolean visible) {

    }

    @Override
    public void makeEnable(boolean enable) {

    }
}
