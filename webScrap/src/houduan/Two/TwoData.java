package houduan.Two;

public class TwoData {
    String cityName;
    int newlyCase;
    int totalCase;
    int totalDeath;
    int totalCured;

    public TwoData(String cityName, int newlyCase, int totalCase, int totalDeath, int totalCured) {
        this.cityName = cityName;
        this.newlyCase = newlyCase;
        this.totalCase = totalCase;
        this.totalDeath = totalDeath;
        this.totalCured = totalCured;
    }

    public String getCityName() {
        return cityName;
    }

    public int getNewlyCase() {
        return newlyCase;
    }

    public int getTotalCase() {
        return totalCase;
    }

    public int getTotalDeath() {
        return totalDeath;
    }

    public int getTotalCured() {
        return totalCured;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setNewlyCase(int newlyCase) {
        this.newlyCase = newlyCase;
    }

    public void setTotalCase(int totalCase) {
        this.totalCase = totalCase;
    }

    public void setTotalDeath(int totalDeath) {
        this.totalDeath = totalDeath;
    }

    public void setTotalCured(int totalCured) {
        this.totalCured = totalCured;
    }
}
