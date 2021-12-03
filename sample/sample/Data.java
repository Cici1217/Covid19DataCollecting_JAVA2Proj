package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Data {
    private SimpleStringProperty CountryName =new SimpleStringProperty();
    private SimpleIntegerProperty TotalCases=new SimpleIntegerProperty();
    private SimpleIntegerProperty NewlyCases=new SimpleIntegerProperty();
    private SimpleIntegerProperty TotalDeath=new SimpleIntegerProperty();
    private SimpleIntegerProperty NewlyDeath=new SimpleIntegerProperty();
    private static ArrayList<Data> data;


    public static ArrayList<Data> getData() {
        return data;
    }
    public static void setData(ArrayList<Data> data) {
        Data.data = data;
    }


    public Data(String CountryName,Integer TotalCases,Integer NewlyCases,
                Integer TotalDeath,Integer NewlyDeath){
        this.CountryName.set(CountryName);
        this.TotalCases.set(TotalCases);
        this.NewlyCases.set(NewlyCases);
        this.TotalDeath.set(TotalDeath);
        this.NewlyDeath.set(NewlyDeath);
    }
    public int getParameter(int i){
        switch (i){
            case 0:return this.getTotalCases();
            case 1:return this.getNewlyCases();
            case 2:return this.getTotalDeath();
            case 3:return this.getNewlyDeath();
            default:return -1;

        }
    }
    public static String getName(int i){
        switch (i){
            case 0:return "TotalCases";
            case 1:return "NewlyCases";
            case 2:return "TotalDeath";
            case 3:return "NewlyDeath";
            default:return "";

        }
    }

    public String getCountryName() {
        return CountryName.get();
    }

    public SimpleStringProperty countryNameProperty() {
        return CountryName;
    }

    public void setCountryName(String countryName) {
        this.CountryName.set(countryName);
    }

    public int getTotalCases() {
        return TotalCases.get();
    }

    public SimpleIntegerProperty totalCasesProperty() {
        return TotalCases;
    }

    public void setTotalCases(int totalCases) {
        this.TotalCases.set(totalCases);
    }

    public int getNewlyCases() {
        return NewlyCases.get();
    }

    public SimpleIntegerProperty newlyCasesProperty() {
        return NewlyCases;
    }

    public void setNewlyCases(int newlyCases) {
        this.NewlyCases.set(newlyCases);
    }

    public int getTotalDeath() {
        return TotalDeath.get();
    }

    public SimpleIntegerProperty totalDeathProperty() {
        return TotalDeath;
    }

    public void setTotalDeath(int totalDeath) {
        this.TotalDeath.set(totalDeath);
    }

    public int getNewlyDeath() {
        return NewlyDeath.get();
    }

    public SimpleIntegerProperty newlyDeathProperty() {
        return NewlyDeath;
    }

    public void setNewlyDeath(int newlyDeath) {
        this.NewlyDeath.set(newlyDeath);
    }




}