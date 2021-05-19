package unitConversion.Mass;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class MetricTons extends Unit implements Mass {

    @Override
    public String toString() {
        return "Metric Tons (mt)";
    }

    public MetricTons() {
        setUnitSymbol("mt");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) / 1000000000);
    }

    @Override
    public BigDecimal convertMass(Grams grams) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1000000);
    }

    @Override
    public BigDecimal convertMass(Kilograms kilograms) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1000);
    }

    @Override
    public BigDecimal convertMass(Tons tons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1.102311311);
    }

    @Override
    public BigDecimal convertMass(MetricTons metricTons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertMass(Ounces ounces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 35273.96195);
    }

    @Override
    public BigDecimal convertMass(Pounds pounds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 2204.622622);
    }

    @Override
    public BigDecimal convertMass(Stones stones) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 157.4730444);
    }
}
