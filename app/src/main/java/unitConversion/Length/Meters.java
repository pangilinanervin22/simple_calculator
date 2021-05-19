package unitConversion.Length;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Meters extends Unit implements Length {

    public Meters() {
        setUnitSymbol("m");
    }

    @Override
    public String toString() {
        return "Meters (m)";
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1000);
    }

    @Override
    public BigDecimal convertLength(Centimeters centimeters) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 100);
    }

    @Override
    public BigDecimal convertLength(Meters meters) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertLength(Kilometers kilometers) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.001);
    }

    @Override
    public BigDecimal convertLength(Yards yards) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1.093613298);
    }

    @Override
    public BigDecimal convertLength(Foot foot) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3.280839895);
    }

    @Override
    public BigDecimal convertLength(Inches inches) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 39.37007874);
    }

    @Override
    public BigDecimal convertLength(Miles miles) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0006213711922);
    }

    @Override
    public BigDecimal convertLength(NauticalMiles nauticalMiles) {
        if(isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0005399568035
        );
    }

}
