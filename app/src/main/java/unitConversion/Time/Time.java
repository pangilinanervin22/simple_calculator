package unitConversion.Time;

import java.math.BigDecimal;

public interface Time {

    BigDecimal convertTime(Milliseconds milliseconds);

    BigDecimal convertTime(Seconds seconds);

    BigDecimal convertTime(Minutes minutes);

    BigDecimal convertTime(Hours hours);

    BigDecimal convertTime(Days days);

    BigDecimal convertTime(Weeks weeks);

    BigDecimal convertTime(Months months);

    BigDecimal convertTime(Years years);

}
