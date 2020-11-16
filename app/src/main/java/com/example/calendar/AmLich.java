package com.example.calendar;

public class AmLich {
    
    int s1, s2, s;
    int cannam, chinam;
    int canthang, chithang;
    int canngay, chingay, chingaysrc;
    int cangio, chigio, luckyhour;
    int chinamsrc, nguHanhsrc;
    int menh, mct;
    int menhchitiet;

    public  Calculation calculation = new Calculation();
    /* Tim can, chi nam, thang, ngay va gio nam am lich */

    public void findCanChiNam(int y) {
        int yecan = y%10;
        switch (yecan){
            case 0: this.cannam = (R.string.c7); this.s1=4; break;
            case 1: this.cannam = (R.string.c8); this.s1=4; break;
            case 2: this.cannam = (R.string.c9); this.s1=5; break;
            case 3: this.cannam = (R.string.c10); this.s1=5; break;
            case 4: this.cannam = (R.string.c1); this.s1=1; break;
            case 5: this.cannam = (R.string.c2); this.s1=1; break;
            case 6: this.cannam = (R.string.c3); this.s1=2; break;
            case 7: this.cannam = (R.string.c4); this.s1=2; break;
            case 8: this.cannam = (R.string.c5); this.s1=3; break;
            case 9: this.cannam = (R.string.c6); this.s1=3; break;
        }
        
        int yechi = y%12;
        switch (yechi) {
            case 0:
                this.chinam = (R.string.ch9);
                this.chinamsrc = (R.drawable.monkey);
                s2=1;
                break;
            case 1:
                this.chinam = (R.string.ch10);
                this.chinamsrc = (R.drawable.rooster);
                s2=1;
                break;
            case 2:
                this.chinam = (R.string.ch11);
                this.chinamsrc = (R.drawable.dog);
                s2=2;
                break;
            case 3:
                this.chinam = (R.string.ch12);
                this.chinamsrc = (R.drawable.pig);
                s2=2;
                break;
            case 4:
                this.chinam = (R.string.ch1);
                this.chinamsrc = (R.drawable.rat);
                s2=0;
                break;
            case 5:
                this.chinam = (R.string.ch2);
                this.chinamsrc = (R.drawable.ox);
                s2=0;
                break;
            case 6:
                this.chinam = (R.string.ch3);
                this.chinamsrc = (R.drawable.tiger);
                s2=1;
                break;
            case 7:
                this.chinam = (R.string.ch4);
                this.chinamsrc = (R.drawable.rabbit);
                s2=1;
                break;
            case 8:
                this.chinam = (R.string.ch5);
                this.chinamsrc = (R.drawable.dragon);
                s2=2;
                break;
            case 9:
                this.chinam = (R.string.ch6);
                this.chinamsrc = (R.drawable.snake);
                s2=2;
                break;
            case 10:
                this.chinam = (R.string.ch7);
                this.chinamsrc = (R.drawable.horse);
                s2=0;
                break;
            case 11:
                this.chinam = (R.string.ch8);
                this.chinamsrc = (R.drawable.goat);
                s2=0;
                break;
        }
        
        this.s = this.s1 + this.s2;
        if (this.s>5) this.s = this.s - 5;

        switch (this.s) {
            case 1:
                this.menh = (R.string.kim);
                this.nguHanhsrc = (R.drawable.kim);
                if ((yechi==0) || (yechi==1)) mct=12;
                if ((yechi==2) || (yechi==3)) mct=2;
                if ((yechi==4) || (yechi==5)) mct=13;
                if ((yechi==6) || (yechi==7)) mct=9;
                if ((yechi==8) || (yechi==9)) mct=5;
                if ((yechi==10) || (yechi==11)) mct=16;
                break;
            case 2:
                this.menh = (R.string.thuy);
                this.nguHanhsrc = (R.drawable.thuy);
                if ((yechi==0) || (yechi==1)) mct=17;
                if ((yechi==2) || (yechi==3)) mct=7;
                if ((yechi==4) || (yechi==5)) mct=24;
                if ((yechi==6) || (yechi==7)) mct=14;
                if ((yechi==8) || (yechi==9)) mct=10;
                if ((yechi==10) || (yechi==11)) mct=21;
                break;
            case 3:
                this.menh = (R.string.hoa);
                this.nguHanhsrc = (R.drawable.hoa);
                if ((yechi==0) || (yechi==1)) mct=22;
                if ((yechi==2) || (yechi==3)) mct=18;
                if ((yechi==4) || (yechi==5)) mct=29;
                if ((yechi==6) || (yechi==7)) mct=19;
                if ((yechi==8) || (yechi==9)) mct=15;
                if ((yechi==10) || (yechi==11)) mct=26;
                break;
            case 4:
                this.menh = (R.string.tho);
                this.nguHanhsrc = (R.drawable.tho);
                if ((yechi==0) || (yechi==1)) mct=27;
                if ((yechi==2) || (yechi==3)) mct=23;
                if ((yechi==4) || (yechi==5)) mct=3;
                if ((yechi==6) || (yechi==7)) mct=30;
                if ((yechi==8) || (yechi==9)) mct=20;
                if ((yechi==10) || (yechi==11)) mct=6;
                break;
            case 5:
                this.menh = (R.string.moc);
                this.nguHanhsrc = (R.drawable.moc);
                if ((yechi==0) || (yechi==1)) mct=1;
                if ((yechi==2) || (yechi==3)) mct=28;
                if ((yechi==4) || (yechi==5)) mct=8;
                if ((yechi==6) || (yechi==7)) mct=4;
                if ((yechi==8) || (yechi==9)) mct=25;
                if ((yechi==10) || (yechi==11)) mct=11;
                break;
        }

        switch (mct) {
            case 1: this.menhchitiet = (R.string.hh1); break;
            case 2: this.menhchitiet = (R.string.hh2); break;
            case 3: this.menhchitiet = (R.string.hh3); break;
            case 4: this.menhchitiet = (R.string.hh4); break;
            case 5: this.menhchitiet = (R.string.hh5); break;
            case 6: this.menhchitiet = (R.string.hh6); break;
            case 7: this.menhchitiet = (R.string.hh7); break;
            case 8: this.menhchitiet = (R.string.hh8); break;
            case 9: this.menhchitiet = (R.string.hh9); break;
            case 10: this.menhchitiet = (R.string.hh10); break;
            case 11: this.menhchitiet = (R.string.hh11); break;
            case 12: this.menhchitiet = (R.string.hh12); break;
            case 13: this.menhchitiet = (R.string.hh13); break;
            case 14: this.menhchitiet = (R.string.hh14); break;
            case 15: this.menhchitiet = (R.string.hh15); break;
            case 16: this.menhchitiet = (R.string.hh16); break;
            case 17: this.menhchitiet = (R.string.hh17); break;
            case 18: this.menhchitiet = (R.string.hh18); break;
            case 19: this.menhchitiet = (R.string.hh19); break;
            case 20: this.menhchitiet = (R.string.hh20); break;
            case 21: this.menhchitiet = (R.string.hh21); break;
            case 22: this.menhchitiet = (R.string.hh22); break;
            case 23: this.menhchitiet = (R.string.hh23); break;
            case 24: this.menhchitiet = (R.string.hh24); break;
            case 25: this.menhchitiet = (R.string.hh25); break;
            case 26: this.menhchitiet = (R.string.hh26); break;
            case 27: this.menhchitiet = (R.string.hh27); break;
            case 28: this.menhchitiet = (R.string.hh28); break;
            case 29: this.menhchitiet = (R.string.hh29); break;
            case 30: this.menhchitiet = (R.string.hh30); break;
        }
    }
    

