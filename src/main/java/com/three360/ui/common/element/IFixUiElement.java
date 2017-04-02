package com.three360.ui.common.element;

import com.three360.fixatdl.core.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sainik on 3/23/17.
 */
public interface IFixUiElement<T, K> {

    /***
     *
     * @return
     */
    T create();

    /***
     *
     * @param e
     */
    void registerForEvent(K e);

    /***
     *
     * @param
     */
    default void setParameters(List<ParameterT> parameterTList) {
    }

    default List<ParameterT> getParameter() {
        return null;
    }

    default List<ParameterT> findParameterByName(String... names) {
        return this.getParameter() != null ? this.getParameter()
                .stream()
                .filter(parameterT -> {
                    boolean matched = false;
                    for (int i = 0; i < names.length; i++)
                        matched |= parameterT.getName().equals(names[i]);
                    return matched;
                })
                .collect(Collectors.toList()) : null;
    }

    default boolean setFieldValueToParameter(Object object, ParameterT parameterT) {
        if (parameterT instanceof LanguageT) {

        } else if (parameterT instanceof CountryT) {
            if (object instanceof String) {
                ((CountryT) parameterT).setConstValue((String) object);
                return true;
            }
        } else if (parameterT instanceof LengthT) {
            if (object instanceof String) {
                try {
                    BigInteger bigDecimal = new BigInteger((String) object);
                    ((LengthT) parameterT).setConstValue(bigDecimal);
                    return true;
                } catch (NumberFormatException e) {

                }
            } else if (object instanceof BigInteger) {
                ((LengthT) parameterT).setConstValue((BigInteger) object);
                return true;
            }
        } else if (parameterT instanceof DataT) {
            if (object instanceof String) {
                DataT dataT = (DataT) object;
                String content = (String) object;
                BigInteger length = new BigInteger(String.valueOf(content.length()));
                if ((dataT.getMinLength() == null || dataT.getMinLength().compareTo(length) <= 0) &&
                        (dataT.getMaxLength() == null || dataT.getMaxLength().compareTo(length) >= 0)) {
                    ((DataT) parameterT).setConstValue(content);
                    return true;
                }
            }
        } else if (parameterT instanceof StringT) {
            if (object instanceof String) {
                StringT stringT = (StringT) object;
                String content = (String) object;
                BigInteger length = new BigInteger(String.valueOf(content.length()));
                if ((stringT.getMinLength() == null || stringT.getMinLength().compareTo(length) <= 0) &&
                        (stringT.getMaxLength() == null || stringT.getMaxLength().compareTo(length) >= 0)) {
                    ((StringT) parameterT).setConstValue(content);
                    return true;
                }
            }
        } else if (parameterT instanceof ExchangeT) {
            if (object instanceof String) {
                ExchangeT exchangeT = (ExchangeT) object;
                exchangeT.setConstValue((String) object);
                return true;
            }
        } else if (parameterT instanceof CharT) {
            if (object instanceof String) {
                CharT charT = (CharT) parameterT;
                charT.setConstValue((String) object);
            }
        } else if (parameterT instanceof CurrencyT) {
            if (object instanceof String) {
                CurrencyT currencyT = (CurrencyT) parameterT;
                currencyT.setConstValue((String) object);
            }
        } else if (parameterT instanceof UTCTimeOnlyT) {


        } else if (parameterT instanceof SeqNumT) {

        } else if (parameterT instanceof TagNumT) {

        } else if (parameterT instanceof TZTimestampT) {

        } else if (parameterT instanceof LocalMktDateT) {

        } else if (parameterT instanceof IntT) {

        } else if (parameterT instanceof MultipleStringValueT) {

        } else if (parameterT instanceof MonthYearT) {

        } else if (parameterT instanceof TenorT) {

        } else if (parameterT instanceof BooleanT) {

        } else if (parameterT instanceof TZTimeOnlyT) {

        } else if (parameterT instanceof UTCDateOnlyT) {

        } else if (parameterT instanceof MultipleCharValueT) {

        } else if (parameterT instanceof FloatT) {

        } else if (parameterT instanceof PriceT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PriceT t = (PriceT) parameterT;
                    if ((t.getMinValue() == null || t.getMinValue().compareTo(bigDecimal) <= 0)
                            && (t.getMaxValue() == null || t.getMaxValue().compareTo(bigDecimal) >= 0)) {
                        ((PriceT) parameterT).setConstValue(bigDecimal);
                        return true;
                    }
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        } else if (parameterT instanceof AmtT) {

        } else if (parameterT instanceof PercentageT) {

        } else if (parameterT instanceof QtyT) {

        } else if (parameterT instanceof PriceOffsetT) {

        } else if (parameterT instanceof UTCTimestampT) {

        } else if (parameterT instanceof PriceOffsetT) {

        }
        return false;
    }

}
