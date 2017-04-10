package com.three360.ui.controlflow;

import com.three360.ui.common.element.IFixUiElement;

/**
 * Created by sainik on 4/10/17.
 */
public interface AtdlControlFlowRegister {

    void registerControlFlow(IFixUiElement<?, ? extends Comparable<?>> iFixUiElement);
}