    public  void findCanThang(int m, int y) {
        int mocan = (y *12 + m +3)%10;
        switch (mocan) {
            case 0: this.canthang  = R.string.c1; break;
            case 1: this.canthang  = R.string.c2; break;
            case 2: this.canthang  = R.string.c3; break;
            case 3: this.canthang  = R.string.c4; break;
            case 4: this.canthang  = R.string.c5; break;
            case 5: this.canthang  = R.string.c6; break;
            case 6: this.canthang  = R.string.c7; break;
            case 7: this.canthang  = R.string.c8; break;
            case 8: this.canthang  = R.string.c9; break;
            case 9: this.canthang  = R.string.c10; break;
        }
    }

    public  void findChiThang(int m) {
        switch (m) {
            case 1: this.chithang  = (R.string.ch3); break;
            case 2: this.chithang  = (R.string.ch4); break;
            case 3: this.chithang  = (R.string.ch5); break;
            case 4: this.chithang  = (R.string.ch6); break;
            case 5: this.chithang  = (R.string.ch7); break;
            case 6: this.chithang  = (R.string.ch8); break;
            case 7: this.chithang  = (R.string.ch9); break;
            case 8: this.chithang  = (R.string.ch10); break;
            case 9: this.chithang  = (R.string.ch11); break;
            case 10: this.chithang  = (R.string.ch12); break;
            case 11: this.chithang  = (R.string.ch1); break;
            case 12: this.chithang  = (R.string.ch2); break;
        }
    }

