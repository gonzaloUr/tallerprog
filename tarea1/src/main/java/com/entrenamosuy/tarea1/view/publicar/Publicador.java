package com.entrenamosuy.tarea1.view.publicar;

import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.Endpoint;

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
        endpoint = Endpoint.publish("http://localhost:9128/webservices", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint(){
        return endpoint;
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

    /*
    @WebMethod
    public void crearSocio(BeanCrearSocioArgs args) throws Exception {
        File img = null;

        if (args.getImagen() != null) {
            InputStream is = args.getImagen().openStream();
            img = File.createTempFile("img_", null);
            OutputStream os = new FileOutputStream(img);
            pipe(is, os);
            os.close();
        }

        facades.getFacadeUsuario().crearSocio()
            .setNickname(args.getNickname())
            .setNombre(args.getNombre())
            .setApellido(args.getApellido())
            .setCorreo(args.getCorreo())
            .setNacimiento(args.getNacimiento())
            .setPassword(args.getPassword())
            .setImagen(img)
            .invoke();
    }

    @WebMethod
    public void crearProfesor(BeanCrearProfesorArgs args) throws Exception {
        File img = null;

        if (args.getImagen() != null) {
            InputStream is = args.getImagen().openStream();
            img = File.createTempFile("img_", null);
            OutputStream os = new FileOutputStream(img);
            pipe(is, os);
            os.close();
        }

        facades.getFacadeUsuario().crearProfesor()
            .setNickname(args.getNickname())
            .setNombre(args.getNombre())
            .setApellido(args.getApellido())
            .setCorreo(args.getCorreo())
            .setNacimiento(args.getNacimiento())
            .setInstitucion(args.getInstitucion())
            .setDescripcion(args.getDescripcion())
            .setBiografia(args.getBio())
            .setSitioWeb(args.getLink())
            .setPassword(args.getPassword())
            .setImagen(img)
            .invoke();
    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }
    */
}
