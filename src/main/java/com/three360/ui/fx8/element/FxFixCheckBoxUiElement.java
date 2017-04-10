package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.CheckBoxT;
import com.three360.ui.common.element.IFixCheckBoxUiElement;
import javafx.beans.property.ObjectProperty;
import javafx.scene.control.CheckBox;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;

public class FxFixCheckBoxUiElement implements IFixCheckBoxUiElement<CheckBox, String> {

    private CheckBoxT checkBoxT;

    private CheckBox checkBox;

    private ParameterT parameterT;



    @Override
    public CheckBox create() {
        if (this.checkBoxT != null) {
            this.checkBox = new CheckBox(this.checkBoxT.getLabel());

            if (this.checkBoxT.isInitValue() != null)
                this.checkBox.setSelected(this.checkBoxT.isInitValue());

            if (this.parameterT != null)
                this.checkBox.selectedProperty()
                        .addListener((observable, oldValue, newValue) ->
                                setFieldValueToParameter(newValue ?
                                                this.checkBoxT.getCheckedEnumRef() :
                                                this.checkBoxT.getUncheckedEnumRef(),
                                        this.parameterT));
            return this.checkBox;
        }
        return null;
    }

    @Override
    public void setCheckBoxT(CheckBoxT checkBoxT) {
        this.checkBoxT = checkBoxT;
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
