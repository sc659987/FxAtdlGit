package com.three360.ui.fx8.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import com.three360.ui.common.element.IFixUiElement;
import com.three360.ui.controlflow.AtdlStateRuleEvaluator;
import com.three360.ui.controlflow.AtdlStateRuleResultType;
import com.three360.ui.fx8.validator.EditRuleEvaluatorImpl;
import com.three360.ui.validator.EditRuleEvaluator;
import com.three360.ui.validator.FieldToComparableMapperCache;
import javafx.util.Pair;

import java.util.Map;

/***
 *
 */
public class FxAtdlStateRuleEvaluator implements AtdlStateRuleEvaluator {

	private EditRuleEvaluator editRuleEvaluator;
	private FieldToComparableMapperCache fieldToComparableMapperCache;

	public FxAtdlStateRuleEvaluator(Map<String, IFixUiElement> allIFixUiElement) {
		this.fieldToComparableMapperCache = new FieldToComparableMapperControlCache(allIFixUiElement);
		this.editRuleEvaluator = new EditRuleEvaluatorImpl(fieldToComparableMapperCache);
	}

	@Override
	public Pair<AtdlStateRuleResultType, Comparable> getResult(StateRuleT stateRuleT) {
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
