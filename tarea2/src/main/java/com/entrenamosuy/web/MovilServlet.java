package com.entrenamosuy.web;

import java.io.IOException;
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
import com.entrenamosuy.web.publicar.PublicadorService;
import com.entrenamosuy.web.publicar.UsuarioNoEncontradoExceptionWrapper_Exception;
import com.entrenamosuy.web.publicar.BeanActividad;
import com.entrenamosuy.web.publicar.BeanInstitucion;

public class MovilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

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
            String institucionNombre = request.getParameter("institucion");
            BeanInstitucion institucion = port.getDataInstitucion(institucionNombre);
            String nombre = institucion.getNombre();

            List<String> actividadesOfrecidas = port.getActividadesDeInstitucion(institucionNombre);

            request.setAttribute("nombre", nombre);
            request.setAttribute("actividadesOfrecidas", actividadesOfrecidas);

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
        }
        
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

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