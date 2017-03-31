package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.MultiSelectListT;
import com.three360.ui.common.element.IFixMultiSelectListUiElement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sainik on 3/27/17.
 */
public class FxFixMultiSelectListUiElement implements IFixMultiSelectListUiElement<Pane, EventHandler<ActionEvent>> {

	private VBox vBoxWrapper;
	private ListView<String> stringListView;
	private Label label;

	private MultiSelectListT multiSelectListT;

	private List<ParameterT> parameterTList;

	@Override
	public Pane create() {
		if (this.multiSelectListT != null) {
			this.vBoxWrapper = new VBox();
			this.label = new Label(this.multiSelectListT.getLabel());
			this.stringListView = new ListView<>(FXCollections.observableArrayList(
					this.multiSelectListT
							.getListItem()
							.stream()
							.map(ListItemT::getUiRep)
							.collect(Collectors.toList())));
			this.stringListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
			this.vBoxWrapper.getChildren().add(this.label);
			this.vBoxWrapper.getChildren().add(this.stringListView);
			return this.vBoxWrapper;
		}
		return null;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setMultiSelectList(MultiSelectListT multiSelectListT) {
		this.multiSelectListT = multiSelectListT;
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
