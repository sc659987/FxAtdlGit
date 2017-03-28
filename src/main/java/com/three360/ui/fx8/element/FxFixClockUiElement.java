package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.ClockT;
import com.three360.ui.common.element.IFixClockUiElement;
import com.three360.ui.fx8.customelement.TimeSpinner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FxFixClockUiElement implements IFixClockUiElement<HBox, EventHandler<ActionEvent>> {

    private TimeSpinner timeSpinner;
    private HBox hBox;
    private Label label;

    private ClockT clockT;

    @Override
    public HBox create() {
        if (this.clockT != null) {
            this.hBox = new HBox();
            this.label = new Label(this.clockT.getLabel());
            this.timeSpinner = new TimeSpinner();
            this.hBox.getChildren().add(this.label);
            this.hBox.getChildren().add(this.timeSpinner);
            return this.hBox;
        }
        return null;
    }

    @Override
    public void setClockT(ClockT clockT) {
        this.clockT = clockT;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }
}
