package com.entrenamosuy.tarea1.view.publicar;

import java.time.LocalDateTime;

public class BeanLocalDateTime {

    private int year;

    private int month;

    private int dayOfMonth;

    private int hour;

    private int minute;

    private int second;

    private int nano;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getNano() {
        return nano;
    }

    public void setNano(int nano) {
        this.nano = nano;
    }

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

    public void from(LocalDateTime x) {
        setYear(x.getYear());
        setMonth(x.getMonthValue());
        setDayOfMonth(x.getDayOfMonth());
        setHour(x.getHour());
        setMinute(x.getMinute());
        setSecond(x.getSecond());
        setNano(x.getNano());
    }

    public static BeanLocalDateTime of(LocalDateTime x) {
        BeanLocalDateTime ret = new BeanLocalDateTime();
        ret.from(x);
        return ret;
    }
}

