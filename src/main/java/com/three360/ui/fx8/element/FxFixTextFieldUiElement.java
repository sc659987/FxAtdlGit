package com.three360.ui.fx8.element;

import com.sun.istack.internal.NotNull;
import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.TextFieldT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixTextFieldUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.List;

public class FxFixTextFieldUiElement implements IFixTextFieldUiElement<Pane, ChangeListener<String>> {

    private TextFieldT textFieldT;

    private TextField textField;
    private Label label;
    private GridPane gridPane;

    private ParameterT parameterT;
    private int nextColumn = 0;

    @Override
    public Pane create() {
        if (this.textFieldT != null) {
            this.gridPane = new GridPane();
            if (this.textFieldT.getLabel() != null && !this.textFieldT.getLabel().equals("")) {
                this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
                this.gridPane.add(this.label = new Label(this.textFieldT.getLabel()), this.nextColumn++, 0);
            }
            this.textField = new TextField(this.textFieldT.getInitValue());

            if (parameterT != null)
                this.textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue.equals("-") || parameterT == null)
                        return;
                    if (!Utils.isEmpty(newValue) && !setFieldValueToParameter(newValue, parameterT))
                        textField.textProperty().setValue(oldValue);

                });
            this.gridPane.add(this.textField, this.nextColumn, 0);
            return this.gridPane;
        }
        return null;
    }

    @Override
    public void setTextField(TextFieldT textField) {
        this.textFieldT = textField;
    }

    @Override
    public void registerForEvent(ChangeListener<String> e) {

    }

    @Override
    public void setParameters(@NotNull List<ParameterT> parameterTList) {
        if (parameterTList != null && parameterTList.size() > 0)
            this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }
}
