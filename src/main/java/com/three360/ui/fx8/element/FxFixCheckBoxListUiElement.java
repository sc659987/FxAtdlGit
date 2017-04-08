package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.CheckBoxListT;
import com.three360.fixatdl.layout.PanelOrientationT;
import com.three360.ui.common.element.IFixCheckBoxListUiElement;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixCheckBoxListUiElement implements IFixCheckBoxListUiElement<Pane, ChangeListener<List<String>>> {

    private CheckBoxListT checkBoxListT;

    private GridPane gridPane;

    private List<CheckBox> checkBoxes;

    private Label label;

    private ParameterT parameterT;

    private int nextRow = 0;

    ObjectProperty<Pair<String, List<String>>> pairObjectProperty = new SimpleObjectProperty<>();

    @Override
    public Pane create() {
        if (this.checkBoxListT != null) {
            this.gridPane = new GridPane();

            if (this.checkBoxListT.getLabel() != null && !this.checkBoxListT.getLabel().equals("")) {
                this.label = new Label(this.checkBoxListT.getLabel());
                this.gridPane.add(this.label, 0, this.nextRow++, GridPane.REMAINING, 1);
            }

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


            pairObjectProperty.addListener((observable, oldValue, newValue) -> {
                System.out.println(observable);
                System.out.println(newValue);
            });


            checkBoxes.stream().forEach(checkBox -> {
                checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
                    pairObjectProperty.setValue(new Pair<>(this.checkBoxListT.getID(), checkBoxes.stream()
                            .filter(CheckBox::isSelected)
                            .map(cb -> cb.getId())
                            .collect(Collectors.toList())));
                    //System.out.println(observable);
                });
            });

            if (parameterT != null)
                this.checkBoxes.stream().forEach(checkBox -> {
                    checkBox.setOnAction(event -> {
                        CheckBox ch = (CheckBox) event.getSource();
                        if (ch.isSelected()) {
                            setFieldValueToParameter(String.join(" ", checkBoxes.stream()
                                    .filter(CheckBox::isSelected)
                                    .map(cb -> cb.getId())
                                    .collect(Collectors.toList())), parameterT);
                        }

                    });
                });


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

//    ChangeListener<List<String>> listChangeListener


//    public ChangeListener<List<String>> listen(){
//
//
//    }


    @Override
    public void registerForEvent(ChangeListener<List<String>> listener) {


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
}
