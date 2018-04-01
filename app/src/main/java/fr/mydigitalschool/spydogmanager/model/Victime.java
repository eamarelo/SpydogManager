package fr.mydigitalschool.spydogmanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jp789 on 01/04/2018.
 */

public class Victime implements Serializable {
    int id;
    String latitude;
    String longitude;
    String identification;
    String date;
    List<Position> position = new ArrayList<>(  );
    public Victime(int id, String identification, String latitude, String longitude , String date){
        this.id = id;
        this.identification = identification;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
        Position pos = new Position(this.date,  this.longitude, this.latitude);
        setPostion( pos );
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setPostion(Position pos){
        this.position.add(pos);
    }

    public List<Position> getPostion() {
        return position;
    }

    public String getIdentification() {
        return identification;
    }

    public int getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}

