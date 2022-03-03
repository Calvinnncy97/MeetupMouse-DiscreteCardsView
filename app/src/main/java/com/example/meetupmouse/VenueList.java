package com.example.meetupmouse;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

//import com.yarolegovich.discretescrollview.sample.App;
//import com.yarolegovich.discretescrollview.sample.R;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class VenueList {

    public static VenueList get() {
        return new VenueList();
    }

    private SharedPreferences storage;

    private VenueList() {

    }

    public List<Venue> getData() {
        return Arrays.asList(
                new Venue(1, "Everyday Candle", 100, 100, 4.5, "Western", "SUTD", R.drawable.venue1),
                new Venue(2, "Small Porcelain Bowl", 100, 100, 3.0, "Asian", "CCP", R.drawable.venue2),
                new Venue(3, "Favourite Board", 100, 100, 3.0, "Asian", "CCP", R.drawable.venue3),
                new Venue(4, "Earthenware Bowl", 100, 100, 4.5, "Western", "SUTD", R.drawable.venue4),
                new Venue(5, "Porcelain Dessert Plate", 100, 100, 3.0, "Asian", "CCP", R.drawable.venue5),
                new Venue(6, "Detailed Rolling Pin", 100, 100, 4.5, "Western", "SUTD", R.drawable.venue6));

        //Update this list according to CRUD
    }

    public boolean isRated(int itemId) {
        return storage.getBoolean(String.valueOf(itemId), false);
    }
}

