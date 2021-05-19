package unitConversion.Temperature;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Fahrenheit extends Unit implements Temperature {

    @Override
    public String toString() {
        return "Fahrenheit (°F)";
    }

    public Fahrenheit() {
        setUnitSymbol("°F");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Fahrenheit)
            return getRoundOffNum(convertTemp((Fahrenheit) unit));
        if (unit instanceof Kelvin)
            return getRoundOffNum(convertTemp((Kelvin)unit));

        return getRoundOffNum(convertTemp((Celsius) unit));
    }

    @Override
    public BigDecimal convertTemp(Celsius celsius) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf((Double.parseDouble(getValue()) - 32.0) * 0.55555);
    }

    @Override
    public BigDecimal convertTemp(Fahrenheit fahrenheit) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertTemp(Kelvin kelvin) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf((Double.parseDouble(getValue()) - 32) * 0.55555555555 + 273.15);
    }
}
