package com.three360.ui.validator.impl;

import com.three360.fixatdl.core.ParameterT;
import com.three360.ui.validator.common.FieldToObjectMapperCache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class EditFieldToParameterMapperCache implements FieldToObjectMapperCache<Map<String, ParameterT>, ParameterT> {

    private Map<String, ParameterT> stringParameterTMap;

    @Override
    public ParameterT get(String key) {
        return this.stringParameterTMap.get(key);
    }


    public EditFieldToParameterMapperCache(List<ParameterT> parameterTS) {
        stringParameterTMap = parameterTS
                .stream()
                .collect(Collectors.toMap(ParameterT::getName, parameterT -> parameterT));
    }



}
