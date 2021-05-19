package unitConversion.Volume;

import java.math.BigDecimal;

public interface Volume {

    BigDecimal convertVolume(Milliliters milliliters);

    BigDecimal convertVolume(Liters liters);

    BigDecimal convertVolume(CubicFoot cubicFeet);

    BigDecimal convertVolume(CubicMeters cubicMeters);

    BigDecimal convertVolume(CubicMillimeters cubicMillimeters);

    BigDecimal convertVolume(Cups cups);

    BigDecimal convertVolume(FluidOunces fluidOunces);

    BigDecimal convertVolume(Gallons gallons);

}
