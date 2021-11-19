package com.entrenamosuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.web.publicar.PasswordInvalidaException_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;
import com.entrenamosuy.web.publicar.UsuarioNoEncontradoExceptionWrapper_Exception;

public class MovilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

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