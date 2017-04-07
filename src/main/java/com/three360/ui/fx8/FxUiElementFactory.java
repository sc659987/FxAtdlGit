package com.three360.ui.fx8;

import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.*;
import com.three360.ui.fx8.element.*;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;

import java.util.List;

public class FxUiElementFactory implements UiElementAbstractFactory {

    @Override
    public IFixButtonUiElement instantiateNewButton() {
        return null;
    }

    @Override
    public IFixCheckBoxListUiElement<Pane, ChangeListener<List<String>>> instantiateNewCheckBoxList() {
        return new FxFixCheckBoxListUiElement();
    }

    @Override
    public IFixDropDownListUiElement<Pane, ChangeListener<String>> instantiateNewDropDownList() {
        return new FxFixDropDownListUiElement();
    }

    @Override
    public IFixHiddenFieldUiElement instantiateNewHiddenField() {
        // TODO add it
        return null;
    }

    @Override
    public IFixLabelUiElement<Label, EventHandler<ActionEvent>> instantiateNewLabel() {
        return new FxFixLabelUiElement();
    }

    @Override
    public IFixPanelUiElement<Node, EventHandler<ActionEvent>> instantiateNewPanel() {
        return new FxFixPanelUiElement();
    }

    @Override
    public IFixRadioButtonUiElement<RadioButton, EventHandler<ActionEvent>> instantiateNewRadioButton() {
        return new FxFixRadioButtonUiElement();
    }

    @Override
    public IFixSliderUiElement<Pane, EventHandler<ActionEvent>> instantiateNewSlider() {
        return new FxFixSliderUiElement();
    }

    @Override
    public IFixSingleSpinnerUiElement<Pane, ChangeListener<String>> instantiateNewSingleSpinner() {
        return new FxFixSingleSpinnerUiElement();
    }

    @Override
    public IFixCheckBoxUiElement<CheckBox, EventHandler<ActionEvent>> instantiateNewCheckBox() {
        return new FxFixCheckBoxUiElement();
    }

    @Override
    public IFixClockUiElement<Pane, EventHandler<ActionEvent>> instantiateNewClock() {
        return new FxFixClockUiElement();
    }

    @Override
    public IFixDoubleSpinnerUiElement<Pane, EventHandler<ActionEvent>> instantiateNewDoubleSpinner() {
        return new FxFixDoubleSpinnerUiElement();
    }

    @Override
    public IFixEditableDropDownListUiElement<Pane, ChangeListener<String>> instantiateNewEditableDropDownList() {
        return new FxFixEditableDropDownListUiElement();
    }

    @Override
    public IFixMultiSelectListUiElement<Pane, EventHandler<ActionEvent>> instantiateNewMultiSelectList() {
        return new FxFixMultiSelectListUiElement();
    }

    @Override
    public IFixRadioButtonListUiElement<Pane, EventHandler<ActionEvent>> instantiateNewRadioButtonList() {
        return new FxFixRadioButtonListUiElement();
    }

    @Override
    public IFixSingleSelectListUiElement<Pane, EventHandler<ActionEvent>> instantiateNewSingleSelectList() {
        return new FxFixSingleSelectListUiElement();
    }

    @Override
    public IFixTextFieldUiElement<Pane, ChangeListener<String>> instantiateNewTextField() {
        return new FxFixTextFieldUiElement();
    }

    @Override
    public IFixLayoutUiElement<Node, EventHandler<ActionEvent>> instantiateNewLayout() {
        return new FxFixLayoutUiElement();
    }
}
