package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.EditableDropDownListT;
import com.three360.ui.common.element.IFixEditableDropDownListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixEditableDropDownListUiElement
		implements IFixEditableDropDownListUiElement<Pane, String> {

	private ComboBox<String> stringComboBox;
	private EditableDropDownListT editableDropDownListT;
	private GridPane gridPane;
	private Label label;

	private int nextColumn = 0;
	private ParameterT parameterT;

	private ObjectProperty<String> checkedProperty = new SimpleObjectProperty<>();

	@Override
	public Pane create() {
		if (this.editableDropDownListT != null) {
			this.gridPane = new GridPane();
			this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
			if (this.editableDropDownListT.getLabel() != null
					&& !this.editableDropDownListT.getLabel().equals(""))
				this.gridPane.add(this.label = new Label(this.editableDropDownListT.getLabel()),
						this.nextColumn++, 0);
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

			this.stringComboBox.setOnAction(event -> {
				this.checkedProperty.set(editableDropDownListT.getID());

				if (this.parameterT != null)
					setFieldValueToParameter(stringComboBox.getValue(), this.parameterT);
			});

			this.gridPane.add(this.stringComboBox, nextColumn, 0);
			return this.gridPane;
		}
		return null;
	}

	@Override
	public void setEditableDropDownList(EditableDropDownListT editableDropDownListT) {
		this.editableDropDownListT = editableDropDownListT;
	}

	@Override
	public void setParameters(List<ParameterT> parameterTList) {
		if (parameterTList != null && parameterTList.size() > 0)
			this.parameterT = parameterTList.get(0);
	}

	@Override
	public List<ParameterT> getParameter() {
		List<ParameterT> parameterTS = Collections.emptyList();
		parameterTS.add(this.parameterT);
		return parameterTS;
	}

	@Override
	public ObjectProperty<String> listenChange() {
		return this.checkedProperty;
	}

	@Override
	public EditableDropDownListT getControl() {
		return this.editableDropDownListT;
	}

	@Override
	public String getValue() {
		return this.stringComboBox.getValue();
	}

	@Override
	public void setValue(String s) {
		this.stringComboBox.setValue(s);
	}

	@Override
	public void makeVisible(boolean visible) {
		stringComboBox.setVisible(visible);
	}

	@Override
	public void makeEnable(boolean enable) {
		this.stringComboBox.setDisable(!enable);
	}

}
