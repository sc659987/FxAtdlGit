package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.DoubleSpinnerT;
import com.three360.ui.common.element.IFixDoubleSpinnerUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;

public class FxFixDoubleSpinnerUiElement implements IFixDoubleSpinnerUiElement<Pane, EventHandler<ActionEvent>> {

	@Override
	public Pane create() {
		return null;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setDoubleSpinner(DoubleSpinnerT doubleSpinnerT) {

	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
