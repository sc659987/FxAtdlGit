package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SingleSelectListT;
import com.three360.ui.common.element.IFixSingleSelectListUiElement;
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

public class FxFixSingleSelectListUiElement
		implements IFixSingleSelectListUiElement<Pane, EventHandler<ActionEvent>> {

	private VBox vBoxWrapper;
	private ListView<String> stringListView;
	private Label label;

	private SingleSelectListT singleSelectListT;

	private List<ParameterT> parameterTList;

	@Override
	public Pane create() {
		if (this.singleSelectListT != null) {
			this.vBoxWrapper = new VBox();
			this.label = new Label(this.singleSelectListT.getLabel());
			this.stringListView = new ListView<>(FXCollections.observableArrayList(
					this.singleSelectListT
							.getListItem()
							.stream()
							.map(ListItemT::getUiRep)
							.collect(Collectors.toList())));
			this.stringListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
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
	public void setSingleSelectList(SingleSelectListT singleSelectListT) {
		this.singleSelectListT = singleSelectListT;
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
