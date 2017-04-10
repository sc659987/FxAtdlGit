package com.three360.ui.controlflow;

import com.three360.ui.common.element.IFixUiElement;
import javafx.util.Pair;

/**
 * Created by sainik on 09/04/17.
 */
public interface AtdlStateRuleResultActor {

    void doAct(Pair<AtdlStateRuleResultType, Comparable> stateRuleResultComparablePair, IFixUiElement iFixUiElement);

}
