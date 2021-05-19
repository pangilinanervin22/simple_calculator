package unitConversion.Area;

import java.math.BigDecimal;

public interface Area {

    BigDecimal convertArea(Acres acres);

    BigDecimal convertArea(Hectares hectares);

    BigDecimal convertArea(SquareFeet squareFeet);

    BigDecimal convertArea(SquareKiloMeters squareKiloMeters);

    BigDecimal convertArea(SquareMeters squareMeters);

    BigDecimal convertArea(SquareMiles squareMiles);

    BigDecimal convertArea(SquareYards squareYards);

}
