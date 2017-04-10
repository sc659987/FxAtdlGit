package com.three360.ui.fx8.controlflow;

import com.three360.fixatdl.flow.StateRuleT;
import com.three360.fixatdl.layout.CheckBoxListT;
import com.three360.fixatdl.validation.EditT;
import com.three360.ui.common.element.IFixUiElement;
import com.three360.ui.fx8.element.FxFixCheckBoxListUiElement;
import javafx.beans.property.ObjectProperty;
import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sainik on 09/04/17.
 */
public class ControlFlowSingle {

    private Map<String, Set<IFixUiElement>> controlIdUiElementMap = new HashMap<>();


    ObjectProperty<Pair<String, String>> pairObjectProperty;

    StateRuleResultGenerator stateRuleResultGenerator;


    ResultActor resultActor;


    public void add(FxFixCheckBoxListUiElement fxFixCheckBoxListUiElement) {

        CheckBoxListT checkBoxListT = fxFixCheckBoxListUiElement.getControl();
        checkBoxListT.getID();
        checkBoxListT.getStateRule().forEach(stateRuleT -> {
            getAllControlIdFromEdit(stateRuleT.getEdit()).forEach(s -> {
                Set<IFixUiElement> iFixUiElements = controlIdUiElementMap.get(s);
                iFixUiElements = (iFixUiElements == null) ? new HashSet<>() : iFixUiElements;
                iFixUiElements.add(fxFixCheckBoxListUiElement);
                controlIdUiElementMap.put(s, iFixUiElements);

            });
        });
        (pairObjectProperty = fxFixCheckBoxListUiElement.listenChange())
                .addListener((observable, oldValue, newValue) -> {
                    Set<IFixUiElement> iFixUiElements = controlIdUiElementMap
                            .get(newValue.getKey());
                    if (iFixUiElements != null) {
                        iFixUiElements.forEach(iFixUiElement -> {
                            iFixUiElement.getControl().getStateRule().forEach(stateRuleT -> {
                                resultActor
                                        .doAct(stateRuleResultGenerator
                                                        .getResult(stateRuleT, controlIdUiElementMap),
                                                iFixUiElement);
                            });
                        });
                    }
                });


    }


    private Set<String> getAllControlIdFromEdit(EditT editT) {

        if (editT.getLogicOperator() != null) {
            return editT.getEdit().stream()
                    .map(editT1 -> getAllControlIdFromEdit(editT1))
                    .flatMap(strings -> strings.stream()).collect(Collectors.toSet());
        } else {
            Set<String> stringList = new HashSet<>();
            if (editT.getField() != null)
                stringList.add(editT.getField());
            if (editT.getField2() != null)
                stringList.add(editT.getField2());
            return stringList;
        }
    }
}
