package com.three360.fixatdl.validator.impl;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.validation.StrategyEditT;
import com.three360.fixatdl.validator.common.EditRuleEvaluator;
import com.three360.fixatdl.validator.common.IStrategyEditValidator;
import javafx.util.Pair;

import java.util.List;
import java.util.stream.Collectors;


public class StrategyEditValidator implements IStrategyEditValidator {

    EditRuleEvaluator editRuleEvaluator;

    List<StrategyEditT> strategyEditTS;

    List<ParameterT> parameterTS;

    public StrategyEditValidator(List<StrategyEditT> strategyEditTS, List<ParameterT> parameterTS) {
        assert (strategyEditTS != null && parameterTS != null);

        this.strategyEditTS = strategyEditTS;
        this.parameterTS = parameterTS;

        this.editRuleEvaluator = new EditRuleEvaluatorImpl(this.parameterTS);
    }

    @Override
    public List<String> validateStrategyEditRuleAndGetErrorMessage() {
        return this.strategyEditTS
                .stream()
                .map(strategyEditT -> new Pair<>(this.editRuleEvaluator.validate(strategyEditT.getEdit()), strategyEditT.getErrorMessage()))
                .map(booleanStringPair -> booleanStringPair.getKey() ? booleanStringPair.getValue() : null)
                .collect(Collectors.toList());
    }
}
