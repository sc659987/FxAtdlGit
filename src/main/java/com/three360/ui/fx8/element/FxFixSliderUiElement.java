package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SliderT;
import com.three360.ui.common.element.IFixSliderUiElement;
import com.three360.ui.fx8.utils.ListStringConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

import java.util.stream.Collectors;

/***
 *
 */
public class FxFixSliderUiElement implements IFixSliderUiElement<Slider, EventHandler<ActionEvent>> {

	private SliderT sliderT;
	private Slider slider;
	private StringConverter<Double> converter;

	@Override
	public Slider create() {
		this.converter = new ListStringConverter(this.sliderT.getListItem().stream().map(ListItemT::getUiRep).collect(Collectors.toList()));
		this.slider = new Slider(0, this.sliderT.getListItem().size(), this.converter.fromString(this.sliderT.getInitValue()));
		this.slider.setLabelFormatter(this.converter);
		return this.slider;
	}

	@Override
	public void registerForEvent(EventHandler<ActionEvent> handler) {

	}

	@Override
	public void setSlider(SliderT slider) {
		this.sliderT = slider;
	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
