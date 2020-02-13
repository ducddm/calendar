package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatePicker picker;
    Calculation calcu;
    Button button;
    int da;
    int m;
    int y;

    TextView solar;
    TextView lunar;
    TextView menh;
    TextView men;
    TextView menhchi;
    ImageView diachi;
    ImageView nguhanh;

    TextView cannam;
    TextView chinam;

    TextView canthang;
    TextView chithang;

    TextView canngay;
    TextView chingay;

    TextView cangio;
    TextView chigio;

    TextView nam;
    TextView thang;
    TextView ngay;
    TextView ggg;

    int gio;

    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
            // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.hhh, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
        spinner.setAdapter(adapter1);


        HomeFragmentPaperAdapter adapter = new HomeFragmentPaperAdapter(getSupportFragmentManager());
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {

        switch (pos){
            case 0: gio = 1; break;
            case 1: gio = 2; break;
            case 2: gio = 3; break;
            case 3: gio = 4; break;
            case 4: gio = 5; break;
            case 5: gio = 6; break;
            case 6: gio = 7; break;
            case 7: gio = 8; break;
            case 8: gio = 9; break;
            case 9: gio = 10; break;
            case 10: gio = 11; break;
            case 11: gio = 12; break;
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void clickme(View view){

        nam = findViewById(R.id.y0);
        thang = findViewById(R.id.m0);
        ngay = findViewById(R.id.d0);
        ggg = findViewById(R.id.h0);
        men = findViewById(R.id.men);
        menh = findViewById(R.id.nguhanh);
        menhchi = findViewById(R.id.menhchitiet);

        nam.setText(R.string.y);
        thang.setText(R.string.m);
        ngay.setText(R.string.d);
        ggg.setText(R.string.h);
        men.setText(R.string.menh);

        diachi = findViewById(R.id.diachi);
        nguhanh = findViewById(R.id.anhmenh);

        picker = findViewById(R.id.picker);
        button = findViewById(R.id.button);

        solar = findViewById(R.id.solar);
        lunar = findViewById(R.id.lunar);

        cannam = findViewById(R.id.yy1);
        chinam = findViewById(R.id.yy2);

        canthang = findViewById(R.id.mm1);
        chithang = findViewById(R.id.mm2);

        canngay = findViewById(R.id.dd1);
        chingay = findViewById(R.id.dd2);

        cangio = findViewById(R.id.hh1);
        chigio = findViewById(R.id.hh2);


        da = picker.getDayOfMonth();
        m = picker.getMonth()+1;
        y = picker.getYear();
        int d[]=calcu.Solar2Lunar(da,m,y);
        solar.setText(da+"/"+m+"/"+y);
        lunar.setText(d[0]+"/"+d[1]+"/"+d[2]);

        int ye = d[2];
        int yecan = ye%10;
        int yechi = ye%12;

        int s1=0;
        int s2=0;

        switch (yecan){
            case 0: cannam.setText(R.string.c7); s1=4; break;
            case 1: cannam.setText(R.string.c8); s1=4; break;
            case 2: cannam.setText(R.string.c9); s1=5; break;
            case 3: cannam.setText(R.string.c10); s1=5; break;
            case 4: cannam.setText(R.string.c1); s1=1; break;
            case 5: cannam.setText(R.string.c2); s1=1; break;
            case 6: cannam.setText(R.string.c3); s1=2; break;
            case 7: cannam.setText(R.string.c4); s1=2; break;
            case 8: cannam.setText(R.string.c5); s1=3; break;
            case 9: cannam.setText(R.string.c6); s1=3; break;
        }


        switch (yechi) {
            case 0:
                chinam.setText(R.string.ch9);
                diachi.setImageResource(R.drawable.monkey);
                s2=1;
                break;
            case 1:
                chinam.setText(R.string.ch10);
                diachi.setImageResource(R.drawable.rooster);
                s2=1;
                break;
            case 2:
                chinam.setText(R.string.ch11);
                diachi.setImageResource(R.drawable.dog);
                s2=2;
                break;
            case 3:
                chinam.setText(R.string.ch12);
                diachi.setImageResource(R.drawable.pig);
                s2=2;
                break;
            case 4:
                chinam.setText(R.string.ch1);
                diachi.setImageResource(R.drawable.rat);
                s2=0;
                break;
            case 5:
                chinam.setText(R.string.ch2);
                diachi.setImageResource(R.drawable.ox);
                s2=0;
                break;
            case 6:
                chinam.setText(R.string.ch3);
                diachi.setImageResource(R.drawable.tiger);
                s2=1;
                break;
            case 7:
                chinam.setText(R.string.ch4);
                diachi.setImageResource(R.drawable.rabbit);
                s2=1;
                break;
            case 8:
                chinam.setText(R.string.ch5);
                diachi.setImageResource(R.drawable.dragon);
                s2=2;
                break;
            case 9:
                chinam.setText(R.string.ch6);
                diachi.setImageResource(R.drawable.snake);
                s2=2;
                break;
            case 10:
                chinam.setText(R.string.ch7);
                diachi.setImageResource(R.drawable.horse);
                s2=0;
                break;
            case 11:
                chinam.setText(R.string.ch8);
                diachi.setImageResource(R.drawable.goat);
                s2=0;
                break;
        }

        int total;
        total = s1 + s2;
        if (total>5) total = total - 5;
        int menhchitiet=0;

        switch (total) {
            case 1:
                menh.setText(R.string.kim);
                if ((yechi==0) || (yechi==1)) menhchitiet=12;
                if ((yechi==2) || (yechi==3)) menhchitiet=2;
                if ((yechi==4) || (yechi==5)) menhchitiet=13;
                if ((yechi==6) || (yechi==7)) menhchitiet=9;
                if ((yechi==8) || (yechi==9)) menhchitiet=5;
                if ((yechi==10) || (yechi==11)) menhchitiet=16;
                break;
            case 2:
                menh.setText(R.string.thuy);
                if ((yechi==0) || (yechi==1)) menhchitiet=17;
                if ((yechi==2) || (yechi==3)) menhchitiet=7;
                if ((yechi==4) || (yechi==5)) menhchitiet=24;
                if ((yechi==6) || (yechi==7)) menhchitiet=14;
                if ((yechi==8) || (yechi==9)) menhchitiet=10;
                if ((yechi==10) || (yechi==11)) menhchitiet=21;
                break;
            case 3:
                menh.setText(R.string.hoa);
                if ((yechi==0) || (yechi==1)) menhchitiet=22;
                if ((yechi==2) || (yechi==3)) menhchitiet=18;
                if ((yechi==4) || (yechi==5)) menhchitiet=29;
                if ((yechi==6) || (yechi==7)) menhchitiet=19;
                if ((yechi==8) || (yechi==9)) menhchitiet=15;
                if ((yechi==10) || (yechi==11)) menhchitiet=26;
                break;
            case 4:
                menh.setText(R.string.tho);
                if ((yechi==0) || (yechi==1)) menhchitiet=27;
                if ((yechi==2) || (yechi==3)) menhchitiet=23;
                if ((yechi==4) || (yechi==5)) menhchitiet=3;
                if ((yechi==6) || (yechi==7)) menhchitiet=30;
                if ((yechi==8) || (yechi==9)) menhchitiet=20;
                if ((yechi==10) || (yechi==11)) menhchitiet=6;
                break;
            case 5:
                menh.setText(R.string.moc);
                if ((yechi==0) || (yechi==1)) menhchitiet=1;
                if ((yechi==2) || (yechi==3)) menhchitiet=28;
                if ((yechi==4) || (yechi==5)) menhchitiet=8;
                if ((yechi==6) || (yechi==7)) menhchitiet=4;
                if ((yechi==8) || (yechi==9)) menhchitiet=25;
                if ((yechi==10) || (yechi==11)) menhchitiet=11;
                break;
        }

        switch (menhchitiet) {
            case 1: menhchi.setText(R.string.hh1); break;
            case 2: menhchi.setText(R.string.hh2); break;
            case 3: menhchi.setText(R.string.hh3); break;
            case 4: menhchi.setText(R.string.hh4); break;
            case 5: menhchi.setText(R.string.hh5); break;
            case 6: menhchi.setText(R.string.hh6); break;
            case 7: menhchi.setText(R.string.hh7); break;
            case 8: menhchi.setText(R.string.hh8); break;
            case 9: menhchi.setText(R.string.hh9); break;
            case 10: menhchi.setText(R.string.hh10); break;
            case 11: menhchi.setText(R.string.hh11); break;
            case 12: menhchi.setText(R.string.hh12); break;
            case 13: menhchi.setText(R.string.hh13); break;
            case 14: menhchi.setText(R.string.hh14); break;
            case 15: menhchi.setText(R.string.hh15); break;
            case 16: menhchi.setText(R.string.hh16); break;
            case 17: menhchi.setText(R.string.hh17); break;
            case 18: menhchi.setText(R.string.hh18); break;
            case 19: menhchi.setText(R.string.hh19); break;
            case 20: menhchi.setText(R.string.hh20); break;
            case 21: menhchi.setText(R.string.hh21); break;
            case 22: menhchi.setText(R.string.hh22); break;
            case 23: menhchi.setText(R.string.hh23); break;
            case 24: menhchi.setText(R.string.hh24); break;
            case 25: menhchi.setText(R.string.hh25); break;
            case 26: menhchi.setText(R.string.hh26); break;
            case 27: menhchi.setText(R.string.hh27); break;
            case 28: menhchi.setText(R.string.hh28); break;
            case 29: menhchi.setText(R.string.hh29); break;
            case 30: menhchi.setText(R.string.hh30); break;
        }

        int mo = d[1];
        int mocan = (ye*12+mo+3)%10;
        switch (mocan) {
            case 0: canthang.setText(R.string.c1); break;
            case 1: canthang.setText(R.string.c2); break;
            case 2: canthang.setText(R.string.c3); break;
            case 3: canthang.setText(R.string.c4); break;
            case 4: canthang.setText(R.string.c5); break;
            case 5: canthang.setText(R.string.c6); break;
            case 6: canthang.setText(R.string.c7); break;
            case 7: canthang.setText(R.string.c8); break;
            case 8: canthang.setText(R.string.c9); break;
            case 9: canthang.setText(R.string.c10); break;
        }
        switch (mo) {
            case 1: chithang.setText(R.string.ch3); break;
            case 2: chithang.setText(R.string.ch4); break;
            case 3: chithang.setText(R.string.ch5); break;
            case 4: chithang.setText(R.string.ch6); break;
            case 5: chithang.setText(R.string.ch7); break;
            case 6: chithang.setText(R.string.ch8); break;
            case 7: chithang.setText(R.string.ch9); break;
            case 8: chithang.setText(R.string.ch10); break;
            case 9: chithang.setText(R.string.ch11); break;
            case 10: chithang.setText(R.string.ch12); break;
            case 11: chithang.setText(R.string.ch1); break;
            case 12: chithang.setText(R.string.ch2); break;
        }

        int dcan = Calculation.INT(Calculation.UniversalToJD(da,m,y)+9.5) % 10;
        int dchi = Calculation.INT(Calculation.UniversalToJD(da,m,y) + 1.5) % 12;

        switch (dcan) {
            case 0: canngay.setText(R.string.c1); break; //Giap
            case 1: canngay.setText(R.string.c2); break; //At
            case 2: canngay.setText(R.string.c3); break; //Binh
            case 3: canngay.setText(R.string.c4); break; //Dinh
            case 4: canngay.setText(R.string.c5); break; //Mau
            case 5: canngay.setText(R.string.c6); break; //Ky
            case 6: canngay.setText(R.string.c7); break; //Canh
            case 7: canngay.setText(R.string.c8); break; //Tan
            case 8: canngay.setText(R.string.c9); break; //Nham
            case 9: canngay.setText(R.string.c10); break; //Quy
        }

        switch (dchi) {
            case 0: {
                chingay.setText(R.string.ch1);
                break;
            }
            case 1: {
                chingay.setText(R.string.ch2);
                break;
            }
            case 2: {
                chingay.setText(R.string.ch3);
                break;
            }
            case 3: {
                chingay.setText(R.string.ch4);
                break;
            }
            case 4: {
                chingay.setText(R.string.ch5);
                break;
            }
            case 5: {
                chingay.setText(R.string.ch6);
                break;
            }
            case 6: {
                chingay.setText(R.string.ch7);
                break;
            }
            case 7: {
                chingay.setText(R.string.ch8);
                break;
            }
            case 8: {
                chingay.setText(R.string.ch9);
                break;
            }
            case 9: {
                chingay.setText(R.string.ch10);
                break;
            }
            case 10: {
                chingay.setText(R.string.ch11);
                break;
            }
            case 11: {
                chingay.setText(R.string.ch12);
                break;
            }
        }

        if ((dcan==0) || (dcan==5)) {
            if (gio==1) cangio.setText(R.string.c1);
            if (gio==2) cangio.setText(R.string.c2);
            if (gio==3) cangio.setText(R.string.c3);
            if (gio==4) cangio.setText(R.string.c4);
            if (gio==5) cangio.setText(R.string.c5);
            if (gio==6) cangio.setText(R.string.c6);
            if (gio==7) cangio.setText(R.string.c7);
            if (gio==8) cangio.setText(R.string.c8);
            if (gio==9) cangio.setText(R.string.c9);
            if (gio==10) cangio.setText(R.string.c10);
            if (gio==11) cangio.setText(R.string.c1);
            if (gio==12) cangio.setText(R.string.c2);
        }

        if ((dcan==1) || (dcan==6)) {
            if (gio==1) cangio.setText(R.string.c3);
            if (gio==2) cangio.setText(R.string.c4);
            if (gio==3) cangio.setText(R.string.c5);
            if (gio==4) cangio.setText(R.string.c6);
            if (gio==5) cangio.setText(R.string.c7);
            if (gio==6) cangio.setText(R.string.c8);
            if (gio==7) cangio.setText(R.string.c9);
            if (gio==8) cangio.setText(R.string.c10);
            if (gio==9) cangio.setText(R.string.c1);
            if (gio==10) cangio.setText(R.string.c2);
            if (gio==11) cangio.setText(R.string.c3);
            if (gio==12) cangio.setText(R.string.c4);
        }

        if ((dcan==2) || (dcan==7)) {
            if (gio==1) cangio.setText(R.string.c5);
            if (gio==2) cangio.setText(R.string.c6);
            if (gio==3) cangio.setText(R.string.c7);
            if (gio==4) cangio.setText(R.string.c8);
            if (gio==5) cangio.setText(R.string.c9);
            if (gio==6) cangio.setText(R.string.c10);
            if (gio==7) cangio.setText(R.string.c1);
            if (gio==8) cangio.setText(R.string.c2);
            if (gio==9) cangio.setText(R.string.c3);
            if (gio==10) cangio.setText(R.string.c4);
            if (gio==11) cangio.setText(R.string.c5);
            if (gio==12) cangio.setText(R.string.c6);
        }

        if ((dcan==3) || (dcan==8)) {
            if (gio==1) cangio.setText(R.string.c7);
            if (gio==2) cangio.setText(R.string.c8);
            if (gio==3) cangio.setText(R.string.c9);
            if (gio==4) cangio.setText(R.string.c10);
            if (gio==5) cangio.setText(R.string.c1);
            if (gio==6) cangio.setText(R.string.c2);
            if (gio==7) cangio.setText(R.string.c3);
            if (gio==8) cangio.setText(R.string.c4);
            if (gio==9) cangio.setText(R.string.c5);
            if (gio==10) cangio.setText(R.string.c6);
            if (gio==11) cangio.setText(R.string.c7);
            if (gio==12) cangio.setText(R.string.c8);
        }

        if ((dcan==4) || (dcan==9)) {
            if (gio==1) cangio.setText(R.string.c9);
            if (gio==2) cangio.setText(R.string.c10);
            if (gio==3) cangio.setText(R.string.c1);
            if (gio==4) cangio.setText(R.string.c2);
            if (gio==5) cangio.setText(R.string.c3);
            if (gio==6) cangio.setText(R.string.c4);
            if (gio==7) cangio.setText(R.string.c5);
            if (gio==8) cangio.setText(R.string.c6);
            if (gio==9) cangio.setText(R.string.c7);
            if (gio==10) cangio.setText(R.string.c8);
            if (gio==11) cangio.setText(R.string.c9);
            if (gio==12) cangio.setText(R.string.c10);
        }

        if (gio==1) chigio.setText(R.string.ch1);
        if (gio==2) chigio.setText(R.string.ch2);
        if (gio==3) chigio.setText(R.string.ch3);
        if (gio==4) chigio.setText(R.string.ch4);
        if (gio==5) chigio.setText(R.string.ch5);
        if (gio==6) chigio.setText(R.string.ch6);
        if (gio==7) chigio.setText(R.string.ch7);
        if (gio==8) chigio.setText(R.string.ch8);
        if (gio==9) chigio.setText(R.string.ch9);
        if (gio==10) chigio.setText(R.string.ch10);
        if (gio==11) chigio.setText(R.string.ch11);
        if (gio==12) chigio.setText(R.string.ch12);


        TextView day1 = findViewById(R.id.thu);
        int X=calcu.MOD((int)(Calculation.UniversalToJD(da,m,y)+2.5), 7);
        switch (X){
            case 7: day1.setText(R.string.sat); break;
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

        TextView tc = findViewById(R.id.tc);
        TextView tcr = findViewById(R.id.tcr);

        TextView qh11 = findViewById(R.id.qh11);
        TextView qh12 = findViewById(R.id.qh12);

        TextView qh21 = findViewById(R.id.qh21);
        TextView qh22 = findViewById(R.id.qh22);

        TextView qh31 = findViewById(R.id.qh31);

        switch (m) {
            case 1: if (da<20) {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
                ele.setText(R.string.dat);
                pla.setText(R.string.st8);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a11);
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa5);
                qh12.setText(R.string.sa9);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa10);
                qh31.setText(R.string.sa7);
            }
            else {
                star.setImageResource(R.drawable.aquarius);
                st.setText(R.string.s2);
                ele.setText(R.string.k);
                pla.setText(R.string.st8);
                pla1.setText(R.string.st9);
                ang.setText(R.string.a11);
                ang1.setText(R.string.a12);
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa6);
                qh12.setText(R.string.sa10);
                qh21.setText(R.string.sa12);
                qh22.setText(R.string.sa11);
                qh31.setText(R.string.sa8);
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
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa6);
                qh12.setText(R.string.sa10);
                qh21.setText(R.string.sa12);
                qh22.setText(R.string.sa11);
                qh31.setText(R.string.sa8);
            }
            else {
                star.setImageResource(R.drawable.pisces);
                st.setText(R.string.s3);
                ele.setText(R.string.n);
                pla.setText(R.string.st10);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a13);
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa7);
                qh12.setText(R.string.sa11);
                qh21.setText(R.string.sa6);
                qh22.setText(R.string.sa12);
                qh31.setText(R.string.sa9);
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
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa7);
                qh12.setText(R.string.sa11);
                qh21.setText(R.string.sa6);
                qh22.setText(R.string.sa12);
                qh31.setText(R.string.sa9);

            }
            else {
                star.setImageResource(R.drawable.aries);
                st.setText(R.string.s4);
                ele.setText(R.string.l);
                pla.setText(R.string.st1);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a1);
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa8);
                qh12.setText(R.string.sa12);
                qh21.setText(R.string.sa7);
                qh22.setText(R.string.sa1);
                qh31.setText(R.string.sa10);
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
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa8);
                qh12.setText(R.string.sa12);
                qh21.setText(R.string.sa7);
                qh22.setText(R.string.sa1);
                qh31.setText(R.string.sa10);
            }
            else {
                star.setImageResource(R.drawable.taurus);
                st.setText(R.string.s5);
                ele.setText(R.string.dat);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a2);
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa9);
                qh12.setText(R.string.sa1);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa8);
                qh31.setText(R.string.sa11);
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
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa9);
                qh12.setText(R.string.sa1);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa8);
                qh31.setText(R.string.sa11);
            }
            else {
                star.setImageResource(R.drawable.gemini);
                st.setText(R.string.s6);
                ele.setText(R.string.k);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a3);
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa10);
                qh12.setText(R.string.sa2);
                qh21.setText(R.string.sa9);
                qh22.setText(R.string.sa3);
                qh31.setText(R.string.sa12);
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
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa10);
                qh12.setText(R.string.sa2);
                qh21.setText(R.string.sa9);
                qh22.setText(R.string.sa3);
                qh31.setText(R.string.sa12);
            }
            else {
                star.setImageResource(R.drawable.cancer);
                st.setText(R.string.s7);
                ele.setText(R.string.n);
                pla.setText(R.string.st4);
                pla1.setText("");
                ang.setText(R.string.a4);
                ang1.setText(R.string.a5);
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa11);
                qh12.setText(R.string.sa3);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa10);
                qh31.setText(R.string.sa1);
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
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa11);
                qh12.setText(R.string.sa3);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa10);
                qh31.setText(R.string.sa1);
            }
            else {
                star.setImageResource(R.drawable.leo);
                st.setText(R.string.s8);
                ele.setText(R.string.l);
                pla.setText(R.string.st5);
                pla1.setText("");
                ang1.setText("");
                ang.setText(R.string.a6);
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa4);
                qh12.setText(R.string.sa12);
                qh21.setText(R.string.sa5);
                qh22.setText(R.string.sa11);
                qh31.setText(R.string.sa2);
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
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa4);
                qh12.setText(R.string.sa12);
                qh21.setText(R.string.sa5);
                qh22.setText(R.string.sa11);
                qh31.setText(R.string.sa2);
            }
            else {
                star.setImageResource(R.drawable.virgo);
                st.setText(R.string.s9);
                ele.setText(R.string.dat);
                pla.setText(R.string.st3);
                pla1.setText("");
                ang.setText(R.string.a3);
                ang.setText(R.string.a5);
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa1);
                qh12.setText(R.string.sa5);
                qh21.setText(R.string.sa12);
                qh22.setText(R.string.sa6);
                qh31.setText(R.string.sa3);
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
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa1);
                qh12.setText(R.string.sa5);
                qh21.setText(R.string.sa12);
                qh22.setText(R.string.sa6);
                qh31.setText(R.string.sa3);
            }
            else {
                star.setImageResource(R.drawable.libra);
                st.setText(R.string.s10);
                ele.setText(R.string.k);
                pla.setText(R.string.st2);
                pla1.setText("");
                ang.setText(R.string.a7);
                ang1.setText(R.string.a2);
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa6);
                qh12.setText(R.string.sa2);
                qh21.setText(R.string.sa7);
                qh22.setText(R.string.sa1);
                qh31.setText(R.string.sa4);
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
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa6);
                qh12.setText(R.string.sa2);
                qh21.setText(R.string.sa7);
                qh22.setText(R.string.sa1);
                qh31.setText(R.string.sa4);
            }
            else {
                star.setImageResource(R.drawable.scorpio);
                st.setText(R.string.s11);
                ele.setText(R.string.n);
                pla.setText(R.string.st6);
                pla1.setText("");
                ang.setText(R.string.a8);
                ang1.setText(R.string.a1);
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa3);
                qh12.setText(R.string.sa7);
                qh21.setText(R.string.sa8);
                qh22.setText(R.string.sa2);
                qh31.setText(R.string.sa5);
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
                tc.setText(R.string.tc2);
                tcr.setText(R.string.tc22);
                qh11.setText(R.string.sa3);
                qh12.setText(R.string.sa7);
                qh21.setText(R.string.sa8);
                qh22.setText(R.string.sa2);
                qh31.setText(R.string.sa5);
            }
            else {
                star.setImageResource(R.drawable.sagittarius);
                st.setText(R.string.s12);
                ele.setText(R.string.l);
                pla.setText(R.string.st7);
                pla1.setText("");
                ang.setText(R.string.a9);
                ang1.setText(R.string.a10);
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa4);
                qh12.setText(R.string.sa8);
                qh21.setText(R.string.sa9);
                qh22.setText(R.string.sa3);
                qh31.setText(R.string.sa8);
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
                tc.setText(R.string.tc3);
                tcr.setText(R.string.tc33);
                qh11.setText(R.string.sa4);
                qh12.setText(R.string.sa8);
                qh21.setText(R.string.sa9);
                qh22.setText(R.string.sa3);
                qh31.setText(R.string.sa8);
            }
            else {
                star.setImageResource(R.drawable.capricorn);
                st.setText(R.string.s1);
                ele.setText(R.string.dat);
                pla.setText(R.string.st8);
                pla1.setText("");
                ang.setText(R.string.a11);
                ang1.setText("");
                tc.setText(R.string.tc1);
                tcr.setText(R.string.tc11);
                qh11.setText(R.string.sa5);
                qh12.setText(R.string.sa9);
                qh21.setText(R.string.sa4);
                qh22.setText(R.string.sa10);
                qh31.setText(R.string.sa7);
            }
                break;
        }



    }
}
