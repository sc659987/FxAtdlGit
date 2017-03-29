package com.three360.ui.common;

import com.three360.ui.common.element.*;

public interface UiElementAbstractFactory {

    IFixButtonUiElement instantiateNewButton();

    <T, K> IFixCheckBoxListUiElement<T, K> instantiateNewCheckBoxList();

    <T, K> IFixCheckBoxUiElement<T, K> instantiateNewCheckBox();

    <T, K> IFixClockUiElement<T, K> instantiateNewClock();

    <T, K> IFixDoubleSpinnerUiElement<T, K> instantiateNewDoubleSpinner();

    <T, K> IFixDropDownListUiElement<T, K> instantiateNewDropDownList();

    <T, K> IFixEditableDropDownListUiElement<T, K> instantiateNewEditableDropDownList();

    <T, K> IFixLabelUiElement<T, K> instantiateNewLabel();

    <T, K> IFixMultiSelectListUiElement<T, K> instantiateNewMultiSelectList();

    <T, K> IFixRadioButtonListUiElement<T, K> instantiateNewRadioButtonList();

    <T, K> IFixRadioButtonUiElement<T, K> instantiateNewRadioButton();

    <T, K> IFixSingleSelectListUiElement<T, K> instantiateNewSingleSelectList();

    <T, K> IFixSingleSpinnerUiElement<T, K> instantiateNewSingleSpinner();

    <T, K> IFixSliderUiElement<T, K> instantiateNewSlider();

    <T, K> IFixTextFieldUiElement<T, K> instantiateNewTextField();

    <T, K> IFixHiddenFieldUiElement<T, K> instantiateNewHiddenField();

    <T, K> IFixPanelUiElement<T, K> instantiateNewPanel();

    <T, K> IFixLayoutUiElement<T, K> instantiateNewLayout();

}