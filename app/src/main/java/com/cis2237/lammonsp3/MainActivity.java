/*
Hayden Lammons
HLammons1@cnm.edu
LammonsP4 Earthquake Viewer
 */

package com.cis2237.lammonsp3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(this, "LammonsP4 Earthquake Viewer", Toast.LENGTH_SHORT).show();

    }
}