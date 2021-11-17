package com.entrenamosuy.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.web.publicar.BeanEmail;
import com.entrenamosuy.web.publicar.BeanLocalDate;
import com.entrenamosuy.web.publicar.BeanLocalDateTime;

public class Utils {

    public static LocalDateTime localDateTimeFromBean(BeanLocalDateTime bean) {
        return LocalDateTime.of(bean.getYear(),
                bean.getMonth(),
                bean.getDayOfMonth(),
                bean.getHour(),
                bean.getMinute(),
                bean.getSecond(),
                bean.getNano());
    }

    public static LocalDate localDateFromBean(BeanLocalDate bean) {
        return LocalDate.of(bean.getYear(), bean.getMonth(), bean.getDayOfMonth());
    }

    public static BeanLocalDate beanFromLocalDate(LocalDate date) {
        BeanLocalDate ret = new BeanLocalDate();

        ret.setYear(date.getYear());
        ret.setMonth(date.getMonthValue());
        ret.setDayOfMonth(date.getDayOfMonth());

        return ret;
    }

    public static BeanLocalDateTime beanFromLocalDateTime(LocalDateTime date) {
        BeanLocalDateTime ret = new BeanLocalDateTime();

        ret.setYear(date.getYear());
        ret.setMonth(date.getMonthValue());
        ret.setDayOfMonth(date.getDayOfMonth());
        ret.setHour(date.getHour());
        ret.setMinute(date.getMinute());
        ret.setSecond(date.getSecond());
        ret.setNano(date.getNano());

        return ret;
    }

    // TODO: no usar core en tarea2
    public static BeanEmail beanFromEmail(Email e) {
        BeanEmail ret = new BeanEmail();

        ret.setDomain(e.getDomain());
        ret.setPrefix(e.getPrefix());

        return ret;
    }
}
