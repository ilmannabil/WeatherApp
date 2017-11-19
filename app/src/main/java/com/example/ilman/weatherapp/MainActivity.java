package com.example.ilman.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ilman.weatherapp.fragments.WeatherFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frame_main_activity, new WeatherFragment()).commit();

    }
}
