package com.cis2237.lammonsp3;

import android.location.Location;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Earthquake {
    String id;
    Date date;
    String details;
    Location location;
    double magnitude;
    String link;

    //private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH.mm", Locale.US);
    public String getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    public Location getLocation() {
        return location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLink() {
        return link;
    }

    public Earthquake(String id, Date date, String details, Location location, double magnitude, String link) {
        this.id = id;
        this.date = date;
        this.details = details;
        this.location = location;
        this.magnitude = magnitude;
        this.link = link;
    }

    @Override
    public String toString() {
        return "Earthquake{" +
                "date=" + date +
                ", details='" + details + '\'' +
                ", magnitude=" + magnitude +
                '}';
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Earthquake) {
            Earthquake eq = (Earthquake) obj;
            return Objects.equals(id, eq.id);
        }
        else return false;
    }
}
