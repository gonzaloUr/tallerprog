package com.entrenamosuy.web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.web.publicar.Exception_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;

public class ImagenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        URI uri;

        try {
            uri = new URI(request.getRequestURI());
        } catch (URISyntaxException e) {
            e.printStackTrace(response.getWriter());
            return;
        }

        String path = uri.getPath();
        String ident = path.substring(path.lastIndexOf("/") + 1);

        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        byte[] data = null;

        if (path.startsWith(request.getContextPath() + "/img/usuario")) {
            try {
                data = port.getImagenUsuario(ident);
            } catch (Exception_Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (path.startsWith(request.getContextPath() + "/img/clase")) {
            try {
                data = port.getImagenClase(ident);
            } catch (Exception_Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (path.startsWith(request.getContextPath() + "/img/actividad")) {
            try {
                data = port.getImagenActividad(ident);
            } catch (Exception_Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (path.startsWith(request.getContextPath() + "/img/institucion")) {
            try {
                data = port.getImagenInstitucion(ident);
            } catch (Exception_Exception e) {
                e.printStackTrace();
                return;
            }
        } else if (path.startsWith(request.getContextPath() + "/img/cuponera")) {
            try {
                data = port.getImagenCuponera(ident);
            } catch (Exception_Exception e) {
                e.printStackTrace();
                return;
            }
        }

        response.setContentLength(data.length);
        response.getOutputStream().write(data);
    }
}
