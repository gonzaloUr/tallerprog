package com.entrenamosuy.tarea1.view.publicar;

import java.time.LocalDate;

public class BeanLocalDate {

    private int year;

    private int month;

    private int dayOfMonth;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public void from(LocalDate x) {
        setYear(x.getYear());
        setMonth(x.getMonthValue());
        setDayOfMonth(x.getDayOfMonth());
    }

    public static BeanLocalDate of(LocalDate x) {
        BeanLocalDate ret = new BeanLocalDate();
        ret.from(x);
        return ret;
    }
}
