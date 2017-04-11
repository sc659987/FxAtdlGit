package com.three360.ui.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import javafx.util.Pair;

public interface AtdlStateRuleEvaluator {

	Pair<AtdlStateRuleResultType, Comparable> getResult(StateRuleT stateRuleT);

}
