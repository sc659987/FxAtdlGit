package com.three360.ui.fx8.component;

import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.fx8.FxFixAtdlStrategyUI;
import com.three360.ui.fx8.FxFixAtdlUi;
import com.three360.ui.fx8.element.FxFixLayoutUiElement;
import com.three360.ui.fx8.element.FxFixPanelUiElement;
import com.three360.ui.fx8.module.Fx8DependencyModule;
import dagger.Component;

import javax.inject.Singleton;
import javax.xml.bind.Unmarshaller;

/**
 * Created by sainik on 3/22/17.
 */
@Singleton
@Component(modules = { Fx8DependencyModule.class })
public interface MyComponent {

	Unmarshaller provideUnmarshaller();

	UiElementAbstractFactory provideUiElementAbstractFactory();

	void inject(FxFixAtdlUi fxFixAtdlUiPanel);

	void inject(FxFixAtdlStrategyUI strategyUI);

	void inject(FxFixPanelUiElement fxFixPanelUiElement);

	void inject(FxFixLayoutUiElement fxFixLabelUiElement);

}
