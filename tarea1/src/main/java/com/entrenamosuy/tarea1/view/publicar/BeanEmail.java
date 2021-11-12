package com.entrenamosuy.tarea1.view.publicar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.entrenamosuy.core.data.Email;

@XmlAccessorType(XmlAccessType.FIELD)
public class BeanEmail {

    private String prefix;

    private String domain;

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
    
    public static BeanEmail of(Email x) {
        BeanEmail ret = new BeanEmail();
        ret.from(x);
        return ret;
    }
}
