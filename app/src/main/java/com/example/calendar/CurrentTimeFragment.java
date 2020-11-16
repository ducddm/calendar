package com.example.calendar;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class CurrentTimeFragment extends Fragment {

    private String title;
    private int page;

    Calculation calculation;
    DuongLich duongLich = new DuongLich();
    AmLich amLich = new AmLich();

    public static CurrentTimeFragment newInstance(int page, String title) {
        CurrentTimeFragment fragment = new CurrentTimeFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt("someInt", 0);
            title = getArguments().getString("someTitle");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_time, container, false);
        final Calendar c = Calendar.getInstance();

        /*Declare Variable*/
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);

        int tz = 7;

        /*Calculate*/

        int day[] = Calculation.convertSolar2Lunar(d,m,y,tz);

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
        LinearLayout currentTime = view.findViewById(R.id.currentTime);

        TextView leapd = currentTime.findViewById(R.id.leapd);
        TextView leapa = currentTime.findViewById(R.id.leapa);


        TextView gg = currentTime.findViewById(R.id.textView);

        ImageView star = currentTime.findViewById(R.id.star);
        TextView st = currentTime.findViewById(R.id.st);

        TextView day1 = currentTime.findViewById(R.id.date);
        TextView gg3 = currentTime.findViewById(R.id.tv2);

        TextView y1 = currentTime.findViewById(R.id.year1);
        TextView y2 = currentTime.findViewById(R.id.year2);

        TextView m1 = currentTime.findViewById(R.id.month1);
        TextView m2 = currentTime.findViewById(R.id.month2);

        TextView d1 = currentTime.findViewById(R.id.day1);
        TextView d2 = currentTime.findViewById(R.id.day2);

        ImageView ngay = currentTime.findViewById(R.id.ngay);

        TextView h1 = currentTime.findViewById(R.id.hour1);
        TextView h2 = currentTime.findViewById(R.id.hour2);

        TextView lh = currentTime.findViewById(R.id.luckyhour);

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
        return view;
    }


}
