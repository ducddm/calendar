package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class SearchActivity extends AppCompatActivity {

    DatePicker picker;
    Calculation calcu;
    Button button;
    int da;
    int m;
    int y;

    TextView solar;
    TextView lunar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



        HomeFragmentPaperAdapter adapter = new HomeFragmentPaperAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void clickme(View view){
        picker = findViewById(R.id.picker);
        button = findViewById(R.id.button);

        solar = findViewById(R.id.solar);
        lunar = findViewById(R.id.lunar);



        da = picker.getDayOfMonth();
        m = picker.getMonth()+1;
        y = picker.getYear();
        int d[]=calcu.Solar2Lunar(da,m,y);
        solar.setText(da+"/"+m+"/"+y);
        lunar.setText(d[0]+"/"+d[1]+"/"+d[2]);

    }
}
