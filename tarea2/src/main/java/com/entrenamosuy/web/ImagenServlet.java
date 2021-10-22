package com.entrenamosuy.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImagenServlet extends HttpServlet {

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        String nickname = path.substring("/img/usuario/".length());
        File img = Facades.getFacades().getFacadeUsuario().getImagenUsuario(nickname);

        response.setContentLength((int) img.length());

        InputStream is = new FileInputStream(img);
        OutputStream os = response.getOutputStream();

        pipe(is, os);
        is.close();
        os.close();
    }
}
