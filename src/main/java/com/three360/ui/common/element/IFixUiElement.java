package com.three360.ui.common.element;

import com.three360.fixatdl.core.*;
import com.three360.fixatdl.layout.MultiSelectListT;
import com.three360.fixatdl.timezones.Timezone;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;


public interface IFixUiElement<T, K> {

    T create();

    void registerForEvent(K e);


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
            if (object instanceof String)
                ((LanguageT) parameterT).setConstValue((String) object);
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
            if (object instanceof String) {
                UTCTimeOnlyT utcTimeOnlyT = (UTCTimeOnlyT) parameterT;
                // TODO check and change code to use time only
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(utcTimeOnlyT.getLocalMktTz().value()));
                try {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.setTime(simpleDateFormat.parse((String) object));
                    XMLGregorianCalendar calendar = DatatypeFactory
                            .newInstance()
                            .newXMLGregorianCalendar(gregorianCalendar);
                    if ((utcTimeOnlyT.getMinValue() == null || utcTimeOnlyT.getMinValue().compare(calendar) <= 0) &&
                            (utcTimeOnlyT.getMaxValue() == null || utcTimeOnlyT.getMaxValue().compare(calendar) >= 0)) {
                        utcTimeOnlyT.setConstValue(calendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        } else if (parameterT instanceof SeqNumT) {
            if (object instanceof String) {
                try {
                    ((SeqNumT) parameterT).setConstValue(BigInteger.valueOf(Long.parseLong((String) object)));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            }
        } else if (parameterT instanceof TagNumT) {
            if (object instanceof String) {
                try {
                    ((TagNumT) parameterT).setConstValue(BigInteger.valueOf(Long.parseLong((String) object)));
                    return true;
                } catch (NumberFormatException e) {
                    return false;
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
                    if ((tzTimestampT.getMinValue() == null || tzTimestampT.getMinValue().compare(xmlGregorianCalendar) <= 0)
                            && (tzTimestampT.getMaxValue() == null || tzTimestampT.getMaxValue().compare(xmlGregorianCalendar) >= 0)) {
                        tzTimestampT.setConstValue(xmlGregorianCalendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
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
                    if (localMktDateT.getMinValue() == null || localMktDateT.getMinValue().compare(calendar) <= 0
                            && localMktDateT.getMaxValue() == null || localMktDateT.getMaxValue().compare(calendar) >= 0) {
                        localMktDateT.setConstValue(calendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
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
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        } else if (parameterT instanceof MultipleStringValueT) {
            if (object instanceof String) {
                MultipleStringValueT multipleStringValueT = (MultipleStringValueT) parameterT;
                try {
                    String multiValue = (String) object;
                    if ((multipleStringValueT.getMinLength() == null || multipleStringValueT.getMinLength().intValue() <= multiValue.length())
                            && (multipleStringValueT.getMaxLength() == null || multipleStringValueT.getMaxLength().intValue() >= multiValue.length())) {
                        multipleStringValueT.setConstValue(multiValue);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        } else if (parameterT instanceof MonthYearT) {
            if (object instanceof String) {
                MonthYearT monthYearT = (MonthYearT) parameterT;
                // TODO  test and debug
                monthYearT.setConstValue((String) object);
                return true;
            }
        } else if (parameterT instanceof TenorT) {
            if (object instanceof String) {
                TenorT tenorT = (TenorT) parameterT;
                tenorT.setConstValue((String) object);
                return true;
            }
        } else if (parameterT instanceof BooleanT) {
            if (object instanceof String) {
                ((BooleanT) parameterT).setConstValue((String) object);
                return true;
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
                    if (tzTimeOnlyT.getMinValue() == null || tzTimeOnlyT.getMinValue().compare(xmlGregorianCalendar) <= 0
                            && tzTimeOnlyT.getMaxValue() == null || tzTimeOnlyT.getMaxValue().compare(xmlGregorianCalendar) >= 0) {
                        tzTimeOnlyT.setConstValue(xmlGregorianCalendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
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
                    if ((utcTimeOnlyT.getMinValue() == null || utcTimeOnlyT.getMinValue().compare(xmlGregorianCalendar) <= 0)
                            && (utcTimeOnlyT.getMaxValue() == null || utcTimeOnlyT.getMaxValue().compare(xmlGregorianCalendar) >= 0)) {
                        utcTimeOnlyT.setConstValue(xmlGregorianCalendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

        } else if (parameterT instanceof MultipleCharValueT) {
            if (object instanceof String) {
                MultipleCharValueT charValueT = (MultipleCharValueT) parameterT;
                try {
                    String value = (String) object;
                    if ((charValueT.getMinLength() == null || value.length() >= charValueT.getMinLength().intValue())
                            && (charValueT.getMaxLength() == null || charValueT.getMaxLength().intValue() >= value.length())) {
                        charValueT.setConstValue(new String(value));
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

        } else if (parameterT instanceof FloatT) {
            if (object instanceof String) {
                FloatT floatT = (FloatT) parameterT;
                BigDecimal bigDecimal = new BigDecimal((String) object);
                if ((floatT.getMinValue() == null || floatT.getMinValue().compareTo(bigDecimal) <= 0) &&
                        (floatT.getMaxValue() == null || floatT.getMaxValue().compareTo(bigDecimal) >= 0)) {
                    floatT.setConstValue(bigDecimal);
                    return true;
                }
            }
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
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    AmtT amtT = (AmtT) parameterT;
                    if ((amtT.getMinValue() == null || amtT.getMinValue().compareTo(bigDecimal) <= 0)
                            && (amtT.getMaxValue() == null || amtT.getMaxValue().compareTo(bigDecimal) >= 0)) {
                        amtT.setConstValue(bigDecimal);
                        return true;
                    }
                } catch (Exception e) {

                }
            }
        } else if (parameterT instanceof PercentageT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PercentageT percentageT = (PercentageT) parameterT;
                    if ((percentageT.getMinValue() == null || percentageT.getMinValue().compareTo(bigDecimal) <= 0)
                            && (percentageT.getMaxValue() == null || percentageT.getMaxValue().compareTo(bigDecimal) >= 0)) {
                        percentageT.setConstValue(bigDecimal);
                        return true;
                    }
                } catch (Exception e) {

                }
            }

        } else if (parameterT instanceof QtyT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    QtyT qtyT = (QtyT) parameterT;
                    if ((qtyT.getMinValue() == null || qtyT.getMinValue().compareTo(bigDecimal) <= 0)
                            && (qtyT.getMaxValue() == null || qtyT.getMaxValue().compareTo(bigDecimal) >= 0)) {
                        qtyT.setConstValue(bigDecimal);
                        return true;
                    }
                } catch (Exception e) {

                }
            }
        } else if (parameterT instanceof PriceOffsetT) {
            if (object instanceof String) {
                try {
                    BigDecimal bigDecimal = new BigDecimal((String) object);
                    PriceOffsetT priceOffsetT = (PriceOffsetT) parameterT;
                    if ((priceOffsetT.getMinValue() == null || priceOffsetT.getMinValue().compareTo(bigDecimal) <= 0)
                            && (priceOffsetT.getMaxValue() == null || priceOffsetT.getMaxValue().compareTo(bigDecimal) >= 0)) {
                        priceOffsetT.setConstValue(bigDecimal);
                        return true;
                    }
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
                    if ((utcTimestampT.getMinValue() == null || utcTimestampT.getMinValue().compare(xmlGregorianCalendar) <= 0)
                            && (utcTimestampT.getMaxValue() == null || utcTimestampT.getMaxValue().compare(xmlGregorianCalendar) >= 0)) {
                        utcTimestampT.setConstValue(xmlGregorianCalendar);
                        return true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }

        }
        return false;
    }

}
