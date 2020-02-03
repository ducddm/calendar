package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
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

        TextView day1 = findViewById(R.id.thu);
        int X=calcu.MOD((int)(Calculation.UniversalToJD(da,m,y)+2.5), 7);
        switch (X){
            case 0: day1.setText(R.string.sat); break;
            case 1: day1.setText(R.string.sun); break;
            case 2: day1.setText(R.string.mon); break;
            case 3: day1.setText(R.string.tue); break;
            case 4: day1.setText(R.string.wed); break;
            case 5: day1.setText(R.string.thu); break;
            case 6: day1.setText(R.string.fri); break;
        }

        /*Cung Hoàng Đạo*/

        ImageView star = findViewById(R.id.starr);
        TextView st = findViewById(R.id.sta);
        TextView ele = findViewById(R.id.ele);
        TextView pla = findViewById(R.id.pla);
        TextView pla1 = findViewById(R.id.pla1);
        TextView ang = findViewById(R.id.ang);
        TextView ang1 = findViewById(R.id.ang1);

        TextView nhom = findViewById(R.id.nhom);
        TextView han = findViewById(R.id.hanh);
        TextView than = findViewById(R.id.than);

        nhom.setText(R.string.nh);
        han.setText(R.string.ha);
        than.setText(R.string.th);

        switch (m) {
            case 1: if (da<20) {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
                ele.setText(R.string.dat);
                pla.setText(R.string.st8);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a11);
            }
            else {
                star.setImageResource(R.drawable.aquarius);
                st.setText(R.string.s2);
                ele.setText(R.string.k);
                pla.setText(R.string.st8);
                pla1.setText(R.string.st9);
                ang.setText(R.string.a11);
                ang1.setText(R.string.a12);
            }
                break;

            case 2: if (da<19) {
                star.setImageResource(R.drawable.aquarius);
                st.setText(R.string.s2);
                ele.setText(R.string.k);
                pla.setText(R.string.st8);
                pla1.setText(R.string.st9);
                ang.setText(R.string.a11);
                ang1.setText(R.string.a12);
            }
            else {
                star.setImageResource(R.drawable.pisces);
                st.setText(R.string.s3);
                ele.setText(R.string.n);
                pla.setText(R.string.st10);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a13);
            }
                break;

            case 3: if (da<21) {
                star.setImageResource(R.drawable.pisces);
                st.setText(R.string.s3);
                ele.setText(R.string.n);
                pla.setText(R.string.st10);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a13);

            }
            else {
                star.setImageResource(R.drawable.aries);
                st.setText(R.string.s4);
                ele.setText(R.string.l);
                pla.setText(R.string.st1);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a1);
            }
                break;

            case 4: if (da<20) {
                star.setImageResource(R.drawable.aries);
                st.setText(R.string.s4);
                ele.setText(R.string.l);
                pla.setText(R.string.st1);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a1);
            }
            else {
                star.setImageResource(R.drawable.taurus);
                st.setText(R.string.s5);
                ele.setText(R.string.dat);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a2);
            }
                break;

            case 5: if (da<21) {
                star.setImageResource(R.drawable.taurus);
                st.setText(R.string.s5);
                ele.setText(R.string.dat);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a2);
            }
            else {
                star.setImageResource(R.drawable.gemini);
                st.setText(R.string.s6);
                ele.setText(R.string.k);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a3);
            }
                break;

            case 6: if (da<22) {
                star.setImageResource(R.drawable.gemini);
                st.setText(R.string.s6);
                ele.setText(R.string.k);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a3);
            }
            else {
                star.setImageResource(R.drawable.cancer);
                st.setText(R.string.s7);
                ele.setText(R.string.n);
                pla.setText(R.string.st4);
                pla1.setText("");
                ang.setText(R.string.a4);
                ang1.setText(R.string.a5);
            }
                break;

            case 7: if (da<23) {
                star.setImageResource(R.drawable.cancer);
                st.setText(R.string.s7);
                ele.setText(R.string.n);
                pla.setText(R.string.st4);
                pla1.setText("");
                ang.setText(R.string.a4);
                ang1.setText(R.string.a5);
            }
            else {
                star.setImageResource(R.drawable.leo);
                st.setText(R.string.s8);
                ele.setText(R.string.l);
                pla.setText(R.string.st5);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a6);
            }
                break;

            case 8: if (da<23) {
                star.setImageResource(R.drawable.leo);
                st.setText(R.string.s8);
                ele.setText(R.string.l);
                pla.setText(R.string.st5);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a6);
            }
            else {
                star.setImageResource(R.drawable.virgo);
                st.setText(R.string.s9);
                ele.setText(R.string.dat);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang.setText(R.string.a3);
                ang.setText(R.string.a5);
            }
                break;

            case 9: if (da<23) {
                star.setImageResource(R.drawable.virgo);
                st.setText(R.string.s9);
                ele.setText(R.string.dat);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang.setText(R.string.a3);
                ang.setText(R.string.a5);
            }
            else {
                star.setImageResource(R.drawable.libra);
                st.setText(R.string.s10);
                ele.setText(R.string.k);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang.setText(R.string.a7);
                ang1.setText(R.string.a2);
            }
                break;

            case 10: if (da<24) {
                star.setImageResource(R.drawable.libra);
                st.setText(R.string.s10);
                ele.setText(R.string.k);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang.setText(R.string.a7);
                ang1.setText(R.string.a2);
            }
            else {
                star.setImageResource(R.drawable.scorpio);
                st.setText(R.string.s11);
                ele.setText(R.string.n);
                pla.setText(R.string.st6);
                pla1.setText("");
                ang.setText(R.string.a8);
                ang1.setText(R.string.a1);
            }
                break;

            case 11: if (da<22) {
                star.setImageResource(R.drawable.scorpio);
                st.setText(R.string.s11);
                ele.setText(R.string.n);
                pla.setText(R.string.st6);
                pla1.setText("");
                ang.setText(R.string.a8);
                ang1.setText(R.string.a1);
            }
            else {
                star.setImageResource(R.drawable.sagittarius);
                st.setText(R.string.s12);
                ele.setText(R.string.l);
                pla.setText(R.string.st7);
                pla1.setText("");
                ang.setText(R.string.a9);
                ang1.setText(R.string.a10);
            }
                break;

            case 12: if (da<22) {
                star.setImageResource(R.drawable.sagittarius);
                st.setText(R.string.s12);
                ele.setText(R.string.l);
                pla.setText(R.string.st7);
                pla1.setText("");
                ang.setText(R.string.a9);
                ang1.setText(R.string.a10);
            }
            else {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
                ele.setText(R.string.dat);
                pla.setText(R.string.st8);
                pla1.setText("");
                ang.setText(R.string.a11);
                ang1.setText("");

            }
                break;
        }



    }
}
