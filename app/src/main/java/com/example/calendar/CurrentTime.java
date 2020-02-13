package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Calendar;

public class CurrentTime extends AppCompatActivity {

    Calculation calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);

        final Calendar c = Calendar.getInstance();

        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);

        TextView gg = (TextView) findViewById(R.id.textView);
        gg.setText(d + "/" + m + "/" + y);

        ImageView star = findViewById(R.id.star);
        TextView st = findViewById(R.id.st);
        switch (m) {
            case 1: if (d<20) {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
            }
            else {
                star.setImageResource(R.drawable.aquarius);
                st.setText(R.string.s2);
            }
            break;

            case 2: if (d<19) {
                star.setImageResource(R.drawable.aquarius);
                st.setText(R.string.s2);
            }
            else {
                star.setImageResource(R.drawable.pisces);
                st.setText(R.string.s3);
            }
            break;

            case 3: if (d<21) {
                star.setImageResource(R.drawable.pisces);
                st.setText(R.string.s3);
            }
            else {
                star.setImageResource(R.drawable.aries);
                st.setText(R.string.s4);
            }
            break;

            case 4: if (d<20) {
                star.setImageResource(R.drawable.aries);
                st.setText(R.string.s4);
            }
            else {
                star.setImageResource(R.drawable.taurus);
                st.setText(R.string.s5);
            }
            break;

            case 5: if (d<21) {
                star.setImageResource(R.drawable.taurus);
                st.setText(R.string.s5);
            }
            else {
                star.setImageResource(R.drawable.gemini);
                st.setText(R.string.s6);
            }
            break;

            case 6: if (d<22) {
                star.setImageResource(R.drawable.gemini);
                st.setText(R.string.s6);
            }
            else {
                star.setImageResource(R.drawable.cancer);
                st.setText(R.string.s7);
            }
            break;

            case 7: if (d<23) {
                star.setImageResource(R.drawable.cancer);
                st.setText(R.string.s7);
            }
            else {
                star.setImageResource(R.drawable.leo);
                st.setText(R.string.s8);
            }
            break;

            case 8: if (d<23) {
                star.setImageResource(R.drawable.leo);
                st.setText(R.string.s8);
            }
            else {
                star.setImageResource(R.drawable.virgo);
                st.setText(R.string.s9);
            }
            break;

            case 9: if (d<23) {
                star.setImageResource(R.drawable.virgo);
                st.setText(R.string.s9);
            }
            else {
                star.setImageResource(R.drawable.libra);
                st.setText(R.string.s10);
            }
            break;

            case 10: if (d<24) {
                star.setImageResource(R.drawable.libra);
                st.setText(R.string.s10);
            }
            else {
                star.setImageResource(R.drawable.scorpio);
                st.setText(R.string.s11);
            }
            break;

            case 11: if (d<22) {
                star.setImageResource(R.drawable.scorpio);
                st.setText(R.string.s11);
            }
            else {
                star.setImageResource(R.drawable.sagittarius);
                st.setText(R.string.s12);
            }
            break;

            case 12: if (d<22) {
                star.setImageResource(R.drawable.sagittarius);
                st.setText(R.string.s12);
            }
            else {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
            }
            break;
        }

        TextView day1 = findViewById(R.id.date);
        int X=calculation.MOD((int)(Calculation.UniversalToJD(d,m,y)+2.5), 7);
        switch (X){
            case 7: day1.setText(R.string.sat); break;
            case 1: day1.setText(R.string.sun); break;
            case 2: day1.setText(R.string.mon); break;
            case 3: day1.setText(R.string.tue); break;
            case 4: day1.setText(R.string.wed); break;
            case 5: day1.setText(R.string.thu); break;
            case 6: day1.setText(R.string.fri); break;
        }



        TextView gg3 = findViewById(R.id.tv2);
        int day[] = Calculation.Solar2Lunar(d,m,y);
        gg3.setText(day[0]+"/"+day[1]+"/"+day[2]);


        TextView y1 = findViewById(R.id.year1);
        TextView y2 = findViewById(R.id.year2);
        int ye = day[2];
        int yecan = ye%10;
        int yechi = ye%12;

        switch (yecan){
            case 0: y1.setText(R.string.c7); break;
            case 1: y1.setText(R.string.c8); break;
            case 2: y1.setText(R.string.c9); break;
            case 3: y1.setText(R.string.c10); break;
            case 4: y1.setText(R.string.c1); break;
            case 5: y1.setText(R.string.c2); break;
            case 6: y1.setText(R.string.c3); break;
            case 7: y1.setText(R.string.c4); break;
            case 8: y1.setText(R.string.c5); break;
            case 9: y1.setText(R.string.c6); break;
        }

        switch (yechi) {
            case 0: y2.setText(R.string.ch9); break;
            case 1: y2.setText(R.string.ch10); break;
            case 2: y2.setText(R.string.ch11); break;
            case 3: y2.setText(R.string.ch12); break;
            case 4: y2.setText(R.string.ch1); break;
            case 5: y2.setText(R.string.ch2); break;
            case 6: y2.setText(R.string.ch3); break;
            case 7: y2.setText(R.string.ch4); break;
            case 8: y2.setText(R.string.ch5); break;
            case 9: y2.setText(R.string.ch6); break;
            case 10: y2.setText(R.string.ch7); break;
            case 11: y2.setText(R.string.ch8); break;
        }

        TextView m1 = findViewById(R.id.month1);
        TextView m2 = findViewById(R.id.month2);

        int mo = day[1];
        int mocan = (ye*12+mo+3)%10;
        switch (mocan) {
            case 0: m1.setText(R.string.c1); break;
            case 1: m1.setText(R.string.c2); break;
            case 2: m1.setText(R.string.c3); break;
            case 3: m1.setText(R.string.c4); break;
            case 4: m1.setText(R.string.c5); break;
            case 5: m1.setText(R.string.c6); break;
            case 6: m1.setText(R.string.c7); break;
            case 7: m1.setText(R.string.c8); break;
            case 8: m1.setText(R.string.c9); break;
            case 9: m1.setText(R.string.c10); break;
        }
        switch (mo) {
            case 1: m2.setText(R.string.ch3); break;
            case 2: m2.setText(R.string.ch4); break;
            case 3: m2.setText(R.string.ch5); break;
            case 4: m2.setText(R.string.ch6); break;
            case 5: m2.setText(R.string.ch7); break;
            case 6: m2.setText(R.string.ch8); break;
            case 7: m2.setText(R.string.ch9); break;
            case 8: m2.setText(R.string.ch10); break;
            case 9: m2.setText(R.string.ch11); break;
            case 10: m2.setText(R.string.ch12); break;
            case 11: m2.setText(R.string.ch1); break;
            case 12: m2.setText(R.string.ch2); break;
        }

        TextView d1 = findViewById(R.id.day1);
        TextView d2 = findViewById(R.id.day2);
        ImageView ngay = findViewById(R.id.ngay);

        int dcan = Calculation.INT(Calculation.UniversalToJD(d,m,y)+9.5) % 10;
        int dchi = Calculation.INT(Calculation.UniversalToJD(d,m,y) + 1.5) % 12;

        switch (dcan) {
            case 0: d1.setText(R.string.c1); break;
            case 1: d1.setText(R.string.c2); break;
            case 2: d1.setText(R.string.c3); break;
            case 3: d1.setText(R.string.c4); break;
            case 4: d1.setText(R.string.c5); break;
            case 5: d1.setText(R.string.c6); break;
            case 6: d1.setText(R.string.c7); break;
            case 7: d1.setText(R.string.c8); break;
            case 8: d1.setText(R.string.c9); break;
            case 9: d1.setText(R.string.c10); break;
        }

        switch (dchi) {
            case 0: {
                d2.setText(R.string.ch1);
                ngay.setImageResource(R.drawable.rat);
                break;
            }
            case 1: {
                d2.setText(R.string.ch2);
                ngay.setImageResource(R.drawable.ox);
                break;
            }
            case 2: {
                d2.setText(R.string.ch3);
                ngay.setImageResource(R.drawable.tiger);
                break;
            }
            case 3: {
                d2.setText(R.string.ch4);
                ngay.setImageResource(R.drawable.rabbit);
                break;
            }
            case 4: {
                d2.setText(R.string.ch5);
                ngay.setImageResource(R.drawable.dragon);
                break;
            }
            case 5: {
                d2.setText(R.string.ch6);
                ngay.setImageResource(R.drawable.snake);
                break;
            }
            case 6: {
                d2.setText(R.string.ch7);
                ngay.setImageResource(R.drawable.horse);
                break;
            }
            case 7: {
                d2.setText(R.string.ch8);
                ngay.setImageResource(R.drawable.goat);
                break;
            }
            case 8: {
                d2.setText(R.string.ch9);
                ngay.setImageResource(R.drawable.monkey);
                break;
            }
            case 9: {
                d2.setText(R.string.ch10);
                ngay.setImageResource(R.drawable.rooster);
                break;
            }
            case 10: {
                d2.setText(R.string.ch11);
                ngay.setImageResource(R.drawable.dog);
                break;
            }
            case 11: {
                d2.setText(R.string.ch12);
                ngay.setImageResource(R.drawable.pig);
                break;
            }
        }

        TextView h1 = findViewById(R.id.hour1);
        TextView h2 = findViewById(R.id.hour2);


        if ((dcan==0) || (dcan==5)) {
            if ((hour==23) || (hour==0)) h1.setText(R.string.c1);
            if ((hour==1) || (hour==2)) h1.setText(R.string.c2);
            if ((hour==3) || (hour==4)) h1.setText(R.string.c3);
            if ((hour==5) || (hour==6)) h1.setText(R.string.c4);
            if ((hour==7) || (hour==8)) h1.setText(R.string.c5);
            if ((hour==9) || (hour==10)) h1.setText(R.string.c6);
            if ((hour==11) || (hour==12)) h1.setText(R.string.c7);
            if ((hour==13) || (hour==14)) h1.setText(R.string.c8);
            if ((hour==15) || (hour==16)) h1.setText(R.string.c9);
            if ((hour==17) || (hour==18)) h1.setText(R.string.c10);
            if ((hour==19) || (hour==20)) h1.setText(R.string.c1);
            if ((hour==21) || (hour==22)) h1.setText(R.string.c2);
        }

        if ((dcan==1) || (dcan==6)) {
            if ((hour==23) || (hour==0)) h1.setText(R.string.c3);
            if ((hour==1) || (hour==2)) h1.setText(R.string.c4);
            if ((hour==3) || (hour==4)) h1.setText(R.string.c5);
            if ((hour==5) || (hour==6)) h1.setText(R.string.c6);
            if ((hour==7) || (hour==8)) h1.setText(R.string.c7);
            if ((hour==9) || (hour==10)) h1.setText(R.string.c8);
            if ((hour==11) || (hour==12)) h1.setText(R.string.c9);
            if ((hour==13) || (hour==14)) h1.setText(R.string.c10);
            if ((hour==15) || (hour==16)) h1.setText(R.string.c1);
            if ((hour==17) || (hour==18)) h1.setText(R.string.c2);
            if ((hour==19) || (hour==20)) h1.setText(R.string.c3);
            if ((hour==21) || (hour==22)) h1.setText(R.string.c4);
        }

        if ((dcan==2) || (dcan==7)) {
            if ((hour==23) || (hour==0)) h1.setText(R.string.c5);
            if ((hour==1) || (hour==2)) h1.setText(R.string.c6);
            if ((hour==3) || (hour==4)) h1.setText(R.string.c7);
            if ((hour==5) || (hour==6)) h1.setText(R.string.c8);
            if ((hour==7) || (hour==8)) h1.setText(R.string.c9);
            if ((hour==9) || (hour==10)) h1.setText(R.string.c10);
            if ((hour==11) || (hour==12)) h1.setText(R.string.c1);
            if ((hour==13) || (hour==14)) h1.setText(R.string.c2);
            if ((hour==15) || (hour==16)) h1.setText(R.string.c3);
            if ((hour==17) || (hour==18)) h1.setText(R.string.c4);
            if ((hour==19) || (hour==20)) h1.setText(R.string.c5);
            if ((hour==21) || (hour==22)) h1.setText(R.string.c6);
        }

        if ((dcan==3) || (dcan==8)) {
            if ((hour==23) || (hour==0)) h1.setText(R.string.c7);
            if ((hour==1) || (hour==2)) h1.setText(R.string.c8);
            if ((hour==3) || (hour==4)) h1.setText(R.string.c9);
            if ((hour==5) || (hour==6)) h1.setText(R.string.c10);
            if ((hour==7) || (hour==8)) h1.setText(R.string.c1);
            if ((hour==9) || (hour==10)) h1.setText(R.string.c2);
            if ((hour==11) || (hour==12)) h1.setText(R.string.c3);
            if ((hour==13) || (hour==14)) h1.setText(R.string.c4);
            if ((hour==15) || (hour==16)) h1.setText(R.string.c5);
            if ((hour==17) || (hour==18)) h1.setText(R.string.c6);
            if ((hour==19) || (hour==20)) h1.setText(R.string.c7);
            if ((hour==21) || (hour==22)) h1.setText(R.string.c8);
        }

        if ((dcan==4) || (dcan==9)) {
            if ((hour==23) || (hour==0)) h1.setText(R.string.c9);
            if ((hour==1) || (hour==2)) h1.setText(R.string.c10);
            if ((hour==3) || (hour==4)) h1.setText(R.string.c1);
            if ((hour==5) || (hour==6)) h1.setText(R.string.c2);
            if ((hour==7) || (hour==8)) h1.setText(R.string.c3);
            if ((hour==9) || (hour==10)) h1.setText(R.string.c4);
            if ((hour==11) || (hour==12)) h1.setText(R.string.c5);
            if ((hour==13) || (hour==14)) h1.setText(R.string.c6);
            if ((hour==15) || (hour==16)) h1.setText(R.string.c7);
            if ((hour==17) || (hour==18)) h1.setText(R.string.c8);
            if ((hour==19) || (hour==20)) h1.setText(R.string.c9);
            if ((hour==21) || (hour==22)) h1.setText(R.string.c10);
        }

        if ((hour==23) || (hour==0)) h2.setText(R.string.ch1);
        if ((hour==1) || (hour==2)) h2.setText(R.string.ch2);
        if ((hour==3) || (hour==4)) h2.setText(R.string.ch3);
        if ((hour==5) || (hour==6)) h2.setText(R.string.ch4);
        if ((hour==7) || (hour==8)) h2.setText(R.string.ch5);
        if ((hour==9) || (hour==10)) h2.setText(R.string.ch6);
        if ((hour==11) || (hour==12)) h2.setText(R.string.ch7);
        if ((hour==13) || (hour==14)) h2.setText(R.string.ch8);
        if ((hour==15) || (hour==16)) h2.setText(R.string.ch9);
        if ((hour==17) || (hour==18)) h2.setText(R.string.ch10);
        if ((hour==19) || (hour==20)) h2.setText(R.string.ch11);
        if ((hour==21) || (hour==22)) h2.setText(R.string.ch12);

        TextView lh = findViewById(R.id.luckyhour);

        if ((dchi==2) || (dchi==8)) lh.setText(R.string.h1);
        if ((dchi==3) || (dchi==9)) lh.setText(R.string.h2);
        if ((dchi==4) || (dchi==10)) lh.setText(R.string.h3);
        if ((dchi==5) || (dchi==11)) lh.setText(R.string.h4);
        if ((dchi==6) || (dchi==0)) lh.setText(R.string.h5);
        if ((dchi==7) || (dchi==1)) lh.setText(R.string.h6);
    }



}
