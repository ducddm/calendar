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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DatePicker picker;

    Calculation calcu;
    DuongLich duongLich = new DuongLich();
    AmLich amLich = new AmLich();

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
            case 0: gio = 23; break;
            case 1: gio = 1; break;
            case 2: gio = 3; break;
            case 3: gio = 5; break;
            case 4: gio = 7; break;
            case 5: gio = 9; break;
            case 6: gio = 11; break;
            case 7: gio = 13; break;
            case 8: gio = 15; break;
            case 9: gio = 17; break;
            case 10: gio = 19; break;
            case 11: gio = 21; break;
        }

    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void clickme(View view){

        /*Constant Variable*/

        /*Duong Lich*/
        TextView nhom = findViewById(R.id.nhom);
        TextView han = findViewById(R.id.hanh);
        TextView than = findViewById(R.id.than);

        TextView va1 = findViewById(R.id.va1);
        TextView va2 = findViewById(R.id.va2);

        TextView dactrung = findViewById(R.id.dt);
        TextView tinhcach = findViewById(R.id.tinhcach);

        TextView qh1 = findViewById(R.id.qh1);
        TextView qh2 = findViewById(R.id.qh2);
        TextView qh3 = findViewById(R.id.qh3);

        nhom.setText(R.string.nh);
        han.setText(R.string.ha);
        than.setText(R.string.th);

        va1.setText(R.string.va);
        va2.setText(R.string.va);

        dactrung.setText(R.string.dt);
        tinhcach.setText(R.string.tinhcach);

        qh1.setText(R.string.qh1);
        qh2.setText(R.string.qh2);
        qh3.setText(R.string.qh3);

        /*Am Lich*/

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

        /*Declare Variable*/

        /*Duong Lich*/

        TextView leapd = findViewById(R.id.leapd);
        TextView thu = findViewById(R.id.thu);
        ImageView star = findViewById(R.id.starr);
        TextView st = findViewById(R.id.sta);
        TextView ele = findViewById(R.id.ele);
        TextView pla = findViewById(R.id.pla);
        TextView pla1 = findViewById(R.id.pla1);
        TextView ang = findViewById(R.id.ang);
        TextView ang1 = findViewById(R.id.ang1);

        TextView tc = findViewById(R.id.tc);
        TextView tcr = findViewById(R.id.tcr);

        TextView qh11 = findViewById(R.id.qh11);
        TextView qh12 = findViewById(R.id.qh12);

        TextView qh21 = findViewById(R.id.qh21);
        TextView qh22 = findViewById(R.id.qh22);

        TextView qh31 = findViewById(R.id.qh31);

        /*Am Lich*/

        TextView leapa = findViewById(R.id.leapa);

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

        /*Calculation*/

        da = picker.getDayOfMonth();
        m = picker.getMonth()+1;
        y = picker.getYear();

        /*Duong Lich*/

        duongLich.findSolarInformation(da,m);
        int checkd = duongLich.checkLeapYear(y);
        int day = duongLich.findDay(da,m,y);

        /*Am Lich*/

        int d[]=calcu.Solar2Lunar(da,m,y);

        int ye = d[2];
        int mo = d[1];
        int dat = d[0];

        int checka = amLich.checkLeapYear(ye);

        amLich.findCanChiNam(ye);

        amLich.findCanThang(mo,ye);
        amLich.findChiThang(mo);

        amLich.findCanNgay(da, m, y);
        amLich.findChiNgay(da, m, y);
        amLich.findChiNgayduongLich(da, m, y);

        amLich.findCanGio(gio, da, m, y);
        amLich.findChiGio(gio);


        /*Fetch Result*/

        /*Duong Lich*/

        leapd.setText(checkd);
        thu.setText(day);
        star.setImageResource(duongLich.imgSrc);
        st.setText(duongLich.star);
        ele.setText(duongLich.ele);
        pla.setText(duongLich.st);
        pla1.setText(duongLich.st1);
        ang1.setText(duongLich.ang1);
        ang.setText(duongLich.ang);
        tc.setText(duongLich.tc);
        tcr.setText(duongLich.tcr);

        qh11.setText(duongLich.qh11);
        qh12.setText(duongLich.qh12);

        qh21.setText(duongLich.qh21);
        qh22.setText(duongLich.qh22);

        qh31.setText(duongLich.qh31);

        /*Am Lich*/

        leapa.setText(checka);

        solar.setText(da+"/"+m+"/"+y);
        lunar.setText(dat+"/"+mo+"/"+ye);

        cannam.setText(amLich.cannam);
        chinam.setText(amLich.chinam);
        diachi.setImageResource(amLich.chinamsrc);

        nguhanh.setImageResource(amLich.nguHanhsrc);
        menh.setText(amLich.menh);
        menhchi.setText(amLich.menhchitiet);

        canthang.setText(amLich.canthang);
        chithang.setText(amLich.chithang);

        canngay.setText(amLich.canngay);
        chingay.setText(amLich.chingay);

        cangio.setText(amLich.cangio);
        chigio.setText(amLich.chigio);


        TextView day1 = findViewById(R.id.thu);


    }
}
