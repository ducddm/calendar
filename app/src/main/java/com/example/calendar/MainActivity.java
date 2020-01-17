package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickme(View view){
        final Calendar c = Calendar.getInstance();
        int m = c.get(Calendar.MONTH);

        TextView gg = (TextView) findViewById(R.id.textView);
        gg.setText(Integer.toString(m));
    }


}
