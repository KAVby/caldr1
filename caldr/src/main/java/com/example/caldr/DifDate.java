package com.example.caldr;

import java.util.Calendar;

/**
 * Created by Home on 07.03.2017.
 */

public class DifDate {

public static Calendar gc1,gc2;
    public static int diferenceDate(int field, Calendar c1, Calendar c2, String sY, String sM, String sD){
        int count = 0;
        gc1 = (Calendar)c1.clone();
        gc2 = (Calendar)c2.clone();
        gc1.set(gc1.get(Calendar.YEAR)-Integer.parseInt(sY),gc1.get(Calendar.MONTH)-Integer.parseInt(sM),gc1.get(Calendar.DAY_OF_MONTH)-Integer.parseInt(sD));
        int test;
        // очищаем поля, которые мы не будем учитывать при сравнении дат
        if (field==Calendar.YEAR) {
            //           gc2.set(Calendar.DAY_OF_MONTH,gc1.get(Calendar.DAY_OF_MONTH)-1);
//            for (gc1.add(field, 1);
//                 gc1.compareTo(gc2) <0;
//                 gc1.add(field, 1))
//            {test=gc1.compareTo(gc2);
//                count++;
//            }

            gc1.add(field, 1);
            while (gc1.compareTo(gc2) <=0) {
                gc1.add(field, 1);
                count++;
            }
        }
        if (field==Calendar.MONTH){
            if (gc1.get(Calendar.MONTH)==gc2.get(Calendar.MONTH)){
                if (gc1.get(Calendar.DAY_OF_MONTH)<gc2.get(Calendar.DAY_OF_MONTH))
                    count=0;
                if (gc1.get(Calendar.DAY_OF_MONTH)==gc2.get(Calendar.DAY_OF_MONTH))
                    count=0;
                if (gc1.get(Calendar.DAY_OF_MONTH)>gc2.get(Calendar.DAY_OF_MONTH))
                    count=11;
            }
            if (gc1.get(Calendar.MONTH)>gc2.get(Calendar.MONTH)){
                gc2.set(Calendar.YEAR,gc1.get(Calendar.YEAR)+1);
                for (gc1.add(field, 1); gc1.compareTo(gc2) <= 0; gc1.add(field, 1)) {
                    count++;
                }
            }
            if (gc1.get(Calendar.MONTH)<gc2.get(Calendar.MONTH)){
                gc1.clear(Calendar.YEAR);
                gc2.clear(Calendar.YEAR);
                for (gc1.add(field, 1); gc1.compareTo(gc2) <=0; gc1.add(field, 1))
                {
                    count++;
                }
            }


        }

        if (field==Calendar.DAY_OF_MONTH){
count=1;
            if (gc1.get(Calendar.DAY_OF_MONTH)<=gc2.get(Calendar.DAY_OF_MONTH)){
                gc1.clear(Calendar.MONTH);
                gc2.clear(Calendar.MONTH);
                gc1.clear(Calendar.YEAR);
                gc2.clear(Calendar.YEAR);
                for (gc1.add(field, 1); gc1.compareTo(gc2) <=0; gc1.add(field, 1))
                {
                    count++;
                }
            }
            else {   //пересмотреть алгоритм - здесь косяк если день меньше
//                gc2.set(Calendar.MONTH,gc1.get(Calendar.MONTH)+1);
//                gc1.clear(Calendar.MONTH);
//                gc2.clear(Calendar.MONTH);
                int dd=gc2.get(Calendar.DAY_OF_MONTH);
                gc2.add(field, -dd);
                gc1.clear(Calendar.MONTH);
                gc2.clear(Calendar.MONTH);
                gc1.clear(Calendar.YEAR);
                gc2.clear(Calendar.YEAR);
                for (gc1.add(field, 1); gc1.compareTo(gc2) <= 0; gc1.add(field, 1)) {
                    count++;
                }count=count+dd;
            }
        }
        if (c1.compareTo(c2) >0) count=0;
        return count;

    }

























}
