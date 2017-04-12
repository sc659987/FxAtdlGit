package com.three360.ui.common.element;

import com.three360.fixatdl.core.*;
import com.three360.fixatdl.layout.ControlT;
import javafx.beans.property.ObjectProperty;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

public interface IFixUiElement<T, K extends Comparable<?>> {

    public static final String NULL_VALUE = "{NULL}";

    /***
     * create the Ui and return depending on type
     *
     * @return
     */
    T create();

    /***
     * Publish the changes by
     *
     * @return
     */
    ObjectProperty<String> listenChange();

    /***
     *
     * @return
     */
    K getValue();

    /***
     *
     * @param k
     */
    void setValue(K k);

    /***
     *
     * @param visible
     */
    void makeVisible(boolean visible);

    /***
     *
     * @param enable
     */
    void makeEnable(boolean enable);

    /***
     *
     *
     * @param parameterTList
     */
    void setParameters(List<ParameterT> parameterTList);

    /****
     *
     * @return
     */
    List<ParameterT> getParameter();

    /***
     *
     * @param <C>
     * @return
     */
    <C extends ControlT> C getControl();

    /****
     *
     * @param names
     * @return
     */
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

    /****
     *
     * @param object
     * @param parameterT
     * @return
     */
    default void setFieldValueToParameter(Object object, ParameterT parameterT) {
        if(parameterT==null)
            return;

        if (parameterT instanceof LanguageT) {
            if (object instanceof String)
                ((LanguageT) parameterT).setConstValue((String) object);

        } else if (parameterT instanceof CountryT) {
            if (object instanceof String) {
                ((CountryT) parameterT).setConstValue((String) object);
            }
        } else if (parameterT instanceof LengthT) {
            if (object instanceof String) {
                try {
                    BigInteger bigDecimal = new BigInteger((String) object);
                    ((LengthT) parameterT).setConstValue(bigDecimal);
                } catch (NumberFormatException e) {

                }
            } else if (object instanceof BigInteger) {
                ((LengthT) parameterT).setConstValue((BigInteger) object);
            }
        } else if (parameterT instanceof DataT) {
            if (object instanceof String)
                ((DataT) parameterT).setConstValue((String) object);
        } else if (parameterT instanceof StringT) {
            if (object instanceof String)
                ((StringT) parameterT).setConstValue((String) object);
        } else if (parameterT instanceof ExchangeT) {
            if (object instanceof String)
                ((ExchangeT) parameterT).setConstValue((String) object);
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
            if (object instanceof String) {
                UTCTimeOnlyT utcTimeOnlyT = (UTCTimeOnlyT) parameterT;
                // TODO check and change code to use time only hh:mm:ss
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(utcTimeOnlyT.getLocalMktTz().value()));
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar calendar = DatatypeFactory
                            .newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    utcTimeOnlyT.setConstValue(calendar);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof SeqNumT) {
            if (object instanceof String) {
                try {
                    ((SeqNumT) parameterT).setConstValue(BigInteger.valueOf(Long.parseLong((String) object)));
                } catch (NumberFormatException e) {
                }
            }
        } else if (parameterT instanceof TagNumT) {
            if (object instanceof String) {
                try {
                    ((TagNumT) parameterT).setConstValue(BigInteger.valueOf(Long.parseLong((String) object)));
                } catch (NumberFormatException e) {
                }
            }
        } else if (parameterT instanceof TZTimestampT) {
            if (object instanceof String) {
                TZTimestampT tzTimestampT = (TZTimestampT) parameterT;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    tzTimestampT.setConstValue(xmlGregorianCalendar);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof LocalMktDateT) {
            if (object instanceof String) {
                LocalMktDateT localMktDateT = (LocalMktDateT) parameterT;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    GregorianCalendar gregorianCalendar1 = new GregorianCalendar();
                    gregorianCalendar1.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar1);
                    localMktDateT.setConstValue(calendar);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof IntT) {
            if (object instanceof String) {
                IntT intT = (IntT) parameterT;
                try {
                    Integer constValue = Integer.parseInt((String) object);
                    if ((intT.getMinValue() == null || intT.getMinValue().compareTo(constValue) <= 0)
                            && (intT.getMaxValue() == null || intT.getMaxValue().compareTo(constValue) >= 0)) {
                        intT.setConstValue(constValue);
                    }
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof MultipleStringValueT) {
            if (object instanceof String) {
                MultipleStringValueT multipleStringValueT = (MultipleStringValueT) parameterT;
                try {
                    String multiValue = (String) object;
                    multipleStringValueT.setConstValue(multiValue);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof MonthYearT) {
            if (object instanceof String) {
                MonthYearT monthYearT = (MonthYearT) parameterT;
                // TODO consumeWireString and debug
                monthYearT.setConstValue((String) object);
            }
        } else if (parameterT instanceof TenorT) {
            if (object instanceof String) {
                TenorT tenorT = (TenorT) parameterT;
                tenorT.setConstValue((String) object);
            }
        } else if (parameterT instanceof BooleanT) {
            if (object instanceof String) {
                ((BooleanT) parameterT).setConstValue((String) object);
            }
        } else if (parameterT instanceof TZTimeOnlyT) {
            if (object instanceof String) {
                TZTimeOnlyT tzTimeOnlyT = (TZTimeOnlyT) parameterT;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
                            .newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    tzTimeOnlyT.setConstValue(xmlGregorianCalendar);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof UTCDateOnlyT) {
            if (object instanceof UTCTimeOnlyT) {
                UTCTimeOnlyT utcTimeOnlyT = (UTCTimeOnlyT) parameterT;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory
                            .newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    utcTimeOnlyT.setConstValue(xmlGregorianCalendar);
                } catch (Exception e) {
                }
            }

        } else if (parameterT instanceof MultipleCharValueT) {
            if (object instanceof String) {
                MultipleCharValueT charValueT = (MultipleCharValueT) parameterT;
                try {
                    String value = (String) object;
                    charValueT.setConstValue(new String(value));
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof FloatT) {
            FloatT floatT = (FloatT) parameterT;
            BigDecimal bigDecimal = null;
            if (object instanceof String) {
                bigDecimal = new BigDecimal((String) object);
            } else if (object instanceof Number) {
                bigDecimal = new BigDecimal(((Number) object).doubleValue());
            } else {
                return;
            }
            floatT.setConstValue(bigDecimal);

        } else if (parameterT instanceof PriceT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PriceT t = (PriceT) parameterT;
                    ((PriceT) parameterT).setConstValue(bigDecimal);
                } catch (NumberFormatException e) {
                }
            }
        } else if (parameterT instanceof AmtT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    AmtT amtT = (AmtT) parameterT;
                    amtT.setConstValue(bigDecimal);
                } catch (Exception e) {

                }
            }
        } else if (parameterT instanceof PercentageT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PercentageT percentageT = (PercentageT) parameterT;
                    percentageT.setConstValue(bigDecimal);
                } catch (Exception e) {

                }
            }

        } else if (parameterT instanceof QtyT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    QtyT qtyT = (QtyT) parameterT;
                    qtyT.setConstValue(bigDecimal);
                } catch (Exception e) {

                }
            }
        } else if (parameterT instanceof PriceOffsetT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PriceOffsetT priceOffsetT = (PriceOffsetT) parameterT;
                    priceOffsetT.setConstValue(bigDecimal);
                } catch (Exception e) {
                }
            }
        } else if (parameterT instanceof UTCTimestampT) {
            if (object instanceof String) {
                UTCTimestampT utcTimestampT = (UTCTimestampT) parameterT;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    utcTimestampT.setConstValue(xmlGregorianCalendar);
                } catch (Exception e) {
                }
            }

        }
    }

}
