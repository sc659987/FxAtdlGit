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
import javafx.scene.paint.Color;

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

    private Button validateButton;

    private VBox errorMessageAndValidateButtonBox;

    private TextField textField;

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
        this.errorMessageAndValidateButtonBox = new VBox();

        this.validateButton = new Button("Validate");
        this.textField = new TextField();

        this.textField.setEditable(false);

        HBox validateBox = new HBox();
        validateBox.getChildren().add(this.validateButton);
        validateBox.getChildren().add(this.textField);


        this.validateButton.setOnAction(event -> {
            List<String> errorMessage = iStrategyEditValidator.validateStrategyEditRuleAndGetErrorMessage();
            if (errorMessage != null && errorMessage.size() > 0) {
                this.errorMessageAndValidateButtonBox.getChildren().addAll(errorMessage.stream().map(str -> {
                    Label lb = new Label(str);
                    lb.setTextFill(Color.web("#FF0040"));
                    return lb;
                }).collect(Collectors.toList()));
            } else {
                // generate the wire value and put that pn text box

            }
        });
        HBox.setHgrow(textField, Priority.ALWAYS);

        VBox wrapperBox = new VBox();

        this.errorMessageAndValidateButtonBox.getChildren().add(validateBox);

        wrapperBox.getChildren().add(this.errorMessageAndValidateButtonBox);
        wrapperBox.getChildren().add(validateBox);

        this.borderPane.setBottom(wrapperBox);
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
            IFixDropDownListUiElement<ComboBox<String>, String> element = this.factory.instantiateNewDropDownList();
            List<ListItemT> listItemTS = getStrategies().getStrategy().stream().map(s -> {
                ListItemT listItemT = new ListItemT();
                listItemT.setUiRep(s.getUiRep());
                return listItemT;
            }).collect(Collectors.toList());
            DropDownListT dropDownListT = new DropDownListT();
            dropDownListT.getListItem().addAll(listItemTS);
            element.setDropDownList(dropDownListT);
            element.listenChange().addListener((observable, oldValue, newValue) -> {
                if (newValue != null) {
                    setSelectedStrategy(findStrategyTByName(newValue.getValue()));
                    createFixLayout();
                }
            });
            strategySelectionBox.getChildren().add(element.create());
        }
        return strategySelectionBox;
    }
}
