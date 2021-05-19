package unitConversion.Volume;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Gallons extends Unit implements Volume {

    @Override
    public String toString() {
        return "Gallons (gal)";
    }

    public Gallons() {setUnitSymbol("gal");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3785.411784);
    }

    @Override
    public BigDecimal convertVolume(Liters liters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3.785411784);
    }

    @Override
    public BigDecimal convertVolume(CubicFoot cubicFeet) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.1336805556);
    }

    @Override
    public BigDecimal convertVolume(CubicMeters cubicMeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.003785411784);
    }

    @Override
    public BigDecimal convertVolume(CubicMillimeters cubicMillimeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 3785411.784
        );
    }

    @Override
    public BigDecimal convertVolume(Cups cups) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 16);
    }

    @Override
    public BigDecimal convertVolume(FluidOunces fluidOunces) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 128);
    }

    @Override
    public BigDecimal convertVolume(Gallons gallons) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

}
