package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.CheckBoxListT;
import com.three360.fixatdl.layout.PanelOrientationT;
import com.three360.ui.common.element.IFixCheckBoxListUiElement;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixCheckBoxListUiElement
        implements IFixCheckBoxListUiElement<Pane, ChangeListener<List<String>>, List<String>> {

    private CheckBoxListT checkBoxListT;

    private GridPane gridPane;

    private List<CheckBox> checkBoxes;

    private Label label;

    private ParameterT parameterT;

    private int nextRow = 0;

    private ChangeListener<List<String>> listener;

    @Override
    public Pane create() {
        if (this.checkBoxListT != null) {
            this.gridPane = new GridPane();

            if (this.checkBoxListT.getLabel() != null && !this.checkBoxListT.getLabel().equals(""))
                this.gridPane.add(this.label = new Label(this.checkBoxListT.getLabel()),
                        0, this.nextRow++, GridPane.REMAINING, 1);


            this.checkBoxes = this.checkBoxListT.getListItem().stream().map(listItemT -> {
                CheckBox checkBox = new CheckBox();
                checkBox.setId(listItemT.getEnumID());
                checkBox.setText(listItemT.getUiRep());
                return checkBox;
            }).collect(Collectors.toList());

            this.checkBoxes.stream()
                    .filter(checkBox -> checkBox.getId().equals(
                            this.checkBoxListT.getInitValue()))
                    .collect(Collectors.toList())
                    .forEach(checkBox -> checkBox.setSelected(true));

            this.gridPane.setHgap(2.0);
            this.gridPane.setVgap(2.0);

            if (parameterT != null)
                checkBoxes.stream().forEach(checkBox ->
                        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                            List<String> checkedCheckBoxes = checkBoxes.stream()
                                    .filter(CheckBox::isSelected)
                                    .map(cb -> cb.getId())
                                    .collect(Collectors.toList());
                            if (listener != null)
                                listener.changed(null, null, checkedCheckBoxes);
                            setFieldValueToParameter(String.join(" ", checkedCheckBoxes), parameterT);
                        })
                );
            //TODO change it to functional code using marge


            for (int index = 0; index < this.checkBoxes.size(); index++) {
                if (this.checkBoxListT.getOrientation() == PanelOrientationT.HORIZONTAL) {
                    this.gridPane.add(this.checkBoxes.get(index), 3 * index, this.nextRow, 1, 1);
                } else {
                    this.gridPane.add(this.checkBoxes.get(index), 0, this.nextRow++, GridPane.REMAINING, 1);
                }
            }

            return this.gridPane;
        }
        return null;
    }


    @Override
    public void registerForEvent(ChangeListener<List<String>> listener) {
        this.listener = listener;
    }

    @Override
    public FxFixCheckBoxListUiElement setCheckBoxListT(CheckBoxListT checkBoxListT) {
        this.checkBoxListT = checkBoxListT;
        return this;
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
    public void makeElementVisible(boolean visible) {

    }

    @Override
    public void makeElementEnable(boolean enable) {

    }

    @Override
    public void setValue(List<String> value) {
        
    }
}
