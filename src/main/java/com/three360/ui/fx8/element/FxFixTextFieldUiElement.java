package com.three360.ui.fx8.element;

import com.sun.deploy.util.StringUtils;
import com.sun.istack.internal.NotNull;
import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.TextFieldT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixTextFieldUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.List;

/**
 * Created by sainik on 3/24/17.
 */
public class FxFixTextFieldUiElement implements IFixTextFieldUiElement<Pane, ChangeListener<String>> {

    /***
     *
     */
    private TextFieldT textFieldT;

    /****
     *
     */
    private TextField textField;
    private Label label;
    private GridPane gridPane;

    /****
     *
     */
    private List<ParameterT> parameterTList;

    private ParameterT parameterT;

    /****
     *
     */
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
        assert (parameterTList != null);
        this.parameterTList = parameterTList;
        this.parameterT = this.parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        return this.parameterTList;
    }
}
