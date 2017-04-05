package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.IntT;
import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.SingleSpinnerT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixSingleSpinnerUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;

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
public class FxFixSingleSpinnerUiElement implements IFixSingleSpinnerUiElement<Pane, ChangeListener<String>> {

    private Spinner<Double> singleSpinner;
    private SingleSpinnerT singleSpinnerT;
    private Label label;

    private GridPane gridPane;

    private ParameterT parameterT;

    private int nextColumn = 0;

    @Override
    public Pane create() {
        if (this.singleSpinnerT != null && parameterT != null) {
            Pair<Double, Double> limit = extractRangeFromParameter();

            this.singleSpinner = new Spinner<>(limit.getKey(), limit.getValue(), singleSpinnerT.getInitValue() == null ? 0 : limit.getKey(),
                    this.singleSpinnerT.getIncrement() == null ? ((limit.getKey() == 0.0) ? 0.1 : limit.getKey()) : this.singleSpinnerT.getIncrement());

            this.singleSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (!setFieldValueToParameter(newValue, parameterT)) {
                    
                }
            });

            this.gridPane = new GridPane();
            if (!Utils.isEmpty(this.singleSpinnerT.getLabel())) {
                this.gridPane.getColumnConstraints().addAll(FxUtils.getTwoColumnSameWidthForGridPane());
                this.gridPane.add(this.label = new Label(this.singleSpinnerT.getLabel()),
                        this.nextColumn++, 0);
            }
            this.gridPane.add(this.singleSpinner, this.nextColumn, 0);
            return this.gridPane;
        }
        return null;
    }

    private Pair<Double, Double> extractRangeFromParameter() {
        return parameterT != null && (parameterT instanceof IntT) ?
                new Pair<>((((IntT) parameterT).getMinValue() == null ? 0.0 : ((IntT) parameterT).getMinValue()),
                        (((IntT) parameterT).getMaxValue() == null ? Double.MAX_VALUE : ((IntT) parameterT).getMaxValue()))
                : new Pair<>(0.0, Double.MAX_VALUE);
    }

    @Override
    public void registerForEvent(ChangeListener<String> e) {

    }

    @Override
    public void setSingleSpinner(SingleSpinnerT singleSpinnerT) {
        this.singleSpinnerT = singleSpinnerT;
    }

    @Override
    public void setParameters(List<ParameterT> parameterTList) {
        assert (parameterTList != null);
        this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }
}
