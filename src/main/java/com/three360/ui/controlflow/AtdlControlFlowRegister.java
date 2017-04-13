package com.three360.ui.controlflow;

import com.three360.ui.common.element.IFixUiElement;

public interface AtdlControlFlowRegister {

	void registerControlFlow(IFixUiElement<?, ? extends Comparable<?>> iFixUiElement);
}
