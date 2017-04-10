package com.three360.ui.fx8.controlflow;

import com.three360.ui.common.element.IFixUiElement;
import javafx.util.Pair;

/**
 * Created by sainik on 09/04/17.
 */
public interface ResultActor {

    void doAct(Pair<StateRuleResult, Comparable> stateRuleResultComparablePair, IFixUiElement iFixUiElement);

}
