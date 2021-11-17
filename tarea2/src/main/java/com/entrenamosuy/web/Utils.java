package com.entrenamosuy.web;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
