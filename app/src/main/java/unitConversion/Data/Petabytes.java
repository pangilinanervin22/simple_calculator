package unitConversion.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class Petabytes extends Unit implements Data {

    @Override
    public String toString() {
        return "Petabyte (pb)";
    }

    public Petabytes() {
        setUnitSymbol("pb");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Bytes)
            return getRoundOffNum(convertData((Bytes) unit));
        if (unit instanceof Kilobytes)
            return getRoundOffNum(convertData((Kilobytes) unit));
        if (unit instanceof Megabytes)
            return getRoundOffNum(convertData((Megabytes) unit));
        if (unit instanceof Gigabytes)
            return getRoundOffNum(convertData((Gigabytes) unit));
        if (unit instanceof Terabytes)
            return getRoundOffNum(convertData((Terabytes) unit));
        if (unit instanceof Petabytes)
            return getRoundOffNum(convertData((Petabytes) unit));

        return "";
    }

    @Override
    public BigDecimal convertData(Bytes bytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e+15);
    }

    @Override
    public BigDecimal convertData(Kilobytes kilobytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e+12);
    }

    @Override
    public BigDecimal convertData(Megabytes megabytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e+9);
    }

    @Override
    public BigDecimal convertData(Gigabytes gigabytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e+16);
    }

    @Override
    public BigDecimal convertData(Terabytes terabytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1e+3);
    }

    @Override
    public BigDecimal convertData(Petabytes petabytes) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

}
