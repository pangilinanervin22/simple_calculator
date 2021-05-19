package unitConversion;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;

public abstract class Unit {

    public Unit() {
        setValue("");
    }

    private String value;
    private String unitSymbol;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }

    protected void setUnitSymbol(String unitSymbol) {
        this.unitSymbol = unitSymbol;
    }

    public String getRoundOffNum(BigDecimal number) {
        DecimalFormat df = new DecimalFormat("#.#########");
        if (number.remainder(new BigDecimal(BigInteger.ONE)).equals(new BigDecimal(BigInteger.ZERO)))
            return number.toBigInteger().toString();

        return df.format(number);
    }

    public boolean isEmptyAndNull() {
        return this.getValue() == null || this.getValue().equals("") || this.getValue().equals("-");
    }

    public abstract String convert(Unit unit);

}
