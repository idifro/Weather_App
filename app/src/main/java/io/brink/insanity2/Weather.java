package io.brink.insanity2;

public class Weather {

    private String mainWeather;
    private String descWeather;
    private Double temp;
    private Double minTemp;
    private Double maxTemp;
    private String city;

    public Weather(String mainWeather, String descWeather, Double temp, Double minTemp, Double maxTemp, String city) {
        this.mainWeather = mainWeather;
        this.descWeather = descWeather;
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.city = city;
    }

    public String getMainWeather() {
        return mainWeather;
    }

    public void setMainWeather(String mainWeather) {
        this.mainWeather = mainWeather;
    }

    public String getDescWeather() {
        return descWeather;
    }

    public void setDescWeather(String descWeather) {
        this.descWeather = descWeather;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
