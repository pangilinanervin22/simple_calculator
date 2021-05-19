package unitConversion.Speed;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class FeetPerHour extends Unit implements Speed {

    @Override
    public String toString() {
        return "Feet Per Hour (ft/h)";
    }

    public FeetPerHour() {setUnitSymbol("ft/h");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof MetersPerSecond)
            return getRoundOffNum(convertSpeed((MetersPerSecond) unit));
        else if (unit instanceof MetersPerHour)
            return getRoundOffNum(convertSpeed((MetersPerHour) unit));
        else if (unit instanceof KiloMetersPerHour)
            return getRoundOffNum(convertSpeed((KiloMetersPerHour) unit));
        else if (unit instanceof KiloMetersPerSeconds)
            return getRoundOffNum(convertSpeed((KiloMetersPerSeconds) unit));
        else if (unit instanceof Knots)
            return getRoundOffNum(convertSpeed((Knots) unit));
        else if (unit instanceof FeetPerHour)
            return getRoundOffNum(convertSpeed((FeetPerHour) unit));
        else if (unit instanceof FeetPerSecond)
            return getRoundOffNum(convertSpeed((FeetPerSecond) unit));
        else if (unit instanceof MilesPerHour)
            return getRoundOffNum(convertSpeed((MilesPerHour) unit));
        else if (unit instanceof MilesPerSecond)
            return getRoundOffNum(convertSpeed((MilesPerSecond) unit));


        return "";
    }

    @Override
    public BigDecimal convertSpeed(FeetPerHour feetPerHour) {
       if (isEmptyAndNull())
           return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertSpeed(FeetPerSecond feetPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0002777777778);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerHour kiloMetersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0003048);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerSeconds kiloMetersPerSeconds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 8.466666667e-8);
    }

    @Override
    public BigDecimal convertSpeed(Knots knots) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0001645788337);
    }

    @Override
    public BigDecimal convertSpeed(MetersPerHour metersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.3048);
    }

    @Override
    public BigDecimal convertSpeed(MetersPerSecond metersPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00008466666667);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerHour milesPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0001893939394);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerSecond milesPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 5.260942761e-8);
    }

}
