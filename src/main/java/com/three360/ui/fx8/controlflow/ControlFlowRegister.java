package com.three360.ui.fx8.controlflow;


import com.three360.fixatdl.layout.ControlT;
import com.three360.ui.common.element.IFixUiElement;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;

public class ControlFlowRegister {

    public void registerForControlFlow(IFixUiElement<
            ? extends Node,
            ? extends ChangeListener<?>,
            ? extends ChangeListener<?>> iFixUiElement,
                                       ControlT controlT) {

        iFixUiElement.registerForEvent();


    }


}
