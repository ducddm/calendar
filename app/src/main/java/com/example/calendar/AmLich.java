package com.example.calendar;

public class AmLich {

    public  Calculation calculation = new Calculation();
    /* Tim can, chi nam, thang, ngay va gio nam am lich */

    public  int findCanNam(int d, int m, int y) {
        int day[] = calculation.Solar2Lunar(d,m,y);
        int ye = day[2];
        int yecan = ye%10;
        int canID = 0;
        switch (yecan){
            case 0: canID = (R.string.c7); break;
            case 1: canID = (R.string.c8); break;
            case 2: canID = (R.string.c9); break;
            case 3: canID = (R.string.c10); break;
            case 4: canID = (R.string.c1); break;
            case 5: canID = (R.string.c2); break;
            case 6: canID = (R.string.c3); break;
            case 7: canID = (R.string.c4); break;
            case 8: canID = (R.string.c5); break;
            case 9: canID = (R.string.c6); break;
        }
        return canID;
    }

    public  int findChiNam(int d, int m, int y) {
        int day[] = calculation.Solar2Lunar(d,m,y);
        int ye = day[2];
        int yechi = ye%12;
        int chiID = 0;
        switch (yechi) {
            case 0: chiID = R.string.ch9; break;
            case 1: chiID = R.string.ch10; break;
            case 2: chiID = R.string.ch11; break;
            case 3: chiID = R.string.ch12; break;
            case 4: chiID = R.string.ch1; break;
            case 5: chiID = R.string.ch2; break;
            case 6: chiID = R.string.ch3; break;
            case 7: chiID = R.string.ch4; break;
            case 8: chiID = R.string.ch5; break;
            case 9: chiID = R.string.ch6; break;
            case 10: chiID = R.string.ch7; break;
            case 11: chiID = R.string.ch8; break;
        }
        return chiID;
    }

    public  int findCanThang(int d, int m, int y) {
        int day[] = calculation.Solar2Lunar(d,m,y);
        int me = day[1];
        int ye = day[2];
        int mocan = (ye *12 + me+3)%10;
        int m1 = 0;
        switch (mocan) {
            case 0: m1 = R.string.c1; break;
            case 1: m1 = R.string.c2; break;
            case 2: m1 = R.string.c3; break;
            case 3: m1 = R.string.c4; break;
            case 4: m1 = R.string.c5; break;
            case 5: m1 = R.string.c6; break;
            case 6: m1 = R.string.c7; break;
            case 7: m1 = R.string.c8; break;
            case 8: m1 = R.string.c9; break;
            case 9: m1 = R.string.c10; break;
        }
        return m1;
    }

    public  int findChiThang(int d, int m, int y) {
        int day[] = calculation.Solar2Lunar(d,m,y);
        int mo = day[1];
        int m2 = 0;
        switch (mo) {
            case 1: m2 = (R.string.ch3); break;
            case 2: m2 = (R.string.ch4); break;
            case 3: m2 = (R.string.ch5); break;
            case 4: m2 = (R.string.ch6); break;
            case 5: m2 = (R.string.ch7); break;
            case 6: m2 = (R.string.ch8); break;
            case 7: m2 = (R.string.ch9); break;
            case 8: m2 = (R.string.ch10); break;
            case 9: m2 = (R.string.ch11); break;
            case 10: m2 = (R.string.ch12); break;
            case 11: m2 = (R.string.ch1); break;
            case 12: m2 = (R.string.ch2); break;
        }
        return m2;
    }

    public  int findCanNgay(int d, int m, int y) {
        int dcan = calculation.INT(calculation.UniversalToJD(d,m,y)+9.5) % 10;
        int canNgayID = 0;
        switch (dcan) {
            case 0: canNgayID =(R.string.c1); break;
            case 1: canNgayID =(R.string.c2); break;
            case 2: canNgayID =(R.string.c3); break;
            case 3: canNgayID =(R.string.c4); break;
            case 4: canNgayID =(R.string.c5); break;
            case 5: canNgayID =(R.string.c6); break;
            case 6: canNgayID =(R.string.c7); break;
            case 7: canNgayID =(R.string.c8); break;
            case 8: canNgayID =(R.string.c9); break;
            case 9: canNgayID =(R.string.c10); break;
        }
        return canNgayID;
    }