    public  void findCanNgay(int d, int m, int y) {
        int dcan = calculation.INT(calculation.jdFromDate(d,m,y)+9.5) % 10;
        switch (dcan) {
            case 0: this.canngay =(R.string.c1); break;
            case 1: this.canngay =(R.string.c2); break;
            case 2: this.canngay =(R.string.c3); break;
            case 3: this.canngay =(R.string.c4); break;
            case 4: this.canngay =(R.string.c5); break;
            case 5: this.canngay =(R.string.c6); break;
            case 6: this.canngay =(R.string.c7); break;
            case 7: this.canngay =(R.string.c8); break;
            case 8: this.canngay =(R.string.c9); break;
            case 9: this.canngay =(R.string.c10); break;
        }
    }

    public  void findChiNgay(int d, int m, int y) {
        int dchi = calculation.INT(calculation.jdFromDate(d,m,y) + 1.5) % 12;
        switch (dchi) {
            case 0: {
                this.chingay =(R.string.ch1);
                break;
            }
            case 1: {
                this.chingay =(R.string.ch2);
                break;
            }
            case 2: {
                this.chingay =(R.string.ch3);
                break;
            }
            case 3: {
                this.chingay =(R.string.ch4);
                break;
            }
            case 4: {
                this.chingay =(R.string.ch5);
                break;
            }
            case 5: {
                this.chingay =(R.string.ch6);
                break;
            }
            case 6: {
                this.chingay =(R.string.ch7);
                break;
            }
            case 7: {
                this.chingay =(R.string.ch8);
                break;
            }
            case 8: {
                this.chingay =(R.string.ch9);
                break;
            }
            case 9: {
                this.chingay =(R.string.ch10);
                break;
            }
            case 10: {
                this.chingay =(R.string.ch11);
                break;
            }
            case 11: {
                this.chingay =(R.string.ch12);
                break;
            }
        }
    }

