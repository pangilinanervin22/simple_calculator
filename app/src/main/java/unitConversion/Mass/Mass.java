package unitConversion.Mass;

import java.math.BigDecimal;

public interface Mass {

    BigDecimal convertMass(Miligrams miligrams);

    BigDecimal convertMass(Grams grams);

    BigDecimal convertMass(Kilograms kilograms);

    BigDecimal convertMass(Tons tons);

    BigDecimal convertMass(MetricTons metricTons);

    BigDecimal convertMass(Ounces ounces);

    BigDecimal convertMass(Pounds pounds);

    BigDecimal convertMass(Stones stones);
}