    public  int findChiNgay(int d, int m, int y) {
        int dchi = calculation.INT(calculation.UniversalToJD(d,m,y) + 1.5) % 12;
        int chiNgayID = 0;
        switch (dchi) {
            case 0: {
                chiNgayID =(R.string.ch1);
                break;
            }
            case 1: {
                chiNgayID =(R.string.ch2);
                break;
            }
            case 2: {
                chiNgayID =(R.string.ch3);
                break;
            }
            case 3: {
                chiNgayID =(R.string.ch4);
                break;
            }
            case 4: {
                chiNgayID =(R.string.ch5);
                break;
            }
            case 5: {
                chiNgayID =(R.string.ch6);
                break;
            }
            case 6: {
                chiNgayID =(R.string.ch7);
                break;
            }
            case 7: {
                chiNgayID =(R.string.ch8);
                break;
            }
            case 8: {
                chiNgayID =(R.string.ch9);
                break;
            }
            case 9: {
                chiNgayID =(R.string.ch10);
                break;
            }
            case 10: {
                chiNgayID =(R.string.ch11);
                break;
            }
            case 11: {
                chiNgayID =(R.string.ch12);
                break;
            }
        }
        return chiNgayID;
    }

    public  int findChiNgayduongLich(int d, int m, int y) {
        int dchi = calculation.INT(calculation.UniversalToJD(d,m,y) + 1.5) % 12;
        int chiduongLich = 0;
        switch (dchi) {
            case 0: {
                chiduongLich =(R.drawable.rat);
                break;
            }
            case 1: {
                chiduongLich =(R.drawable.ox);
                break;
            }
            case 2: {
                chiduongLich =(R.drawable.tiger);
                break;
            }
            case 3: {
                chiduongLich =(R.drawable.rabbit);
                break;
            }
            case 4: {
                chiduongLich =(R.drawable.dragon);
                break;
            }
            case 5: {
                chiduongLich =(R.drawable.snake);
                break;
            }
            case 6: {
                chiduongLich =(R.drawable.horse);
                break;
            }
            case 7: {
                chiduongLich =(R.drawable.goat);
                break;
            }
            case 8: {
                chiduongLich =(R.drawable.monkey);
                break;
            }
            case 9: {
                chiduongLich =(R.drawable.rooster);
                break;
            }
            case 10: {
                chiduongLich =(R.drawable.dog);
                break;
            }
            case 11: {
                chiduongLich =(R.drawable.pig);
                break;
            }
        }
        return chiduongLich;
    }

    public  int findCanGio(int h, int d, int m, int y){
        int dcan = calculation.INT(calculation.UniversalToJD(d,m,y)+9.5) % 10;
        int dchi = calculation.INT(calculation.UniversalToJD(d,m,y) + 1.5) % 12;
        int canGioID = 0;
        if ((dcan==0) || (dcan==5)) {
            if ((h==23) || (h==0)) canGioID = (R.string.c1);
            if ((h==1) || (h==2)) canGioID = (R.string.c2);
            if ((h==3) || (h==4)) canGioID = (R.string.c3);
            if ((h==5) || (h==6)) canGioID = (R.string.c4);
            if ((h==7) || (h==8)) canGioID = (R.string.c5);
            if ((h==9) || (h==10)) canGioID = (R.string.c6);
            if ((h==11) || (h==12)) canGioID = (R.string.c7);
            if ((h==13) || (h==14)) canGioID = (R.string.c8);
            if ((h==15) || (h==16)) canGioID = (R.string.c9);
            if ((h==17) || (h==18)) canGioID = (R.string.c10);
            if ((h==19) || (h==20)) canGioID = (R.string.c1);
            if ((h==21) || (h==22)) canGioID = (R.string.c2);
        }

        if ((dcan==1) || (dcan==6)) {
            if ((h==23) || (h==0)) canGioID = (R.string.c3);
            if ((h==1) || (h==2)) canGioID = (R.string.c4);
            if ((h==3) || (h==4)) canGioID = (R.string.c5);
            if ((h==5) || (h==6)) canGioID = (R.string.c6);
            if ((h==7) || (h==8)) canGioID = (R.string.c7);
            if ((h==9) || (h==10)) canGioID = (R.string.c8);
            if ((h==11) || (h==12)) canGioID = (R.string.c9);
            if ((h==13) || (h==14)) canGioID = (R.string.c10);
            if ((h==15) || (h==16)) canGioID = (R.string.c1);
            if ((h==17) || (h==18)) canGioID = (R.string.c2);
            if ((h==19) || (h==20)) canGioID = (R.string.c3);
            if ((h==21) || (h==22)) canGioID = (R.string.c4);
        }

        if ((dcan==2) || (dcan==7)) {
            if ((h==23) || (h==0)) canGioID = (R.string.c5);
            if ((h==1) || (h==2)) canGioID = (R.string.c6);
            if ((h==3) || (h==4)) canGioID = (R.string.c7);
            if ((h==5) || (h==6)) canGioID = (R.string.c8);
            if ((h==7) || (h==8)) canGioID = (R.string.c9);
            if ((h==9) || (h==10)) canGioID = (R.string.c10);
            if ((h==11) || (h==12)) canGioID = (R.string.c1);
            if ((h==13) || (h==14)) canGioID = (R.string.c2);
            if ((h==15) || (h==16)) canGioID = (R.string.c3);
            if ((h==17) || (h==18)) canGioID = (R.string.c4);
            if ((h==19) || (h==20)) canGioID = (R.string.c5);
            if ((h==21) || (h==22)) canGioID = (R.string.c6);
        }

        if ((dcan==3) || (dcan==8)) {
            if ((h==23) || (h==0)) canGioID = (R.string.c7);
            if ((h==1) || (h==2)) canGioID = (R.string.c8);
            if ((h==3) || (h==4)) canGioID = (R.string.c9);
            if ((h==5) || (h==6)) canGioID = (R.string.c10);
            if ((h==7) || (h==8)) canGioID = (R.string.c1);
            if ((h==9) || (h==10)) canGioID = (R.string.c2);
            if ((h==11) || (h==12)) canGioID = (R.string.c3);
            if ((h==13) || (h==14)) canGioID = (R.string.c4);
            if ((h==15) || (h==16)) canGioID = (R.string.c5);
            if ((h==17) || (h==18)) canGioID = (R.string.c6);
            if ((h==19) || (h==20)) canGioID = (R.string.c7);
            if ((h==21) || (h==22)) canGioID = (R.string.c8);
        }

        if ((dcan==4) || (dcan==9)) {
            if ((h==23) || (h==0)) canGioID = (R.string.c9);
            if ((h==1) || (h==2)) canGioID = (R.string.c10);
            if ((h==3) || (h==4)) canGioID = (R.string.c1);
            if ((h==5) || (h==6)) canGioID = (R.string.c2);
            if ((h==7) || (h==8)) canGioID = (R.string.c3);
            if ((h==9) || (h==10)) canGioID = (R.string.c4);
            if ((h==11) || (h==12)) canGioID = (R.string.c5);
            if ((h==13) || (h==14)) canGioID = (R.string.c6);
            if ((h==15) || (h==16)) canGioID = (R.string.c7);
            if ((h==17) || (h==18)) canGioID = (R.string.c8);
            if ((h==19) || (h==20)) canGioID = (R.string.c9);
            if ((h==21) || (h==22)) canGioID = (R.string.c10);
        }

        return canGioID;

    }

