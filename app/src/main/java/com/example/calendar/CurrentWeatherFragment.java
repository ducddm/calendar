package com.example.calendar;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

public class CurrentWeatherFragment extends Fragment {

    private String title;
    private int page;

    WeatherCalculation weatherCalculation = new WeatherCalculation();

    /*Tiet khi*/
    private TextView tietkhi;
    private TextView tietkhiDetail;

    /*Current weather*/
    private ImageView imgCurrent;
    private TextView weatherStatusCurrent;
    private TextView weatherTempCurrent;
    private TextView location;

    /*Weather in a week*/
    private String[] w = new String[7];
    private String[] tempC = new String[7];

    private TextView[] day = new TextView[7];
    private TextView[] temp = new TextView[7];
    private TextView[] weather = new TextView[7];
    private ImageView[] weatherImage = new ImageView[7];

    private double[] tempCmin = new double[7];
    private double[] tempCmax = new double[7];

    /*Temperature in the next 10 hours*/
    private GraphView graph;

    private double[] tempChour = new double[10];
    private String[] hourLabel = new String[10];

    private RequestQueue requestQueue;

    public static CurrentWeatherFragment newInstance(int page, String title) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt("someInt", 0);
            title = getArguments().getString("someTitle");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_weather, container, false);

        /*LinearLayout*/
        LinearLayout ll = view.findViewById(R.id.ll);
        tietkhi = ll.findViewById(R.id.tk);
        tietkhiDetail = ll.findViewById(R.id.tkdetail);

        /*In Relative Layout*/
        RelativeLayout rl = view.findViewById(R.id.weather_container);
        imgCurrent = rl.findViewById(R.id.image_weather);
        weatherStatusCurrent = rl.findViewById(R.id.current_weather);
        weatherTempCurrent = rl.findViewById(R.id.current_temp);
        location = rl.findViewById(R.id.location);


        /*In Scroll View*/
        ScrollView sv = view.findViewById(R.id.totalweather);

        /*In Graph View*/
        LinearLayout llgraph = view.findViewById(R.id.llgraph);
        graph = llgraph.findViewById(R.id.graph);

        day[0] = sv.findViewById(R.id.day1);
        day[1] = sv.findViewById(R.id.day2);
        day[2] = sv.findViewById(R.id.day3);
        day[3] = sv.findViewById(R.id.day4);
        day[4] = sv.findViewById(R.id.day5);
        day[5] = sv.findViewById(R.id.day6);
        day[6] = sv.findViewById(R.id.day7);

        weatherImage[0] = sv.findViewById(R.id.image1);
        weatherImage[1] = sv.findViewById(R.id.image2);
        weatherImage[2] = sv.findViewById(R.id.image3);
        weatherImage[3] = sv.findViewById(R.id.image4);
        weatherImage[4] = sv.findViewById(R.id.image5);
        weatherImage[5] = sv.findViewById(R.id.image6);
        weatherImage[6] = sv.findViewById(R.id.image7);

        weather[0] = sv.findViewById(R.id.weather1);
        weather[1] = sv.findViewById(R.id.weather2);
        weather[2] = sv.findViewById(R.id.weather3);
        weather[3] = sv.findViewById(R.id.weather4);
        weather[4] = sv.findViewById(R.id.weather5);
        weather[5] = sv.findViewById(R.id.weather6);
        weather[6] = sv.findViewById(R.id.weather7);

        temp[0] = sv.findViewById(R.id.temp1);
        temp[1] = sv.findViewById(R.id.temp2);
        temp[2] = sv.findViewById(R.id.temp3);
        temp[3] = sv.findViewById(R.id.temp4);
        temp[4] = sv.findViewById(R.id.temp5);
        temp[5] = sv.findViewById(R.id.temp6);
        temp[6] = sv.findViewById(R.id.temp7);

        requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        /*Find Tiet Khi*/
        final Calendar c = Calendar.getInstance();

        /*Declare Variable*/
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);

        weatherCalculation.findTietkhi(d,m);

        tietkhi.setText(weatherCalculation.tietkhi);
        tietkhiDetail.setText(weatherCalculation.tietkhiDetail);

        parsejson("21.0278,105.8342",7);

        return view;
    }

    public int findDay(int d) {
        int day = 0;
        switch (d) {
            case 5: day =  R.string.tue1; break;
            case 6: day =  R.string.wed1; break;
            case 0: day =  R.string.thu1; break;
            case 1: day =  R.string.fri1; break;
            case 2: day =  R.string.sat1; break;
            case 3: day =  R.string.sun1; break;
            case 4: day =  R.string.mon1; break;
        }
        return day;
    }

    public int findWeatherImage(String w1) {
        int url = 0;
        if (w1.contains("cloudy") || (w1.contains("clear"))) {
            url =  R.drawable.cloudy;
        } else if (w1.contains("sun")) {
            url =  R.drawable.sunny;
        } else if (w1.contains("snow")) {
            url =  R.drawable.snow;
        } else if (w1.contains("haze") || (w1.contains("mist"))){
            url =  R.drawable.foggy;
        } else if (w1.contains("storm")) {
            url =  R.drawable.storm;
        } else if (w1.contains("rain") || (w1.contains("drizzle"))) {
            url =  R.drawable.rain;
        }
        return url;
    }

    public int findWeatherStatus(String w1) {
        int status = 0;
        if (w1.contains("cloudy") || (w1.contains("clear"))) {
            status =  R.string.cloudy;
        } else if (w1.contains("sun")) {
            status =  R.string.sunny;
        } else if (w1.contains("snow")) {
            status =  R.string.snow;
        } else if (w1.contains("haze") || (w1.contains("mist"))){
            status =  R.string.foggy;
        } else if (w1.contains("storm")) {
            status =  R.string.storm;
        } else if (w1.contains("rain") || (w1.contains("drizzle"))) {
            status =  R.string.rain;
        }
        return status;
    }

    private void parsejson(String latlong, final int GMT){
        String url1 = "https://api.darksky.net/forecast/3631f61602a29ee69edc1f4accb0a2b8/" + latlong;
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    /*Find Data for the next 7 days*/
                    JSONObject ob1 = response.getJSONObject("daily");
                    JSONArray ar1 = ob1.getJSONArray("data");

                    for (int i=0; i< 7; i++) {
                        JSONObject ob11 = ar1.getJSONObject(i);

                        /*declare so that array is not null*/
                        tempCmin[i] = 0;

                        int time1 = ob11.getInt("time");
                        int newsec1 = time1 + GMT*3600;
                        int date1 = newsec1 / 86400;
                        int choose1 = date1 % 7;

                        w[i] = ob11.getString("icon");

                        Double tempmin = ob11.getDouble("temperatureLow");
                        Double tempmax = ob11.getDouble("temperatureHigh");

                        tempCmin[i] = (double)Math.round((tempmin - 32) * 5/9 * 10) / 10;
                        tempCmax[i] = (double)Math.round((tempmax - 32) * 5/9 * 10) / 10;

                        tempC[i] = tempCmin[i] + "C - " + tempCmax[i] + "C";



                        day[i].setText(findDay(choose1));
                        weather[i].setText(findWeatherStatus(w[i]));
                        weatherImage[i].setImageResource(findWeatherImage(w[i]));
                        temp[i].setText(tempC[i]);
                    }

                    imgCurrent.setImageResource(findWeatherImage(w[0]));
                    weatherStatusCurrent.setText(findWeatherStatus(w[0]));
                    weatherTempCurrent.setText(tempC[0]);
                    location.setText(R.string.hn);

                    /*Find Data for displaying in the graph*/
                    JSONObject ob2 = response.getJSONObject("hourly");
                    JSONArray arr2 = ob2.getJSONArray("data");

                    for (int i=0; i<10; i++) {
                        JSONObject ob21 = arr2.getJSONObject(i);

                        /*Find temperature after each hour*/
                        Double tempFhour = ob21.getDouble("temperature");
                        tempChour[i] = (double)Math.round((tempFhour - 32) * 5/9 * 10)/10;

                        /*Find time */
                        int hourOrigin = ob21.getInt("time");
                        int hourNew = (hourOrigin / (3600)) % 24 + GMT;
                        if (hourNew > 24) {
                            hourNew = hourNew - 24;
                        }

                        String hourN = String.valueOf(hourNew);
                        char ch = 'h';
                        hourLabel[i] = hourN + ch;
                    }

                    BarGraphSeries<DataPoint> series = new BarGraphSeries<>(new DataPoint[] {
                            new DataPoint(0, tempChour[0]),
                            new DataPoint(1, tempChour[1]),
                            new DataPoint(2, tempChour[2]),
                            new DataPoint(3, tempChour[3]),
                            new DataPoint(4, tempChour[4]),
                            new DataPoint(5, tempChour[5]),
                            new DataPoint(6, tempChour[6]),
                            new DataPoint(7, tempChour[7]),
                            new DataPoint(8, tempChour[8]),
                            new DataPoint(9, tempChour[9])
                    });

                    StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
                    staticLabelsFormatter.setHorizontalLabels(hourLabel);

                    graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                    graph.getGridLabelRenderer().setTextSize(20);

                    graph.addSeries(series);
                    graph.getViewport().setMinY(0);
                    graph.getViewport().setMaxY(40);

                    series.setSpacing(50);
                    series.setDrawValuesOnTop(true);
                    series.setValuesOnTopColor(Color.RED);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }



}
