package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.EnumPairT;
import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ControlT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SliderT;
import com.three360.ui.common.element.IFixSliderUiElement;
import com.three360.ui.fx8.FxUtils;
import com.three360.ui.fx8.utils.ListStringConverter;
import javafx.beans.property.ObjectProperty;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//TODO fix for large level by increasing the length of slide bar
public class FxFixSliderUiElement implements IFixSliderUiElement<Pane, String> {

	private SliderT sliderT;
	private Slider slider;
	private StringConverter<Double> converter;

	private GridPane gridPane;

	private Label label;

	private ParameterT parameterT;

	@Override
	public Pane create() {
		this.gridPane = new GridPane();
		this.gridPane.getColumnConstraints().addAll(FxUtils.getOneColumnWidthForGridPane());

		this.label = new Label(this.sliderT.getLabel());

		this.gridPane.add(this.label, 0, 0);

		this.converter = new ListStringConverter(this.sliderT.getListItem()
				.stream()
				.map(ListItemT::getUiRep)
				.collect(Collectors.toList()));
		this.slider = new Slider(0,
				this.sliderT
						.getListItem()
						.size() - 1,
				this.converter.fromString(this.sliderT.getInitValue()));

		this.slider.setMajorTickUnit(1.0);

		if (parameterT != null)
			this.slider.valueProperty().addListener((observable, oldValue, newValue) -> {
				if (oldValue.intValue() != newValue.intValue()) {
					setFieldValueToParameter(parameterT
							.getEnumPair()
							.stream()
							.filter(enumPairT -> enumPairT.getEnumID()
									.equals(
											this.converter
													.toString(newValue.doubleValue())))
							.map(EnumPairT::getWireValue)
							.findFirst()
							.orElse("1"), parameterT);
				}
			});
		this.slider.setLabelFormatter(this.converter);
		this.slider.setShowTickLabels(true);
		this.slider.setShowTickMarks(true);
		this.slider.setMajorTickUnit(1.0);

		this.slider.setMinorTickCount(0);
		this.slider.setSnapToTicks(true);

		this.slider.setOrientation(Orientation.HORIZONTAL);

		this.slider.setMaxWidth(Double.MAX_VALUE);

		this.gridPane.add(this.slider, 0, 1);
		return this.gridPane;
	}

	@Override
	public ObjectProperty<String> listenChange() {
		return null;
	}

	@Override
	public String getValue() {
		return null;
	}

	@Override
	public void setValue(String s) {

	}

	@Override
	public void makeVisible(boolean visible) {

	}

	@Override
	public void makeEnable(boolean enable) {

	}

	@Override
	public <C extends ControlT> C getControl() {
		return null;
	}

	@Override
	public void setSlider(SliderT slider) {
		this.sliderT = slider;
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

}
