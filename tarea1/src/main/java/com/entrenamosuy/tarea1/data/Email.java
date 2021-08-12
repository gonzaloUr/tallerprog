package com.entrenamosuy.tarea1.data;

import java.util.Objects;

public class Email {

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
}
