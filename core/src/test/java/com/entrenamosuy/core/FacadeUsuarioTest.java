package com.entrenamosuy.core;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.DataUsuario;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.exceptions.EmailParseException;
import com.entrenamosuy.core.exceptions.PasswordInvalidaException;
import com.entrenamosuy.core.exceptions.SocioNoEncontradoException;
import com.entrenamosuy.core.util.FacadeContainer;
import org.junit.jupiter.api.Test;

public class FacadeUsuarioTest {

    @Test
    public void crearSocio() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test2")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test")
                .setPassword("pass")
                .setCorreo(Email.of("test2", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });
    }

    @Test
    public void crearProfesor() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test2", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });

        assertThrows(UsuarioRepetidoException.class, () -> {
            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test2")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });
    }
    

    @Test
    public void getSocios() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                .setNombre("test")
                .setApellido("test")
                .setNickname("test")
                .setPassword("pass")
                .setCorreo(Email.of("test", "mail.com"))
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();
        });
        
        Set<String> ret = facades.getFacadeUsuario().getSocios();
        assertTrue(ret.contains("test"));

        assertThrows(SocioNoEncontradoException.class, () -> {
                facades.getFacadeUsuario().getDataSocio("nickname");
        });

    }

    @Test
    public void getProfesores() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });
        
        Set<String> ret = facades.getFacadeUsuario().getProfesores();
        assertTrue(ret.contains("test"));
    }

    @Test
    public void getDataProfesor() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("cup1")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s1")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s1", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s2")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s2", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().seguirUsuario("s1", "test");
            facades.getFacadeUsuario().seguirUsuario("s2", "test");
            facades.getFacadeUsuario().seguirUsuario("test", "s2");
        });

        DataProfesor ret = facades.getFacadeUsuario().getDataProfesor("test");

        assertEquals("test", ret.getNickname());
        assertEquals("test", ret.getNombre());
        assertEquals("test", ret.getApellido());
        assertEquals("test", ret.getDescripcion());
        assertEquals("test", ret.getInstitucion());
        assertEquals(LocalDate.of(1999, 1, 1), ret.getNacimiento());
    }

    @Test
    public void getDataSocio() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeCuponera().crearCuponera()
                    .setNombre("cup1")
                    .setDescripcion("test")
                    .setInicio(LocalDate.of(1999, 1, 1))
                    .setFin(LocalDate.of(2000, 1, 1))
                    .setDescuento(50)
                    .setFechaRegistro(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s1")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s1", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s2")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s2", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s3")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s3", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s4")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s4", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

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

            facades.getFacadeClase().crearClase()
                    .setNombre("c1")
                    .setNombreActividad("a1")
                    .setFechaRegistro(LocalDate.of(2000, 1, 1))
                    .setCantMin(1)
                    .setCantMax(10)
                    .setAcceso(new URL("https://test"))
                    .setInicio(LocalDateTime.of(2000, 10, 1, 0, 0))
                    .invoke();

            facades.getFacadeUsuario().seguirUsuario("s2", "s1");
            facades.getFacadeUsuario().seguirUsuario("s3", "s1");
            facades.getFacadeUsuario().seguirUsuario("s1", "s4");
            facades.getFacadeUsuario().seguirUsuario("s1", "s3");

            facades.getFacadeCuponera().comprarCuponera("s1", "cup1");

            facades.getFacadeActividad().registarseSinCuponera("s1", "c1", LocalDate.of(2000, 1, 1));
        });

        DataSocio ret = facades.getFacadeUsuario().getDataSocio("s1");

        assertEquals("test", ret.getApellido());
        assertEquals("test", ret.getNombre());
        assertEquals("s1", ret.getNickname());
        assertEquals(Email.of("s1", "mail.com"), ret.getCorreo());
        assertEquals(LocalDate.of(1999, 1, 1), ret.getNacimiento());
    }
    
    @Test
    public void modificarDatosSocio() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s1")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s1", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();
            
            facades.getFacadeUsuario().modificarDatosSocio()
                .setNickname("s1")
                .setNombre("s1")
                .setNacimiento(LocalDate.of(2000, 1, 1))
                .setApellido("s1")
                .invoke();
        });

        DataSocio ret = facades.getFacadeUsuario().getDataSocio("s1");
        
        assertEquals("s1", ret.getNombre());
        assertEquals("s1", ret.getApellido());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getNacimiento());
    }
    
    @Test
    public void modificarDatosProfesor() throws MalformedURLException {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("test")
                    .setCorreo(Email.of("test", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
            
            facades.getFacadeUsuario().modificarDatosProfesor()
                    .setNickname("test")
                    .setNombre("prof")
                    .setApellido("prof")
                    .setDescripcion("desc")
                    .setBiografia("bio")
                    .setNacimiento(LocalDate.of(2000, 1, 1))
                    .setSitioWeb(new URL("https://url"))
                    .invoke();
        });

        DataProfesor ret = facades.getFacadeUsuario().getDataProfesor("test");

        assertEquals("prof", ret.getNombre());
        assertEquals("prof", ret.getApellido());
        assertEquals("desc", ret.getDescripcion());
        assertEquals("bio", ret.getBiografia());
        assertEquals(LocalDate.of(2000, 1, 1), ret.getNacimiento());
        assertEquals(new URL("https://url"), ret.getSitioWeb());
    }

    @Test
    public void seguirUsuarios() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s1")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s1", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s2")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s2", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s3")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s3", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();

            facades.getFacadeUsuario().crearSocio()
                    .setNickname("s4")
                    .setNombre("test")
                    .setApellido("test")
                    .setCorreo(Email.of("s4", "mail.com"))
                    .setPassword("pass")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .invoke();
        });

        facades.getFacadeUsuario().seguirUsuario("s2", "s1");
        facades.getFacadeUsuario().seguirUsuario("s3", "s1");
        facades.getFacadeUsuario().seguirUsuario("s3", "s2");
        facades.getFacadeUsuario().seguirUsuario("s1", "s3");
        facades.getFacadeUsuario().seguirUsuario("s1", "s4");
        facades.getFacadeUsuario().seguirUsuario("s3", "s4");

        DataUsuario dataUsuario1 = facades.getFacadeUsuario().getDataSocio("s1");
        DataUsuario dataUsuario2 = facades.getFacadeUsuario().getDataSocio("s2");
        DataUsuario dataUsuario3 = facades.getFacadeUsuario().getDataSocio("s3");
        DataUsuario dataUsuario4 = facades.getFacadeUsuario().getDataSocio("s4");

        assertTrue(dataUsuario1.getSeguidores().contains("s3"));
        assertTrue(dataUsuario1.getSeguidores().contains("s4"));
        assertEquals(2, dataUsuario1.getSeguidores().size());
        assertTrue(dataUsuario2.getSeguidores().contains("s1"));
        assertEquals(1, dataUsuario2.getSeguidores().size());
        assertTrue(dataUsuario3.getSeguidores().contains("s1"));
        assertTrue(dataUsuario3.getSeguidores().contains("s2"));
        assertTrue(dataUsuario3.getSeguidores().contains("s4"));
        assertEquals(3, dataUsuario3.getSeguidores().size());
        assertEquals(0, dataUsuario4.getSeguidores().size());

        assertTrue(dataUsuario1.getSeguidos().contains("s2"));
        assertTrue(dataUsuario1.getSeguidos().contains("s3"));
        assertEquals(2, dataUsuario1.getSeguidos().size());
        assertTrue(dataUsuario2.getSeguidos().contains("s3"));
        assertEquals(1, dataUsuario2.getSeguidos().size());
        assertTrue(dataUsuario3.getSeguidos().contains("s1"));
        assertEquals(1, dataUsuario3.getSeguidos().size());
        assertTrue(dataUsuario4.getSeguidos().contains("s1"));
        assertTrue(dataUsuario4.getSeguidos().contains("s3"));
        assertEquals(2, dataUsuario4.getSeguidos().size());

        facades.getFacadeUsuario().dejarDeSeguirUsuario("s3", "s4");
        facades.getFacadeUsuario().dejarDeSeguirUsuario("s2", "s1");
        facades.getFacadeUsuario().dejarDeSeguirUsuario("s1", "s3");
        facades.getFacadeUsuario().dejarDeSeguirUsuario("s1", "s4");
        facades.getFacadeUsuario().seguirUsuario("s2", "s4");
        facades.getFacadeUsuario().seguirUsuario("s4", "s1");
        facades.getFacadeUsuario().seguirUsuario("s1", "s2");

        dataUsuario1 = facades.getFacadeUsuario().getDataSocio("s1");
        dataUsuario2 = facades.getFacadeUsuario().getDataSocio("s2");
        dataUsuario3 = facades.getFacadeUsuario().getDataSocio("s3");
        dataUsuario4 = facades.getFacadeUsuario().getDataSocio("s4");

        assertTrue(dataUsuario1.getSeguidores().contains("s2"));
        assertEquals(1, dataUsuario1.getSeguidores().size());
        assertTrue(dataUsuario2.getSeguidores().contains("s4"));
        assertEquals(1, dataUsuario2.getSeguidores().size());
        assertTrue(dataUsuario3.getSeguidores().contains("s1"));
        assertTrue(dataUsuario3.getSeguidores().contains("s2"));
        assertEquals(2, dataUsuario3.getSeguidores().size());
        assertTrue(dataUsuario4.getSeguidores().contains("s1"));
        assertEquals(1, dataUsuario4.getSeguidores().size());

        assertTrue(dataUsuario1.getSeguidos().contains("s3"));
        assertTrue(dataUsuario1.getSeguidos().contains("s4"));
        assertEquals(2, dataUsuario1.getSeguidos().size());
        assertTrue(dataUsuario2.getSeguidos().contains("s1"));
        assertTrue(dataUsuario2.getSeguidos().contains("s3"));
        assertEquals(2, dataUsuario2.getSeguidos().size());
        assertEquals(0, dataUsuario3.getSeguidos().size());
        assertTrue(dataUsuario4.getSeguidos().contains("s2"));
        assertEquals(1, dataUsuario4.getSeguidos().size());
    }

    @Test
    public void getProfesoresDeInstitucion() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("p1")
                    .setCorreo(Email.of("p1", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("p2")
                    .setCorreo(Email.of("p2", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();
        });

        Set<String> ret = facades.getFacadeUsuario().getProfesoresDeInstitucion("test");

        assertEquals(2, ret.size());
        assertTrue(ret.contains("p1"));
        assertTrue(ret.contains("p2"));
    }

    @Test
    public void validarCredenciales() {
        Fabrica fabrica = new Fabrica();
        FacadeContainer facades = fabrica.createFacades();

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().crearSocio()
                .setNickname("s1")
                .setNombre("test")
                .setApellido("test")
                .setCorreo(Email.of("s1", "mail.com"))
                .setPassword("pass")
                .setNacimiento(LocalDate.of(1999, 1, 1))
                .invoke();

            facades.getFacadeInstitucion().crearInstitucion()
                    .setNombre("test")
                    .setDescripcion("test")
                    .setDescripcion("test")
                    .setUrl(new URL("https://test"))
                    .invoke();

            facades.getFacadeUsuario().crearProfesor()
                    .setNickname("p1")
                    .setCorreo(Email.of("p1", "mail.com"))
                    .setNombre("test")
                    .setApellido("test")
                    .setDescripcion("test")
                    .setPassword("pass")
                    .setInstitucion("test")
                    .setNacimiento(LocalDate.of(1999, 1, 1))
                    .setSitioWeb(new URL("https://test"))
                    .invoke();

        });

        assertThrows(PasswordInvalidaException.class, () -> {
            facades.getFacadeUsuario().validarCredenciales("s1", "mal");
        });

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().validarCredenciales("s1", "pass");
        });

        assertThrows(PasswordInvalidaException.class, () -> {
            facades.getFacadeUsuario().validarCredenciales("p1", "mal");
        });

        assertDoesNotThrow(() -> {
            facades.getFacadeUsuario().validarCredenciales("p1", "pass");
        });
    }
}
