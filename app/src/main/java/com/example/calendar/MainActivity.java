package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    Calculation calculation;
    DuongLich duongLich = new DuongLich();
    AmLich amLich = new AmLich();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);

        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.search) {
                    startActivity(new Intent(MainActivity.this,SearchActivity.class));
                    Toast.makeText(MainActivity.this,"Search",Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.aboutme) {
                    Toast.makeText(MainActivity.this,"About me",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        final Calendar c = Calendar.getInstance();

        /*Declare Variable*/
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);


        /*Calculate*/

        int day[] = Calculation.Solar2Lunar(d,m,y);

        int da = day[0];
        int mo = day[1];
        int ye = day[2];

        duongLich.findSolarInformation(d,m);
        int dayId = duongLich.findDay(d,m,y);

        int leaps = duongLich.checkLeapYear(y);
        int leapl = amLich.checkLeapYear(ye);

        amLich.findCanChiNam(ye);


        amLich.findCanThang(mo, ye);
        amLich.findChiThang(mo);

        amLich.findCanNgay(d, m, y);
        amLich.findChiNgay(d, m, y);
        amLich.findChiNgayduongLich(d, m, y);

        amLich.findCanGio(hour, d, m, y);
        amLich.findChiGio(hour);

        amLich.findGioHoangDao(d, m, y);

        /*Find place to put result*/
        TextView leapd = (TextView) findViewById(R.id.leapd);
        TextView leapa = (TextView) findViewById(R.id.leapa);


        TextView gg = (TextView) findViewById(R.id.textView);

        ImageView star = findViewById(R.id.star);
        TextView st = findViewById(R.id.st);

        TextView day1 = findViewById(R.id.date);
        TextView gg3 = findViewById(R.id.tv2);

        TextView y1 = findViewById(R.id.year1);
        TextView y2 = findViewById(R.id.year2);

        TextView m1 = findViewById(R.id.month1);
        TextView m2 = findViewById(R.id.month2);

        TextView d1 = findViewById(R.id.day1);
        TextView d2 = findViewById(R.id.day2);

        ImageView ngay = findViewById(R.id.ngay);

        TextView h1 = findViewById(R.id.hour1);
        TextView h2 = findViewById(R.id.hour2);

        TextView lh = findViewById(R.id.luckyhour);

        /*Fetch Result*/

        gg.setText(d + "/" + m + "/" + y);

        leapd.setText(leaps);
        leapa.setText(leapl);

        star.setImageResource(duongLich.imgSrc);

        day1.setText(dayId);
        st.setText(duongLich.star);


        gg3.setText(da+"/"+mo+"/"+ye);

        y1.setText(amLich.cannam);
        y2.setText(amLich.chinam);

        m1.setText(amLich.canthang);
        m2.setText(amLich.chithang);

        d1.setText(amLich.canngay);
        d2.setText(amLich.chingay);

        ngay.setImageResource(amLich.chingaysrc);

        h1.setText(amLich.cangio);
        h2.setText(amLich.chigio);

        lh.setText(amLich.luckyhour);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }




}
