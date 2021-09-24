package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DescActividad;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.util.FacadeContainer;

import org.junit.jupiter.api.Test;

public class FacadeCuponeraTest {

    @Test
    public void crearCuponera() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> facades.getFacadeCuponera().crearCuponera()
                .setNombre("test")
                .setDescripcion("test")
                .setInicio(LocalDate.of(2000, 2, 2))
                .setFin(LocalDate.of(2000, 2, 5))
                .setFechaRegistro(LocalDate.of(1999, 2, 2))
                .setDescuento(50)
                .setImagen(null)
                .invoke());

        assertTrue(facades.getRegistry().getCuponeras().containsKey("test"));
    }

    @Test
    public void cuponerasUsables() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                .setNickname("test")
                .setNombre("test")
                .setApellido("test")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();

            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("test")
                .setDescripcion("test")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setDescripcion("test")
                .setInstitucion("test")
                .setDuracion(Duration.ofHours(1))
                .setCosto(1f)
                .setRegistro(LocalDate.of(1999, 1, 1))
                .setCategoriasString(categorias)
                .invoke();

            facades.getFacadeActividad().crearActividad()
                .setNombre("a2")
                .setDescripcion("test")
                .setInstitucion("test")
                .setDuracion(Duration.ofHours(1))
                .setCosto(1f)
                .setRegistro(LocalDate.of(1999, 1, 1))
                .setCategoriasString(categorias)
                .invoke();

            facades.getFacadeClase().crearClase()
                .setNombre("clase1")
                .setNombreActividad("a1")
                .setFechaRegistro(LocalDate.of(1999, 1, 1))
                .setCantMin(1)
                .setCantMax(10)
                .setAcceso(new URL("https://test"))
                .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                .invoke();

            facades.getFacadeCuponera().crearCuponera()
                .setNombre("c1")
                .setDescripcion("test")
                .setInicio(LocalDate.of(1999, 1, 1))
                .setFin(LocalDate.of(2000, 1, 1))
                .setDescuento(50)
                .setFechaRegistro(LocalDate.of(1999, 1, 1))
                .invoke();

            facades.getFacadeCuponera().crearCuponera()
                .setNombre("c2")
                .setDescripcion("test")
                .setInicio(LocalDate.of(1999, 1, 1))
                .setFin(LocalDate.of(2000, 1, 1))
                .setDescuento(50)
                .setFechaRegistro(LocalDate.of(1999, 1, 1))
                .invoke();

            facades.getFacadeCuponera().comprarCuponera("test", "c1");
            facades.getFacadeCuponera().comprarCuponera("test", "c2");
            facades.getFacadeCuponera().agregarACuponera("c1", "a1", 2);
            facades.getFacadeCuponera().agregarACuponera("c2", "a2", 3);
            facades.getFacadeCuponera().agregarACuponera("c2", "a1", 1);

            facades.getFacadeActividad().registraseConCuponera("test", "clase1", "c2", LocalDate.of(1999, 9, 9));
        });

        Set<String> ret = facades.getFacadeCuponera().cuponerasUsables("a1", "test");

        assertEquals(ret.size(), 1);
        assertTrue(ret.contains("c1"));
    }

    @Test
    public void actividadesAgregables() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a1")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a2")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a3")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a4")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(categorias)
                    .invoke();

            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("c1")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeCuponera().agregarACuponera("c1", "a1", 1);

            facades.getFacadeActividad().aceptarActividad("a2");
            facades.getFacadeActividad().aceptarActividad("a3");
        });

        Set<String> ret = facades.getFacadeCuponera().actividadesAgregables("c1", "test");

        assertEquals(2, ret.size());
        assertTrue(ret.contains("a2"));
        assertTrue(ret.contains("a3"));
    }

    @Test
    public void getCuponeras() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("c1")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("c2")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("c3")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();
        });

        Set<String> ret = facades.getFacadeCuponera().getCuponeras();

        assertEquals(3, ret.size());
        assertTrue(ret.contains("c1"));
        assertTrue(ret.contains("c2"));
        assertTrue(ret.contains("c3"));
    }

    @Test
    public void getDataCuponera() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeActividad().crearCategoria("c1");
            facades.getFacadeActividad().crearCategoria("c2");
            facades.getFacadeActividad().crearCategoria("c3");
            facades.getFacadeActividad().crearCategoria("c4");

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a1")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(Collections.singleton("c1"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a2")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(Collections.singleton("c2"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a3")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(Collections.singleton("c3"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("a4")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(1f)
                    .setRegistro(LocalDate.of(1999, 1, 1))
                    .setCategoriasString(Collections.singleton("c4"))
                    .invoke();

            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .setInicio(LocalDate.of(2000, 1, 1))
                    .setFin(LocalDate.of(2001, 1, 1))
                    .invoke();

            facades.getFacadeCuponera().agregarACuponera("test", "a1", 4);
            facades.getFacadeCuponera().agregarACuponera("test", "a2", 1);
            facades.getFacadeCuponera().agregarACuponera("test", "a3", 3);
            facades.getFacadeCuponera().agregarACuponera("test", "a4", 2);
        });

        DataCuponera ret = facades.getFacadeCuponera().getDataCuponera("test");

        assertEquals("test", ret.getNombre());
        assertEquals("test", ret.getDescripcion());

        DescActividad a1 = new DescActividad("a1", "test", Duration.ofHours(1), LocalDate.of(1999, 1, 1), 1f);
        DescActividad a2 = new DescActividad("a2", "test", Duration.ofHours(1), LocalDate.of(1999, 1, 1), 1f);
        DescActividad a3 = new DescActividad("a3", "test", Duration.ofHours(1), LocalDate.of(1999, 1, 1), 1f);
        DescActividad a4 = new DescActividad("a4", "test", Duration.ofHours(1), LocalDate.of(1999, 1, 1), 1f);

        assertEquals(4, ret.getActividades().size());
        assertTrue(ret.getActividades().contains(a1));
        assertTrue(ret.getActividades().contains(a2));
        assertTrue(ret.getActividades().contains(a3));
        assertTrue(ret.getActividades().contains(a4));

        assertEquals(4, ret.getCategorias().size());
        assertTrue(ret.getCategorias().contains("c1"));
        assertTrue(ret.getCategorias().contains("c2"));
        assertTrue(ret.getCategorias().contains("c3"));
        assertTrue(ret.getCategorias().contains("c4"));
    }
}
