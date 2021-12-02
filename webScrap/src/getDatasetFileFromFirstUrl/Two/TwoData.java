package getDatasetFileFromFirstUrl.Two;

public class TwoData {
    private String Name;
    private String WHO_region;
    //5 data about cases
    private int cumulativeCases;
    private double cumulativeCasesPer100000;
    private int newlyReportedCasesIn7Days;
    private double newlyReportedCasesIn7DaysPer100000;
    private int newlyReportedCasesIn24Hours;
    //5 data about death
    private int cumulativeDeaths;
    private double cumulativeDeathsPer100000;
    private int newlyReportedDeathsIn7Days;
    private double newlyReportedDeathsIn7DaysPer100000;
    private int newlyReportedDeathsIn24Hours;


    public void setName(String name) {
        Name = name;
    }

    public void setWHO_region(String WHO_region) {
        this.WHO_region = WHO_region;
    }

    public void setCumulativeCases(String cumulativeCases) {
        this.cumulativeCases = Integer.parseInt(cumulativeCases);
    }

    public void setCumulativeCasesPer100000(String cumulativeCasesPer100000) {
         this.cumulativeCasesPer100000 = Double.parseDouble(cumulativeCasesPer100000);
    }

    public void setNewlyReportedCasesIn7Days(String newlyReportedCasesIn7Days) {
        this.newlyReportedCasesIn7Days = Integer.parseInt(newlyReportedCasesIn7Days);
    }

    public void setNewlyReportedCasesIn7DaysPer100000(String newlyReportedCasesIn7DaysPer100000) {
        this.newlyReportedCasesIn7DaysPer100000 = Double.parseDouble(newlyReportedCasesIn7DaysPer100000);
    }

    public void setNewlyReportedCasesIn24Hours(String newlyReportedCasesIn24Hours) {
        this.newlyReportedCasesIn24Hours = Integer.parseInt(newlyReportedCasesIn24Hours);
    }

    public void setCumulativeDeaths(String cumulativeDeaths) {
        this.cumulativeDeaths = Integer.parseInt(cumulativeDeaths);
    }

    public void setCumulativeDeathsPer100000(String cumulativeDeathsPer100000) {
        this.cumulativeDeathsPer100000 = Double.parseDouble(cumulativeDeathsPer100000);
    }

    public void setNewlyReportedDeathsIn7Days(String newlyReportedDeathsIn7Days) {
        this.newlyReportedDeathsIn7Days = Integer.parseInt(newlyReportedDeathsIn7Days);
    }

    public void setNewlyReportedDeathsIn7DaysPer100000(String newlyReportedDeathsIn7DaysPer100000) {
        this.newlyReportedDeathsIn7DaysPer100000 = Double.parseDouble(newlyReportedDeathsIn7DaysPer100000);
    }

    public void setNewlyReportedDeathsIn24Hours(String newlyReportedDeathsIn24Hours) {
        this.newlyReportedDeathsIn24Hours = Integer.parseInt(newlyReportedDeathsIn24Hours);
    }
}
