package houduan.getDatasetFileFromFirstUrl.Two;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class TwoData {
    private SimpleStringProperty Name = new SimpleStringProperty();
    private SimpleStringProperty WHO_region = new SimpleStringProperty();
    //5 data about cases
    private SimpleIntegerProperty cumulativeCases = new SimpleIntegerProperty();
    private SimpleDoubleProperty cumulativeCasesPer100000 = new SimpleDoubleProperty();
    private SimpleIntegerProperty newlyReportedCasesIn7Days = new SimpleIntegerProperty();
    private SimpleDoubleProperty newlyReportedCasesIn7DaysPer100000 = new SimpleDoubleProperty();
    private SimpleIntegerProperty newlyReportedCasesIn24Hours = new SimpleIntegerProperty();
    //5 data about death
    private SimpleIntegerProperty cumulativeDeaths = new SimpleIntegerProperty();
    private SimpleDoubleProperty cumulativeDeathsPer100000 = new SimpleDoubleProperty();
    private SimpleIntegerProperty newlyReportedDeathsIn7Days = new SimpleIntegerProperty();
    private SimpleDoubleProperty newlyReportedDeathsIn7DaysPer100000 = new SimpleDoubleProperty();
    private SimpleIntegerProperty newlyReportedDeathsIn24Hours = new SimpleIntegerProperty();
    private static ArrayList<TwoData> data;

    public static ArrayList<TwoData> getData() {
        return data;
    }

    public static void setData(ArrayList<TwoData> data) {
        TwoData.data = data;
    }

    public TwoData(String Name,
                   String WHO_region,
                   String cumulativeCases,
                   String cumulativeCasesPer100000,
                   String newlyReportedCasesIn7Days,
                   String newlyReportedCasesIn7DaysPer100000,
                   String newlyReportedCasesIn24Hours,
                   String cumulativeDeaths,
                   String cumulativeDeathsPer100000,
                   String newlyReportedDeathsIn7Days,
                   String newlyReportedDeathsIn7DaysPer100000,
                   String newlyReportedDeathsIn24Hours) {
        this.Name.set(Name);
        this.WHO_region.set(WHO_region);
        this.cumulativeCases.set(Integer.parseInt(cumulativeCases));
        this.cumulativeCasesPer100000.set(Double.parseDouble(cumulativeCases));
        this.newlyReportedCasesIn7Days.set(Integer.parseInt(newlyReportedCasesIn7Days));
        this.newlyReportedCasesIn7DaysPer100000.set(Double.parseDouble(newlyReportedCasesIn7DaysPer100000));
        this.newlyReportedCasesIn24Hours.set(Integer.parseInt(newlyReportedCasesIn24Hours));
        this.cumulativeDeaths.set(Integer.parseInt(cumulativeDeaths));
        this.cumulativeDeathsPer100000.set(Double.parseDouble(cumulativeDeathsPer100000));
        this.newlyReportedDeathsIn7Days.set(Integer.parseInt(newlyReportedDeathsIn7Days));
        this.newlyReportedDeathsIn7DaysPer100000.set(Double.parseDouble(newlyReportedDeathsIn7DaysPer100000));
        this.newlyReportedDeathsIn24Hours.set(Integer.parseInt(newlyReportedDeathsIn24Hours));
    }

    public int getParameter(int i) {
        switch (i) {
            case 0:
                return this.getCumulativeCases();
            case 1:
                return (int) this.getCumulativeCasesPer100000();
            case 2:
                return this.getNewlyReportedCasesIn7Days();
            case 3:
                return this.getNewlyReportedCasesIn24Hours();
            case 4:
                return (int) this.getNewlyReportedCasesIn7DaysPer100000();
            case 5:
                return this.getCumulativeDeaths();
            case 6:
                return (int) this.getCumulativeDeathsPer100000();
            case 7:
                return this.getNewlyReportedDeathsIn7Days();
            case 8:
                return this.getNewlyReportedDeathsIn24Hours();
            case 9:
                return (int) this.getNewlyReportedDeathsIn7DaysPer100000();
            default:
                return -1;

        }
    }

    public static String getName(int i) {
        switch (i) {
            case 0:
                return "CumulativeCases";
            case 1:
                return "CumulativeCasesPer100000";
            case 2:
                return "NewlyReportedCasesIn7Days";
            case 3:
                return "NewlyReportedCasesIn24Hours";
            case 4:
                return "NewlyReportedCasesIn7DaysPer100000";
            case 5:
                return "CumulativeDeaths";
            case 6:
                return "CumulativeDeathsPer100000";
            case 7:
                return "NewlyReportedDeathsIn7Days";
            case 8:
                return "NewlyReportedDeathsIn24Hours";
            case 9:
                return "NewlyReportedDeathsIn7DaysPer100000";
            default:
                return "";

        }
    }

    public String getName() {
        return Name.get();
    }

    public SimpleStringProperty nameProperty() {
        return Name;
    }

    public String getWHO_region() {
        return WHO_region.get();
    }

    public SimpleStringProperty WHO_regionProperty() {
        return WHO_region;
    }

    public int getCumulativeCases() {
        return cumulativeCases.get();
    }

    public SimpleIntegerProperty cumulativeCasesProperty() {
        return cumulativeCases;
    }

    public double getCumulativeCasesPer100000() {
        return cumulativeCasesPer100000.get();
    }

    public SimpleDoubleProperty cumulativeCasesPer100000Property() {
        return cumulativeCasesPer100000;
    }

    public int getNewlyReportedCasesIn7Days() {
        return newlyReportedCasesIn7Days.get();
    }

    public SimpleIntegerProperty newlyReportedCasesIn7DaysProperty() {
        return newlyReportedCasesIn7Days;
    }

    public double getNewlyReportedCasesIn7DaysPer100000() {
        return newlyReportedCasesIn7DaysPer100000.get();
    }

    public SimpleDoubleProperty newlyReportedCasesIn7DaysPer100000Property() {
        return newlyReportedCasesIn7DaysPer100000;
    }

    public int getNewlyReportedCasesIn24Hours() {
        return newlyReportedCasesIn24Hours.get();
    }

    public SimpleIntegerProperty newlyReportedCasesIn24HoursProperty() {
        return newlyReportedCasesIn24Hours;
    }

    public int getCumulativeDeaths() {
        return cumulativeDeaths.get();
    }

    public SimpleIntegerProperty cumulativeDeathsProperty() {
        return cumulativeDeaths;
    }

    public double getCumulativeDeathsPer100000() {
        return cumulativeDeathsPer100000.get();
    }

    public SimpleDoubleProperty cumulativeDeathsPer100000Property() {
        return cumulativeDeathsPer100000;
    }

    public int getNewlyReportedDeathsIn7Days() {
        return newlyReportedDeathsIn7Days.get();
    }

    public SimpleIntegerProperty newlyReportedDeathsIn7DaysProperty() {
        return newlyReportedDeathsIn7Days;
    }

    public double getNewlyReportedDeathsIn7DaysPer100000() {
        return newlyReportedDeathsIn7DaysPer100000.get();
    }

    public SimpleDoubleProperty newlyReportedDeathsIn7DaysPer100000Property() {
        return newlyReportedDeathsIn7DaysPer100000;
    }

    public int getNewlyReportedDeathsIn24Hours() {
        return newlyReportedDeathsIn24Hours.get();
    }

    public SimpleIntegerProperty newlyReportedDeathsIn24HoursProperty() {
        return newlyReportedDeathsIn24Hours;
    }
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public void setWHO_region(String WHO_region) {
//        this.WHO_region = WHO_region;
//    }
//
//    public void setCumulativeCases(String cumulativeCases) {
//        this.cumulativeCases = Integer.parseInt(cumulativeCases);
//    }
//
//    public void setCumulativeCasesPer100000(String cumulativeCasesPer100000) {
//         this.cumulativeCasesPer100000 = Double.parseDouble(cumulativeCasesPer100000);
//    }
//
//    public void setNewlyReportedCasesIn7Days(String newlyReportedCasesIn7Days) {
//        this.newlyReportedCasesIn7Days = Integer.parseInt(newlyReportedCasesIn7Days);
//    }
//
//    public void setNewlyReportedCasesIn7DaysPer100000(String newlyReportedCasesIn7DaysPer100000) {
//        this.newlyReportedCasesIn7DaysPer100000 = Double.parseDouble(newlyReportedCasesIn7DaysPer100000);
//    }
//
//    public void setNewlyReportedCasesIn24Hours(String newlyReportedCasesIn24Hours) {
//        this.newlyReportedCasesIn24Hours = Integer.parseInt(newlyReportedCasesIn24Hours);
//    }
//
//    public void setCumulativeDeaths(String cumulativeDeaths) {
//        this.cumulativeDeaths = Integer.parseInt(cumulativeDeaths);
//    }
//
//    public void setCumulativeDeathsPer100000(String cumulativeDeathsPer100000) {
//        this.cumulativeDeathsPer100000 = Double.parseDouble(cumulativeDeathsPer100000);
//    }
//
//    public void setNewlyReportedDeathsIn7Days(String newlyReportedDeathsIn7Days) {
//        this.newlyReportedDeathsIn7Days = Integer.parseInt(newlyReportedDeathsIn7Days);
//    }
//
//    public void setNewlyReportedDeathsIn7DaysPer100000(String newlyReportedDeathsIn7DaysPer100000) {
//        this.newlyReportedDeathsIn7DaysPer100000 = Double.parseDouble(newlyReportedDeathsIn7DaysPer100000);
//    }
//
//    public void setNewlyReportedDeathsIn24Hours(String newlyReportedDeathsIn24Hours) {
//        this.newlyReportedDeathsIn24Hours = Integer.parseInt(newlyReportedDeathsIn24Hours);
//    }
}
