package unitConversion.Area;

import java.math.BigDecimal;
import java.math.BigInteger;

import unitConversion.Unit;

public class SquareMeters extends Unit implements Area {
    @Override
    public String toString() {
        return "SquareMeter (m²)";
    }

    public SquareMeters() {setUnitSymbol("m²");
    }

    @Override
    public String convert(Unit unit) {
        if (unit instanceof Acres)
            return getRoundOffNum(convertArea((Acres) unit));
        else if (unit instanceof Hectares)
            return getRoundOffNum(convertArea((Hectares) unit));
        else if (unit instanceof SquareFeet)
            return getRoundOffNum(convertArea((SquareFeet) unit));
        else if (unit instanceof SquareMeters)
            return getRoundOffNum(convertArea((SquareMeters) unit));
        else if (unit instanceof SquareKiloMeters)
            return getRoundOffNum(convertArea((SquareKiloMeters) unit));
        else if (unit instanceof SquareMiles)
            return getRoundOffNum(convertArea((SquareMiles) unit));
        else if (unit instanceof SquareYards)
            return getRoundOffNum(convertArea((SquareYards) unit));

        return "";
    }

    @Override
    public BigDecimal convertArea(Acres acres) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0002471053815);
    }

    @Override
    public BigDecimal convertArea(Hectares hectares) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.0001);
    }

    @Override
    public BigDecimal convertArea(SquareFeet squareFeet) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 10.76391042);
    }

    @Override
    public BigDecimal convertArea(SquareKiloMeters squareKiloMeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 0.000001);
    }

    @Override
    public BigDecimal convertArea(SquareMeters squareMeters) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()));
    }

    @Override
    public BigDecimal convertArea(SquareMiles squareMiles) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 	3.861021585e-7);
    }

    @Override
    public BigDecimal convertArea(SquareYards squareYards) {
        if (isEmptyAndNull())
            return new BigDecimal(BigInteger.ZERO);

        return BigDecimal.valueOf(Double.parseDouble(getValue()) * 1.195990046);
    }
}
