package unitConversion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import unitConversion.Area.Acres;
import unitConversion.Area.Hectares;
import unitConversion.Area.SquareFeet;
import unitConversion.Area.SquareKiloMeters;
import unitConversion.Area.SquareMeters;
import unitConversion.Area.SquareMiles;
import unitConversion.Area.SquareYards;
import unitConversion.Data.Bytes;
import unitConversion.Data.Gigabytes;
import unitConversion.Data.Kilobytes;
import unitConversion.Data.Megabytes;
import unitConversion.Data.Petabytes;
import unitConversion.Data.Terabytes;
import unitConversion.Length.Centimeters;
import unitConversion.Length.Foot;
import unitConversion.Length.Inches;
import unitConversion.Length.Kilometers;
import unitConversion.Length.Meters;
import unitConversion.Length.Miles;
import unitConversion.Length.Millimeters;
import unitConversion.Length.NauticalMiles;
import unitConversion.Length.Yards;
import unitConversion.Mass.Grams;
import unitConversion.Mass.Kilograms;
import unitConversion.Mass.MetricTons;
import unitConversion.Mass.Miligrams;
import unitConversion.Mass.Ounces;
import unitConversion.Mass.Pounds;
import unitConversion.Mass.Stones;
import unitConversion.Mass.Tons;
import unitConversion.Speed.FeetPerHour;
import unitConversion.Speed.FeetPerSecond;
import unitConversion.Speed.KiloMetersPerHour;
import unitConversion.Speed.KiloMetersPerSeconds;
import unitConversion.Speed.Knots;
import unitConversion.Speed.MetersPerHour;
import unitConversion.Speed.MetersPerSecond;
import unitConversion.Speed.MilesPerHour;
import unitConversion.Speed.MilesPerSecond;
import unitConversion.Temperature.Celsius;
import unitConversion.Temperature.Fahrenheit;
import unitConversion.Temperature.Kelvin;
import unitConversion.Time.Days;
import unitConversion.Time.Hours;
import unitConversion.Time.Milliseconds;
import unitConversion.Time.Minutes;
import unitConversion.Time.Months;
import unitConversion.Time.Seconds;
import unitConversion.Time.Weeks;
import unitConversion.Time.Years;
import unitConversion.Volume.CubicFoot;
import unitConversion.Volume.CubicMeters;
import unitConversion.Volume.CubicMillimeters;
import unitConversion.Volume.Cups;
import unitConversion.Volume.FluidOunces;
import unitConversion.Volume.Gallons;
import unitConversion.Volume.Liters;
import unitConversion.Volume.Milliliters;

public class UnitConversion {

    private static List<Unit> unitList = new ArrayList<>();

    public static void setUnitList(ArrayList<Unit> unitList) {
        UnitConversion.unitList = unitList;
    }

    public static List<Unit> getUnitList() {
        return unitList;
    }

    public static String[] getUnitArray() {
        String[] unitString = new String[unitList.size()];
        int index = 0;
        for (Unit unit: unitList) {
            unitString[index++] = unit.toString();
        }
        return unitString;
    }

    // set unit list
    public static void setTemperatureList() {
        unitList = Arrays.asList(new Celsius() , new Fahrenheit(), new Kelvin());
    }

    public static void setLengthList() {
        unitList = Arrays.asList(new Millimeters() , new Centimeters(), new Meters(), new Kilometers(),
                new Inches(), new Foot(), new Yards(), new Miles(), new NauticalMiles());
    }

    public static void setAreaList() {
        unitList = Arrays.asList(new Acres(), new Hectares(), new SquareMeters(),new SquareKiloMeters(), new SquareFeet(),
                 new SquareMiles(), new SquareYards());
    }

    public static void setMassList() {
        unitList = Arrays.asList(new Miligrams(), new Grams(), new Kilograms(), new Pounds(), new MetricTons(),
                new Tons(), new Stones(), new Ounces());
    }

    public static void setSpeedList() {
        unitList = Arrays.asList(new MetersPerSecond(), new MetersPerHour(), new KiloMetersPerSeconds(), new KiloMetersPerHour(),
                new Knots(), new MilesPerSecond(), new MilesPerHour(), new FeetPerSecond(), new FeetPerHour());
    }

    public static void setTimeList() {
        unitList = Arrays.asList(new Milliseconds(), new Seconds(), new Minutes(), new Hours(), new Days(), new Weeks(),
                new Months(), new Years());
    }

    public static void setVolumeList() {
        unitList = Arrays.asList(new Milliliters(), new Liters(), new Gallons(), new FluidOunces(), new Cups(), new CubicMillimeters(),
                new CubicFoot(), new CubicMeters());
    }

    public static void setDataList() {
        unitList = Arrays.asList(new Bytes(), new Kilobytes(), new Megabytes(), new Gigabytes(), new Terabytes(), new Petabytes());
    }

}
