package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.TextFieldT;
import com.three360.ui.common.element.IFixTextFieldUiElement;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Created by sainik on 3/24/17.
 */
public class FxFixTextFieldUiElement implements IFixTextFieldUiElement<HBox, EventHandler<ActionEvent>> {

	private TextFieldT textFieldT;

	private TextField textField;
	private Label label;
	private HBox hBoxWrapper;

	@Override
	public HBox create() {
		if (this.textFieldT != null) {
			this.label = new Label(this.textFieldT.getLabel());
			this.textField = new TextField(this.textFieldT.getInitValue());
			this.hBoxWrapper = new HBox();
			this.hBoxWrapper.getChildren().addAll(this.label, this.textField);
			return this.hBoxWrapper;
		}
		return null;
	}

	@Override
	public void setTextField(TextFieldT textField) {
		this.textFieldT = textField;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
