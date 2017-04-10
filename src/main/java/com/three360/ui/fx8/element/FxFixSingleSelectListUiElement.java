package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.SingleSelectListT;
import com.three360.ui.Utils;
import com.three360.ui.common.element.IFixSingleSelectListUiElement;
import com.three360.ui.fx8.FxUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.util.Collections;
import java.util.List;

public class FxFixSingleSelectListUiElement
        implements IFixSingleSelectListUiElement<Pane, String> {

    private GridPane gridPane;
    private ListView<ListItemT> singleSelectListView;
    private SingleSelectListT singleSelectListT;
    private ParameterT parameterT;
    private int nextRow = 0;

    private ObjectProperty<String> controlIdEmitter = new SimpleObjectProperty<>();

    @Override
    public Pane create() {
        if (this.singleSelectListT != null) {
            this.gridPane = new GridPane();


            this.singleSelectListView = new ListView<>(FXCollections.observableArrayList(
                    this.singleSelectListT
                            .getListItem()));

            this.singleSelectListView.setCellFactory(param -> new ListCell<ListItemT>() {
                @Override
                protected void updateItem(ListItemT item, boolean empty) {
                    super.updateItem(item, empty);
                    setText(item.getUiRep());
                }
            });

            this.singleSelectListView.getSelectionModel()
                    .setSelectionMode(SelectionMode.SINGLE);

            if (parameterT != null)
                this.singleSelectListView.setOnMouseClicked(event ->

                        // TODO fix this code
                        parameterT
                                .getEnumPair()
                                .stream()
                                .filter(enumPairT ->
                                        enumPairT.getEnumID()
                                                .equals(this.singleSelectListT
                                                        .getListItem()
                                                        .get(singleSelectListView
                                                                .getSelectionModel()
                                                                .getSelectedIndices()
                                                                .get(0))
                                                        .getEnumID()))
                                .findFirst().ifPresent(enumPairT -> {
                            controlIdEmitter.set(singleSelectListT.getID());
                            setFieldValueToParameter(enumPairT.getWireValue(), parameterT);
                        })
                );

            if (!Utils.isEmpty(this.singleSelectListT.getLabel())) {
                this.gridPane.getColumnConstraints().addAll(FxUtils.getOneColumnWidthForGridPane());
                this.gridPane.add(new Label(this.singleSelectListT.getLabel()), 0,
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
    public ObjectProperty<String> listenChange() {
        return this.controlIdEmitter;
    }

    @Override
    public SingleSelectListT getControl() {
        return this.singleSelectListT;
    }

    @Override
    public String getValue() {
        return singleSelectListView.getItems().get(
                singleSelectListView
                        .getSelectionModel()
                        .getSelectedIndices()
                        .get(0))
                .getEnumID();
    }

    @Override
    public void setValue(String s) {
        // TODO to be done in future for control flow extension
    }

    @Override
    public void makeVisible(boolean visible) {
        this.singleSelectListView.setVisible(visible);
    }

    @Override
    public void makeEnable(boolean enable) {
        this.singleSelectListView.setDisable(!enable);
    }
}
