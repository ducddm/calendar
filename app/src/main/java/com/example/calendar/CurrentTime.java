package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.ChineseCalendar;
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

        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);

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
        int X=MOD((int)(UniversalToJD(d,m,y)+2.5), 7);
        switch (X){
            case 0: day1.setText(R.string.sat); break;
            case 1: day1.setText(R.string.sun); break;
            case 2: day1.setText(R.string.mon); break;
            case 3: day1.setText(R.string.tue); break;
            case 4: day1.setText(R.string.wed); break;
            case 5: day1.setText(R.string.thu); break;
            case 6: day1.setText(R.string.fri); break;
        }



        TextView gg3 = findViewById(R.id.tv2);
        int day[] = Solar2Lunar(d,m,y);
        gg3.setText(day[0]+"/"+day[1]+"/"+day[2]);


    }

    public static int INT(double d) {
        return (int)Math.floor(d);
    }

    public static int MOD(int x, int y) {
        int z = x - (int)(y * Math.floor(((double)x / y)));
        if (z == 0) {
            z = y;
        }
        return z;
    }

    public static double UniversalToJD(int D, int M, int Y) {
        double JD;
        if (Y > 1582 || (Y == 1582 && M > 10) || (Y == 1582 && M == 10 && D > 14)) {
            JD = 367*Y - INT(7*(Y+INT((M+9)/12))/4) - INT(3*(INT((Y+(M-9)/7)/100)+1)/4) + INT(275*M/9)+D+1721028.5;
        } else {
            JD = 367*Y - INT(7*(Y+5001+INT((M-9)/7))/4) + INT(275*M/9)+D+1729776.5;
        }
        return JD;
    }

    public static int[] UniversalFromJD(double JD) {
        int Z, A, alpha, B, C, D, E, dd, mm, yyyy;
        double F;
        Z = INT(JD+0.5);
        F = (JD+0.5)-Z;
        if (Z < 2299161) {
            A = Z;
        } else {
            alpha = INT((Z-1867216.25)/36524.25);
            A = Z + 1 + alpha - INT(alpha/4);
        }
        B = A + 1524;
        C = INT( (B-122.1)/365.25);
        D = INT( 365.25*C );
        E = INT( (B-D)/30.6001 );
        dd = INT(B - D - INT(30.6001*E) + F);
        if (E < 14) {
            mm = E - 1;
        } else {
            mm = E - 13;
        }
        if (mm < 3) {
            yyyy = C - 4715;
        } else {
            yyyy = C - 4716;
        }
        return new int[]{dd, mm, yyyy};
    }



    public static int[] LocalFromJD(double JD) {
        return UniversalFromJD(JD + 7/24.0);
    }

    public static double LocalToJD(int D, int M, int Y) {
        return UniversalToJD(D, M, Y) - 7/24.0;
    }

    public static double NewMoon(int k) {
        double T = k/1236.85; // Time in Julian centuries from 1900 January 0.5
        double T2 = T * T;
        double T3 = T2 * T;
        double dr = Math.PI/180;
        double Jd1 = 2415020.75933 + 29.53058868*k + 0.0001178*T2 - 0.000000155*T3;
        Jd1 = Jd1 + 0.00033*Math.sin((166.56 + 132.87*T - 0.009173*T2)*dr); // Mean new moon
        double M = 359.2242 + 29.10535608*k - 0.0000333*T2 - 0.00000347*T3; // Sun's mean anomaly
        double Mpr = 306.0253 + 385.81691806*k + 0.0107306*T2 + 0.00001236*T3; // Moon's mean anomaly
        double F = 21.2964 + 390.67050646*k - 0.0016528*T2 - 0.00000239*T3; // Moon's argument of latitude
        double C1=(0.1734 - 0.000393*T)*Math.sin(M*dr) + 0.0021*Math.sin(2*dr*M);
        C1 = C1 - 0.4068*Math.sin(Mpr*dr) + 0.0161*Math.sin(dr*2*Mpr);
        C1 = C1 - 0.0004*Math.sin(dr*3*Mpr);
        C1 = C1 + 0.0104*Math.sin(dr*2*F) - 0.0051*Math.sin(dr*(M+Mpr));
        C1 = C1 - 0.0074*Math.sin(dr*(M-Mpr)) + 0.0004*Math.sin(dr*(2*F+M));
        C1 = C1 - 0.0004*Math.sin(dr*(2*F-M)) - 0.0006*Math.sin(dr*(2*F+Mpr));
        C1 = C1 + 0.0010*Math.sin(dr*(2*F-Mpr)) + 0.0005*Math.sin(dr*(2*Mpr+M));
        double deltat;
        if (T < -11) {
            deltat= 0.001 + 0.000839*T + 0.0002261*T2 - 0.00000845*T3 - 0.000000081*T*T3;
        } else {
            deltat= -0.000278 + 0.000265*T + 0.000262*T2;
        };
        double JdNew = Jd1 + C1 - deltat;
        return JdNew;
    }

    public static double SunLongitude(double jdn) {
        double T = (jdn - 2451545.0 ) / 36525; // Time in Julian centuries from 2000-01-01 12:00:00 GMT
        double T2 = T*T;
        double dr = Math.PI/180; // degree to radian
        double M = 357.52910 + 35999.05030*T - 0.0001559*T2 - 0.00000048*T*T2; // mean anomaly, degree
        double L0 = 280.46645 + 36000.76983*T + 0.0003032*T2; // mean longitude, degree
        double DL = (1.914600 - 0.004817*T - 0.000014*T2)*Math.sin(dr*M);
        DL = DL + (0.019993 - 0.000101*T)*Math.sin(dr*2*M) + 0.000290*Math.sin(dr*3*M);
        double L = L0 + DL; // true longitude, degree
        L = L*dr;
        L = L - Math.PI*2*(INT(L/(Math.PI*2))); // Normalize to (0, 2*PI)
        return L;
    }

    public static int[] LunarMonth11(int Y) {
        double off = LocalToJD(31, 12, Y) - 2415021.076998695;
        int k = INT(off / 29.530588853);
        double jd = NewMoon(k);
        int[] ret = LocalFromJD(jd);
        double sunLong = SunLongitude(LocalToJD(ret[0], ret[1], ret[2])); // sun longitude at local midnight
        if (sunLong > 3*Math.PI/2) {
            jd = NewMoon(k-1);
        }
        return LocalFromJD(jd);
    }

    public static final double[] SUNLONG_MAJOR = new double[] {
            0, Math.PI/6, 2*Math.PI/6, 3*Math.PI/6, 4*Math.PI/6, 5*Math.PI/6, Math.PI, 7*Math.PI/6, 8*Math.PI/6, 9*Math.PI/6, 10*Math.PI/6, 11*Math.PI/6
    };

    public static int[][] LunarYear(int Y) {
        int[][] ret = null;
        int[] month11A = LunarMonth11(Y-1);
        double jdMonth11A = LocalToJD(month11A[0], month11A[1], month11A[2]);
        int k = (int)Math.floor(0.5 + (jdMonth11A - 2415021.076998695) / 29.530588853);
        int[] month11B = LunarMonth11(Y);
        double off = LocalToJD(month11B[0], month11B[1], month11B[2]) - jdMonth11A;
        boolean leap = off > 365.0;
        if (!leap) {
            ret = new int[13][5];
        } else {
            ret = new int[14][5];
        }
        ret[0] = new int[]{month11A[0], month11A[1], month11A[2], 0, 0};
        ret[ret.length - 1] = new int[]{month11B[0], month11B[1], month11B[2], 0, 0};
        for (int i = 1; i < ret.length - 1; i++) {
            double nm = NewMoon(k+i);
            int[] a = LocalFromJD(nm);
            ret[i] = new int[]{a[0], a[1], a[2], 0, 0};
        }
        for (int i = 0; i < ret.length; i++) {
            ret[i][3] = MOD(i + 11, 12);
        }
        if (leap) {
            initLeapYear(ret);
        }
        return ret;
    }

    static void initLeapYear(int[][] ret) {
        double[] sunLongitudes = new double[ret.length];
        for (int i = 0; i < ret.length; i++) {
            int[] a = ret[i];
            double jdAtMonthBegin = LocalToJD(a[0], a[1], a[2]);
            sunLongitudes[i] = SunLongitude(jdAtMonthBegin);
        }
        boolean found = false;
        for (int i = 0; i < ret.length; i++) {
            if (found) {
                ret[i][3] = MOD(i+10, 12);
                continue;
            }
            double sl1 = sunLongitudes[i];
            double sl2 = sunLongitudes[i+1];
            boolean hasMajorTerm = Math.floor(sl1/Math.PI*6) != Math.floor(sl2/Math.PI*6);
            if (!hasMajorTerm) {
                found = true;
                ret[i][4] = 1;
                ret[i][3] = MOD(i+10, 12);
            }
        }
    }

    public static int[] Solar2Lunar(int D, int M, int Y) {
        int yy = Y;
        int[][] ly = LunarYear(Y); // Please cache the result of this computation for later use!!!
        int[] month11 = ly[ly.length - 1];
        double jdToday = LocalToJD(D, M, Y);
        double jdMonth11 = LocalToJD(month11[0], month11[1], month11[2]);
        if (jdToday >= jdMonth11) {
            ly = LunarYear(Y+1);
            yy = Y + 1;
        }
        int i = ly.length - 1;
        while (jdToday < LocalToJD(ly[i][0], ly[i][1], ly[i][2])) {
            i--;
        }
        int dd = (int)(jdToday - LocalToJD(ly[i][0], ly[i][1], ly[i][2])) + 1;
        int mm = ly[i][3];
        if (mm >= 11) {
            yy--;
        }
        return new int[] {dd, mm, yy, ly[i][4]};
    }

}
