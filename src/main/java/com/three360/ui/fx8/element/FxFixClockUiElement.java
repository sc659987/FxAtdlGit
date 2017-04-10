package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ClockT;
import com.three360.ui.common.element.IFixClockUiElement;
import com.three360.ui.fx8.FxUtils;
import com.three360.ui.fx8.customelement.TimeSpinner;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;

public class FxFixClockUiElement implements IFixClockUiElement<Pane, String> {

    private TimeSpinner timeSpinner;

    private GridPane gridPane;

    private Label label;

    private ClockT clockT;

    private ParameterT parameterT;

    @Override
    public Pane create() {
        if (this.clockT != null) {
            this.gridPane = new GridPane();
            this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
            this.label = new Label(this.clockT.getLabel());
            this.timeSpinner = new TimeSpinner();

            this.timeSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (parameterT != null)
                    if (!setFieldValueToParameter(newValue.toString(), parameterT)) {

                    }
            });
            this.gridPane.add(this.label, 0, 0);
            this.gridPane.add(this.timeSpinner, 1, 0);
            return this.gridPane;
        }
        return null;
    }

    @Override
    public void setClockT(ClockT clockT) {
        this.clockT = clockT;
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
    public ObjectProperty<Pair<String, String>> listenChange() {
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
}
