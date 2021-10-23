package com.entrenamosuy.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
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
import com.entrenamosuy.core.data.MiniUsuario;
import com.entrenamosuy.core.exceptions.UsuarioRepetidoException;
import com.entrenamosuy.core.exceptions.EmailParseException;

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
            if (request.getParameterMap().isEmpty())
                request.getRequestDispatcher("/alta_usuario_selecion.jsp").forward(request, response);
            else {
                String tipo = request.getParameter("tipo");

                if (tipo.equals("socio"))
                    request.getRequestDispatcher("/alta_socio.jsp").forward(request, response);
                else {
                    Set<String> institucionesSet = Facades.getFacades().getFacadeInstitucion().getInstituciones();
                    List<String> instituciones = new ArrayList<>(institucionesSet.size());
                    instituciones.addAll(institucionesSet);
                    request.setAttribute("instituciones", instituciones);
                    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
                }
            }
        }

        if(path.equals("/consulta_socio")) {
            String nick = request.getParameter("nickname");
            DataSocio socio = Facades.getFacades().getFacadeUsuario().getDataSocio(nick);
            request.setAttribute("nombre", socio.getNombre() + "" + socio.getApellido());
            request.setAttribute("mail", socio.getCorreo().toString());
            request.setAttribute("nacimiento", socio.getNacimiento());
            request.setAttribute("clases", socio.getClases());
            request.setAttribute("cuponeras", socio.getCuponeras());
            request.setAttribute("nickname", nick);

            List<MiniUsuario> seguidos = new ArrayList<MiniUsuario>();
            Set<String> seguidosSet = socio.getSeguidos();
            for(String s: seguidosSet){
                seguidos.add(new MiniUsuario(s, Facades.getFacades().getFacadeUsuario().getSocios().contains(s)));
            }

            List<MiniUsuario> seguidores = new ArrayList<MiniUsuario>();
            Set<String> seguidoresSet = socio.getSeguidores();
            for(String s: seguidoresSet){
                seguidores.add(new MiniUsuario(s, Facades.getFacades().getFacadeUsuario().getSocios().contains(s)));
            }

            request.setAttribute("seguidos", seguidos);
            request.setAttribute("seguidores", seguidores);

            request.getRequestDispatcher("/consulta_socio.jsp")
				.forward(request, response);
        }

        if(path.equals("/consulta_profesor")) {
            String nick = request.getParameter("nickname");
            DataProfesor profe = Facades.getFacades().getFacadeUsuario().getDataProfesor(nick);
            request.setAttribute("nombre", profe.getNombre() + "" + profe.getApellido());
            request.setAttribute("mail", profe.getCorreo().toString());
            request.setAttribute("nacimiento", profe.getNacimiento());
            request.setAttribute("clases", profe.getClases());
            request.setAttribute("actividades", profe.getActividades());
            request.setAttribute("nickname", nick);
            request.setAttribute("institucion", profe.getInstitucion());
            request.setAttribute("descripcion", profe.getDescripcion());
            request.setAttribute("biografia", profe.getBiografia());

            List<MiniUsuario> seguidos = new ArrayList<MiniUsuario>();
            Set<String> seguidosSet = profe.getSeguidos();
            for(String s: seguidosSet){
                seguidos.add(new MiniUsuario(s, Facades.getFacades().getFacadeUsuario().getSocios().contains(s)));
            }

            List<MiniUsuario> seguidores = new ArrayList<MiniUsuario>();
            Set<String> seguidoresSet = profe.getSeguidores();
            for(String s: seguidoresSet){
                seguidores.add(new MiniUsuario(s, Facades.getFacades().getFacadeUsuario().getSocios().contains(s)));
            }

            request.setAttribute("seguidos", seguidos);
            request.setAttribute("seguidores", seguidores);

            request.getRequestDispatcher("/consulta_profesor.jsp")
				.forward(request, response);
        }
    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/alta_socio")) {
            String nickname = (String) request.getParameter("nick");
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String emailStr = (String) request.getParameter("email");
            String nacimientoStr = (String) request.getParameter("nacimiento");
            LocalDate nacimiento = LocalDate.parse(nacimientoStr);
            String pass = (String) request.getParameter("pass");
            String passConfirm = (String) request.getParameter("pass_confirm");

            Email email = null;

            try {
                email = Email.parse(emailStr);
            } catch (EmailParseException e1) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "email_format");
			    request.getRequestDispatcher("/alta_socio.jsp").forward(request, response);
                return;
            }

            if (!pass.equals(passConfirm)) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "pass_does_not_match");
			    request.getRequestDispatcher("/alta_socio.jsp").forward(request, response);
                return;
            }

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
                    .setApellido(apellido)
                    .setCorreo(email)
                    .setPassword(pass)
                    .setImagen(tmp)
                    .setNacimiento(nacimiento)
                    .invoke();
            } catch (UsuarioRepetidoException e) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "usuario_repetido");
                tmp.delete();
			    request.getRequestDispatcher("/alta_socio.jsp").forward(request, response);
                return;
            }

            DataUsuario socio = Facades.getFacades().getFacadeUsuario().getDataSocio(nickname);
            request.getSession().setAttribute("usuario", socio);
            request.getSession().setAttribute("es_profesor", false);
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        } else if (path.equals("/alta_profesor")) {
            String nickname = (String) request.getParameter("nick");
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String emailStr = (String) request.getParameter("email");
            String nacimientoStr = (String) request.getParameter("nacimiento");
            LocalDate nacimiento = LocalDate.parse(nacimientoStr);
            String institucion = (String) request.getParameter("institucion");
            String descripcion = (String) request.getParameter("desc");
            String biografia = (String) request.getParameter("bio");
            URL sitioWeb = new URL((String) request.getParameter("sitio_web"));
            String pass = (String) request.getParameter("pass");
            String passConfirm = (String) request.getParameter("pass_confirm");

            Email email = null;

            try {
                email = Email.parse(emailStr);
            } catch (EmailParseException e1) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "email_format");
			    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
                return;
            }

            if (!pass.equals(passConfirm)) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "pass_does_not_match");
			    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
                return;
            }

            if (biografia.equals(""))
                biografia = null;

            Part imgPart = request.getPart("img");
            InputStream is = imgPart.getInputStream();

            File tmp = File.createTempFile("img_", null);
            OutputStream os = new FileOutputStream(tmp);

            pipe(is, os);
            os.close();

            try {
                Facades.getFacades().getFacadeUsuario().crearProfesor()
                    .setNickname(nickname)
                    .setNombre(nombre)
                    .setApellido(apellido)
                    .setCorreo(email)
                    .setNacimiento(nacimiento)
                    .setInstitucion(institucion)
                    .setDescripcion(descripcion)
                    .setBiografia(biografia)
                    .setSitioWeb(sitioWeb)
                    .setPassword(pass)
                    .setImagen(tmp)
                    .invoke();
            } catch (UsuarioRepetidoException e) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "usuario_repetido");
                tmp.delete();
			    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
                return;
            }

            DataUsuario profesor = Facades.getFacades().getFacadeUsuario().getDataProfesor(nickname);
            request.getSession().setAttribute("usuario", profesor);
            request.getSession().setAttribute("es_profesor", true);
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        }
    }
}
