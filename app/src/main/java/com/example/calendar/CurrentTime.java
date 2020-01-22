package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class CurrentTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        final Calendar c = Calendar.getInstance();
        ImageView i1 = (ImageView) findViewById(R.id.hour);

        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

        TextView gg = (TextView) findViewById(R.id.textView);
        TextView gg1 = (TextView) findViewById(R.id.textView1);
        TextView gg2 = findViewById(R.id.tv1);
        gg.setText(d + "/" + m + "/" + y);
        gg1.setText(hour + ":" + min + ":" + sec);

        if ((hour==0) || (hour==23)) {
            i1.setImageResource(R.drawable.rat);
            gg2.setText(R.string.hour1);
        }
        if ((hour==1) || (hour==2)) {
            i1.setImageResource(R.drawable.ox);
            gg2.setText(R.string.hour2);
        }
        if ((hour==3) || (hour==4)) {
            i1.setImageResource(R.drawable.tiger);
            gg2.setText(R.string.hour3);
        }
        if ((hour==5) || (hour==6)) {
            i1.setImageResource(R.drawable.rabbit);
            gg2.setText(R.string.hour4);
        }
        if ((hour==7) || (hour==8)) {
            i1.setImageResource(R.drawable.dragon);
            gg2.setText(R.string.hour5);
        }
        if ((hour==9) || (hour==10)) {
            i1.setImageResource(R.drawable.snake);
            gg2.setText(R.string.hour6);
        }
        if ((hour==11) || (hour==12)) {
            i1.setImageResource(R.drawable.horse);
            gg2.setText(R.string.hour7);
        }
        if ((hour==13) || (hour==14)) {
            i1.setImageResource(R.drawable.goat);
            gg2.setText(R.string.hour8);
        }
        if ((hour==15) || (hour==16)) {
            i1.setImageResource(R.drawable.monkey);
            gg2.setText(R.string.hour9);
        }
        if ((hour==17) || (hour==18)) {
            i1.setImageResource(R.drawable.rooster);
            gg2.setText(R.string.hour10);
        }
        if ((hour==19) || (hour==20)) {
            i1.setImageResource(R.drawable.dog);
            gg2.setText(R.string.hour11);
        }
        if ((hour==21) || (hour==22)) {
            i1.setImageResource(R.drawable.pig);
            gg2.setText(R.string.hour12);
        }
    }

}
