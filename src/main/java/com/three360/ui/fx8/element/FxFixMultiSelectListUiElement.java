package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.EnumPairT;
import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.MultiSelectListT;
import com.three360.ui.common.element.IFixMultiSelectListUiElement;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FxFixMultiSelectListUiElement implements IFixMultiSelectListUiElement<Pane, String> {

    private VBox vBoxWrapper;
    private ListView<String> multiSelectListView;
    private Label label;

    private MultiSelectListT multiSelectListT;

    private ParameterT parameterT;

    private int nextRow = 0;

    @Override
    public Pane create() {
        if (this.multiSelectListT != null) {
            this.vBoxWrapper = new VBox();
            this.label = new Label(this.multiSelectListT.getLabel());
            this.multiSelectListView = new ListView<>(FXCollections.observableArrayList(
                    this.multiSelectListT
                            .getListItem()
                            .stream()
                            .map(ListItemT::getUiRep)
                            .collect(Collectors.toList())));
            this.multiSelectListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


            if (parameterT != null)
                this.multiSelectListView
                        .getSelectionModel()
                        .selectedIndexProperty()
                        .addListener((observable, oldValue, newValue) -> {
                            if (newValue.intValue() >= 0) {
                                setFieldValueToParameter(String.join(" ", this.multiSelectListView
                                        .getSelectionModel()
                                        .getSelectedIndices()
                                        .stream()
                                        .map(integer -> multiSelectListT.getListItem().get(integer))
                                        .map(listItemT -> listItemT.getEnumID())
                                        .map(s -> parameterT
                                                .getEnumPair()
                                                .stream()
                                                .filter(enumPairT -> enumPairT.getEnumID().equals(s)).findFirst().orElse(null)
                                        ).filter(enumPairT -> enumPairT != null)
                                        .map(EnumPairT::getWireValue)
                                        .collect(Collectors.toList())), parameterT);
                            }
                        });


            this.vBoxWrapper.getChildren().add(this.label);

            this.vBoxWrapper.getChildren().add(this.multiSelectListView);

            return this.vBoxWrapper;
        }
        return null;
    }

    @Override
    public void setMultiSelectList(MultiSelectListT multiSelectListT) {
        this.multiSelectListT = multiSelectListT;
    }

    @Override
    public void setParameters(List<ParameterT> parameterTList) {
        if (parameterTList != null && parameterTList.size() > 0)
            this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }


    @Override
    public ObjectProperty<Pair<String, String>> listenChange() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public void setValue(String s) {

    }

    @Override
    public void makeVisible(boolean visible) {

    }

    @Override
    public void makeEnable(boolean enable) {

    }
}
