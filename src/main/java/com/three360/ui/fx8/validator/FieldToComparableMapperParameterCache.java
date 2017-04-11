package com.three360.ui.fx8.validator;

import com.three360.fixatdl.core.ParameterT;
import com.three360.ui.validator.FieldToComparableMapperCache;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FieldToComparableMapperParameterCache implements FieldToComparableMapperCache {


    private Map<String, ParameterT> stringParameterTMap;

    @Override
    public Comparable get(String key) {
        ParameterT parameterT = this.stringParameterTMap.get(key);
        try {
            Field field = parameterT.getClass().getField("constValue");
            field.setAccessible(true);
            if (field != null)
                return (Comparable) field.get(parameterT);
        } catch (Exception e) {
        }
        return null;
    }


    public FieldToComparableMapperParameterCache(List<ParameterT> parameterTS) {
        stringParameterTMap = parameterTS
                .stream()
                .collect(Collectors.toMap(ParameterT::getName, parameterT -> parameterT));
    }


}
