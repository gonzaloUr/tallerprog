package com.entrenamosuy.tarea1.logic;

public class Fabrica {
    
    public static IControladorActividadClase crearControladorActividadClase() { //TODO Revisar si va el static Luciano
        return new ControladorActividadClase();
    }

    public static IControladorCuponera crearControladorCuponera() {//TODO Revisar si va el static Luciano
        return new ControladorCuponera();
    }

    public static IControladorUsuario creaControladorUsuario() {//TODO Revisar si va el static Luciano
        return new ControladorUsuario();
    }
}
