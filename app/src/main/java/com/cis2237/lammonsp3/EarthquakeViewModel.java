package com.cis2237.lammonsp3;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class EarthquakeViewModel extends AndroidViewModel {

    private static final String TAG = "EarthquakeUpdate";

    final static String EARTHQUAKES_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/2.5_day.atom";

    Handler eqHandler;

    MutableLiveData<List<Earthquake>> quakes;

    public EarthquakeViewModel(@NonNull Application application) {
        super(application);
        eqHandler = new Handler(Looper.getMainLooper());
    }

    public LiveData<List<Earthquake>> getEarthquakes() {
        if (quakes == null) {
            quakes = new MutableLiveData<List<Earthquake>>();
        }
        loadEarthquakes();
        return quakes;
    };

    public void loadEarthquakes() {
        Thread thread = new Thread();

    }
}
