package com.entrenamosuy.tarea1.view.publicar;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.NoFinalizableException;
import com.entrenamosuy.core.exceptions.PasswordInvalidaException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;
import com.entrenamosuy.core.exceptions.SinCategoriaException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.util.FacadeContainer;

@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    private FacadeContainer facades;

    private Endpoint endpoint = null;

    public Publicador(FacadeContainer facades) {
        this.facades = facades;
    }

    @WebMethod(exclude = true)
    public void publicar() {
        String path = System.getProperty("user.home") + File.separator + ".estacionrc";
        File config = new File(path);

        String host = null;
        String port = null;
        String webservicePath = null;

        try {
            FileInputStream is = new FileInputStream(config);
            Properties configProps = new Properties();
            configProps.load(is);

            host = configProps.getProperty("host", "localhost");
            port = configProps.getProperty("port", "9128");
            webservicePath = configProps.getProperty("path", "webservice");
        } catch (Exception e) {
            host = "localhost";
            port = "9128";
            webservicePath = "webservice";
        }

        if (webservicePath.startsWith("/"))
            endpoint = Endpoint.publish("http://" + host + ":" + port + webservicePath, this);
        else
            endpoint = Endpoint.publish("http://" + host + ":" + port + "/" + webservicePath, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint(){
        return endpoint;
    }

    @WebMethod
    public void crearActividad(BeanCrearActividadArgs args) throws
        ActividadRepetidaException,
        InstitucionNoEncontradaExceptionWrapper,
        SinCategoriaExceptionWrapper {

        File img = null;

        try {
            if (args.getImagen() != null) {
                InputStream is = new ByteArrayInputStream(args.getImagen());
                img = File.createTempFile("img_", null);
                OutputStream os = new FileOutputStream(img);
                pipe(is, os);
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            facades.getFacadeActividad().crearActividad()
                .setNombre(args.getNombre())
                .setDescripcion(args.getDescripcion())
                .setInstitucion(args.getInstitucion())
                .setDuracion(Duration.ofMinutes(args.getDuracion()))
                .setCosto(args.getCosto())
                .setRegistro(LocalDate.now())
                .setCategorias(new HashSet<>(args.getCategorias()))
                .setCreador(args.getCreadorNickname())
                .setImagen(img)
                .invoke();
        } catch (InstitucionNoEncontradaException e) {
            throw new InstitucionNoEncontradaExceptionWrapper(e);
        } catch (SinCategoriaException e) {
            throw new SinCategoriaExceptionWrapper(e);
        }
    }

    @WebMethod
    public ArrayList<BeanActividad> listarActividadesAceptadas(){
        return facades
            .getFacadeActividad()
            .listarActividadesAceptadas()
            .stream()
            .map(BeanActividad::of)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    @WebMethod
    public BeanActividad getDataActividad(String act){
        BeanActividad actividad = BeanActividad.of(facades.getFacadeActividad().getDataActividad(act));
        return actividad;
    }

    @WebMethod
    public BeanInstitucion getDataInstitucion(String ins){
        BeanInstitucion institucion = BeanInstitucion.of(facades.getFacadeInstitucion().getDataInstitucion(ins));
        return institucion;
    }

    @WebMethod
    public ArrayList<String> getActividadesDeInstitucion(String institucion){
        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getActividadesDeInstitucion(institucion));

    }

    @WebMethod
    public ArrayList<String> getActividadesDeCategoria(String categoria){

        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getActividadesDeCategoria(categoria));
    }

    @WebMethod
    public ArrayList<String> getInstituciones(){
        return new ArrayList<String>(facades
            .getFacadeInstitucion()
            .getInstituciones());
    }

    @WebMethod
    public ArrayList<String> getCategorias(){
        return new ArrayList<String>(facades
            .getFacadeActividad()
            .getCategorias());
    }

    @WebMethod
    public ArrayList<String> getClasesDeActividad(String actividad){
        return new ArrayList<String>(facades
            .getFacadeClase()
            .getClases(actividad));
    }

    @WebMethod
    public ArrayList<String> getCuponerasUsablesActividad(String act, String nickname){
        return new ArrayList<String>(facades
        .getFacadeCuponera()
        .cuponerasUsables(act, nickname));
    }

    @WebMethod
    public BeanClase getDataClase(String cla){
        BeanClase clase = BeanClase.of(facades.getFacadeClase().getDataClase(cla));
        return clase;
    }

    @WebMethod
    public ArrayList<String> getSocios() {
        return new ArrayList<>(facades.getFacadeUsuario().getSocios());
    }

    @WebMethod
    public ArrayList<String> getProfesores() {
        return new ArrayList<>(facades.getFacadeUsuario().getProfesores());
    }

    @WebMethod
    public BeanSocio getDataSocio(String nickname) {
        return BeanSocio.of(facades.getFacadeUsuario().getDataSocio(nickname));
    }

    @WebMethod
    public BeanProfesor getDataProfesor(String nickname) {
        return BeanProfesor.of(facades.getFacadeUsuario().getDataProfesor(nickname));
    }

    @WebMethod
    public void seguirUsuario(String seguido, String seguidor) {
        facades.getFacadeUsuario().seguirUsuario(seguido, seguidor);
    }

    @WebMethod
    public void dejarDeSeguirUsuario(String seguido, String seguidor) {
        facades.getFacadeUsuario().dejarDeSeguirUsuario(seguido, seguidor);
    }

    @WebMethod
    public void crearSocio(BeanCrearSocioArgs args) throws UsuarioRepetidoException {
        File img = null;

        try {
            if (args.getImagen() != null) {
                InputStream is = new ByteArrayInputStream(args.getImagen());
                img = File.createTempFile("img_", null);
                OutputStream os = new FileOutputStream(img);
                pipe(is, os);
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("imagen de socio: " + img.getAbsolutePath());

        facades.getFacadeUsuario().crearSocio()
            .setNickname(args.getNickname())
            .setNombre(args.getNombre())
            .setApellido(args.getApellido())
            .setCorreo(args.getCorreo().toEmail())
            .setNacimiento(args.getNacimiento().toLocalDate())
            .setPassword(args.getPassword())
            .setImagen(img)
            .invoke();
    }

    @WebMethod
    public void crearProfesor(BeanCrearProfesorArgs args) throws UsuarioRepetidoException {
        File img = null;

        try {
            if (args.getImagen() != null) {
                InputStream is = new ByteArrayInputStream(args.getImagen());
                img = File.createTempFile("img_", null);
                OutputStream os = new FileOutputStream(img);
                pipe(is, os);
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("imagen de profesor: " + img.getAbsolutePath());

        facades.getFacadeUsuario().crearProfesor()
            .setNickname(args.getNickname())
            .setNombre(args.getNombre())
            .setApellido(args.getApellido())
            .setCorreo(args.getCorreo().toEmail())
            .setNacimiento(args.getNacimiento().toLocalDate())
            .setInstitucion(args.getInstitucion())
            .setDescripcion(args.getDescripcion())
            .setBiografia(args.getBio())
            .setSitioWeb(args.getLink())
            .setPassword(args.getPassword())
            .setImagen(img)
            .invoke();
    }

    private static byte[] getImagen(File img) {
        if (img == null)
            return null;

        byte[] ret = null;

        try {
            FileInputStream is = new FileInputStream(img);
            ret = new byte[(int) img.length()];
            is.read(ret);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    @WebMethod
    public byte[] getImagenUsuario(String nickname) {
        File img = facades.getFacadeUsuario().getImagenUsuario(nickname);
        return getImagen(img);
    }


    @WebMethod
    public byte[] getImagenClase(String nombre) {
        File img = facades.getFacadeClase().getImagenClase(nombre);
        return getImagen(img);
    }

    @WebMethod
    public byte[] getImagenActividad(String nombre) {
        File img = facades.getFacadeActividad().getImagenActividad(nombre);
        return getImagen(img);
    }

    @WebMethod
    public byte[] getImagenInstitucion(String nombre) {
        File img = facades.getFacadeInstitucion().getImagenInstitucion(nombre);
        return getImagen(img);
    }

    @WebMethod
    public byte[] getImagenCuponera(String nombre) {
        File img = facades.getFacadeCuponera().getImagenCuponera(nombre);
        return getImagen(img);
    }

    @WebMethod
    public void validarCredenciales(String nickname, String password) throws PasswordInvalidaException, UsuarioNoEncontradoExceptionWrapper {
        try {
            facades.getFacadeUsuario().validarCredenciales(nickname, password);
        } catch (UsuarioNoEncontradoException e) {
            throw new UsuarioNoEncontradoExceptionWrapper(e);
        }
    }

    @WebMethod
    public void validarCredencialesMovil(String nickname, String password) throws PasswordInvalidaException, UsuarioNoEncontradoExceptionWrapper {
        try {
            facades.getFacadeUsuario().validarCredencialesMovil(nickname, password);
        } catch (UsuarioNoEncontradoException e) {
            throw new UsuarioNoEncontradoExceptionWrapper(e);
        }
    }

    @WebMethod
    public void registrarseSinCuponera(String nickname, String clase, BeanLocalDate fecha) throws RegistroInconsistenteExceptionWrapper {
        try {
            facades.getFacadeActividad().registrarseSinCuponera(nickname, clase, fecha.toLocalDate());
        } catch (RegistroInconsistenteException e) {
            throw new RegistroInconsistenteExceptionWrapper(e);
        }
    }

    @WebMethod
    public void registrarseConCuponera(String nickname, String clase, String cuponera, BeanLocalDate fecha) throws RegistroInconsistenteExceptionWrapper {
        try {
            facades.getFacadeActividad().registrarseConCuponera(nickname, clase, cuponera, fecha.toLocalDate());
        } catch (RegistroInconsistenteException e) {
            throw new RegistroInconsistenteExceptionWrapper(e);
        }
    }

    @WebMethod
    public void crearClase(BeanCrearClaseArgs args) throws ClaseInconsistenteExceptionWrapper {
        File img = null;

        try {
            if (args.getImagen() != null) {
                InputStream is = new ByteArrayInputStream(args.getImagen());
                img = File.createTempFile("img_", null);
                OutputStream os = new FileOutputStream(img);
                pipe(is, os);
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            facades.getFacadeClase().crearClase()
                .setNombreActividad(args.getActividad())
                .setNombre(args.getNombre())
                .setInicio(args.getInicio().toLocalDateTime())
                .setNicknameProfesores(new HashSet<>(args.getNicknameProfesores()))
                .setCantMin(args.getCantMin())
                .setCantMax(args.getCantMax())
                .setAcceso(args.getAcceso())
                .setFechaRegistro(args.getRegistro().toLocalDate())
                .setImagen(img)
                .invoke();
        } catch (ClaseInconsistenteException e) {
            throw new ClaseInconsistenteExceptionWrapper(e);
        }
    }

    @WebMethod
    public void realizarSorteo(String clase){
        facades.getFacadeClase().realizarSorteo(clase);
    }

    @WebMethod
    public List<BeanSocio> getGanadores(String clase){
        return facades
                .getFacadeClase()
                .getGanadores(clase)
                .stream()
                .map(BeanSocio::of)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @WebMethod
    public List<BeanSocio> getRegistrados(String clase){
        return facades
                .getFacadeClase()
                .getRegistrados(clase)
                .stream()
                .map(BeanSocio::of)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @WebMethod
    public int getEstadoSorteo(String clase) {
    	return facades.getFacadeClase().getEstadoSorteo(clase);
    }

    @WebMethod
    public void marcarComoFav(String socio, String actividad){
        facades.getFacadeUsuario().marcarComoFav(socio, actividad);
    }

    @WebMethod
    public void desmarcarComoFav(String socio, String actividad){
        facades.getFacadeUsuario().desmarcarComoFav(socio, actividad);
    }

    @WebMethod
    public boolean esFav(String socio, String actividad){
        return facades.getFacadeUsuario().esFav(socio, actividad);
    }

    @WebMethod
    public void finalizarActividad(String actividad) throws NoFinalizableExceptionWrapper{
        try {
            facades.getFacadeActividad().finalizarActividad(actividad);
        } catch (NoFinalizableException e) {
            throw new NoFinalizableExceptionWrapper(e);
        } 
    }

    @WebMethod
    public boolean chequearSiClaseDictada(String cla){
        return facades.getFacadeClase().chequearSiClaseDictada(cla);
    }
}