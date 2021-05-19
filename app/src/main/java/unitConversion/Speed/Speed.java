package unitConversion.Speed;

import java.math.BigDecimal;

public interface Speed {

    BigDecimal convertSpeed(FeetPerHour feetPerHour);

    BigDecimal convertSpeed(FeetPerSecond feetPerSecond);

    BigDecimal convertSpeed(KiloMetersPerHour kiloMetersPerHour);

    BigDecimal convertSpeed(KiloMetersPerSeconds kiloMetersPerSeconds);

    BigDecimal convertSpeed(Knots knots);

    BigDecimal convertSpeed(MetersPerHour metersPerHour);

    BigDecimal convertSpeed(MetersPerSecond metersPerSecond);

    BigDecimal convertSpeed(MilesPerHour milesPerHour);

    BigDecimal convertSpeed(MilesPerSecond milesPerSecond);

}
