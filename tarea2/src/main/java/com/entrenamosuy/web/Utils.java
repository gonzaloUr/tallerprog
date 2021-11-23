package com.entrenamosuy.web;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entrenamosuy.web.publicar.BeanEmail;
import com.entrenamosuy.web.publicar.BeanLocalDate;
import com.entrenamosuy.web.publicar.BeanLocalDateTime;

public class Utils {

    private static final Pattern pattern = Pattern.compile("(.+)@(.+)");

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

    public static BeanEmail parse(String email) throws IllegalArgumentException {
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            String prefix = matcher.group(1);
            String domain = matcher.group(2);

            BeanEmail ret = new BeanEmail();
            ret.setPrefix(prefix);
            ret.setDomain(domain);

            return ret;
        }

        throw new IllegalArgumentException();
    }

    public static boolean esMobile(String userAgent) {
        String lowerCase = userAgent.toLowerCase();
        return lowerCase.contains("android") || lowerCase.contains("iphone") || lowerCase.contains("ipad");
    }
}
