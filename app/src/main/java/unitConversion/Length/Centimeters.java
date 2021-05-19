package unitConversion.Length;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Centimeters extends Unit implements Length {

    public Centimeters() {
        setUnitSymbol("cm");
    }

    @Override
    public String toString() {
        return "Centimeters (cm)";
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Millimeters)
            return getRoundOffNum(convertLength((Millimeters) unit));
        else if (unit instanceof Centimeters)
            return getRoundOffNum(convertLength((Centimeters) unit));
        else if (unit instanceof Meters)
            return getRoundOffNum(convertLength((Meters) unit));
        else if (unit instanceof Kilometers)
            return getRoundOffNum(convertLength((Kilometers) unit));
        else if (unit instanceof Yards)
            return getRoundOffNum(convertLength((Yards) unit));
        else if (unit instanceof Foot)
            return getRoundOffNum(convertLength((Foot) unit));
        else if (unit instanceof Inches)
            return getRoundOffNum(convertLength((Inches) unit));
        else if (unit instanceof Miles)
            return getRoundOffNum(convertLength((Miles) unit));
        else if (unit instanceof NauticalMiles)
            return getRoundOffNum(convertLength((NauticalMiles) unit));

        return "";
    }

    @Override
    public BigDecimal convertLength(Millimeters millimeters) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 10);
    }

    @Override
    public BigDecimal convertLength(Centimeters centimeters) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }


    @Override
    public BigDecimal convertLength(Meters meters) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 	0.01);
    }

    @Override
    public BigDecimal convertLength(Kilometers kilometers) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00001);
    }

    @Override
    public BigDecimal convertLength(Yards yards) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.01093613298);
    }

    @Override
    public BigDecimal convertLength(Foot foot) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 	0.03280839895);
    }

    @Override
    public BigDecimal convertLength(Inches inches) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.3937007874);
    }

    @Override
    public BigDecimal convertLength(Miles miles) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.000006213711922);
    }

    @Override
    public BigDecimal convertLength(NauticalMiles nauticalMiles) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.000005399568035);
    }

}
