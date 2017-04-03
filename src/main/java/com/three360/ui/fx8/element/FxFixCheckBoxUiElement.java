package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.CheckBoxT;
import com.three360.ui.common.element.IFixCheckBoxUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;

import java.util.Collections;
import java.util.List;

public class FxFixCheckBoxUiElement implements IFixCheckBoxUiElement<CheckBox, EventHandler<ActionEvent>> {

    private CheckBoxT checkBoxT;

    private CheckBox checkBox;

    private ParameterT parameterT;


    @Override
    public CheckBox create() {
        if (this.checkBoxT != null) {
            this.checkBox = new CheckBox(this.checkBoxT.getLabel());
            this.checkBox.setSelected(this.checkBoxT.isInitValue());
            this.checkBox.selectedProperty()
                    .addListener((observable, oldValue, newValue) ->
                            setFieldValueToParameter(newValue ?
                                            checkBoxT.getCheckedEnumRef() :
                                            checkBoxT.getUncheckedEnumRef(),
                                    parameterT));
            return this.checkBox;
        }
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {
    }

    @Override
    public void setCheckBoxT(CheckBoxT checkBoxT) {
        this.checkBoxT = checkBoxT;
    }

    @Override
    public void setParameters(List<ParameterT> parameterTList) {
        assert (parameterTList != null);
        parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }
}
