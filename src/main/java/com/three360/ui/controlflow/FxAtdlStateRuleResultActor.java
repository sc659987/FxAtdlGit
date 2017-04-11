package com.three360.ui.controlflow;

import com.three360.ui.common.element.IFixUiElement;
import javafx.util.Pair;

public interface FxAtdlStateRuleResultActor {

	void doAct(Pair<AtdlStateRuleResultType, Comparable> stateRuleResultComparablePair, IFixUiElement iFixUiElement);

}
