package com.example.meetupmouse;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class MainActivity extends AppCompatActivity implements DiscreteScrollView.OnItemChangedListener<VenueAdapter.ViewHolder>,
        View.OnClickListener {

    private List<Venue> data;
    private VenueList mVenueList;

    private TextView currentItemName;
    private TextView currentItemDistance;
    private TextView currentItemRating;
    private TextView currentItemCuisine;
    private TextView currentItemPlace;
    private ImageView rateItemButton;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;

    private ArrayList<Venue> selectedList = new ArrayList<Venue>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        currentItemName = findViewById(R.id.venueName);
//        currentItemDistance = findViewById(R.id.venueDistance);
//        currentItemRating = findViewById(R.id.venueRating);
//        currentItemCuisine = findViewById(R.id.venueCuisine);
//        currentItemPlace = findViewById(R.id.venuePlace);

        mVenueList = VenueList.get();
        data = mVenueList.getData();
        itemPicker = findViewById(R.id.picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new VenueAdapter(data));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(150);
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        onItemChanged(data.get(0));
        //findViewById(R.id.selectButton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
//        Venue current = data.get(realPosition);
//        selectedList.add(current);
        //CRUD code to update database
    }

    public ArrayList<Venue> getSelectedList () {
        return selectedList;
    }

    private void onItemChanged(Venue venue) {
//        currentItemName.setText(venue.getName());
//        currentItemDistance.setText("Distance: " + Double.toString(venue.getDistance()));
//        currentItemRating.setText("Rating " + Double.toString(venue.getRating()));
//        currentItemCuisine.setText("Cuisine: " + venue.getCuisine());
//        currentItemPlace.setText("Place: "+venue.getPlace());
    }


    @Override
    public void onCurrentItemChanged(@Nullable VenueAdapter.ViewHolder viewHolder, int adapterPosition) {
        int positionInDataSet = infiniteAdapter.getRealPosition(adapterPosition);
        onItemChanged(data.get(positionInDataSet));
    }
}
