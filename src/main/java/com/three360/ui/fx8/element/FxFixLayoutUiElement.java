package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.StrategyLayoutT;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.IFixLayoutUiElement;
import com.three360.ui.common.element.IFixPanelUiElement;
import com.three360.ui.fx8.component.DaggerMyComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class FxFixLayoutUiElement implements IFixLayoutUiElement<Node, EventHandler<ActionEvent>> {

	private StrategyLayoutT strategyLayoutT;

	@Inject
	UiElementAbstractFactory factory;

	public FxFixLayoutUiElement() {
		DaggerMyComponent.builder().build().inject(this);
	}

	@Override
	public Node create() {
		VBox vBox = new VBox();
		vBox.getChildren().addAll(this.strategyLayoutT.getStrategyPanel().stream().map(strategyPanelT -> {
			IFixPanelUiElement<Node, EventHandler<ActionEvent>> element = factory.instantiateNewPanel();
			element.setStrategyPanelT(strategyPanelT);
			return element.create();
		}).collect(Collectors.toList()));
		return vBox;
	}

	@Override
	public void setStrategyLayout(StrategyLayoutT strategyLayoutT) {
		this.strategyLayoutT = strategyLayoutT;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {
		throw new RuntimeException();
	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
