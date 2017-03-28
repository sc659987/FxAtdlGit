package com.three360.ui.fx8.element;

import com.three360.fixatdl.layout.SingleSpinnerT;
import com.three360.ui.common.element.IFixSingleSpinnerUiElement;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.HBox;

/***
 * TODO
 *
 * Control/@incrementPolicy
 * string
 * N
 * For single spinner control, defines how to determine the
 * increment.
 * Valid values:
 * “Static” – use value from increment attribute
 * “LotSize” – use the round lot size of symbol. (If this
 * value is not available, use the value from the
 * increment attribute.)
 * “Tick” - use symbol minimum tick size. (If this value
 * is not available, use the value from the increment
 * attribute.)
 * Applicable when xsi:type is SingleSpinner_t.
 * If no value is supplied then use value from increment attribute.
 * Please note: The schema file, fixatdl-layout-1-1.xsd, does
 * not include the “Static” enumeration value. If “Static”
 * behavior is desired then do not populate this attribute.
 *
 *
 */
public class FxFixSingleSpinnerUiElement implements IFixSingleSpinnerUiElement<HBox, EventHandler<ActionEvent>> {

    private Spinner<Double> singleSpinner;
    private SingleSpinnerT singleSpinnerT;
    private HBox hBoxWrapper;
    private Label labelForSpinner;

    @Override
    public HBox create() {
        if (this.singleSpinnerT != null) {
            this.singleSpinner.setValueFactory(
                    new SpinnerValueFactory.ListSpinnerValueFactory<>(
                            FXCollections.observableArrayList(0.0, 0.1, 0.2, 0.3)));
            this.labelForSpinner = new Label();
            this.labelForSpinner.setText(this.singleSpinnerT.getLabel());
            this.hBoxWrapper = new HBox();
            this.hBoxWrapper.getChildren().addAll(this.labelForSpinner, this.singleSpinner);
            return this.hBoxWrapper;
        }
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }

    @Override
    public void setSingleSpinner(SingleSpinnerT singleSpinnerT) {
        this.singleSpinnerT = singleSpinnerT;
    }
}
