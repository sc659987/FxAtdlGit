package com.three360.ui.fx8.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import com.three360.ui.common.element.IFixUiElement;
import javafx.util.Pair;

import java.util.Map;
import java.util.Set;

/**
 * Created by sainik on 09/04/17.
 */
public interface StateRuleResultGenerator {

    Pair<StateRuleResult, Comparable> getResult(StateRuleT stateRuleT, Map<String, Set<IFixUiElement>> stringSetMap);


}
