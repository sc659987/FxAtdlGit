package com.three360.ui.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import com.three360.ui.common.element.IFixUiElement;
import javafx.util.Pair;

import java.util.Map;
import java.util.Set;


public interface AtdlStateRuleEvaluator {

    Pair<AtdlStateRuleResultType, Comparable> getResult(StateRuleT stateRuleT, Map<String, Set<IFixUiElement>> stringSetMap);


}
