package com.entrenamosuy.tarea1.logic;

public class ControladorActividadClase {
    
    public:
    ingresarDatosActividad(String nombreInstitutucion,String nombre, String descripcion, float duracion, float costo, Fecha fecha){
        Manejador maneja = Manejador.getInstance();
        Map actividades = maneja.getActividades();
        try {
            if actividades.containsKey(nombre){
                throw();
            }
            else {
                
                actividades.put(nombre,nuevaActividad); //agrego la nueva actividad al map
            }
        } 
        catch (Exception e) {
            //TODO: handle exception
        }
    }









}

