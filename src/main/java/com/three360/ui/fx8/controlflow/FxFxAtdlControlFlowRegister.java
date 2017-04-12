package com.three360.ui.fx8.controlflow;

import com.three360.fixatdl.layout.ControlT;
import com.three360.fixatdl.validation.EditT;
import com.three360.ui.common.element.IFixUiElement;
import com.three360.ui.controlflow.AtdlStateRuleEvaluator;
import com.three360.ui.controlflow.FxAtdlControlFlowRegister;
import com.three360.ui.controlflow.FxAtdlStateRuleResultActor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FxFxAtdlControlFlowRegister implements FxAtdlControlFlowRegister {

    // controlId and Fx Ui element which are dependent on that Id for control flow
    private Map<String, Set<IFixUiElement>> controlIdUiElementMap;

    // evaluate the condition of state rule
    private AtdlStateRuleEvaluator atdlStateRuleEvaluator;

    // act of result of atdlStateRuleEvaluator
    private FxAtdlStateRuleResultActor fxAtdlStateRuleResultActor;

    private Map<String, IFixUiElement> allIFixUiElements = new HashMap<>();

    public FxFxAtdlControlFlowRegister() {
        controlIdUiElementMap = new HashMap<>();
        atdlStateRuleEvaluator = new FxAtdlStateRuleEvaluator(this.allIFixUiElements);
        fxAtdlStateRuleResultActor = new FxFxAtdlStateRuleResultActor();
    }

    public void registerControlFlow(IFixUiElement<?, ? extends Comparable<?>> iFixUiElement) {
        //
        allIFixUiElements.put(iFixUiElement.getControl().getID(), iFixUiElement);
        // get control from iFixUiElement
        ControlT checkBoxListT = iFixUiElement.getControl();
        // for each StateRule map all control Id this UiElement depends on
        checkBoxListT.getStateRule().forEach(stateRuleT -> getAllControlIdFromEdit(stateRuleT.getEdit()).forEach(controlId -> {
            Set<IFixUiElement> iFixUiElements = controlIdUiElementMap.get(controlId);
            iFixUiElements = (iFixUiElements == null) ? new HashSet<>() : iFixUiElements;
            iFixUiElements.add(iFixUiElement);
            controlIdUiElementMap.put(controlId, iFixUiElements);
        }));
        // listen to all
        iFixUiElement.listenChange().addListener((observable, oldValue, newValue) -> {
            Set<IFixUiElement> iFixUiElements = controlIdUiElementMap
                    .get(newValue.split(":")[0]);
            if (iFixUiElements != null) {
                iFixUiElements.forEach(iFixUiElement1 -> iFixUiElement1.getControl().getStateRule().forEach(stateRuleT -> {
                    fxAtdlStateRuleResultActor
                            .doAct(atdlStateRuleEvaluator
                                            .getResult(stateRuleT),
                                    iFixUiElement1);
                }));
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
