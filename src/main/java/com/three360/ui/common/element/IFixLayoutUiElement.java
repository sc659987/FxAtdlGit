package com.three360.ui.common.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.StrategyLayoutT;

import java.util.List;

public interface IFixLayoutUiElement<T, K> extends IFixUiElement<T, K> {

	void setStrategyLayout(StrategyLayoutT strategyLayoutT);

}
