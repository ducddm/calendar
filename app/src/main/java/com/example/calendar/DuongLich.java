package com.example.calendar;

public class DuongLich {
    int imgSrc, star, ele;
    int st, st1;
    int ang, ang1;
    int tc, tcr;
    int qh11, qh12;
    int qh21, qh22;
    int qh31;

    public static Calculation calculation = new Calculation();

    public int checkLeapYear(int y) {
        int check = 0;
        if (y % 100 == 0) {
            if (y % 400 == 0) {
                check = R.string.nhuand;
            } else {
                check = R.string.empty;
            }
        } else {
            if (y % 4 == 0){
                check = R.string.nhuand;
            } else {
                check = R.string.empty;
            }
        }
        return check;
    }

    public void findSolarInformation(int d, int m) {
        switch (m) {
            case 1: if (d<20) {
                this.imgSrc =  (R.drawable.capricorn);
                this.star = (R.string.s1);
                this.ele = (R.string.dat);
                this.st = (R.string.st8);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a11);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa5);
                this.qh12 = (R.string.sa9);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa10);
                this.qh31 = (R.string.sa7);
            }
            else {
                this.imgSrc =  (R.drawable.aquarius);
                this.star = (R.string.s2);
                this.ele = (R.string.k);
                this.st = (R.string.st8);
                this.st1 = (R.string.st9);
                this.ang = (R.string.a11);
                this.ang1 = (R.string.a12);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa6);
                this.qh12 = (R.string.sa10);
                this.qh21 = (R.string.sa12);
                this.qh22 = (R.string.sa11);
                this.qh31 = (R.string.sa8);
            }
                break;

            case 2: if (d<19) {
                this.imgSrc =  (R.drawable.aquarius);
                this.star = (R.string.s2);
                this.ele = (R.string.k);
                this.st = (R.string.st8);
                this.st1 = (R.string.st9);
                this.ang = (R.string.a11);
                this.ang1 = (R.string.a12);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa6);
                this.qh12 = (R.string.sa10);
                this.qh21 = (R.string.sa12);
                this.qh22 = (R.string.sa11);
                this.qh31 = (R.string.sa8);
            }
            else {
                this.imgSrc =  (R.drawable.pisces);
                this.star = (R.string.s3);
                this.ele = (R.string.n);
                this.st = (R.string.st10);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a13);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa7);
                this.qh12 = (R.string.sa11);
                this.qh21 = (R.string.sa6);
                this.qh22 = (R.string.sa12);
                this.qh31 = (R.string.sa9);
            }
                break;

            case 3: if (d<21) {
                this.imgSrc =  (R.drawable.pisces);
                this.star = (R.string.s3);
                this.ele = (R.string.n);
                this.st = (R.string.st10);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a13);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa7);
                this.qh12 = (R.string.sa11);
                this.qh21 = (R.string.sa6);
                this.qh22 = (R.string.sa12);
                this.qh31 = (R.string.sa9);

            }
            else {
                this.imgSrc =  (R.drawable.aries);
                this.star = (R.string.s4);
                this.ele = (R.string.l);
                this.st = (R.string.st1);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a1);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa8);
                this.qh12 = (R.string.sa12);
                this.qh21 = (R.string.sa7);
                this.qh22 = (R.string.sa1);
                this.qh31 = (R.string.sa10);
            }
                break;

            case 4: if (d<20) {
                this.imgSrc =  (R.drawable.aries);
                this.star = (R.string.s4);
                this.ele = (R.string.l);
                this.st = (R.string.st1);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a1);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa8);
                this.qh12 = (R.string.sa12);
                this.qh21 = (R.string.sa7);
                this.qh22 = (R.string.sa1);
                this.qh31 = (R.string.sa10);
            }
            else {
                this.imgSrc =  (R.drawable.taurus);
                this.star = (R.string.s5);
                this.ele = (R.string.dat);
                this.st = (R.string.st2);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a2);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa9);
                this.qh12 = (R.string.sa1);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa8);
                this.qh31 = (R.string.sa11);
            }
                break;

            case 5: if (d<21) {
                this.imgSrc =  (R.drawable.taurus);
                this.star = (R.string.s5);
                this.ele = (R.string.dat);
                this.st = (R.string.st2);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a2);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa9);
                this.qh12 = (R.string.sa1);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa8);
                this.qh31 = (R.string.sa11);
            }
            else {
                this.imgSrc =  (R.drawable.gemini);
                this.star = (R.string.s6);
                this.ele = (R.string.k);
                this.st = (R.string.st3);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a3);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa10);
                this.qh12 = (R.string.sa2);
                this.qh21 = (R.string.sa9);
                this.qh22 = (R.string.sa3);
                this.qh31 = (R.string.sa12);
            }
                break;

            case 6: if (d<22) {
                this.imgSrc =  (R.drawable.gemini);
                this.star = (R.string.s6);
                this.ele = (R.string.k);
                this.st = (R.string.st3);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a3);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa10);
                this.qh12 = (R.string.sa2);
                this.qh21 = (R.string.sa9);
                this.qh22 = (R.string.sa3);
                this.qh31 = (R.string.sa12);
            }
            else {
                this.imgSrc =  (R.drawable.cancer);
                this.star = (R.string.s7);
                this.ele = (R.string.n);
                this.st = (R.string.st4);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a4);
                this.ang1 = (R.string.a5);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa11);
                this.qh12 = (R.string.sa3);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa10);
                this.qh31 = (R.string.sa1);
            }
                break;

            case 7: if (d<23) {
                this.imgSrc =  (R.drawable.cancer);
                this.star = (R.string.s7);
                this.ele = (R.string.n);
                this.st = (R.string.st4);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a4);
                this.ang1 = (R.string.a5);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa11);
                this.qh12 = (R.string.sa3);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa10);
                this.qh31 = (R.string.sa1);
            }
            else {
                this.imgSrc =  (R.drawable.leo);
                this.star = (R.string.s8);
                this.ele = (R.string.l);
                this.st = (R.string.st5);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a6);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa4);
                this.qh12 = (R.string.sa12);
                this.qh21 = (R.string.sa5);
                this.qh22 = (R.string.sa11);
                this.qh31 = (R.string.sa2);
            }
                break;

            case 8: if (d<23) {
                this.imgSrc =  (R.drawable.leo);
                this.star = (R.string.s8);
                this.ele = (R.string.l);
                this.st = (R.string.st5);
                this.st1 = (R.string.empty);
                this.ang1 = (R.string.empty);
                this.ang = (R.string.a6);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa4);
                this.qh12 = (R.string.sa12);
                this.qh21 = (R.string.sa5);
                this.qh22 = (R.string.sa11);
                this.qh31 = (R.string.sa2);
            }
            else {
                this.imgSrc =  (R.drawable.virgo);
                this.star = (R.string.s9);
                this.ele = (R.string.dat);
                this.st = (R.string.st3);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a3);
                this.ang1 = (R.string.a5);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa1);
                this.qh12 = (R.string.sa5);
                this.qh21 = (R.string.sa12);
                this.qh22 = (R.string.sa6);
                this.qh31 = (R.string.sa3);
            }
                break;

            case 9: if (d<23) {
                this.imgSrc =  (R.drawable.virgo);
                this.star = (R.string.s9);
                this.ele = (R.string.dat);
                this.st = (R.string.st3);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a3);
                this.ang = (R.string.a5);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa1);
                this.qh12 = (R.string.sa5);
                this.qh21 = (R.string.sa12);
                this.qh22 = (R.string.sa6);
                this.qh31 = (R.string.sa3);
            }
            else {
                this.imgSrc =  (R.drawable.libra);
                this.star = (R.string.s10);
                this.ele = (R.string.k);
                this.st = (R.string.st2);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a7);
                this.ang1 = (R.string.a2);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa6);
                this.qh12 = (R.string.sa2);
                this.qh21 = (R.string.sa7);
                this.qh22 = (R.string.sa1);
                this.qh31 = (R.string.sa4);
            }
                break;

            case 10: if (d<24) {
                this.imgSrc =  (R.drawable.libra);
                this.star = (R.string.s10);
                this.ele = (R.string.k);
                this.st = (R.string.st2);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a7);
                this.ang1 = (R.string.a2);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa6);
                this.qh12 = (R.string.sa2);
                this.qh21 = (R.string.sa7);
                this.qh22 = (R.string.sa1);
                this.qh31 = (R.string.sa4);
            }
            else {
                this.imgSrc =  (R.drawable.scorpio);
                this.star = (R.string.s11);
                this.ele = (R.string.n);
                this.st = (R.string.st6);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a8);
                this.ang1 = (R.string.a1);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa3);
                this.qh12 = (R.string.sa7);
                this.qh21 = (R.string.sa8);
                this.qh22 = (R.string.sa2);
                this.qh31 = (R.string.sa5);
            }
                break;

            case 11: if (d<22) {
                this.imgSrc =  (R.drawable.scorpio);
                this.star = (R.string.s11);
                this.ele = (R.string.n);
                this.st = (R.string.st6);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a8);
                this.ang1 = (R.string.a1);
                this.tc = (R.string.tc2);
                this.tcr = (R.string.tc22);
                this.qh11 = (R.string.sa3);
                this.qh12 = (R.string.sa7);
                this.qh21 = (R.string.sa8);
                this.qh22 = (R.string.sa2);
                this.qh31 = (R.string.sa5);
            }
            else {
                this.imgSrc =  (R.drawable.sagittarius);
                this.star = (R.string.s12);
                this.ele = (R.string.l);
                this.st = (R.string.st7);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a9);
                this.ang1 = (R.string.a10);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa4);
                this.qh12 = (R.string.sa8);
                this.qh21 = (R.string.sa9);
                this.qh22 = (R.string.sa3);
                this.qh31 = (R.string.sa8);
            }
                break;

            case 12: if (d<22) {
                this.imgSrc =  (R.drawable.sagittarius);
                this.star = (R.string.s12);
                this.ele = (R.string.l);
                this.st = (R.string.st7);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a9);
                this.ang1 = (R.string.a10);
                this.tc = (R.string.tc3);
                this.tcr = (R.string.tc33);
                this.qh11 = (R.string.sa4);
                this.qh12 = (R.string.sa8);
                this.qh21 = (R.string.sa9);
                this.qh22 = (R.string.sa3);
                this.qh31 = (R.string.sa8);
            }
            else {
                this.imgSrc =  (R.drawable.capricorn);
                this.star = (R.string.s1);
                this.ele = (R.string.dat);
                this.st = (R.string.st8);
                this.st1 = (R.string.empty);
                this.ang = (R.string.a11);
                this.ang1 = (R.string.empty);
                this.tc = (R.string.tc1);
                this.tcr = (R.string.tc11);
                this.qh11 = (R.string.sa5);
                this.qh12 = (R.string.sa9);
                this.qh21 = (R.string.sa4);
                this.qh22 = (R.string.sa10);
                this.qh31 = (R.string.sa7);
            }
                break;
        }
    }


    public int findDay(int d, int m, int y) {
        int X= calculation.MOD((int)(calculation.jdFromDate(d,m,y)+2.5), 7);
        int date = 0;
        switch (X){
            case 7: date = R.string.sat; break;
            case 1: date = R.string.sun; break;
            case 2: date = R.string.mon; break;
            case 3: date = R.string.tue; break;
            case 4: date = R.string.wed; break;
            case 5: date = R.string.thu; break;
            case 6: date = R.string.fri; break;
        }
        return date;
    }
}