    public  int findChiGio(int h) {
        int chiGioID = 0;
        if ((h==23) || (h==0)) chiGioID = (R.string.ch1);
        if ((h==1) || (h==2)) chiGioID = (R.string.ch2);
        if ((h==3) || (h==4)) chiGioID = (R.string.ch3);
        if ((h==5) || (h==6)) chiGioID = (R.string.ch4);
        if ((h==7) || (h==8)) chiGioID = (R.string.ch5);
        if ((h==9) || (h==10)) chiGioID = (R.string.ch6);
        if ((h==11) || (h==12)) chiGioID = (R.string.ch7);
        if ((h==13) || (h==14)) chiGioID = (R.string.ch8);
        if ((h==15) || (h==16)) chiGioID = (R.string.ch9);
        if ((h==17) || (h==18)) chiGioID = (R.string.ch10);
        if ((h==19) || (h==20)) chiGioID = (R.string.ch11);
        if ((h==21) || (h==22)) chiGioID = (R.string.ch12);

        return chiGioID;
    }

    public  int findGioHoangDao(int d, int m, int y) {
        int dchi = calculation.INT(calculation.UniversalToJD(d,m,y) + 1.5) % 12;
        int gioHoangDaoID = 0;
        if ((dchi==2) || (dchi==8)) gioHoangDaoID = (R.string.h1);
        if ((dchi==3) || (dchi==9)) gioHoangDaoID = (R.string.h2);
        if ((dchi==4) || (dchi==10)) gioHoangDaoID = (R.string.h3);
        if ((dchi==5) || (dchi==11)) gioHoangDaoID = (R.string.h4);
        if ((dchi==6) || (dchi==0)) gioHoangDaoID = (R.string.h5);
        if ((dchi==7) || (dchi==1)) gioHoangDaoID = (R.string.h6);
        return gioHoangDaoID;
    }

    public int checkLeapYear(int d, int m, int y) {
        int day[] = calculation.Solar2Lunar(d,m,y);
        int ye = day[2];

        int mod = ye%19;
        int check = 0;

        if ((mod == 0) || (mod == 3) || (mod == 6) || (mod == 9) || (mod == 11) || (mod == 14) || (mod == 17)) {
            check = R.string.nhuana;
        } else {
            check = R.string.empty;
        }

        return check;
    }
}
