package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ClockT;
import com.three360.ui.common.element.IFixClockUiElement;
import com.three360.ui.fx8.FxUtils;
import com.three360.ui.fx8.customelement.TimeSpinner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class FxFixClockUiElement implements IFixClockUiElement<Pane, EventHandler<ActionEvent>> {

	private TimeSpinner timeSpinner;
	private GridPane gridPane;
	private Label label;

	private ClockT clockT;

	@Override
	public Pane create() {
		if (this.clockT != null) {
			this.gridPane = new GridPane();
			this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
			this.label = new Label(this.clockT.getLabel());
			this.timeSpinner = new TimeSpinner();
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
	public void registerForEvent(EventHandler<ActionEvent> e) {

	}

	@Override
	public void setParameter(ParameterT parameter) {

	}
}
