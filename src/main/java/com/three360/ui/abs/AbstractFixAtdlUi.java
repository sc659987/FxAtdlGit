package com.three360.ui.abs;

import com.three360.fixatdl.core.StrategiesT;
import com.three360.fixatdl.core.StrategyT;
import com.three360.ui.common.IFixAtdlUi;

import javax.xml.bind.JAXBElement;
import java.io.File;

/***
 *
 * @param <T>
 */
public abstract class AbstractFixAtdlUi<T> implements IFixAtdlUi<T> {

    protected StrategiesT strategiesT;

    protected StrategyT selectedStrategyT;

    @Override
    public void parseFixAtdlFile(File file) {
        try {
            if (file != null && file.exists() && !file.isDirectory()) {
                JAXBElement o = (JAXBElement) getUnmarshaller().unmarshal(file);
                if (o.getValue() instanceof StrategiesT)
                    this.strategiesT = (StrategiesT) o.getValue();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void validate(StrategyT strategyT) {

    }

    @Override
    public StrategiesT getStrategies() {
        return this.strategiesT;
    }

    @Override
    public void setSelectedStrategy(StrategyT strategyT) {
        this.selectedStrategyT = strategyT;
    }

    @Override
    public StrategyT getSelectedStrategy() {
        return this.selectedStrategyT;
    }

}
