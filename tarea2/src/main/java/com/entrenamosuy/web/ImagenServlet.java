package com.entrenamosuy.web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.web.publicar.Publicador;

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

        Publicador port = Webservice.getPort();

        byte[] data = null;

        if (path.startsWith(request.getContextPath() + "/img/usuario"))
            data = port.getImagenUsuario(ident);
        else if (path.startsWith(request.getContextPath() + "/img/clase"))
            data = port.getImagenClase(ident);
        else if (path.startsWith(request.getContextPath() + "/img/actividad"))
            data = port.getImagenActividad(ident);
        else if (path.startsWith(request.getContextPath() + "/img/institucion"))
            data = port.getImagenInstitucion(ident);
        else if (path.startsWith(request.getContextPath() + "/img/cuponera"))
            data = port.getImagenCuponera(ident);

        response.setContentLength(data.length);
        response.getOutputStream().write(data);
    }
}
