package com.three360.ui.fx8;

import com.three360.fixatdl.core.StrategyT;
import com.three360.fixatdl.layout.DropDownListT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.ui.abs.AbstractFixAtdlUi;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import com.three360.ui.common.element.IFixPanelUiElement;
import com.three360.ui.fx8.component.DaggerMyComponent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.inject.Inject;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.stream.Collectors;

/**
 * Created by sainik on 3/22/17.
 */
public class FxFixAtdlUi extends AbstractFixAtdlUi<Pane> {

    @Inject
    Unmarshaller jaxbUnmarshaller;

    @Inject
    UiElementAbstractFactory factory;

    private Map<String, FxFixAtdlStrategyUI> map = new WeakHashMap<>();

    public FxFixAtdlUi() {
        DaggerMyComponent.builder().build().inject(this);
    }

    @Override
    public Pane createUi() {
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.TOP_LEFT);
        if (getStrategies() != null) {
            vBox.getChildren().add(createStrategySelectionPanel());
            if (getStrategies().getStrategy().size() > 0)
                setSelectedStrategy(getStrategies().getStrategy().get(0));
            if (getSelectedStrategy() != null) {
                IFixPanelUiElement<Node, EventHandler<ActionEvent>> pane = factory.instantiateNewPanel();
                pane.setStrategyPanelT(getSelectedStrategy().getStrategyLayout().getStrategyPanel().get(0));
                vBox.getChildren().add(pane.create());
            }
        }
        return vBox;
    }

    @Override
    public Unmarshaller getUnmarshaller() {
        return this.jaxbUnmarshaller;
    }

    @Override
    public Pane createStrategySelectionPanel() {
        HBox strategySelectionBox = new HBox();
        strategySelectionBox.setAlignment(Pos.CENTER);
        if (getStrategies() != null) {
            IFixDropDownListUiElement<ComboBox<String>, EventHandler<ActionEvent>> element = this.factory.instantiateNewDropDownList();
            List<ListItemT> listItemTS = getStrategies().getStrategy().stream().map(StrategyT::getName).map(s -> {
                ListItemT listItemT = new ListItemT();
                listItemT.setUiRep(s);
                return listItemT;
            }).collect(Collectors.toList());
            DropDownListT dropDownListT = new DropDownListT();
            dropDownListT.getListItem().addAll(listItemTS);
            element.setDropDownList(dropDownListT);
            element.registerForEvent(event -> {
            });
            strategySelectionBox.getChildren().add(element.create());
        }
        return strategySelectionBox;
    }
}
