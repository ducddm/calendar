package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    DatePicker picker;
    TextView ngayam;
    Calculation calcu;
    Button button;
    int da;
    int m;
    int y;
    int h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        picker = findViewById(R.id.picker);
        button = findViewById(R.id.button);
        ngayam = findViewById(R.id.ngayam);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                da = picker.getDayOfMonth();
                m = picker.getMonth()+1;
                y = picker.getYear();
                int d[]=calcu.Solar2Lunar(da,m,y);
                ngayam.setText(d[0]+"/"+d[1]+"/"+d[2]);
            }
        });

    }
}
