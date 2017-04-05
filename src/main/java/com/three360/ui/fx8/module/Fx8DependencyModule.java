package com.three360.ui.fx8.module;

import com.three360.fixatdl.core.StrategiesT;
import com.three360.fixatdl.validator.common.IStrategyEditValidator;
import com.three360.fixatdl.validator.impl.StrategyEditValidator;
import com.three360.ui.common.UiElementAbstractFactory;
import com.three360.ui.fx8.FxUiElementFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 * Created by sainik on 3/22/17.
 */
@Module
public class Fx8DependencyModule {

	@Provides
	@Singleton
	Unmarshaller provideJAXBContext() {
		try {
			return JAXBContext.newInstance(StrategiesT.class.getPackage().getName()).createUnmarshaller();
		} catch (Exception e) {
			return null;
		}
	}

	@Provides
	@Singleton
	UiElementAbstractFactory provideUiElementAbstractFactory() {
		return new FxUiElementFactory();
	}


}
