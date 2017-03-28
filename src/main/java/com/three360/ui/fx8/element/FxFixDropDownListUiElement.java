package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.DropDownListT;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.stream.Collectors;

public class FxFixDropDownListUiElement implements IFixDropDownListUiElement<HBox, EventHandler<ActionEvent>> {

    private DropDownListT dropDownListT;

    private ComboBox<String> stringComboBox = new ComboBox<>();

    private EventHandler<ActionEvent> handlers;
    private Label label;
    private HBox hBox;

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {
        this.handlers = e;
    }

    @Override
    public void setDropDownList(DropDownListT downList) {
        this.dropDownListT = downList;
    }

    @Override
    public HBox create() {
        if (this.dropDownListT != null) {
            this.hBox = new HBox();
            this.hBox.getChildren().add(this.label = new Label(this.dropDownListT.getLabel()));
            this.stringComboBox.getItems()
                    .addAll(this.dropDownListT.getListItem().stream().map(listItemT -> listItemT.getUiRep()).collect(Collectors.toList()));
            this.stringComboBox.getSelectionModel().selectFirst();
            this.stringComboBox.setOnAction(event -> {
                if (handlers != null)
                    handlers.handle(event);
                stringComboBox.getValue();
            });
            this.hBox.getChildren().add(this.stringComboBox);
            return this.hBox;
        }
        return null;
    }
}
