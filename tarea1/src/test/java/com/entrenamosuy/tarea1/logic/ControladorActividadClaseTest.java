package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;

import com.entrenamosuy.tarea1.exceptions.ActividadRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionRepetidaException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorActividadClaseTest {
    
    @BeforeEach
    void resetarManejador() {
        Manejador manejador = Manejador.getInstance();

        manejador.getActividades().clear();
        manejador.getClases().clear();
        manejador.getCuponeras().clear();
        manejador.getInstituciones().clear();
        manejador.getProfesores().clear();
        manejador.getProfesoresMail().clear();
        manejador.getSocios().clear();
        manejador.getSociosMail().clear();
    }
    
    @Test
    void crearActividad() throws MalformedURLException, ActividadRepetidaException, InstitucionNoEncontradaException {
        Fabrica F = new Fabrica();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("Peñarol", "Peñarol Peñarol!", u);
        });

        /*assertDoesNotThrow(() -> {
            ctrlA.crearActividad("Peñarol", "Futbol", "Pelota", Duration.ofMinutes(90), 8, LocalDate.of(2018, 03, 28));
            
        });*/

        assertThrows(InstitucionNoEncontradaException.class, () -> { 
            ctrlA.crearActividad("Pe", "Futbol", "Pelota", Duration.ofMinutes(90), 8, LocalDate.of(2018, 03, 28));
        });


    }

    @Test
    void crearInstitucion() throws MalformedURLException, InstitucionRepetidaException {
        Fabrica F = new Fabrica();
        IControladorActividadClase ctrlA = F.crearControladorActividadClase();
        URL u = new URL("http", "www.google", 5, "file");
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("Peñarol", "Peñarol Peñarol!", u);
        });
        assertThrows(InstitucionRepetidaException.class, () -> { 
            ctrlA.crearInstitucion("Peñarol", "Peñarol Peñarol!", u);
        });
    }

}
