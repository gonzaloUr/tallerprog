package com.entrenamosuy.core.data;

public class BeanEmail {

    private String prefix;

    private String domain;

    public BeanEmail() {}

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void from(Email x) {
        setPrefix(x.getPrefix());
        setDomain(x.getDomain());
    }
}
