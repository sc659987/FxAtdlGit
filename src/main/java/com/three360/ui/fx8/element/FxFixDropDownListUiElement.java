package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.DropDownListT;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixDropDownListUiElement implements IFixDropDownListUiElement<Pane, String> {

    private DropDownListT dropDownListT;

    private ComboBox<String> stringComboBox = new ComboBox<>();

    private ChangeListener<String> handlers;
    private Label label;
    private GridPane gridPane;

    private int nextColumn = 0;

    private ParameterT parameterT;

    @Override
    public void setDropDownList(DropDownListT downList) {
        this.dropDownListT = downList;
    }

    @Override
    public Pane create() {
        if (this.dropDownListT != null) {
            this.gridPane = new GridPane();
            if (this.dropDownListT.getLabel() != null && !this.dropDownListT.getLabel().equals("")) {
                this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
                this.gridPane.add(this.label = new Label(this.dropDownListT.getLabel()), this.nextColumn++, 0);
            }
            this.stringComboBox.getItems()
                    .addAll(this.dropDownListT
                            .getListItem()
                            .stream()
                            .map(listItemT -> listItemT.getUiRep())
                            .collect(Collectors.toList()));

            if (this.dropDownListT.getInitValue() == null || this.dropDownListT.getInitValue().equals(""))
                this.stringComboBox.getSelectionModel().selectFirst();
            else
                this.stringComboBox.getSelectionModel().select(this.dropDownListT.getInitValue());


            this.stringComboBox
                    .valueProperty()
                    .addListener((observable, oldValue, newValue) -> {
                        if (handlers != null)
                            handlers.changed(observable, oldValue, newValue);
                        if (parameterT != null)
                            setFieldValueToParameter(newValue, this.parameterT);
                    });

            this.gridPane.add(this.stringComboBox, this.nextColumn, 0);

            return this.gridPane;
        }
        return null;
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
