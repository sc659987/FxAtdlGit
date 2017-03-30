package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.LabelT;
import com.three360.ui.common.element.IFixLabelUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class FxFixLabelUiElement implements IFixLabelUiElement<Label, EventHandler<ActionEvent>> {

	private Label label;
	private LabelT labelT;

	@Override
	public Label create() {
		if (this.labelT != null) {
			this.label = new Label();
			this.label.setText(this.labelT.getLabel());
			return this.label;
		}
		return null;
	}

	@Override
	public void setLabel(LabelT label) {
		this.labelT = label;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
