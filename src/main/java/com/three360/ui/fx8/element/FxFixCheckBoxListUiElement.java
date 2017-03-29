package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.CheckBoxListT;
import com.three360.fixatdl.layout.PanelOrientationT;
import com.three360.ui.common.element.IFixCheckBoxListUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.stream.Collectors;


public class FxFixCheckBoxListUiElement implements IFixCheckBoxListUiElement<Pane, EventHandler<ActionEvent>> {

    private CheckBoxListT checkBoxListT;
    private GridPane gridPane;
    private List<CheckBox> checkBoxes;
    private Label label;

    private int nextRow = 0;

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
                    .filter(checkBox -> checkBox.getId().equals(this.checkBoxListT.getInitValue())).collect(Collectors.toList())
                    .forEach(checkBox -> {
                        checkBox.setSelected(true);
                    });
            this.gridPane.setHgap(2.0);
            this.gridPane.setVgap(2.0);
            for (int i = 0; i < this.checkBoxes.size(); i++) {
                if (this.checkBoxListT.getOrientation() == PanelOrientationT.HORIZONTAL) {
                    this.gridPane.add(this.checkBoxes.get(i), 3 * i, nextRow, 3, 1);
                } else {
                    this.gridPane.add(this.checkBoxes.get(i), 0, nextRow++, GridPane.REMAINING, 1);
                }
            }
            return this.gridPane;
        }
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }

    @Override
    public FxFixCheckBoxListUiElement setCheckBoxListT(CheckBoxListT checkBoxListT) {
        this.checkBoxListT = checkBoxListT;
        return this;
    }
}
