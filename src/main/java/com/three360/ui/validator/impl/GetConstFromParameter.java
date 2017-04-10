package com.three360.ui.validator.impl;

import com.three360.fixatdl.core.ParameterT;

import java.lang.reflect.Field;

/**
 * Created by sainik on 4/10/17.
 */
public class GetConstFromParameter implements GetComparableValue{
    @Override
    public Comparable<?> extractComparableValue(Object o) {
        if(o instanceof ParameterT){
            try {
                Field field = o.getClass().getField("constValue");
                if (field != null)
                    return (Comparable) field.get(o);
            } catch (Exception e) {
            }
            return null;
        }
        return null;
    }
}
