package com.entrenamosuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;
import com.entrenamosuy.web.publicar.PasswordInvalidaException_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;

public class SesionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/iniciar_sesion")) {
            getServletContext()
                .getRequestDispatcher("/iniciar_sesion.jsp")
                .forward(request, response);
        } else if (path.equals("/cerrar_sesion")) {
            request.getSession().removeAttribute("nickname");
            request.getSession().removeAttribute("usuario");
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
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
            port.validarCredenciales(nickname, password);

            HttpSession session = request.getSession();
            List<String> socios = port.getSocios();

            if (socios.contains(nickname)) {
                session.setAttribute("usuario", port.getDataSocio(nickname));
                session.setAttribute("es_profesor", false);
            } else {
                session.setAttribute("usuario", port.getDataProfesor(nickname));
                session.setAttribute("es_profesor", true);
            }

            request.setAttribute("successful_login", true);
        } catch (PasswordInvalidaException_Exception e) {
            request.setAttribute("reason", "password");
            request.setAttribute("successful_login", false);
        } catch (UsuarioNoEncontradoException e) {
            request.setAttribute("reason", "nickname");
            request.setAttribute("nickname", nickname);
            request.setAttribute("successful_login", false);
        }

        getServletContext()
            .getRequestDispatcher("/iniciar_sesion.jsp")
            .forward(request, response);
    }
}
