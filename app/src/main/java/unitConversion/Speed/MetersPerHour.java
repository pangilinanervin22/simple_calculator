package unitConversion.Speed;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class MetersPerHour extends Unit implements Speed {

    @Override
    public String toString() {
        return "Meters Per Hour (m/h)";
    }

    public MetersPerHour() {
        setUnitSymbol("m/h");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3.280839895);
    }

    @Override
    public BigDecimal convertSpeed(FeetPerSecond feetPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0009113444154);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerHour kiloMetersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.001);
    }

    @Override
    public BigDecimal convertSpeed(KiloMetersPerSeconds kiloMetersPerSeconds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 2.777777778e-7);
    }

    @Override
    public BigDecimal convertSpeed(Knots knots) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0005399568035);
    }

    @Override
    public BigDecimal convertSpeed(MetersPerHour metersPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertSpeed(MetersPerSecond metersPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0002777777778);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerHour milesPerHour) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0006213711923);
    }

    @Override
    public BigDecimal convertSpeed(MilesPerSecond milesPerSecond) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 	1.72603109e-7);
    }

}
