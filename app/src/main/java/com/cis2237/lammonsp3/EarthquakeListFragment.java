package com.cis2237.lammonsp3;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;


public class EarthquakeListFragment extends Fragment {

    List<Earthquake> earthquakes;
    RecyclerView recyclerView;
    EarthquakeRecyclerViewAdapter adapter;

    public EarthquakeListFragment() {
        // Required empty public constructor
        earthquakes = new ArrayList<Earthquake>();
    }

    public EarthquakeListFragment(List<Earthquake> newEarthquakes) {
        earthquakes = newEarthquakes;

    }

    public static EarthquakeListFragment newInstance(String param1, String param2) {
        return new EarthquakeListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_earthquake_list, container, false);
        recyclerView = view.findViewById(R.id.list);
        return view;

        //return inflater.inflate(R.layout.fragment_earthquake_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Context context = view.getContext();
        adapter = new EarthquakeRecyclerViewAdapter(earthquakes);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(adapter);

        Date now = Calendar.getInstance().getTime();
        List<Earthquake> dummyQuakes = new ArrayList<>(2);
        dummyQuakes.add(new Earthquake("0", now, "San Jose", null, 7.3, null));
        dummyQuakes.add(new Earthquake("1", now, "LA", null, 6.5, null));
        this.setEarthquakes(dummyQuakes);

        adapter.notifyDataSetChanged();
    }
    public void setEarthquakes(List<Earthquake> newEarthquakes) {
        for (Earthquake earthquake : newEarthquakes) {
            if (!earthquakes.contains(earthquake)) {
                earthquakes.add(earthquake);
                adapter.notifyItemInserted(earthquakes.indexOf(earthquake));
            }
        }
    }
}