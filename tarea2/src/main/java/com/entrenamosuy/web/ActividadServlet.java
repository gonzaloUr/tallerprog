package com.entrenamosuy.web;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entrenamosuy.web.publicar.ActividadRepetidaException_Exception;
import com.entrenamosuy.web.publicar.BeanActividad;
import com.entrenamosuy.web.publicar.BeanClase;
import com.entrenamosuy.web.publicar.BeanCrearActividadArgs;
import com.entrenamosuy.web.publicar.BeanCuponera;
import com.entrenamosuy.web.publicar.BeanInstitucion;
import com.entrenamosuy.web.publicar.BeanProfesor;
import com.entrenamosuy.web.publicar.BeanSocio;
import com.entrenamosuy.web.publicar.InstitucionNoEncontradaExceptionWrapper_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;
import com.entrenamosuy.web.publicar.SinCategoriaExceptionWrapper_Exception;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class ActividadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if(path.equals("/lista_actividades")) {
            List<BeanActividad> acts = port.listarActividadesAceptadas();

            request.setAttribute("actividades", acts);
            request.getRequestDispatcher("/lista_actividades.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_actividad")) {
            String act = (String) request.getParameter("nombre");

            HttpSession session = request.getSession();

            Object u = session.getAttribute("usuario");

            request.setAttribute("tipoFav", 2);

            if(u != null){
                boolean b = (boolean) session.getAttribute("es_profesor");
                if(b == false){
                    BeanSocio socio = (BeanSocio) u;
                    boolean esFav = port.esFav(socio.getNickname(), act);
                    if(esFav){
                        request.setAttribute("tipoFav", 1);
                    }
                    else{
                        request.setAttribute("tipoFav", 0);
                    }   
                }
            }

            BeanActividad actividad = port.getDataActividad(act);

            String nombre = actividad.getNombre();
            String descripcion = actividad.getDescripcion();

            Set<String> clasesOfrecidas = actividad.getClases()
                .stream()
                .map(BeanClase::getNombre)
                .collect(Collectors.toSet());

            Set<String> cuponerasAsociadas = actividad.getCuponeras()
                .stream()
                .map(BeanCuponera::getNombre)
                .collect(Collectors.toSet());

            Set<String> categoriasAsociadas = actividad.getCategorias()
                .stream()
                .collect(Collectors.toSet());

            int duracion = actividad.getDuracion();

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("clasesOfrecidas", clasesOfrecidas);
            request.setAttribute("cuponerasAsociadas", cuponerasAsociadas);
            request.setAttribute("categoriasAsociadas", categoriasAsociadas);
            request.setAttribute("duracion", duracion);

            request
                .getRequestDispatcher("/consulta_actividad.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_institucion")) {
            String institucionNombre = request.getParameter("institucion");
            BeanInstitucion institucion = port.getDataInstitucion(institucionNombre);
            String nombre = institucion.getNombre();
            String descripcion = institucion.getDescripcion();
            String url = institucion.getUrl().toString();

            List<String> actividadesOfrecidas = port.getActividadesDeInstitucion(institucionNombre);

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
            List<String> catActividades = port.getActividadesDeCategoria(cat);

            request.setAttribute("categorianombre", cat);
            request.setAttribute("catactividades", catActividades);

            request.getRequestDispatcher("/consulta_categoria.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        Boolean bool1 = request.getParameter("nombre_alta_act").equals("");
        Boolean bool2 = request.getParameter("duracion_alta_act").equals("");
        Boolean bool3 = request.getParameter("costo_alta_act").equals("");

        if (bool1||bool2||bool3){
            request.setAttribute("error", "Por favor llene los campos");
            processRequest(request, response);
            return;
        }

        HttpSession session = request.getSession();
        BeanProfesor usr = (BeanProfesor) session.getAttribute("usuario");
        String nick = usr.getNickname();
        String inst = usr.getInstitucion();
        String nombre = (String)request.getParameter("nombre_alta_act");
        String descripcion = (String)request.getParameter("descripcion_alta_act");
        Duration duracion = (Duration.ofMinutes(Long.parseLong(request.getParameter("duracion_alta_act"))));
        Float costo = Float.valueOf(request.getParameter("costo_alta_act"));

        Part imgPart = request.getPart("img");
        InputStream is = imgPart.getInputStream();
        long size = imgPart.getSize();
        byte[] data = new byte[(int) size];
        is.read(data);

        Set<String> categorias = new HashSet<String>();
        String[] array = request.getParameterValues("select_categorias");

        if (array!=null && array.length!=0)
            Collections.addAll(categorias, array);

        try {

            BeanCrearActividadArgs args = new BeanCrearActividadArgs();

            args.setNombre(nombre);
            args.setDescripcion(descripcion);
            args.setInstitucion(inst);
            args.setDuracion((int) duracion.toMinutes());
            args.setCosto(costo);
            args.setRegistro(Utils.beanFromLocalDate(LocalDate.now()));
            args.getCategorias().addAll(categorias);
            args.setCreadorNickname(nick);
            args.setImagen(data);

            port.crearActividad(args);

            Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

            if (esProfesor != null) {
                if (esProfesor) {
                    BeanProfesor p = (BeanProfesor) request.getSession().getAttribute("usuario");
                    String nickname = p.getNickname();
                    request.getSession().setAttribute("usuario", port.getDataProfesor(nickname));
                } else {
                    BeanSocio s = (BeanSocio) request.getSession().getAttribute("usuario");
                    String nickname = s.getNickname();
                    request.getSession().setAttribute("usuario", port.getDataSocio(nickname));
                }
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
            return;
        }
        catch(ActividadRepetidaException_Exception are) {
            request.setAttribute("error", "Ya existe una actividad con ese nombre. ");
        }
        catch(InstitucionNoEncontradaExceptionWrapper_Exception inee){
            request.setAttribute("error", "No existe una institucion con ese nombre. ");
        }
        catch(SinCategoriaExceptionWrapper_Exception sce){
            request.setAttribute("error", "Debe seleccionar al menos una categoria. ");
        }

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();
        List<String> categorias = port.getCategorias();

        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/alta_actividad.jsp")
            .forward(request, response);
    }
}
