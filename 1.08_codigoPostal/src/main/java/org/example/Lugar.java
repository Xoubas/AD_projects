package org.example;

import java.util.Objects;

public class Lugar {
    private String placeName;
    private double longitude;
    private String state;
    private String stateAbb;
    private double latitude;


    public Lugar(String placeName, double longitude, String state, String stateAbb, double latitude) {
        this.placeName = placeName;
        this.longitude = longitude;
        this.state = state;
        this.stateAbb = stateAbb;
        this.latitude = latitude;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbb() {
        return stateAbb;
    }

    public void setStateAbb(String stateAbb) {
        this.stateAbb = stateAbb;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Lugar lugar = (Lugar) o;

        if (Double.doubleToLongBits(this.latitude) != Double.doubleToLongBits(lugar.latitude))
            return false;

        return Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(lugar.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "placeName='" + placeName + '\'' +
                ", longitude=" + longitude +
                ", state='" + state + '\'' +
                ", stateAbb='" + stateAbb + '\'' +
                ", latitude=" + latitude +
                '}';
    }
}
