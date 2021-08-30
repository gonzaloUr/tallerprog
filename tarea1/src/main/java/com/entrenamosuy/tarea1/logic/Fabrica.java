package com.entrenamosuy.tarea1.logic;

public class Fabrica {

    public IControladorActividadClase crearControladorActividadClase() {
        return new ControladorActividadClase();
    }

    public IControladorCuponera crearControladorCuponera() {
        return new ControladorCuponera();
    }

    public IControladorUsuario creaControladorUsuario() {
        return new ControladorUsuario();
    }
}
