package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SliderT;
import com.three360.ui.common.element.IFixSliderUiElement;
import com.three360.ui.fx8.FxUtils;
import com.three360.ui.fx8.utils.ListStringConverter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.util.List;
import java.util.stream.Collectors;

public class FxFixSliderUiElement implements IFixSliderUiElement<Pane, EventHandler<ActionEvent>> {

    private SliderT sliderT;
    private Slider slider;
    private StringConverter<Double> converter;

    private GridPane gridPane;

    private Label label;

    private List<ParameterT> parameterTList;

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
                this.converter.
                        fromString(this.sliderT.getInitValue()));

        this.slider.setMajorTickUnit(1.0);

        this.slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("New Value == " + newValue);
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
    public void registerForEvent(EventHandler<ActionEvent> handler) {
    }

    @Override
    public void setSlider(SliderT slider) {
        this.sliderT = slider;
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
