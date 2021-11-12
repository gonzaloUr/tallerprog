package com.entrenamosuy.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
//import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.crypto.Data;


// import com.entrenamosuy.core.data.DataActividad;
// import com.entrenamosuy.core.data.DataClase;
// import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.web.publicar.DataActividad;
import com.entrenamosuy.web.publicar.DataClase;
import com.entrenamosuy.web.publicar.DataCuponera;
import com.entrenamosuy.web.publicar.HashSet;
import com.entrenamosuy.web.publicar.PublicadorActividad;
import com.entrenamosuy.web.publicar.PublicadorActividadService;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class ActividadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorActividadService service = new PublicadorActividadService();
        PublicadorActividad port = service.getPublicadorActividadPort();

        if(path.equals("/lista_actividades")) {
            // Set<DataActividad> acts = Facades
            //     .getFacades()
            //     .getFacadeActividad()
            //     .listarActividadesAceptadas();
            
            ArrayList<DataActividad> acts = port.listarActividadesAceptadas();

            request.setAttribute("actividades", acts);
            request.getRequestDispatcher("/lista_actividades.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_actividad")) {
            String act = request.getParameter("nombre");
            // DataActividad actividad = Facades.getFacades().getFacadeActividad().getDataActividad(act);
            DataActividad actividad = port.getDataActividad(act);

            String nombre = actividad.getNombre();
            String descripcion = actividad.getDescripcion();

            Set<String> clasesOfrecidas = actividad.getClases()
                .stream()
                .map(DataClase::getNombre)
                .collect(Collectors.toSet());

            Set<String> cuponerasAsociadas = actividad.getCuponeras()
                .stream()
                .map(DataCuponera::getNombre)
                .collect(Collectors.toSet());

            Set<String> categoriasAsociadas = actividad.getCategorias()
                .stream()
                .collect(Collectors.toSet());
            //Duration duracion = actividad.getDuracion();
            Integer dura = 3;

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("clasesOfrecidas", clasesOfrecidas);
            request.setAttribute("cuponerasAsociadas", cuponerasAsociadas);
            request.setAttribute("categoriasAsociadas", categoriasAsociadas);
            request.setAttribute("duracion", dura);

            request
                .getRequestDispatcher("/consulta_actividad.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_institucion")) {
            // TODO: cambiar a webService.

            String institucionNombre = request.getParameter("institucion");
            DataInstitucion institucion = Facades
                .getFacades()
                .getFacadeInstitucion()
                .getDataInstitucion(institucionNombre);

            String nombre = institucion.getNombre();
            String descripcion = institucion.getDescripcion();
            String url = institucion.getUrl().toString();
            Set<String> actividadesOfrecidas = Facades.getFacades().getFacadeActividad().getActividadesDeInstitucion(nombre);

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("actividadesOfrecidas", actividadesOfrecidas);

            request.getRequestDispatcher("/consulta_institucion.jsp")
                .forward(request, response);

        }  else if (path=="/alta_actividad") {
            processRequest(request, response);
        } else if (path.equals("/consulta_categoria")) {
            String cat = request.getParameter("categoria");
            Set<String> catActividades = Facades
                .getFacades()
                .getFacadeActividad()
                .getActividadesDeCategoria(cat);

            request.setAttribute("categorianombre", cat);
            request.setAttribute("catactividades", catActividades);
            request.getRequestDispatcher("/consulta_categoria.jsp")
                .forward(request, response);
        }

    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        Boolean bool1 = request.getParameter("nombre_alta_act").equals("");
        Boolean bool2 = request.getParameter("duracion_alta_act").equals("");
        Boolean bool3 = request.getParameter("costo_alta_act").equals("");
        if (bool1||bool2||bool3){
            request.setAttribute("error", "Por favor llene los campos");
            processRequest(request, response);
            return;
        }

        HttpSession session = request.getSession();
        DataProfesor usr = (DataProfesor) session.getAttribute("usuario");
        String nick = usr.getNickname();
        String inst = usr.getInstitucion();
        String nombre = (String)request.getParameter("nombre_alta_act");
        String descripcion = (String)request.getParameter("descripcion_alta_act");
        Duration duracion = (Duration.ofMinutes(Long.parseLong(request.getParameter("duracion_alta_act"))));
        Float costo = Float.valueOf(request.getParameter("costo_alta_act"));
        Part imgPart = request.getPart("img");
        InputStream is = imgPart.getInputStream();

        

        File tmp = File.createTempFile("img_", null);
        OutputStream os = new FileOutputStream(tmp);

        pipe(is, os);
        os.close();
        Set<String> categorias = new HashSet<String>();
        String[] array = request.getParameterValues("select_categorias");
        if (array!=null && array.length!=0)
            Collections.addAll(categorias, array);
        try {
            Facades.getFacades().getFacadeActividad().crearActividad()
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setInstitucion(inst)
                .setDuracion(duracion)
                .setCosto(costo)
                .setRegistro(LocalDate.now())
                .setCategorias(categorias)
                .setCreador(nick)
                .setImagen(tmp)
                .invoke();

            Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

            if (esProfesor != null) {
                DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");
                String nickname = usuario.getNickname();

                if (esProfesor)
                    request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataProfesor(nickname));
                else
                    request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataSocio(nickname));
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
            return;
        }
        catch(ActividadRepetidaException are){
            request.setAttribute("error", "Ya existe una actividad con ese nombre. ");
        }
        catch(InstitucionNoEncontradaException inee){
            request.setAttribute("error", "No existe una institucion con ese nombre. ");
        }
        catch(SinCategoriaException sce){
            request.setAttribute("error", "Debe seleccionar al menos una categoria. ");
        }
        processRequest(request, response); */
    } 

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<String> categorias = Facades
            .getFacades()
            .getFacadeActividad()
            .getCategorias();

        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/alta_actividad.jsp")
            .forward(request, response);
    } 
}
