package com.three360.ui.fx8;

import com.three360.fixatdl.layout.DropDownListT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.ui.abs.AbstractFixAtdlUi;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import com.three360.ui.common.element.IFixLayoutUiElement;
import com.three360.ui.fx8.component.DaggerMyComponent;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixAtdlUi extends AbstractFixAtdlUi<Pane> {

	@Inject
	Unmarshaller jaxbUnmarshaller;

	@Inject
	UiElementAbstractFactory factory;

	private final VBox vBox = new VBox();

	public FxFixAtdlUi() {
		DaggerMyComponent.builder().build().inject(this);
	}

	@Override
	public Pane createUi() {
		vBox.setAlignment(Pos.TOP_LEFT);
		if (getStrategies() != null) {
			vBox.getChildren().clear();
			vBox.getChildren().add(0, createStrategySelectionPanel());
			if (getStrategies().getStrategy().size() > 0)
				setSelectedStrategy(getStrategies().getStrategy().get(0));
			if (getSelectedStrategy() != null)
				createFixLayout();
		}
		return vBox;
	}

	private void createFixLayout() {
		if (vBox.getChildren().size() > 1)
			vBox.getChildren().remove(1);
		IFixLayoutUiElement<Node, EventHandler<ActionEvent>> layoutUiElement = factory.instantiateNewLayout();
		layoutUiElement.setStrategyLayout(getSelectedStrategy().getStrategyLayout());
		vBox.getChildren().add(1, layoutUiElement.create());
	}

	@Override
	public Unmarshaller getUnmarshaller() {
		return this.jaxbUnmarshaller;
	}

	@Override
	public Pane createStrategySelectionPanel() {
		HBox strategySelectionBox = new HBox();
		strategySelectionBox.setAlignment(Pos.CENTER);
		if (getStrategies() != null) {
			IFixDropDownListUiElement<ComboBox<String>, ChangeListener<String>> element = this.factory.instantiateNewDropDownList();
			List<ListItemT> listItemTS = getStrategies().getStrategy().stream().map(s -> {
				ListItemT listItemT = new ListItemT();
				listItemT.setUiRep(s.getUiRep());
				return listItemT;
			}).collect(Collectors.toList());
			DropDownListT dropDownListT = new DropDownListT();
			dropDownListT.getListItem().addAll(listItemTS);
			element.setDropDownList(dropDownListT);
			element.registerForEvent((observable, oldValue, newValue) -> {
				if (newValue != null) {
					setSelectedStrategy(findStrategyTByName(newValue));
					createFixLayout();
				}
			});
			strategySelectionBox.getChildren().add(element.create());
		}
		return strategySelectionBox;
	}
}
