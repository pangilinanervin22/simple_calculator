package unitConversion.Temperature;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Celsius extends Unit implements Temperature {

    @Override
    public String toString() {
        return "Celsius (°C)";
    }

    public Celsius() {
        setUnitSymbol("°C");
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

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertTemp(Fahrenheit fahrenheit) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf((Double.parseDouble(getValue()) * 1.8) + 32.00);
    }

    @Override
    public BigDecimal convertTemp(Kelvin kelvin) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf((Double.parseDouble(getValue())) + 273.15);
    }

}
