package com.entrenamosuy.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.exceptions.PasswordInvalidaException;
import com.entrenamosuy.core.exceptions.UsuarioNoEncontradoException;

public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String nickname = (String) session.getAttribute("nickname");

        if (nickname == null) {
            getServletContext()
                .getRequestDispatcher("/iniciar_sesion.jsp")
                .forward(request, response);
        }

        String path = request.getServletPath();

        /*if(path.equals("/consulta_socio")) {
            String nick = request.getAttribute("nickname");
            DataSocio socio = Facades.getFacades().getFacadeUsuario().getDataSocio(nick);
            request.setAttribute("nombre", socio.getNombre() + "" + socio.getApellido());
            request.setAttribute("mail", socio.getCorreo().toString());
            request.setAttribute("nacimiento", socio.getNacimiento());
            request.setAttribute("seguidos", socio.getSeguidos());
            request.setAttribute("seguidores", socio.getSeguidores());
            request.setAttribute("clases", socio.getClases());
            request.setAttribute("cuponeras", socio.getCuponeras());
            request.getRequestDispatcher("/consulta_socio.jsp")
				.forward(request, response);
        }*/
    }



}

