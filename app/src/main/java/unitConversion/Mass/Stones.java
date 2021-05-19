package unitConversion.Mass;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Stones extends Unit implements Mass {

    @Override
    public String toString() {
        return "Stones (st)";
    }

    public Stones() {
        setUnitSymbol("st");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 6350293.18);
    }

    @Override
    public BigDecimal convertMass(Grams grams) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 6350.29318);
    }

    @Override
    public BigDecimal convertMass(Kilograms kilograms) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 6.35029318);
    }

    @Override
    public BigDecimal convertMass(Tons tons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.007);
    }

    @Override
    public BigDecimal convertMass(MetricTons metricTons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00635029318);
    }

    @Override
    public BigDecimal convertMass(Ounces ounces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 224);
    }

    @Override
    public BigDecimal convertMass(Pounds pounds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 14);
    }

    @Override
    public BigDecimal convertMass(Stones stones) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

}
