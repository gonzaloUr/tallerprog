package com.entrenamosuy.web;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.web.publicar.PasswordInvalidaException_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.UsuarioNoEncontradoExceptionWrapper_Exception;
import com.entrenamosuy.web.publicar.BeanActividad;
import com.entrenamosuy.web.publicar.BeanClase;
import com.entrenamosuy.web.publicar.BeanCuponera;
import com.entrenamosuy.web.publicar.BeanDescProfesor;
import com.entrenamosuy.web.publicar.BeanInstitucion;
import com.entrenamosuy.web.publicar.BeanProfesor;

public class MovilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        Publicador port = Webservice.getPort();

        if (path.equals("/index_movil")) {
            getServletContext()
                .getRequestDispatcher("/index_movil.jsp")
                .forward(request, response);

        } else if (path.equals("/cerrar_sesion_movil")) {
            request.getSession().removeAttribute("nickname");
            request.getSession().removeAttribute("usuario");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index_movil"));

        } else if (path.equals("/inicio_movil")) {
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");

            request.setAttribute("nombre", nombre);
            request.setAttribute("apellido", apellido);

            request
                .getRequestDispatcher("/inicio_movil.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_dictado_clase_movil")) {



            String claseNombre = request.getParameter("clase");

            BeanClase clase = port.getDataClase(claseNombre);

            String nombre = clase.getNombre();
            LocalDateTime inicio = Utils.localDateTimeFromBean(clase.getInicio());
            int cantMin = clase.getCantMin();
            int cantMax = clase.getCantMax();
            URL url = new URL(clase.getAccesoURL());
            String acti= clase.getActividad().getNombre();

            Set<String> profesorNick = clase.getProfesores()
            .stream()
            .map(BeanDescProfesor::getNickname)
            .collect(Collectors.toSet());

            String nickname = profesorNick.iterator().next();

            boolean esDicta = false;

            HttpSession session = request.getSession();

            Object usr = session.getAttribute("usuario");


            if(usr != null){ //TODO revisar esto que da error consulta dictado a clase
                BeanProfesor profe = (BeanProfesor) usr;
                boolean b = (boolean) session.getAttribute("es_profesor");
                esDicta = (b) && (profe.getNickname().equals(nickname));
            }

            Set<String> profesorNom = clase.getProfesores()
                .stream()
                .map(BeanDescProfesor::getNombre)
                .collect(Collectors.toSet());

            Set<String> profesorApe = clase.getProfesores()
                .stream()
                .map(BeanDescProfesor::getApellido)
                .collect(Collectors.toSet());

            String apellido = profesorApe.iterator().next();

            request.setAttribute("nombre", nombre);
            request.setAttribute("inicio", inicio);
            request.setAttribute("cantMin", cantMin);
            request.setAttribute("cantMax", cantMax);
            request.setAttribute("url", url);
            request.setAttribute("acti", acti);
            request.setAttribute("profesorNom", profesorNom);
            request.setAttribute("profesorApe", profesorApe);
            request.setAttribute("apellido", apellido);
            request.setAttribute("es_profesor_que_dicta", esDicta);
            request.setAttribute("cantPremios", clase.getCantPremios());

            request.getRequestDispatcher("/consulta_dictado_clase_movil.jsp")
                .forward(request, response);





        } else if(path.equals("/consulta_actividad_inst_movil")) {
            Set<String> instituciones = port.getInstituciones()
                .stream()
                .collect(Collectors.toSet());

            String institucionNombre = request.getParameter("institucion");

            BeanInstitucion ins = port.getDataInstitucion(institucionNombre);
            List<BeanActividad> acts = ins.getActividadesOfrecidas();


            request.setAttribute("instituciones", instituciones);
            request.setAttribute("actividades", acts);

            request.getRequestDispatcher("/consulta_actividad_inst_movil.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_actividad_cat_movil")) {
            Set<String> categorias = port.getCategorias()
                .stream()
                .collect(Collectors.toSet());

            String categoriaNombre = request.getParameter("categoria");


            List<String> catActividades = port.getActividadesDeCategoria(categoriaNombre);
            List<BeanActividad> acts = new ArrayList<>();
            for (String acti : catActividades) {
                acts.add(port.getDataActividad(acti));
            }

            request.setAttribute("categorias", categorias);
            request.setAttribute("actividades", acts);

            request.getRequestDispatcher("/consulta_actividad_cat_movil.jsp")
                .forward(request, response);

        } else if(path.equals("/ver_actividad_movil")) {
            Set<String> instituciones = port.getInstituciones()
                .stream()
                .collect(Collectors.toSet());

            Set<String> categorias = port.getCategorias()
                .stream()
                .collect(Collectors.toSet());

            request.setAttribute("instituciones", instituciones);
            request.setAttribute("categorias", categorias);

            request.getRequestDispatcher("/ver_actividad_movil.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_actividad_movil")) {

            String act = (String) request.getParameter("nombre");
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

            request.getRequestDispatcher("/consulta_actividad_movil.jsp")
                .forward(request, response);
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Publicador port = Webservice.getPort();

        String nickname = request.getParameter("nick");
        String password = request.getParameter("pass");

        request.setAttribute("attempted_login", true);

        try {
            port.validarCredencialesMovil(nickname, password);

            HttpSession session = request.getSession();

            session.setAttribute("usuario", port.getDataSocio(nickname));
            session.setAttribute("es_profesor", false);

            request.setAttribute("successful_login", true);
        } catch (PasswordInvalidaException_Exception e) {
            request.setAttribute("reason", "password");
            request.setAttribute("successful_login", false);
        } catch (UsuarioNoEncontradoExceptionWrapper_Exception e) {
            request.setAttribute("reason", "nickname");
            request.setAttribute("nickname", nickname);
            request.setAttribute("successful_login", false);
        }

        getServletContext()
            .getRequestDispatcher("/index_movil.jsp")
            .forward(request, response);
    }
}
