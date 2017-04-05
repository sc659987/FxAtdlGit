package com.three360.fixatdl.validator.impl;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.validation.EditT;
import com.three360.fixatdl.validator.common.EditRuleEvaluator;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EditRuleEvaluatorImpl implements EditRuleEvaluator {

    private Comparable getConstValueFromParameter(ParameterT parameterT) {
        try {
            Field field = parameterT.getClass().getField("constValue");
            if (field != null)
                return (Comparable) field.get(parameterT);
        } catch (Exception e) {
        }
        return null;
    }

    private Map<String, ParameterT> stringParameterTMap;

    public EditRuleEvaluatorImpl(List<ParameterT> allParameterT) {
        assert (allParameterT != null);
        this.stringParameterTMap = allParameterT
                .stream()
                .collect(Collectors.toMap(ParameterT::getName, parameterT -> parameterT));
    }


    @Override
    public boolean validate(EditT editT) {
        if (isLogicalEdit(editT)) {
            switch (editT.getLogicOperator()) {
                case AND:
                    // AND - behaves as short circuit
                    return editT.getEdit().stream().allMatch(editT1 -> validate(editT1));
                case OR:
                    // OR - new interpretation
                    return editT.getEdit().stream().anyMatch(editT1 -> validate(editT));
                case NOT:
                    // NOT - interpreted as 'NOR'; will throw exception if any of the
                    // rules validate as true
                    return !editT.getEdit().stream().anyMatch(editT1 -> validate(editT));
                case XOR:
                    // XOR - defined as true if exactly one argument is true
                    // TODO wrong logic is written. find it to implement in functional way
                    return !editT.getEdit().stream().anyMatch(editT1 -> validate(editT));
                default:
            }
        } else {
            ParameterT parameterT1, parameterT2;
            switch (editT.getOperator()) {
                case EQ:
                    return getConstValueFromParameter(stringParameterTMap
                            .getOrDefault(editT.getField(), null))
                            .compareTo(getConstValueFromParameter(stringParameterTMap
                                    .getOrDefault(editT.getField2(), null))) == 0 ? true : false;
                case EX:
                    return getConstValueFromParameter(stringParameterTMap
                            .getOrDefault(editT.getField(), null)) != null ? true : false;
                case GE:
                    parameterT1 = this.stringParameterTMap.get(editT.getField());
                    parameterT2 = this.stringParameterTMap.get(editT.getField2());
                    return getConstValueFromParameter(parameterT1).compareTo(getConstValueFromParameter(parameterT2)) >= 0 ? true : false;
                case GT:
                    parameterT1 = this.stringParameterTMap.get(editT.getField());
                    parameterT2 = this.stringParameterTMap.get(editT.getField2());
                    return getConstValueFromParameter(parameterT1).compareTo(getConstValueFromParameter(parameterT2)) > 0 ? true : false;
                case LE:
                    parameterT1 = this.stringParameterTMap.get(editT.getField());
                    parameterT2 = this.stringParameterTMap.get(editT.getField2());
                    return getConstValueFromParameter(parameterT1).compareTo(getConstValueFromParameter(parameterT2)) <= 0 ? true : false;
                case LT:
                    parameterT1 = this.stringParameterTMap.get(editT.getField());
                    parameterT2 = this.stringParameterTMap.get(editT.getField2());
                    return getConstValueFromParameter(parameterT1).compareTo(getConstValueFromParameter(parameterT2)) < 0 ? true : false;
                case NE:
                    parameterT1 = this.stringParameterTMap.get(editT.getField());
                    parameterT2 = this.stringParameterTMap.get(editT.getField2());
                    return getConstValueFromParameter(parameterT1).compareTo(getConstValueFromParameter(parameterT2)) != 0 ? true : false;
                case NX:
                    return getConstValueFromParameter(stringParameterTMap
                            .getOrDefault(editT.getField(), null)) != null ? false : true;
                default:
                    return false;
            }
        }
        return false;
    }

    //TODO check the logic for more stability
    public boolean isLogicalEdit(EditT editT) {
        return editT.getOperator() != null ? false : true;
    }
}
