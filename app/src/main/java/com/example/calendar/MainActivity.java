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

        int day[] = Calculation.Solar2Lunar(d,m,y);

        int da = day[0];
        int mo = day[1];
        int ye = day[2];

        /*Calculate*/
        duongLich.findSolarInformation(d,m);
        int dayId = duongLich.findDay(d,m,y);

        int leaps = duongLich.checkLeapYear(y);
        int leapl = amLich.checkLeapYear(da, mo, ye);

        int cany = amLich.findCanNam(da, mo, ye);
        int chiy = amLich.findChiNam(da, mo, ye);

        int canm = amLich.findCanThang(da, mo, ye);
        int chim = amLich.findChiThang(da, mo, ye);

        int cand = amLich.findCanNgay(d, m, y);
        int chid = amLich.findChiNgay(d, m, y);
        int imgchid = amLich.findChiNgayduongLich(d, m, y);

        int canh = amLich.findCanGio(hour, d, m, y);
        int chih = amLich.findChiGio(hour);

        int luckyHour = amLich.findGioHoangDao(d, m, y);

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

        y1.setText(cany);
        y2.setText(chiy);

        m1.setText(canm);
        m2.setText(chim);

        d1.setText(cand);
        d2.setText(chid);

        ngay.setImageResource(imgchid);

        h1.setText(canh);
        h2.setText(chih);

        lh.setText(luckyHour);




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }




}
