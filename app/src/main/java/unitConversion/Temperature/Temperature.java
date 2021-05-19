package unitConversion.Temperature;

import java.math.BigDecimal;

public interface Temperature {

    BigDecimal convertTemp(Celsius celsius);

    BigDecimal convertTemp(Fahrenheit fahrenheit);

    BigDecimal convertTemp(Kelvin kelvin);
}
