package unitConversion.Data;

import java.math.BigDecimal;

public interface Data {

    BigDecimal convertData(Bytes bytes);

    BigDecimal convertData(Kilobytes kilobytes);

    BigDecimal convertData(Megabytes megabytes);

    BigDecimal convertData(Gigabytes gigabytes);

    BigDecimal convertData(Terabytes terabytes);

    BigDecimal convertData(Petabytes petabytes);
}
