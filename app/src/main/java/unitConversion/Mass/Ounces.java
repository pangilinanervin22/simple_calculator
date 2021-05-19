package unitConversion.Mass;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Ounces extends Unit implements Mass {

    @Override
    public String toString() {
        return "Ounces (oz)";
    }

    public Ounces() {
        setUnitSymbol("oz");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Miligrams)
            return getRoundOffNum(convertMass((Miligrams) unit));
        if (unit instanceof Grams)
            return getRoundOffNum(convertMass((Grams) unit));
        if (unit instanceof Kilograms)
            return getRoundOffNum(convertMass((Kilograms) unit));
        if (unit instanceof Tons)
            return getRoundOffNum(convertMass((Tons) unit));
        if (unit instanceof MetricTons)
            return getRoundOffNum(convertMass((MetricTons) unit));
        if (unit instanceof Ounces)
            return getRoundOffNum(convertMass((Ounces) unit));
        if (unit instanceof Pounds)
            return getRoundOffNum(convertMass((Pounds) unit));
        if (unit instanceof Stones)
            return getRoundOffNum(convertMass((Stones) unit));

        return "";
    }

    @Override
    public BigDecimal convertMass(Miligrams miligrams) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 28349.52313);
    }

    @Override
    public BigDecimal convertMass(Grams grams) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 28.34952313);
    }

    @Override
    public BigDecimal convertMass(Kilograms kilograms) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.02834952313);
    }

    @Override
    public BigDecimal convertMass(Tons tons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00003125);
    }

    @Override
    public BigDecimal convertMass(MetricTons metricTons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00002834952313);
    }

    @Override
    public BigDecimal convertMass(Ounces ounces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertMass(Pounds pounds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0625);
    }

    @Override
    public BigDecimal convertMass(Stones stones) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.004464285714);
    }

}
