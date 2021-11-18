package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.ActividadNoEncontradaException;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.CategoriaNoEncontradaException;
import com.entrenamosuy.core.exceptions.ClaseNoEncontradaException;
import com.entrenamosuy.core.exceptions.CuponeraNoEncontradaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.model.ActividadEstado;
import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

public class FacadeActividadTest {

    @Test
    public void crearActividad() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        facades.getFacadeActividad().crearCategoria("cat1");
        Set<String> categorias = new HashSet<>();
        categorias.add("cat1");

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();

            facades.getFacadeActividad().crearActividad()
                    .setNombre("test2")
                    .setDescripcion("test2")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(1))
                    .setCosto(10f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();
        });

        // No se puede crear actividades con nombres repetidos.
        assertThrows(ActividadRepetidaException.class, () -> {
            facades.getFacadeActividad().crearActividad()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setInstitucion("test")
                    .setDuracion(Duration.ofHours(2))
                    .setCosto(15f)
                    .setRegistro(LocalDate.of(2021, 9, 10))
                    .setCategorias(categorias)
                    .invoke();
        });

        // La actividad esta asociada a una institucion valida.
        assertThrows(InstitucionNoEncontradaException.class, () -> {
            facades.getFacadeActividad().crearActividad()
                    .setNombre("test3")
                    .setDescripcion("test3")
                    .setInstitucion("institucion")
                    .setDuracion(Duration.ofMinutes(45))
                    .setCosto(200f)
                    .setRegistro(LocalDate.of(2000, 1, 1))
                    .setCategorias(categorias)
                    .invoke();
        });
    }

    @Test
    public void getDataActividad() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();
        });

        assertThrows(ActividadNoEncontradaException.class, () -> {
            DataActividad ret = facades.getFacadeActividad().getDataActividad("Coso");
        });

        assertThrows(CategoriaNoEncontradaException.class, () -> {
            facades.getFacadeActividad().crearCategoria("cat3");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat4");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a6")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();
        });

        DataActividad ret = facades.getFacadeActividad().getDataActividad("a1");
        assertEquals("a1", ret.getNombre());
        assertEquals("a1", ret.getDescripcion());
        assertEquals(Duration.ofHours(1), ret.getDuracion());
        assertEquals(10f, ret.getCosto());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getRegistro());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getRegistro());

        Set<String> categorias = new HashSet<>();
        categorias.add("cat1");

        assertEquals(categorias, ret.getCategorias());
    }

    @Test
    public void getActividadesDeInstitucion() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();

            facades.getFacadeActividad().crearActividad()
                .setNombre("a2")
                .setInstitucion("i1")
                .setDescripcion("a2")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();

            facades.getFacadeActividad().aceptarActividad("a1");
            facades.getFacadeActividad().aceptarActividad("a2");
        });


        Set<String> ret = facades.getFacadeActividad().getActividadesDeInstitucion("i1");

        assertEquals(2, ret.size());
        assertTrue(ret.contains("a1"));
        assertTrue(ret.contains("a2"));
    }

    @Test
    public void getActividadesDeCategoria() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .setEstado(ActividadEstado.ACEPTADA)
                .invoke();

            facades.getFacadeActividad().crearActividad()
                .setNombre("a2")
                .setInstitucion("i1")
                .setDescripcion("a2")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .setEstado(ActividadEstado.ACEPTADA)
                .invoke();
        });

        Set<String> ret = facades.getFacadeActividad().getActividadesDeCategoria("cat1");

        assertEquals(ret.size(), 2);
        assertTrue(ret.contains("a1"));
        assertTrue(ret.contains("a2"));
    }

    @Test
    public void getCategorias() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeActividad().crearCategoria("c1");
            facades.getFacadeActividad().crearCategoria("c2");
            facades.getFacadeActividad().crearCategoria("c3");
            facades.getFacadeActividad().crearCategoria("c4");
        }); 
        
        Set<String> ret = facades.getFacadeActividad().getCategorias();

        assertEquals(4, ret.size());
        assertTrue(ret.contains("c1"));
    }
    
    @Test 
    public void listarActividadesIngresadas() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {

            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");
                
            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();
        });

        Set<DataActividad> ret = facades.getFacadeActividad().listarActividadesIngresadas();
            
        assertEquals(1, ret.size());
        assertEquals("a1", ((DataActividad) ret.toArray()[0]).getNombre());
    }

    @Test
    public void rechazarActividad() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

            facades.getFacadeActividad().crearCategoria("cat1");
            Set<String> categorias = new HashSet<>();
            categorias.add("cat1");

            facades.getFacadeActividad().crearActividad()
                .setNombre("a1")
                .setInstitucion("i1")
                .setDescripcion("a1")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();

            facades.getFacadeActividad().crearActividad()
                .setNombre("a2")
                .setInstitucion("i1")
                .setDescripcion("a2")
                .setCosto(10f)
                .setDuracion(Duration.ofHours(1))
                .setRegistro(LocalDate.of(2000, 1, 1))
                .setCategorias(categorias)
                .invoke();

            facades.getFacadeActividad().rechazarActividad("a1");
            facades.getFacadeActividad().rechazarActividad("a2");
        });
    }

    @Test
    public void registrarseSinCuponera(){
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();
        
        assertDoesNotThrow(() -> {
        facades.getFacadeInstitucion().crearInstitucion()
                .setNombre("i1")
                .setDescripcion("i1")
                .setUrl(new URL("https://test"))
                .invoke();

        facades.getFacadeActividad().crearCategoria("cat1");
        Set<String> categorias = new HashSet<>();
        categorias.add("cat1");
        
        
        facades.getFacadeActividad().crearActividad()
        .setNombre("a2")
        .setInstitucion("i1")
        .setDescripcion("a2")
        .setCosto(10f)
        .setDuracion(Duration.ofHours(1))
        .setRegistro(LocalDate.of(2000, 1, 1))
        .setCategorias(categorias)
        .invoke();

        facades.getFacadeActividad().aceptarActividad("a2");

        facades.getFacadeUsuario().crearProfesor()
                    .setNickname("p1")
                    .setNombre("p1")
                    .setApellido("p1")
                    .setDescripcion("p1")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNacimiento(LocalDate.of(2000, 1, 1))
                    .setPassword("pass")
                    .setInstitucion("i1")
                    .invoke();

        facades.getFacadeUsuario().crearSocio()
            .setNombre("test")
            .setApellido("test")
            .setNickname("alfonso")
            .setPassword("pass")
            .setCorreo(Email.of("jhgjhgtghjfhfdgdhfgdghffgh", "mail.com"))
            .setNacimiento(LocalDate.of(1999, 1, 1))
            .invoke();


        Set<String> profesoresNickname = new HashSet<>();
        profesoresNickname.add("p1");
        

        facades.getFacadeClase().crearClase()
                .setNombre("clase1")
                .setNombreActividad("a2")
                .setNicknameProfesores(profesoresNickname)
                .setFechaRegistro(LocalDate.of(2000, 1, 1))
                .setCantMin(1)
                .setCantMax(10)
                .setAcceso(new URL("https://test"))
                .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                .invoke();
        
        facades.getFacadeCuponera().crearCuponera()
                .setNombre("c1")
                .setDescripcion("test")
                .setInicio(LocalDate.of(2000, 2, 2))
                .setFin(LocalDate.of(2000, 2, 5))
                .setFechaRegistro(LocalDate.of(1999, 2, 2))
                .setDescuento(50)
                .setImagen(null)
                .invoke();
        });

        assertThrows (ClaseNoEncontradaException.class, ()-> {
            facades.getFacadeActividad().registrarseConCuponera("alfonso", null, "c1", LocalDate.now());
        });

        assertThrows (CuponeraNoEncontradaException.class, ()-> {
            facades.getFacadeActividad().registrarseConCuponera("alfonso", "clase1", null, LocalDate.now());
        });
        
        assertThrows (UsuarioNoEncontradoException.class, ()-> {
            facades.getFacadeActividad().registrarseConCuponera(null, "clase1", "c1", LocalDate.now());
        });

        assertDoesNotThrow(() -> {
            facades.getFacadeClase().getClases("a2");       
        });

    }
    }      

