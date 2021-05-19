package unitConversion.Time;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Weeks extends Unit implements Time {

    @Override
    public String toString() {
        return "Weeks (wk)";
    }

    public Weeks() {
        setUnitSymbol("wk");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Milliseconds)
            return getRoundOffNum(convertTime((Milliseconds) unit));
        if (unit instanceof Seconds)
            return getRoundOffNum(convertTime((Seconds) unit));
        if (unit instanceof Minutes)
            return getRoundOffNum(convertTime((Minutes) unit));
        if (unit instanceof Hours)
            return getRoundOffNum(convertTime((Hours) unit));
        if (unit instanceof Days)
            return getRoundOffNum(convertTime((Days) unit));
        if (unit instanceof Weeks)
            return getRoundOffNum(convertTime((Weeks) unit));
        if (unit instanceof Months)
            return getRoundOffNum(convertTime((Months) unit));
        if (unit instanceof Years)
            return getRoundOffNum(convertTime((Years) unit));

        return "";
    }

    @Override
    public BigDecimal convertTime(Milliseconds milliseconds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 6.048e+8);
    }

    @Override
    public BigDecimal convertTime(Seconds seconds) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 604800);
    }

    @Override
    public BigDecimal convertTime(Minutes minutes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 10080);
    }

    @Override
    public BigDecimal convertTime(Hours hours) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 168);
    }

    @Override
    public BigDecimal convertTime(Days days) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 7);
    }

    @Override
    public BigDecimal convertTime(Weeks weeks) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertTime(Months months) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.230137);
    }

    @Override
    public BigDecimal convertTime(Years years) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0191781);
    }

}
