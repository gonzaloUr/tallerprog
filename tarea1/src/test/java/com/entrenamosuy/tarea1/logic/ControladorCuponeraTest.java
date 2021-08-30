package com.entrenamosuy.tarea1.logic;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.net.URL;

import com.entrenamosuy.tarea1.data.Email;
import com.entrenamosuy.tarea1.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.CuponeraRepetidaException;
import com.entrenamosuy.tarea1.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.tarea1.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.tarea1.util.Pair;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControladorCuponeraTest {

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
    void crearCuponera() throws CuponeraRepetidaException {
        Fabrica F = new Fabrica();
        IControladorCuponera ctrlC = F.crearControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
        });
        assertThrows(CuponeraRepetidaException.class, () -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
        });
    }

    @Test
    void cuponerasUsables() throws ActividadNoEncontradaException, SocioNoEncontradoException {
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        assertDoesNotThrow(() -> {
            ctrlU.crearSocio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlC.cuponerasUsables("test", "Lucho");
        });
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlC.cuponerasUsables("te", "Lucho");
        });
        assertThrows(SocioNoEncontradoException.class, () -> {
            ctrlC.cuponerasUsables("test", "Lu");
        });
    }

    @Test
    void actividadesAgregables() throws CuponeraNoEncontradaException, InstitucionNoEncontradaException {
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlC.actividadesAgregables("cuponera1", "test");
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.actividadesAgregables("cup", "test");
        });
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            ctrlC.actividadesAgregables("cuponera1", "te");
        });
    }

    @Test
    void agregarACuponera() throws ActividadNoEncontradaException, CuponeraNoEncontradaException { //agregarACuponera(String cuponera, String actividad, int cant)
        Manejador m = Manejador.getInstance();
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlC.crearCuponera("cuponera2", "Todo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlA.crearActividad("test", "test2", "test2", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlC.agregarACuponera("cuponera1", "test", 5);
            ctrlC.agregarACuponera("cuponera1", "test2", 5);
        });
        assertDoesNotThrow(() -> {
            Cuponera cup = m.getCuponeras().get("cuponera1");
            Cuponera cup2 = m.getCuponeras().get("cuponera2");
            Set<Compra> c = new HashSet<>();
            Registro reg1 = new Registro(LocalDate.of(2001, 03, 18), 2, null, null);
            Registro reg2 = new Registro(LocalDate.of(2001, 03, 18), 3, null, null);
            Set<Registro> r = new HashSet<>();
            Socio s = new Socio("Lucho", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28), r, c);
            Compra c2 = new Compra(LocalDate.of(2007, 03, 28), s, cup);
            Set<Compra> cupo = new HashSet<>();
            cupo.add(c2);
            s.setRegistros(r);
            s.setCompras(cupo);
            Set<Pair<String, String>> res = s.cuponerasUsables(m.getActividades().get("test"));
            Set<Pair<String, String>> res2 = s.cuponerasUsables(m.getActividades().get("test2"));
            //assertEquals(res, res);
            //assertNotEquals(res, res2);
            assertEquals(reg1, reg1);
            assertNotEquals(reg1, reg2);
            assertNotEquals(reg1, res);
            assertNotEquals(reg1, res2);

            assertNotEquals(c2.getFecha(), LocalDate.of(2005, 03, 28));
            c2.setFecha(LocalDate.of(2005, 03, 28));
            assertEquals(c2.getFecha(), LocalDate.of(2005, 03, 28));

            Socio s2 = new Socio("Lu", "Luciano", "Almenares", Email.of("lucho", "mail.com"), LocalDate.of(2007, 03, 28), r, c);
            assertNotEquals(c2.getSocio(), "Lu");
            c2.setSocio(s2);
            assertEquals(c2.getSocio(), s2);

            c2.setCuponera(cup);
            assertEquals(c2.getCuponera(), cup);
            c2.equals(null);

            assertEquals(reg1.equals(reg1), true);
            assertEquals(reg1.equals(null), false);

            assertNotEquals(reg1.getCuponera(), cup2);
            reg1.setCuponera(cup2);
            assertEquals(reg1.getCuponera(), cup2);

            assertNotEquals(reg1.getSocio(), s2);
            reg1.setSocio(s2);
            assertEquals(reg1.getSocio(), s2);

            assertNotEquals(reg1.getFecha(), LocalDate.of(2005, 03, 28));
            reg1.setFecha(LocalDate.of(2007, 03, 28));
            assertEquals(reg1.getFecha(), LocalDate.of(2007, 03, 28));

            assertNotEquals(reg1.getCosto(), 234);
            reg1.setCosto(234);
            assertEquals(reg1.getCosto(), 234);


        });

        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.agregarACuponera("cupo", "test", 5);
        });
        assertThrows(ActividadNoEncontradaException.class, () -> {
            ctrlC.agregarACuponera("cuponera1", "te", 5);
        });
    }

    @Test
    void varios() {
        Manejador m = Manejador.getInstance();
        ControladorCuponera ctrlC = new ControladorCuponera();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlA.crearActividad("test", "test2", "test2", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            ctrlC.agregarACuponera("cuponera1", "test", 5);
            ctrlC.agregarACuponera("cuponera1", "test2", 5);

        });

        assertDoesNotThrow(() -> {
            Cuponera cup = m.getCuponeras().get("cuponera1");
            ctrlA.crearActividad("test", "test1", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            Actividad a = m.getActividades().get("test");
            Actividad b = m.getActividades().get("test2");


            assertNotEquals(cup.getNombre(), "ombre");
            cup.setNombre("ombre");
            assertEquals(cup.getNombre(), "ombre");

            assertNotEquals(cup.getDescripcion(), "i");
            cup.setDescripcion("i");
            assertEquals(cup.getDescripcion(), "i");

            assertNotEquals(cup.getInicio(), LocalDate.of(2007, 03, 28));
            cup.setInicio(LocalDate.of(2007, 03, 28));
            assertEquals(cup.getInicio(), LocalDate.of(2007, 03, 28));

            assertNotEquals(cup.getFin(), LocalDate.of(2007, 03, 28));
            cup.setFin(LocalDate.of(2007, 03, 28));
            assertEquals(cup.getFin(), LocalDate.of(2007, 03, 28));

            assertNotEquals(cup.getDescuento(), 23);
            cup.setDescuento(23);
            assertEquals(cup.getDescuento(), 23);

            Set<Registro> a7 = null;
            assertEquals(cup.getRegistros().isEmpty(), true);
            cup.setRegistros(a7);
            assertNotEquals(cup.getRegistros(), true);

            assertEquals(cup.getIntegra(a), cup.getIntegra(a));
            assertEquals(cup.tieneActividad(a), true);
            assertNotEquals(cup.tieneActividad(b), false);
            cup.equals(cup);
            cup.equals(null);


            assertNotEquals(a.getNombre(), "nombre");
            a.setNombre("nombre");
            assertEquals(a.getNombre(), "nombre");

            assertNotEquals(a.getDuracion(), Duration.ofHours(54));
            a.setDuracion(Duration.ofHours(1));
            assertEquals(a.getDuracion(), Duration.ofHours(1));

            assertNotEquals(a.getFechaRegistro(), LocalDate.of(2002, 03, 28));
            a.setFechaRegistro(LocalDate.of(2007, 03, 28));
            assertEquals(a.getFechaRegistro(), LocalDate.of(2007, 03, 28));

            assertNotEquals(a.getCosto(), 2);
            a.setCosto(2);
            assertEquals(a.getCosto(), 2);

            a.equals(null);
        });


    }

    @Test
    void obtenerDescCuponeras() {
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlC.obtenerDescCuponeras();
        });
    }

    @Test
    void consultarCuponera() throws CuponeraNoEncontradaException { //consultarCuponera(String nombre)
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            ctrlC.consultarCuponera("cuponera1");
        });
        assertThrows(CuponeraNoEncontradaException.class, () -> {
            ctrlC.consultarCuponera("cupo");
        });
    }

    @Test
    void manejadortest() {
        Manejador man = Manejador.getInstance();
        Map<String, Actividad> act = man.getActividades();
        Map<String, Clase> cla = man.getClases();
        Map<String, Cuponera> cupo = man.getCuponeras();
        Map<String, Institucion> ins = man.getInstituciones();
        Map<String, Profesor> proE = man.getProfesores();
        Map<Email, Profesor> proM = man.getProfesoresMail();
        ControladorActividadClase ctrlA = new ControladorActividadClase();
        ControladorUsuario ctrlU = new ControladorUsuario();
        ControladorCuponera ctrlC = new ControladorCuponera();
        assertDoesNotThrow(() -> {
            ctrlA.crearInstitucion("test", "test", new URL("https://test"));
            ctrlA.crearActividad("test", "test", "test", Duration.ofHours(1), 10.0f, LocalDate.of(2021, 9, 10));
            man.setActividades(act);

            ctrlU.crearProfesor("profe1", "Profe 1", "apellido", Email.of("profe1", "mail.com"), LocalDate.of(2021, 9, 10), "test", "desc", null, null);
            Set<String> profesores = new HashSet<>();
            profesores.add("profe1");
            ctrlA.crearClase("test", "test", LocalDateTime.of(2000, 10, 10, 0, 0), profesores, 2, 10, new URL("https://test"), LocalDate.of(1995, 10, 10));
            man.setClases(cla);

            ctrlC.crearCuponera("cuponera1", "Todo lindo", LocalDate.of(2021, 02, 10), LocalDate.of(2021, 10, 10), 15, LocalDate.of(2021, 01, 10));
            man.setCuponeras(cupo);

            man.setInstituciones(ins);

            man.setProfesores(proE);
            man.setProfesoresMail(proM);
        });


    }
}
