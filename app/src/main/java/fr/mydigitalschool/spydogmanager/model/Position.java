package fr.mydigitalschool.spydogmanager.model;

import java.io.Serializable;

/**
 * Created by jp789 on 01/04/2018.
 */

public class Position implements Serializable {
    String latitude,longitude, date;
    public Position (String date, String latitude,String longitude){
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getDate() {
        return date;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }
}
