package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.EditableDropDownListT;
import com.three360.ui.common.element.IFixEditableDropDownListUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.stream.Collectors;

/**
 * Created by sainik on 3/27/17.
 */
public class FxFixEditableDropDownListUiElement
        implements IFixEditableDropDownListUiElement<HBox, EventHandler<ActionEvent>> {

    private ComboBox<String> stringComboBox;

    private EditableDropDownListT editableDropDownListT;
    private Label label;
    private HBox hBox;

    @Override
    public HBox create() {
        if (this.editableDropDownListT != null) {
            this.hBox = new HBox();
            this.hBox.getChildren().add(this.label = new Label(this.editableDropDownListT.getLabel()));
            this.stringComboBox = new ComboBox<>();
            this.stringComboBox.getItems()
                    .addAll(this.editableDropDownListT.getListItem().stream().map(listItemT -> listItemT.getUiRep()).collect(Collectors.toList()));
            // TODO check
            this.stringComboBox.getSelectionModel().select(editableDropDownListT.getInitValue());
            this.stringComboBox.setEditable(true);
            this.hBox.getChildren().add(this.stringComboBox);
            return this.hBox;
        }
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }

    @Override
    public void setEditableDropDownList(EditableDropDownListT editableDropDownListT) {
        this.editableDropDownListT = editableDropDownListT;

    }
}
