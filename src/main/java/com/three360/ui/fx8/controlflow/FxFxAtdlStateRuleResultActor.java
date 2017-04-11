package com.three360.ui.fx8.controlflow;

import com.three360.ui.common.element.IFixUiElement;
import com.three360.ui.controlflow.AtdlStateRuleResultType;
import com.three360.ui.controlflow.FxAtdlStateRuleResultActor;
import javafx.util.Pair;

/***
 *
 */
public class FxFxAtdlStateRuleResultActor implements FxAtdlStateRuleResultActor {

	@Override
	public void doAct(Pair<AtdlStateRuleResultType, Comparable> stateRuleResultComparablePair,
			IFixUiElement iFixUiElement) {
		switch (stateRuleResultComparablePair.getKey()) {
		case ENABLE:
			iFixUiElement.makeEnable((Boolean) stateRuleResultComparablePair.getValue());
			break;
		case VALUE:
			iFixUiElement.setValue(stateRuleResultComparablePair.getValue());
			break;
		case VISIBLE:
			iFixUiElement.makeVisible((Boolean) stateRuleResultComparablePair.getValue());
			break;
		default:

		}
	}
}
