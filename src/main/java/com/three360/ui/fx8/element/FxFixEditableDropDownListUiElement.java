package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.EditableDropDownListT;
import com.three360.ui.common.element.IFixEditableDropDownListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.List;
import java.util.stream.Collectors;

public class FxFixEditableDropDownListUiElement
		implements IFixEditableDropDownListUiElement<Pane, ChangeListener<String>> {

	private ComboBox<String> stringComboBox;

	private EditableDropDownListT editableDropDownListT;
	private GridPane gridPane;
	private Label label;

	private int nextColumn = 0;

	private ChangeListener<String> changedListener;

	private List<ParameterT> parameterTList;

	@Override
	public Pane create() {
		if (this.editableDropDownListT != null) {
			this.gridPane = new GridPane();
			this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
			if (this.editableDropDownListT.getLabel() != null
					&& !this.editableDropDownListT.getLabel().equals(""))
				this.gridPane.add(this.label = new Label(this.editableDropDownListT.getLabel()), this.nextColumn++, 0);
			this.stringComboBox = new ComboBox<>();
			this.stringComboBox.getItems()
					.addAll(this.editableDropDownListT
							.getListItem()
							.stream()
							.map(listItemT -> listItemT.getUiRep())
							.collect(Collectors.toList()));

			this.stringComboBox.setEditable(true);
			if (this.editableDropDownListT.getInitValue() != null && this.editableDropDownListT.getInitValue().equals(""))
				this.stringComboBox.getSelectionModel().selectFirst();
			else
				this.stringComboBox.getSelectionModel().select(this.editableDropDownListT.getInitValue());

			this.stringComboBox
					.valueProperty()
					.addListener((observable, oldValue, newValue) -> {
						if (this.changedListener != null)
							this.changedListener.changed(observable, oldValue, newValue);
					});
			this.gridPane.add(this.stringComboBox, nextColumn, 0);
			return this.gridPane;
		}
		return null;
	}

	@Override
	public void registerForEvent(ChangeListener<String> changedListener) {
		this.changedListener = changedListener;
	}

	@Override
	public void setEditableDropDownList(EditableDropDownListT editableDropDownListT) {
		this.editableDropDownListT = editableDropDownListT;

	}

	@Override
	public void setParameters(List<ParameterT> parameterTList) {
		this.parameterTList = parameterTList;
	}

	@Override
	public List<ParameterT> getParameter() {
		return this.parameterTList;
	}
}
