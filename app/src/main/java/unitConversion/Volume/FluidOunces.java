package unitConversion.Volume;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class FluidOunces extends Unit implements Volume {

    @Override
    public String toString() {
        return "Fluid Ounces (fl Oz)";
    }

    public FluidOunces() {setUnitSymbol("fl Oz");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 29.57352956);
    }

    @Override
    public BigDecimal convertVolume(Liters liters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.02957352956);
    }

    @Override
    public BigDecimal convertVolume(CubicFoot cubicFeet) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00104437934);
    }

    @Override
    public BigDecimal convertVolume(CubicMeters cubicMeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.00002957352956);
    }

    @Override
    public BigDecimal convertVolume(CubicMillimeters cubicMillimeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) *29573.52956 );
    }

    @Override
    public BigDecimal convertVolume(Cups cups) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.125);
    }

    @Override
    public BigDecimal convertVolume(FluidOunces fluidOunces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertVolume(Gallons gallons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0078125);
    }

}
