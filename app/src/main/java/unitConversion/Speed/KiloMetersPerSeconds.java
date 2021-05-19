package unitConversion.Speed;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class KiloMetersPerSeconds extends Unit implements Speed {

    @Override
    public String toString() {
        return "Kilometers Per Seconds (km/s)";
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


        return getValue();
    }

    @Override
    public BigDecimal convertSpeed(FeetPerHour feetPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 11811023.62);
    }

    @Override
    public BigDecimal convertSpeed(FeetPerSecond feetPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3280.839895);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerHour kiloMetersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3600);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerSeconds kiloMetersPerSeconds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertSpeed(Knots knots) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1943.844492);
    }

    @Override
    public BigDecimal convertSpeed(MetersPerHour metersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3600000);
    }

    @Override
    public BigDecimal convertSpeed(MetersPerSecond metersPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1000);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerHour milesPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 2236.936292);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerSecond milesPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.6213711922);
    }

}
