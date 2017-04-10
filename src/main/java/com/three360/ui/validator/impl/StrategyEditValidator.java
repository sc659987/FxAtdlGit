package com.three360.ui.validator.impl;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.validation.StrategyEditT;
import com.three360.ui.fx8.controlflow.GetComparableValueaaa;
import com.three360.ui.validator.common.EditRuleEvaluator;
import com.three360.ui.validator.common.IStrategyEditValidator;
import javafx.util.Pair;

import java.util.List;
import java.util.stream.Collectors;


public class StrategyEditValidator implements IStrategyEditValidator {

    private EditRuleEvaluator editRuleEvaluator;

    private List<StrategyEditT> strategyEditTS;

    private List<ParameterT> parameterTS;

    private EditFieldToParameterMapperCache editFieldToParameterMapperCache;

    private GetComparableValue getComparableValue;

    public StrategyEditValidator(List<StrategyEditT> strategyEditTS, List<ParameterT> parameterTS) {
        assert (strategyEditTS != null && parameterTS != null);

        this.strategyEditTS = strategyEditTS;
        this.parameterTS = parameterTS;

        this.editFieldToParameterMapperCache = new EditFieldToParameterMapperCache(this.parameterTS);
        this.getComparableValue = new GetConstFromParameter();

        this.editRuleEvaluator = new EditRuleEvaluatorImpl(this.editFieldToParameterMapperCache,
                this.getComparableValue);

    }

    @Override
    public List<String> validateStrategyEditRuleAndGetErrorMessage() {
        return this.strategyEditTS
                .stream()
                .map(strategyEditT -> new Pair<>(this.editRuleEvaluator
                        .validate(strategyEditT.getEdit()), strategyEditT.getErrorMessage()))
                .filter(booleanStringPair -> booleanStringPair.getKey())
                .map(booleanStringPair -> booleanStringPair.getValue())
                .collect(Collectors.toList());
    }
}
