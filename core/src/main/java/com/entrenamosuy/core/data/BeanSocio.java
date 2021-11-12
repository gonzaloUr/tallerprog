package com.entrenamosuy.core.data;

import java.util.Set;

public class BeanSocio {

    private Set<DataClase> clases;

    private Set<DataCuponera> cuponeras;

    public BeanSocio() {}

    public Set<DataClase> getClases() {
        return this.clases;
    }

    public void setClases(Set<DataClase> clases) {
        this.clases = clases;
    }

    public Set<DataCuponera> getCuponeras() {
        return this.cuponeras;
    }

    public void setCuponeras(Set<DataCuponera> cuponeras) {
        this.cuponeras = cuponeras;
    }

    public void from(DataSocio x) {
        setClases(x.getClases());
        setCuponeras(x.getCuponeras());
    }
}
