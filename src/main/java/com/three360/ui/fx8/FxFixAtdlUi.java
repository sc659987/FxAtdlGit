package com.three360.ui.fx8;

import com.three360.fixatdl.layout.DropDownListT;
import com.three360.fixatdl.layout.ListItemT;
import com.three360.fixatdl.validator.common.IStrategyEditValidator;
import com.three360.fixatdl.validator.impl.StrategyEditValidator;
import com.three360.ui.abs.AbstractFixAtdlUi;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.common.element.IFixDropDownListUiElement;
import com.three360.ui.common.element.IFixLayoutUiElement;
import com.three360.ui.fx8.component.DaggerMyComponent;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

import javax.inject.Inject;
import javax.xml.bind.Unmarshaller;
import java.util.List;
import java.util.stream.Collectors;

public class FxFixAtdlUi extends AbstractFixAtdlUi<Pane> {

    @Inject
    Unmarshaller jaxbUnmarshaller;

    @Inject
    UiElementAbstractFactory factory;

    private final BorderPane borderPane = new BorderPane();

    private IStrategyEditValidator iStrategyEditValidator;

    public FxFixAtdlUi() {
        DaggerMyComponent.builder().build().inject(this);
    }

    @Override
    public Pane createUi() {
        if (getStrategies() != null) {
            this.borderPane.getChildren().clear();
            this.borderPane.setTop(createStrategySelectionPanel());
            if (getStrategies().getStrategy().size() > 0)
                setSelectedStrategy(getStrategies().getStrategy().get(0));
            if (getSelectedStrategy() != null) {
                createFixLayout();
                createFixErrorMessage();
                this.iStrategyEditValidator =
                        new StrategyEditValidator(super.selectedStrategyT.getStrategyEdit(),
                                super.selectedStrategyT.getParameter());
            }
        }
        return this.borderPane;
    }

    private void createFixLayout() {
        IFixLayoutUiElement<Node, EventHandler<ActionEvent>> layoutUiElement = factory.instantiateNewLayout();
        layoutUiElement.setStrategyLayout(getSelectedStrategy().getStrategyLayout());
        layoutUiElement.setParameters(super.selectedStrategyT.getParameter());
        this.borderPane.setCenter(layoutUiElement.create());
    }



    //TODO call for validation and print error message on found
    private void createFixErrorMessage() {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label("kjhkehfer werjhikjwe"));


        Button button = new Button("Validate");
        TextField textField = new TextField();
        textField.setEditable(false);

        HBox hBox = new HBox();
        hBox.getChildren().add(button);
        hBox.getChildren().add(textField);

        HBox.setHgrow(textField, Priority.ALWAYS);

        vBox.getChildren().add(hBox);
        this.borderPane.setBottom(vBox);
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
            IFixDropDownListUiElement<ComboBox<String>, ChangeListener<String>> element = this.factory.instantiateNewDropDownList();
            List<ListItemT> listItemTS = getStrategies().getStrategy().stream().map(s -> {
                ListItemT listItemT = new ListItemT();
                listItemT.setUiRep(s.getUiRep());
                return listItemT;
            }).collect(Collectors.toList());
            DropDownListT dropDownListT = new DropDownListT();
            dropDownListT.getListItem().addAll(listItemTS);
            element.setDropDownList(dropDownListT);
            element.registerForEvent((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    setSelectedStrategy(findStrategyTByName(newValue));
                    createFixLayout();
                }
            });
            strategySelectionBox.getChildren().add(element.create());
        }
        return strategySelectionBox;
    }
}
