package com.example.ilman.weatherapp.fragments;


import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.BoolRes;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.ilman.weatherapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherFragment extends Fragment {

    String url="http://api.openweathermap.org/data/2.5/forecast/?lat=-6.260465&lon=106.846831&units=metric&APPID=9ed2257682b1d9a2eb66c15047e1bfdd";

    @BindView(R.id.tvCity)
    TextView tvCity;

    @BindView(R.id.tvMaxTemp)
    TextView tvMaxTemp;

    @BindView(R.id.tvMinTemp)
    TextView tvMinTemp;

    @BindView(R.id.tvDayDate)
    TextView tvDayDate;

    @BindView(R.id.tvStatus)
    TextView tvStatus;

    @BindView(R.id.tvTime)
    TextView tvTime;

    @BindView(R.id.imgCuaca)
    ImageView imgCuaca;

    //TODO weather adapter, weather holder, weather card list

    public WeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_weather, container, false);
        ButterKnife.bind(this,view);

        // Start Code

        //API REQUEST

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject cityObject=  response.getJSONObject("city");
                    String cityName= cityObject.getString("name");
                    String countryName= cityObject.getString("country");

                    JSONArray list= response.getJSONArray("list");
                    JSONObject objectList= list.getJSONObject(0);

                    String dt_txt= objectList.getString("dt_txt");
                    String time= objectList.getString("dt_txt");

                    JSONObject main= objectList.getJSONObject("main");
                    Double tempMax=main.getDouble("temp_max");
                    Double tempMin= main.getDouble("temp_min");

                    JSONArray weatherArray = objectList.getJSONArray("weather");
                    JSONObject objectWeather= weatherArray.getJSONObject(0);
                    String cuaca = objectWeather.getString("main");

                    SimpleDateFormat formatDefault = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    SimpleDateFormat formatTimeCustom = new SimpleDateFormat("E, dd MMMM");
                    SimpleDateFormat formatTimeCustom2 = new SimpleDateFormat("hh:mm");

                    try {
                        Date timesFormat = formatDefault.parse(dt_txt);
                        Date timesFormat2 = formatDefault.parse(time);
                        dt_txt = formatTimeCustom.format(timesFormat);
                        time= formatTimeCustom2.format(timesFormat2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    tvCity.setText(cityName+", "+countryName);
                    tvMaxTemp.setText(String.valueOf(tempMax));
                    tvMinTemp.setText(String.valueOf(tempMin));
                    tvDayDate.setText(dt_txt);
                    tvStatus.setText(cuaca);
                    tvTime.setText(time);

                    if (cuaca.equals("Rain")){
                        imgCuaca.setImageResource(R.drawable.rain_large);
                    }else if(cuaca.equals("Clear")){
                        imgCuaca.setImageResource(R.drawable.sun_large);
                    }else{
                        imgCuaca.setImageResource(R.drawable.coldly_large);
                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR - ",error.getMessage());
            }
        });
        Volley.newRequestQueue(getContext()).add(jsonObjectRequest);


        return view;
    }



}
