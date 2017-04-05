package com.three360.ui.fx8.element;

import com.three360.fixatdl.core.ParameterT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.layout.MultiSelectListT;
import com.three360.ui.common.element.IFixMultiSelectListUiElement;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class FxFixMultiSelectListUiElement implements IFixMultiSelectListUiElement<Pane, EventHandler<ActionEvent>> {

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

            this.multiSelectListView
                    .getSelectionModel()
                    .selectedIndexProperty()
                    .addListener((observable, oldValue, newValue) -> {
                        System.out.println("New Value :   " + multiSelectListView
                                .getSelectionModel()
                                .getSelectedIndices().stream().collect(Collectors.toList()));
                    });



            this.vBoxWrapper.getChildren().add(this.label);

            this.vBoxWrapper.getChildren().add(this.multiSelectListView);

            return this.vBoxWrapper;
        }
        return null;
    }

    @Override
    public void registerForEvent(EventHandler<ActionEvent> e) {

    }

    @Override
    public void setMultiSelectList(MultiSelectListT multiSelectListT) {
        this.multiSelectListT = multiSelectListT;
    }

    @Override
    public void setParameters(List<ParameterT> parameterTList) {
        assert (parameterTList != null);
        this.parameterT = parameterTList.get(0);
    }

    @Override
    public List<ParameterT> getParameter() {
        List<ParameterT> parameterTS = Collections.emptyList();
        parameterTS.add(this.parameterT);
        return parameterTS;
    }
}
