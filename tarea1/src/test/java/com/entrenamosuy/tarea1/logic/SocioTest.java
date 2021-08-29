package com.entrenamosuy.tarea1.logic;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.util.Pair;
import java.net.URL;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SocioTest {

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
    void socioTest() {
        
        assertDoesNotThrow(() -> {
            ControladorActividadClase ctrlA = new ControladorActividadClase();
            ControladorCuponera ctrlC = new ControladorCuponera();
            Manejador m = Manejador.getInstance();
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlA.crearActividad("test", "test1", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            Actividad a = m.getActividades().get("test"); 
            Actividad a2 = m.getActividades().get("test1");
            Integra i = new Integra(2, a2);
            ctrlC.crearCuponera("nombre", "descrip",  LocalDate.of(2001, 03, 18), LocalDate.of(2002, 03, 28), 5, LocalDate.of(2007, 03, 28));
            ctrlC.agregarACuponera("nombre", "test", 2);
            ctrlC.agregarACuponera("nombre", "test1", 2);
            Cuponera cup = m.getCuponeras().get("nombre");
            Set<Compra> c = new HashSet<>();
            Registro reg = new Registro(LocalDate.of(2001, 03, 18), 2, null, null);
            Set<Registro> r = new HashSet<>();
            Socio s = new Socio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28), r, c);
            Compra c2 = new Compra(LocalDate.of(2007, 03, 28), s, cup);
            Set<Compra> cupo = new HashSet<>();
            cupo.add(c2);
            s.setRegistros(r);
            s.setCompras(cupo);
            Set<Pair<String, String>> res = s.cuponerasUsables(a);
            LocalDate awdawd = c2.getFecha();
            c2.setFecha(awdawd);
            Socio awd = c2.getSocio();
            c2.setSocio(awd);
            c2.setCuponera(cup);
            c2.equals(null);
            s.setNickname("UWU");
            s.getCompras();
            s.setCorreo(Email.of("lucho", "mail.com"));
            Socio s1 = new Socio("Lucho1", "Luciano", "Almenares", Email.of("luc4ho", "mail.com"), LocalDate.of(2007, 03, 28), r, c);
            boolean SonIguales = s.equals(s1);
            reg.equals(reg);
            reg.equals(null);
            reg.getCuponera();
            reg.setCuponera(cup);
            reg.setClaseAsociada(null);
            reg.getSocio();
            reg.setSocio(null);
            reg.setFecha(LocalDate.of(2007, 03, 28));
            reg.getFecha();
            reg.getCosto();
            reg.setCosto(234);
            cup.setNombre("ombre");
            cup.setDescripcion("i");
            cup.getInicio();
            cup.setInicio(LocalDate.of(2007, 03, 28));
            cup.getFin();
            cup.setFin(LocalDate.of(2007, 03, 28));
            cup.setDescuento(23);
            cup.getRegistros();
            Set<Registro> a7 = null;
            cup.setRegistros(a7);
            cup.getIntegra(a);
            cup.tieneActividad(a);
            cup.equals(cup);
            cup.equals(null);
            a.setNombre("nombre");
            a.setDescripcion("awd");
            a.getDuracion();
            a.setDuracion(Duration.ofHours(1));
            a.getFechaRegistro();
            a.setFechaRegistro(LocalDate.of(2007, 03, 28));
            a.setCosto(2);
            a.equals(null);
            i.setCantClases(2);
            i.setActividad(a);
            i.equals(i);
            i.equals(null);
        });
    }
}
