package com.three360.ui.validator.impl;

import com.three360.fixatdl.validation.EditT;
import com.three360.ui.validator.common.EditRuleEvaluator;
import com.three360.ui.validator.common.FieldToObjectMapperCache;


public class EditRuleEvaluatorImpl implements EditRuleEvaluator {

    private GetComparableValue getComparableValue;

    FieldToObjectMapperCache<?, ?> fieldToObjectMapperCache;

    public EditRuleEvaluatorImpl(FieldToObjectMapperCache<?, ?> fieldToObjectMapperCache,
                                 GetComparableValue getComparableValue) {
        this.getComparableValue = getComparableValue;
        this.fieldToObjectMapperCache = fieldToObjectMapperCache;
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
                    return editT.getEdit().stream().anyMatch(editT1 -> validate(editT1));
                case NOT:
                    // NOT - interpreted as 'NOR'; will throw exception if any of the
                    // rules validate as true
                    return !editT.getEdit().stream().anyMatch(editT1 -> validate(editT));
                case XOR:
                    // XOR - defined as true if exactly one argument is true
                    // TODO wrong logic is written. find functional implementation
                    return !editT.getEdit().stream().anyMatch(editT1 -> validate(editT));
                default:
            }
        } else {
            switch (editT.getOperator()) {
                case EQ:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) == 0 ? true : false;
                case EX:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField())) != null ? true : false;
                case GE:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) >= 0 ? true : false;
                case GT:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) > 0 ? true : false;
                case LE:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) <= 0 ? true : false;
                case LT:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) < 0 ? true : false;
                case NE:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField()))
                            .compareTo(getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField2()))) != 0 ? true : false;
                case NX:
                    return getComparableValue.extractComparableValue(fieldToObjectMapperCache.get(editT.getField())) != null ? false : true;
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
