package com.three360.ui.fx8.validator;

import com.three360.fixatdl.validation.EditT;
import com.three360.ui.validator.EditRuleEvaluator;
import com.three360.ui.validator.FieldToComparableMapperCache;


public class EditRuleEvaluatorImpl implements EditRuleEvaluator {


    FieldToComparableMapperCache fieldToComparableMapperCache;

    public EditRuleEvaluatorImpl(FieldToComparableMapperCache fieldToComparableMapperCache) {
        this.fieldToComparableMapperCache = fieldToComparableMapperCache;
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
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) == 0 ? true : false;
                case EX:
                    return fieldToComparableMapperCache.get(editT.getField()) != null ? true : false;
                case GE:
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) >= 0 ? true : false;
                case GT:
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) > 0 ? true : false;
                case LE:
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) <= 0 ? true : false;
                case LT:
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) < 0 ? true : false;
                case NE:
                    return fieldToComparableMapperCache.get(editT.getField())
                            .compareTo(fieldToComparableMapperCache.get(editT.getField2())) != 0 ? true : false;
                case NX:
                    return fieldToComparableMapperCache.get(editT.getField()) != null ? false : true;
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
