package com.artcak.artcaklibrary.tools;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UnknownFormatConversionException;

public class TimeHelper {
    public static final String[] days_short = {"Min", "Sen", "Sel", "Rab", "Kam", "Jum", "Sab"};
    public static final String[] days = {"Minggu", "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
    public static final String[] months = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
    public static final String[] months_short = {"Jan", "Feb", "Mar", "Apr", "Mei", "Jun", "Jul", "Agu", "Sept", "Okt", "Nov", "Des"};
    public static final String FORMAT_ISO_DAY_TO_SECOND = "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS";
    public static final String FORMAT_ISO_DAY_TO_YEAR = "%1$tY-%1$tm-%1$td";
    public static final String FORMAT_DAY_TO_SECOND = "1$td %1$tB %1$tY %1$tH:%1$tM:%1$tS";
    public static final String FORMAT_DAY_TO_YEAR = "1$td %1$tB %1$tY";
    public static final String FORMAT_DAY_TO_SECOND_SHORTMONTH = "%1$td %1$tb %1$tY %1$tH:%1$tM:%1$tS";
    public static final String FORMAT_DAY_TO_YEAR_SHORTMONTH = "%1$td %1$tb %1$tY";
    public static long getTimeNow(){
        return Calendar.getInstance().getTime().getTime();
    }
    public static int getTimeComponent(long time, int component){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar.get(component);
    }
    public static long getTime(String date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat, Locale.US);
        try {
            return simpleDateFormat.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public static String getFormatedTime(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return String.format(Locale.US,"%1$tF", calendar);
    }
    public static String getFormatedTime(long time, int type){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        if (type==1){
            return String.format(Locale.US,"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", calendar);
        }else if (type==2){
            return String.format(Locale.US,"%1$tY-%1$tm-%1$td", calendar);
        }else if (type==3){
            return String.format(Locale.US,"%1$td %1$tB %1$tY %1$tH:%1$tM:%1$tS", calendar);
        }else if (type==4){
            return String.format(Locale.US,"%1$td %1$tB %1$tY", calendar);
        }else if (type==5){
            return String.format(Locale.US,"%1$td %1$tb %1$tY %1$tH:%1$tM:%1$tS", calendar);
        }else if (type==6){
            return String.format(Locale.US,"%1$td %1$tb %1$tY", calendar);
        }else{
            return String.format(Locale.US,"%1$td-%1$tm-%1$ty %1$tH:%1$tM:%1$tS", calendar);
        }
    }
    public static String getFormatedTime(long time, String format){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        try{
            return String.format(Locale.US,format, calendar);
        } catch (UnknownFormatConversionException e){
            e.printStackTrace();
        } catch (RuntimeException e){
            e.printStackTrace();
        }
        return String.format(Locale.US,"%1$td-%1$tm-%1$ty %1$tH:%1$tM:%1$tS", calendar);
    }
}