    public  void findChiNgayduongLich(int d, int m, int y) {
        int dchi = calculation.INT(calculation.jdFromDate(d,m,y) + 1.5) % 12;
        switch (dchi) {
            case 0: {
                this.chingaysrc =(R.drawable.rat);
                break;
            }
            case 1: {
                this.chingaysrc =(R.drawable.ox);
                break;
            }
            case 2: {
                this.chingaysrc =(R.drawable.tiger);
                break;
            }
            case 3: {
                this.chingaysrc =(R.drawable.rabbit);
                break;
            }
            case 4: {
                this.chingaysrc =(R.drawable.dragon);
                break;
            }
            case 5: {
                this.chingaysrc =(R.drawable.snake);
                break;
            }
            case 6: {
                this.chingaysrc =(R.drawable.horse);
                break;
            }
            case 7: {
                this.chingaysrc =(R.drawable.goat);
                break;
            }
            case 8: {
                this.chingaysrc =(R.drawable.monkey);
                break;
            }
            case 9: {
                this.chingaysrc =(R.drawable.rooster);
                break;
            }
            case 10: {
                this.chingaysrc =(R.drawable.dog);
                break;
            }
            case 11: {
                this.chingaysrc =(R.drawable.pig);
                break;
            }
        }
    }

    public  void findCanGio(int h, int d, int m, int y){
        int dcan = calculation.INT(calculation.jdFromDate(d,m,y)+9.5) % 10;
        int dchi = calculation.INT(calculation.jdFromDate(d,m,y) + 1.5) % 12;
        if ((dcan==0) || (dcan==5)) {
            if ((h==23) || (h==0)) this.cangio = (R.string.c1);
            if ((h==1) || (h==2)) this.cangio = (R.string.c2);
            if ((h==3) || (h==4)) this.cangio = (R.string.c3);
            if ((h==5) || (h==6)) this.cangio = (R.string.c4);
            if ((h==7) || (h==8)) this.cangio = (R.string.c5);
            if ((h==9) || (h==10)) this.cangio = (R.string.c6);
            if ((h==11) || (h==12)) this.cangio = (R.string.c7);
            if ((h==13) || (h==14)) this.cangio = (R.string.c8);
            if ((h==15) || (h==16)) this.cangio = (R.string.c9);
            if ((h==17) || (h==18)) this.cangio = (R.string.c10);
            if ((h==19) || (h==20)) this.cangio = (R.string.c1);
            if ((h==21) || (h==22)) this.cangio = (R.string.c2);
        }

        if ((dcan==1) || (dcan==6)) {
            if ((h==23) || (h==0)) this.cangio = (R.string.c3);
            if ((h==1) || (h==2)) this.cangio = (R.string.c4);
            if ((h==3) || (h==4)) this.cangio = (R.string.c5);
            if ((h==5) || (h==6)) this.cangio = (R.string.c6);
            if ((h==7) || (h==8)) this.cangio = (R.string.c7);
            if ((h==9) || (h==10)) this.cangio = (R.string.c8);
            if ((h==11) || (h==12)) this.cangio = (R.string.c9);
            if ((h==13) || (h==14)) this.cangio = (R.string.c10);
            if ((h==15) || (h==16)) this.cangio = (R.string.c1);
            if ((h==17) || (h==18)) this.cangio = (R.string.c2);
            if ((h==19) || (h==20)) this.cangio = (R.string.c3);
            if ((h==21) || (h==22)) this.cangio = (R.string.c4);
        }

        if ((dcan==2) || (dcan==7)) {
            if ((h==23) || (h==0)) this.cangio = (R.string.c5);
            if ((h==1) || (h==2)) this.cangio = (R.string.c6);
            if ((h==3) || (h==4)) this.cangio = (R.string.c7);
            if ((h==5) || (h==6)) this.cangio = (R.string.c8);
            if ((h==7) || (h==8)) this.cangio = (R.string.c9);
            if ((h==9) || (h==10)) this.cangio = (R.string.c10);
            if ((h==11) || (h==12)) this.cangio = (R.string.c1);
            if ((h==13) || (h==14)) this.cangio = (R.string.c2);
            if ((h==15) || (h==16)) this.cangio = (R.string.c3);
            if ((h==17) || (h==18)) this.cangio = (R.string.c4);
            if ((h==19) || (h==20)) this.cangio = (R.string.c5);
            if ((h==21) || (h==22)) this.cangio = (R.string.c6);
        }

        if ((dcan==3) || (dcan==8)) {
            if ((h==23) || (h==0)) this.cangio = (R.string.c7);
            if ((h==1) || (h==2)) this.cangio = (R.string.c8);
            if ((h==3) || (h==4)) this.cangio = (R.string.c9);
            if ((h==5) || (h==6)) this.cangio = (R.string.c10);
            if ((h==7) || (h==8)) this.cangio = (R.string.c1);
            if ((h==9) || (h==10)) this.cangio = (R.string.c2);
            if ((h==11) || (h==12)) this.cangio = (R.string.c3);
            if ((h==13) || (h==14)) this.cangio = (R.string.c4);
            if ((h==15) || (h==16)) this.cangio = (R.string.c5);
            if ((h==17) || (h==18)) this.cangio = (R.string.c6);
            if ((h==19) || (h==20)) this.cangio = (R.string.c7);
            if ((h==21) || (h==22)) this.cangio = (R.string.c8);
        }

        if ((dcan==4) || (dcan==9)) {
            if ((h==23) || (h==0)) this.cangio = (R.string.c9);
            if ((h==1) || (h==2)) this.cangio = (R.string.c10);
            if ((h==3) || (h==4)) this.cangio = (R.string.c1);
            if ((h==5) || (h==6)) this.cangio = (R.string.c2);
            if ((h==7) || (h==8)) this.cangio = (R.string.c3);
            if ((h==9) || (h==10)) this.cangio = (R.string.c4);
            if ((h==11) || (h==12)) this.cangio = (R.string.c5);
            if ((h==13) || (h==14)) this.cangio = (R.string.c6);
            if ((h==15) || (h==16)) this.cangio = (R.string.c7);
            if ((h==17) || (h==18)) this.cangio = (R.string.c8);
            if ((h==19) || (h==20)) this.cangio = (R.string.c9);
            if ((h==21) || (h==22)) this.cangio = (R.string.c10);
        }
        

    }

