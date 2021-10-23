package com.entrenamosuy.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.entrenamosuy.core.AbstractFacadeUsuario;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataSocio;
import com.entrenamosuy.core.data.DataUsuario;
import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
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

        //String path = request.getServletPath();

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

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nickname = (String) request.getParameter("nick");
        String nombre = (String) request.getParameter("nombre");
        String pass = (String) request.getParameter("pass");

        Part imgPart = request.getPart("img");
        InputStream is = imgPart.getInputStream();

        File tmp = File.createTempFile("img_", null);
        OutputStream os = new FileOutputStream(tmp);

        pipe(is, os);
        os.close();

        try {
            Facades.getFacades().getFacadeUsuario().crearSocio()
                .setNickname(nickname)
                .setNombre(nombre)
                .setApellido("test")
                .setPassword(pass)
                .setCorreo(Email.of("test", "mail.com"))
                .setImagen(tmp)
                .setNacimiento(LocalDate.now())
                .invoke();
        } catch (UsuarioRepetidoException e) {
            e.printStackTrace(response.getWriter());
        }

        DataUsuario socio = Facades.getFacades().getFacadeUsuario().getDataSocio(nickname);
        request.getSession().setAttribute("usuario", socio);

        // getServletContext().getRequestDispatcher("/").forward(request, response);
        response.getWriter().println("hola");
    }
}
