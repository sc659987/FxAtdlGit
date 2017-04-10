package com.three360.ui.fx8.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import com.three360.ui.common.element.IFixUiElement;
import com.three360.ui.controlflow.AtdlStateRuleEvaluator;
import com.three360.ui.controlflow.AtdlStateRuleResultType;
import com.three360.ui.validator.common.EditRuleEvaluator;
import com.three360.ui.validator.impl.EditRuleEvaluatorImpl;
import javafx.util.Pair;

import java.util.Map;
import java.util.Set;


public class FxAtdlStateRuleEvaluator implements AtdlStateRuleEvaluator {


    private EditRuleEvaluator editRuleEvaluator;

    public FxAtdlStateRuleEvaluator(){

        this.editRuleEvaluator = new EditRuleEvaluatorImpl()

    }


    @Override
    public Pair<AtdlStateRuleResultType, Comparable> getResult(StateRuleT stateRuleT,
                                                               Map<String, Set<IFixUiElement>> stringSetMap) {

        boolean b = editRuleEvaluator.validate(stateRuleT.getEdit());
        if (stateRuleT.isEnabled() != null)
            return new Pair<>(AtdlStateRuleResultType.ENABLE, stateRuleT.isEnabled() && b);
        if (stateRuleT.isVisible() != null)
            return new Pair<>(AtdlStateRuleResultType.VISIBLE, stateRuleT.isVisible() && b);
        if (stateRuleT.getValue() != null)
            return new Pair<>(AtdlStateRuleResultType.VALUE, stateRuleT.getValue());
        return null;
    }
}
