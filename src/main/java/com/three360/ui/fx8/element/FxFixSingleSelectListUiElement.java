package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SingleSelectListT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixSingleSelectListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Pair;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixSingleSelectListUiElement
        implements IFixSingleSelectListUiElement<Pane, String> {

    private GridPane gridPane;
    private ListView<String> singleSelectListView;
    private Label label;

    private SingleSelectListT singleSelectListT;

    private ParameterT parameterT;

    private int nextRow = 0;


    @Override
    public Pane create() {
        if (this.singleSelectListT != null) {
            this.gridPane = new GridPane();
            this.label = new Label(this.singleSelectListT.getLabel());
            this.singleSelectListView = new ListView<>(FXCollections.observableArrayList(
                    this.singleSelectListT
                            .getListItem()
                            .stream()
                            .map(ListItemT::getUiRep)
                            .collect(Collectors.toList())));
            this.singleSelectListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


            if (parameterT != null)
                this.singleSelectListView
                        .getSelectionModel()
                        .selectedIndexProperty()
                        .addListener((observable, oldValue, newValue) -> {
                            parameterT
                                    .getEnumPair()
                                    .stream()
                                    .filter(enumPairT ->
                                            enumPairT.getEnumID()
                                                    .equals(this.singleSelectListT
                                                            .getListItem()
                                                            .get(newValue.intValue()).getEnumID())).findFirst().ifPresent(enumPairT -> {
                                System.out.println("Wire Value : " + enumPairT.getWireValue());
                                setFieldValueToParameter(enumPairT.getWireValue(), parameterT);
                            });

//                        System.out.println(parameterT.getClass());

                        });

            if (!Utils.isEmpty(this.singleSelectListT.getLabel())) {
                this.gridPane.getColumnConstraints().addAll(FxUtils.getOneColumnWidthForGridPane());
                this.gridPane.add(this.label = new Label(this.singleSelectListT.getLabel()), 0,
                        this.nextRow++);
            }

            this.gridPane.add(this.singleSelectListView, 0, this.nextRow);

            return this.gridPane;
        }
        return null;
    }



    @Override
    public void setSingleSelectList(SingleSelectListT singleSelectListT) {
        this.singleSelectListT = singleSelectListT;
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
