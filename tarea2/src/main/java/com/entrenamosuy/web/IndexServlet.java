package com.entrenamosuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String userAgent = request.getHeader("User-Agent");

        if (Utils.esMobile(userAgent)) {
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/index_movil"));
            return;
        }

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
