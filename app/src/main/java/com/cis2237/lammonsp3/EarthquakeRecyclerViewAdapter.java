package com.cis2237.lammonsp3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cis2237.lammonsp3.databinding.ListItemEarthquakeBinding;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeRecyclerViewAdapter.ViewHolder> {

    private List<Earthquake> earthquakes;

    private static final DecimalFormat MAGNITUDE_FORMAT = new DecimalFormat("0.0");
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH.mm", Locale.US);


    public EarthquakeRecyclerViewAdapter(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    public EarthquakeRecyclerViewAdapter() {
    }

    @NonNull
    @Override
    public EarthquakeRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemEarthquakeBinding binding = ListItemEarthquakeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull EarthquakeRecyclerViewAdapter.ViewHolder holder, int position) {
        Earthquake earthquake = earthquakes.get(position);
        holder.binding.setTimeformat(TIME_FORMAT);
        holder.binding.setMagnitudeformat(MAGNITUDE_FORMAT);
        holder.binding.setEarthquake(earthquake);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return earthquakes == null? 0 : earthquakes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final ListItemEarthquakeBinding binding;

        public ViewHolder(ListItemEarthquakeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            //add formatting for time and magnitude
        }

        @NonNull
        @Override
        //returns super to string and earthquake to string
        public String toString() {
            return super.toString() + " " + binding.toString();
        }

    }
}
