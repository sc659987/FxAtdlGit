package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.*;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.*;
import com.three360.ui.fx8.component.DaggerMyComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixPanelUiElement implements IFixPanelUiElement<Node, EventHandler<ActionEvent>> {

	private StrategyPanelT strategyPanelT;

	private List<Region> regionList;
	ScrollPane scrollPane;

	private List<ParameterT> parameterTList;

	@Inject
	UiElementAbstractFactory factory;

	public FxFixPanelUiElement() {
		DaggerMyComponent.builder().build().inject(this);
	}

	@Override
	public Node create() {
		if (this.strategyPanelT != null) {
			TitledPane titledPane = new TitledPane();
			titledPane.setCollapsible(this.strategyPanelT.isCollapsible());
			titledPane.setExpanded(!this.strategyPanelT.isCollapsed());
			// titledPane.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
			titledPane.setText(this.strategyPanelT.getTitle());
			Pane parent = (this.strategyPanelT.getOrientation() == PanelOrientationT.HORIZONTAL)
					? new HBox(20.0) : new VBox();
			// Container for either groups of parameters or strategyPanels, but not both.
			// I.e., a StrategyPanel will contain either all Control elements or all
			// StrategyPanel elements.
			if (this.strategyPanelT.getStrategyPanel() != null && this.strategyPanelT.getStrategyPanel().size() > 0) {
				parent.getChildren().addAll(this.strategyPanelT
						.getStrategyPanel()
						.stream()
						.map(eachStrategyPanelT -> {
							final FxFixPanelUiElement element = new FxFixPanelUiElement();
							element.setStrategyPanelT(eachStrategyPanelT);
							return element.create();
						}).collect(Collectors.toList()));
			} else if (this.strategyPanelT.getControl() != null) {
				regionList = this.strategyPanelT.getControl().stream().map(controlT -> {
					if (controlT instanceof CheckBoxListT) {
						IFixCheckBoxListUiElement<Pane, EventHandler<ActionEvent>> element = factory.instantiateNewCheckBoxList();
						element.setCheckBoxListT((CheckBoxListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof CheckBoxT) {
						IFixCheckBoxUiElement<CheckBox, EventHandler<ActionEvent>> element = factory.instantiateNewCheckBox();
						element.setCheckBoxT((CheckBoxT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof ClockT) {
						IFixClockUiElement<HBox, EventHandler<ActionEvent>> element = factory.instantiateNewClock();
						element.setClockT((ClockT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof DoubleSpinnerT) {
						// TODO complete the double spinner
					} else if (controlT instanceof DropDownListT) {
						IFixDropDownListUiElement<HBox, EventHandler<ActionEvent>> element = factory.instantiateNewDropDownList();
						element.setDropDownList((DropDownListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof EditableDropDownListT) {
						IFixEditableDropDownListUiElement<HBox, EventHandler<ActionEvent>> element = factory.instantiateNewEditableDropDownList();
						element.setEditableDropDownList((EditableDropDownListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof LabelT) {
						IFixLabelUiElement<Label, EventHandler<ActionEvent>> element = factory.instantiateNewLabel();
						element.setLabel((LabelT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof MultiSelectListT) {
						IFixMultiSelectListUiElement<Pane, EventHandler<ActionEvent>> element = factory.instantiateNewMultiSelectList();
						element.setMultiSelectList((MultiSelectListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof RadioButtonListT) {
						IFixRadioButtonListUiElement<Pane, EventHandler<ActionEvent>> element = factory.instantiateNewRadioButtonList();
						element.setRadioButtonListT((RadioButtonListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof RadioButtonT) {
						IFixRadioButtonUiElement<RadioButton, EventHandler<ActionEvent>> element = factory.instantiateNewRadioButton();
						element.setRadioButtonT((RadioButtonT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof SingleSelectListT) {
						IFixSingleSelectListUiElement<Pane, EventHandler<ActionEvent>> element = factory.instantiateNewSingleSelectList();
						element.setSingleSelectList((SingleSelectListT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof SingleSpinnerT) {
						IFixSingleSpinnerUiElement<HBox, EventHandler<ActionEvent>> element = factory.instantiateNewSingleSpinner();
						element.setSingleSpinner((SingleSpinnerT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof SliderT) {
						IFixSliderUiElement<Slider, EventHandler<ActionEvent>> element = factory.instantiateNewSlider();
						element.setSlider((SliderT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof TextFieldT) {
						IFixTextFieldUiElement<HBox, EventHandler<ActionEvent>> element = factory.instantiateNewTextField();
						element.setTextField((TextFieldT) controlT);
						element.setParameters(findParameterByName(controlT.getParameterRef()));
						return element.create();
					} else if (controlT instanceof HiddenFieldT) {

					}
					throw new RuntimeException("control is not recognized");
				}).collect(Collectors.toList());
				parent.getChildren().setAll(regionList);
				scrollPane = new ScrollPane();
				scrollPane.setContent(parent);
			}
			titledPane.setContent(parent);
			return titledPane;
		}
		return null;
	}

	private Node createControlByType(ControlT controlT) {

		return null;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setStrategyPanelT(StrategyPanelT strategyPanelT) {
		this.strategyPanelT = strategyPanelT;
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
