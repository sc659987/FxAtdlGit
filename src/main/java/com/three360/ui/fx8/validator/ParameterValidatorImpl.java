package com.three360.ui.fx8.validator;

import com.three360.fixatdl.core.*;
import com.three360.ui.validator.IParameterValidator;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class ParameterValidatorImpl implements IParameterValidator {

	private List<ParameterT> parameterTS;

	public ParameterValidatorImpl(List<ParameterT> parameterTS) {
		this.parameterTS = parameterTS;
	}

	// TODO make parameter required added to logic
	// TODO check and correct the condition (mostly negate)
	// TODO put required error message
	@Override
	public List<String> validateParameter() {
		return this.parameterTS.stream().map(parameterT -> {
			if (parameterT instanceof DataT) {
				DataT dataT = (DataT) parameterT;
				BigInteger length = new BigInteger(String.valueOf(dataT.getConstValue().length()));
				if (!((dataT.getMinLength() == null || dataT.getMinLength().compareTo(length) <= 0) &&
						(dataT.getMaxLength() == null || dataT.getMaxLength().compareTo(length) >= 0))) {
					return "";
				}
			} else if (parameterT instanceof StringT) {
				StringT stringT = (StringT) parameterT;
				BigInteger length = new BigInteger(String.valueOf(((StringT) parameterT).getConstValue().length()));
				if (((stringT.getMinLength() == null || stringT.getMinLength().compareTo(length) <= 0) &&
						(stringT.getMaxLength() == null || stringT.getMaxLength().compareTo(length) >= 0))) {
					return "";
				}
			} else if (parameterT instanceof UTCTimeOnlyT) {
				UTCTimeOnlyT utcTimeOnlyT = (UTCTimeOnlyT) parameterT;
				if (!((utcTimeOnlyT.getMinValue() == null || utcTimeOnlyT.getMinValue().compare(utcTimeOnlyT.getConstValue()) <= 0) &&
						(utcTimeOnlyT.getMaxValue() == null || utcTimeOnlyT.getMaxValue().compare(utcTimeOnlyT.getConstValue()) >= 0))) {
					return "";
				}
			} else if (parameterT instanceof TZTimestampT) {
				TZTimestampT tzTimestampT = (TZTimestampT) parameterT;
				if (!((tzTimestampT.getMinValue() == null || tzTimestampT.getMinValue().compare(tzTimestampT.getConstValue()) <= 0)
						&& (tzTimestampT.getMaxValue() == null || tzTimestampT.getMaxValue().compare(tzTimestampT.getConstValue()) >= 0))) {
					return "";
				}
			} else if (parameterT instanceof LocalMktDateT) {
				LocalMktDateT localMktDateT = (LocalMktDateT) parameterT;
				if (!(localMktDateT.getMinValue() == null || localMktDateT.getMinValue().compare(localMktDateT.getConstValue()) <= 0
						&& localMktDateT.getMaxValue() == null || localMktDateT.getMaxValue().compare(localMktDateT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof IntT) {
				IntT intT = (IntT) parameterT;
				if (!((intT.getMinValue() == null || intT.getMinValue().compareTo(intT.getConstValue()) <= 0)
						&& (intT.getMaxValue() == null || intT.getMaxValue().compareTo(intT.getConstValue()) >= 0))) {
					return "";
				}
			} else if (parameterT instanceof MultipleStringValueT) {
				MultipleStringValueT multipleStringValueT = (MultipleStringValueT) parameterT;
				if (((multipleStringValueT.getMinLength() == null
						|| multipleStringValueT.getMinLength().intValue() <= multipleStringValueT.getConstValue().length())
						&& (multipleStringValueT.getMaxLength() == null
								|| multipleStringValueT.getMaxLength().intValue() >= multipleStringValueT.getConstValue().length()))) {
					return "";
				}
			} else if (parameterT instanceof TZTimeOnlyT) {
				TZTimeOnlyT tzTimeOnlyT = (TZTimeOnlyT) parameterT;
				if (tzTimeOnlyT.getMinValue() == null || tzTimeOnlyT.getMinValue().compare(tzTimeOnlyT.getConstValue()) <= 0
						&& tzTimeOnlyT.getMaxValue() == null || tzTimeOnlyT.getMaxValue().compare(tzTimeOnlyT.getConstValue()) >= 0) {
					return "";
				}
			} else if (parameterT instanceof UTCDateOnlyT) {
				UTCTimeOnlyT utcTimeOnlyT = (UTCTimeOnlyT) parameterT;
				if ((utcTimeOnlyT.getMinValue() == null || utcTimeOnlyT.getMinValue().compare(utcTimeOnlyT.getConstValue()) <= 0)
						&& (utcTimeOnlyT.getMaxValue() == null || utcTimeOnlyT.getMaxValue().compare(utcTimeOnlyT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof MultipleCharValueT) {
				MultipleCharValueT charValueT = (MultipleCharValueT) parameterT;
				if ((charValueT.getMinLength() == null || charValueT.getConstValue().length() >= charValueT.getMinLength().intValue())
						&& (charValueT.getMaxLength() == null || charValueT.getMaxLength().intValue() >= charValueT.getConstValue().length())) {
					return "";
				}
			} else if (parameterT instanceof FloatT) {
				FloatT floatT = (FloatT) parameterT;
				if ((floatT.getMinValue() == null || floatT.getMinValue().compareTo(floatT.getConstValue()) <= 0) &&
						(floatT.getMaxValue() == null || floatT.getMaxValue().compareTo(floatT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof PriceT) {
				PriceT priceT = (PriceT) parameterT;
				if ((priceT.getMinValue() == null || priceT.getMinValue().compareTo(priceT.getConstValue()) <= 0)
						&& (priceT.getMaxValue() == null || priceT.getMaxValue().compareTo(priceT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof AmtT) {
				AmtT amtT = (AmtT) parameterT;
				if ((amtT.getMinValue() == null || amtT.getMinValue().compareTo(amtT.getConstValue()) <= 0)
						&& (amtT.getMaxValue() == null || amtT.getMaxValue().compareTo(amtT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof PercentageT) {
				PercentageT percentageT = (PercentageT) parameterT;
				if ((percentageT.getMinValue() == null || percentageT.getMinValue().compareTo(percentageT.getConstValue()) <= 0)
						&& (percentageT.getMaxValue() == null || percentageT.getMaxValue().compareTo(percentageT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof QtyT) {
				QtyT qtyT = (QtyT) parameterT;
				if ((qtyT.getMinValue() == null || qtyT.getMinValue().compareTo(qtyT.getConstValue()) <= 0)
						&& (qtyT.getMaxValue() == null || qtyT.getMaxValue().compareTo(qtyT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof PriceOffsetT) {
				PriceOffsetT priceOffsetT = (PriceOffsetT) parameterT;
				if ((priceOffsetT.getMinValue() == null || priceOffsetT.getMinValue().compareTo(priceOffsetT.getConstValue()) <= 0)
						&& (priceOffsetT.getMaxValue() == null || priceOffsetT.getMaxValue().compareTo(priceOffsetT.getConstValue()) >= 0)) {
					return "";
				}
			} else if (parameterT instanceof UTCTimestampT) {
				UTCTimestampT utcTimestampT = (UTCTimestampT) parameterT;
				if ((utcTimestampT.getMinValue() == null || utcTimestampT.getMinValue().compare(utcTimestampT.getConstValue()) <= 0)
						&& (utcTimestampT.getMaxValue() == null || utcTimestampT.getMaxValue().compare(utcTimestampT.getConstValue()) >= 0)) {
					return "";
				}
			}
			return null;
		}).collect(Collectors.toList());
	}
}
