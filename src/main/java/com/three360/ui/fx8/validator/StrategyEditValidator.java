package com.three360.ui.fx8.validator;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.validation.StrategyEditT;
import com.three360.ui.validator.EditRuleEvaluator;
import com.three360.ui.validator.IStrategyEditValidator;
import javafx.util.Pair;

import java.util.List;
import java.util.stream.Collectors;


public class StrategyEditValidator implements IStrategyEditValidator {

    private EditRuleEvaluator editRuleEvaluator;

    private List<StrategyEditT> strategyEditTS;

    private List<ParameterT> parameterTS;

    private FieldToComparableMapperParameterCache fieldToComparableMapperParameterCache;


    public StrategyEditValidator(List<StrategyEditT> strategyEditTS, List<ParameterT> parameterTS) {
        assert (strategyEditTS != null && parameterTS != null);

        this.strategyEditTS = strategyEditTS;
        this.parameterTS = parameterTS;

        this.fieldToComparableMapperParameterCache = new FieldToComparableMapperParameterCache(this.parameterTS);

        this.editRuleEvaluator = new EditRuleEvaluatorImpl(this.fieldToComparableMapperParameterCache);

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
