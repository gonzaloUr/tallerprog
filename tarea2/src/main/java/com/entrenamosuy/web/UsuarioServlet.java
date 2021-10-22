package com.entrenamosuy.web;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;

public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/lista_usuarios")) {
            AbstractFacadeUsuario facade = Facades.getFacades().getFacadeUsuario();

            Set<DataSocio> socios = facade
                .getSocios()
                .stream()
                .map(facade::getDataSocio)
                .collect(Collectors.toSet());

            Set<DataProfesor> profes = facade
                .getProfesores()
                .stream()
                .map(facade::getDataProfesor)
                .collect(Collectors.toSet());

            request.setAttribute("socios", socios);
            request.setAttribute("profes", profes);
			request.getRequestDispatcher("/lista_usuarios.jsp").forward(request, response);
        } else if (path.equals("/alta_usuario")) {
            request.getRequestDispatcher("/alta_usuario.jsp").forward(request, response);
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

