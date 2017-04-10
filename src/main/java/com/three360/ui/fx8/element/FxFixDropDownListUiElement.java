package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.DropDownListT;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixDropDownListUiElement implements IFixDropDownListUiElement<Pane, String> {

    private DropDownListT dropDownListT;
    private ComboBox<String> stringComboBox = new ComboBox<>();
    private GridPane gridPane;
    private int nextColumn = 0;
    private ParameterT parameterT;

    private ObjectProperty<String> checkedProperty = new SimpleObjectProperty<>();

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
                this.gridPane.add(new Label(this.dropDownListT.getLabel()), this.nextColumn++, 0);
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

            this.stringComboBox.setOnAction(event -> {
                if (parameterT != null)
                    setFieldValueToParameter(stringComboBox.getValue(), this.parameterT);

                checkedProperty.setValue(this.dropDownListT.getID());
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
    public ObjectProperty<String> listenChange() {
        return this.checkedProperty;
    }

    @Override
    public DropDownListT getControl() {
        return this.dropDownListT;
    }

    @Override
    public String getValue() {
        return this.stringComboBox.getValue();
    }

    @Override
    public void setValue(String s) {
        stringComboBox.setValue(s);
    }

    @Override
    public void makeVisible(boolean visible) {
        this.stringComboBox.setVisible(visible);
    }

    @Override
    public void makeEnable(boolean enable) {
        this.stringComboBox.setDisable(!enable);
    }
}
