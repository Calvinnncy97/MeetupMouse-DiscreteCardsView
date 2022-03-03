package com.example.meetupmouse;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.yarolegovich.discretescrollview.sample.R;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yarolegovich on 07.03.2017.
 */

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.ViewHolder> {

    private List<Venue> data;
    private int currentPosition;
    private ArrayList<Venue> selectedList = new ArrayList<Venue>();

    public VenueAdapter(List<Venue> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_venue_card, parent, false);
        v.findViewById(R.id.selectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedList.add(data.get(currentPosition));
                for (Venue item:selectedList) {
                    Log.e("Selected list: ", item.getName() + ", ");
                }
            }
        });
        return new ViewHolder(v);
    }

//                (new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                selectedList.add(data.get(currentPosition));
//                for (Venue item:selectedList) {
//                    Log.e("Selected list: " ,item.getName()+", ");
//                }
//            }
//        });


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(data.get(position).getImage())
                .into(holder.image);
        holder.rating.setText(Double.toString(data.get(position).getRating()));
        holder.distance.setText(Double.toString(data.get(position).getDistance()));
        holder.cuisine.setText(data.get(position).getCuisine());
        holder.place.setText(data.get(position).getPlace());
        holder.name.setText(data.get(position).getName());

        currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView rating;
        private TextView distance;
        private TextView cuisine;
        private TextView place;
        private TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            rating = itemView.findViewById(R.id.venueRating);
            distance = itemView.findViewById(R.id.venueDistance);
            cuisine = itemView.findViewById(R.id.venueCuisine);
            place = itemView.findViewById(R.id.venuePlace);
            name = itemView.findViewById(R.id.venueName);
        }
    }
}
