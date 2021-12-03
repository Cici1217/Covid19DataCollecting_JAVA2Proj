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
                   int cumulativeCases,
                   double cumulativeCasesPer100000,
                   int newlyReportedCasesIn7Days,
                   double newlyReportedCasesIn7DaysPer100000,
                   int newlyReportedCasesIn24Hours,
                   int cumulativeDeaths,
                   double cumulativeDeathsPer100000,
                   int newlyReportedDeathsIn7Days,
                   double newlyReportedDeathsIn7DaysPer100000,
                   int newlyReportedDeathsIn24Hours) {
        this.Name.set(Name);
        this.WHO_region.set(WHO_region);
        this.cumulativeCases.set(cumulativeCases);
        this.cumulativeCasesPer100000.set(cumulativeCases);
        this.newlyReportedCasesIn7Days.set(newlyReportedCasesIn7Days);
        this.newlyReportedCasesIn7DaysPer100000.set(newlyReportedCasesIn7DaysPer100000);
        this.newlyReportedCasesIn24Hours.set(newlyReportedCasesIn24Hours);
        this.cumulativeDeaths.set(cumulativeDeaths);
        this.cumulativeDeathsPer100000.set(cumulativeDeathsPer100000);
        this.newlyReportedDeathsIn7Days.set(newlyReportedDeathsIn7Days);
        this.newlyReportedDeathsIn7DaysPer100000.set(newlyReportedDeathsIn7DaysPer100000);
        this.newlyReportedDeathsIn24Hours.set(newlyReportedDeathsIn24Hours);
    }
    //
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
