package com.entrenamosuy.tarea1.data;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {

    private static final Pattern pattern = Pattern.compile("(.+)@(.+)");

    public static Email of(String prefix, String domain) {
        return new Email(prefix, domain);
    }

    public static Email parse(String email) {
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            String prefix = matcher.group(1);
            String domain = matcher.group(2);

            return Email.of(prefix, domain);
        }

        throw new IllegalArgumentException("email invalido");
    }

    private final String prefix;

    private final String domain;

    public Email(String prefix, String domain) {
        this.prefix = prefix;
        this.domain = domain;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Email email = (Email) o;
        return prefix.equals(email.prefix) && domain.equals(email.domain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, domain);
    }

    @Override
    public String toString() {
        return prefix + "@" + domain;
    }

}