    public  void findChiGio(int h) {
        if ((h==23) || (h==0)) this.chigio = (R.string.ch1);
        if ((h==1) || (h==2)) this.chigio = (R.string.ch2);
        if ((h==3) || (h==4)) this.chigio = (R.string.ch3);
        if ((h==5) || (h==6)) this.chigio = (R.string.ch4);
        if ((h==7) || (h==8)) this.chigio = (R.string.ch5);
        if ((h==9) || (h==10)) this.chigio = (R.string.ch6);
        if ((h==11) || (h==12)) this.chigio = (R.string.ch7);
        if ((h==13) || (h==14)) this.chigio = (R.string.ch8);
        if ((h==15) || (h==16)) this.chigio = (R.string.ch9);
        if ((h==17) || (h==18)) this.chigio = (R.string.ch10);
        if ((h==19) || (h==20)) this.chigio = (R.string.ch11);
        if ((h==21) || (h==22)) this.chigio = (R.string.ch12);
        
    }

    public  void findGioHoangDao(int d, int m, int y) {
        int dchi = calculation.INT(calculation.jdFromDate(d,m,y) + 1.5) % 12;
        if ((dchi==2) || (dchi==8)) this.luckyhour = (R.string.h1);
        if ((dchi==3) || (dchi==9)) this.luckyhour = (R.string.h2);
        if ((dchi==4) || (dchi==10)) this.luckyhour = (R.string.h3);
        if ((dchi==5) || (dchi==11)) this.luckyhour = (R.string.h4);
        if ((dchi==6) || (dchi==0)) this.luckyhour = (R.string.h5);
        if ((dchi==7) || (dchi==1)) this.luckyhour = (R.string.h6);
    }

    public int checkLeapYear(int y) {

        int mod = y%19;
        int check = 0;

        if ((mod == 0) || (mod == 3) || (mod == 6) || (mod == 9) || (mod == 11) || (mod == 14) || (mod == 17)) {
            check = R.string.nhuana;
        } else {
            check = R.string.empty;
        }

        return check;
    }
}
