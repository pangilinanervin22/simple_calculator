package unitConversion.Volume;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class CubicMillimeters extends Unit implements Volume {

    @Override
    public String toString() {
        return "Cubic Millimeters (mm³)";
    }

    public CubicMillimeters() {setUnitSymbol("mm³");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Milliliters)
            return getRoundOffNum(convertVolume((Milliliters) unit));
        if (unit instanceof Liters)
            return getRoundOffNum(convertVolume((Liters) unit));
        if (unit instanceof Gallons)
            return getRoundOffNum(convertVolume((Gallons) unit));
        if (unit instanceof Cups)
            return getRoundOffNum(convertVolume((Cups) unit));
        if (unit instanceof FluidOunces)
            return getRoundOffNum(convertVolume((FluidOunces) unit));
        if (unit instanceof CubicFoot)
            return getRoundOffNum(convertVolume((CubicFoot) unit));
        if (unit instanceof CubicMeters)
            return getRoundOffNum(convertVolume((CubicMeters) unit));
        if (unit instanceof CubicMillimeters)
            return getRoundOffNum(convertVolume((CubicMillimeters) unit));

        return "";
    }

    @Override
    public BigDecimal convertVolume(Milliliters milliliters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.001);
    }

    @Override
    public BigDecimal convertVolume(Liters liters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.000001);
    }

    @Override
    public BigDecimal convertVolume(CubicFoot cubicFeet) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3.531466672e-8);
    }

    @Override
    public BigDecimal convertVolume(CubicMeters cubicMeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e-9);
    }

    @Override
    public BigDecimal convertVolume(CubicMillimeters cubicMillimeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertVolume(Cups cups) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.000004226752838);
    }

    @Override
    public BigDecimal convertVolume(FluidOunces fluidOunces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0000338140227);
    }

    @Override
    public BigDecimal convertVolume(Gallons gallons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 2.641720524e-7);
    }

}
