package unitConversion.Length;

import java.math.BigDecimal;

public interface Length {

    BigDecimal convertLength(Millimeters millimeters);

    BigDecimal convertLength(Centimeters centimeters);

    BigDecimal convertLength(Meters meters);

    BigDecimal convertLength(Kilometers kilometers);

    BigDecimal convertLength(Yards yards);

    BigDecimal convertLength(Foot foot);

    BigDecimal convertLength(Inches inches);

    BigDecimal convertLength(Miles miles);

    BigDecimal convertLength(NauticalMiles nauticalMiles);

}
