package houduan.getDatasetFileFromFirstUrl.One;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class OneData {
    private SimpleStringProperty Date_reported = new SimpleStringProperty();
    private SimpleStringProperty Country_code = new SimpleStringProperty();
    private SimpleStringProperty Country = new SimpleStringProperty();
    private SimpleStringProperty WHO_region = new SimpleStringProperty();
    private SimpleIntegerProperty Cumulative_cases = new SimpleIntegerProperty();
    private SimpleIntegerProperty New_cases = new SimpleIntegerProperty();
    private SimpleIntegerProperty Cumulative_deaths = new SimpleIntegerProperty();
    private SimpleIntegerProperty New_deaths = new SimpleIntegerProperty();
    private static ArrayList<OneData> data;


    public static ArrayList<OneData> getData() {
        return data;
    }

    public static void setData(ArrayList<OneData> data) {
        OneData.data = data;
    }

    public OneData(String Date_reported, String Country_code, String Country, String WHO_region, String Cumulative_cases, String New_cases,
                String Cumulative_deaths, String New_deaths) {
        this.Date_reported.set(Date_reported);
        this.Country_code.set(Country_code);
        this.Country.set(Country.substring(0,4));
        this.WHO_region.set(WHO_region);
        this.Cumulative_cases.set(Integer.parseInt(Cumulative_cases));
        this.New_cases.set(Integer.parseInt(New_cases));
        this.Cumulative_deaths.set(Integer.parseInt(Cumulative_deaths));
        this.New_deaths.set(Integer.parseInt(New_deaths));
    }

    public int getParameter(int i) {
        switch (i) {
            case 0:
                return this.getCumulative_cases();
            case 1:
                return this.getNew_cases();
            case 2:
                return this.getCumulative_deaths();
            case 3:
                return this.getNew_deaths();
            case 4:
                return Integer.parseInt(this.getCountry());
            default:
                return -1;

        }
    }

    public static String getName(int i) {
        switch (i) {
            case 0:
                return "TotalCases";
            case 1:
                return "NewlyCases";
            case 2:
                return "TotalDeath";
            case 3:
                return "NewlyDeath";
            case 4:
                return "Date";
            default:
                return "";

        }
    }

    public String getCountry() {
        return Country.get();
    }

    public SimpleStringProperty countryProperty() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country.set(country);
    }

    public int getCumulative_cases() {
        return Cumulative_cases.get();
    }

    public SimpleIntegerProperty cumulative_casesProperty() {
        return Cumulative_cases;
    }

    public void setCumulative_cases(int cumulative_cases) {
        this.Cumulative_cases.set(cumulative_cases);
    }

    public int getNew_cases() {
        return New_cases.get();
    }

    public SimpleIntegerProperty new_casesProperty() {
        return New_cases;
    }

    public void setNew_cases(int new_cases) {
        this.New_cases.set(new_cases);
    }

    public int getCumulative_deaths() {
        return Cumulative_deaths.get();
    }

    public SimpleIntegerProperty cumulative_deathsProperty() {
        return Cumulative_deaths;
    }

    public void setCumulative_deaths(int cumulative_deaths) {
        this.Cumulative_deaths.set(cumulative_deaths);
    }

    public int getNew_deaths() {
        return New_deaths.get();
    }

    public SimpleIntegerProperty new_deathsProperty() {
        return New_deaths;
    }

    public void setNew_deaths(int new_deaths) {
        this.New_deaths.set(new_deaths);
    }


}