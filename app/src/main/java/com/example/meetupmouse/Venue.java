package com.example.meetupmouse;

import android.util.Log;

public class Venue {

    private final int id;
    private final String name;
    private final double distance;
    private final double price;
    private final double rating;
    private final String cuisine;
    private final String place;
    private final int image;

    public Venue(int id, String name, double distance, double price, double rating, String cuisine, String place, int image) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.price = price;
        this.image = image;
        this.cuisine = cuisine;
        this.place = place;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public double getPrice() {
        Log.i("getPrice", "it's here");
        return price;
    }

    public String getCuisine () {
        return cuisine;
    }

    public String getPlace() {
        return place;
    }

    public double getRating () {
        return rating;
    }

    public int getImage () {
        return image;
    }
}

