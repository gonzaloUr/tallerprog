package com.entrenamosuy.web;

import static com.entrenamosuy.web.Utils.beanFromEmail;
import static com.entrenamosuy.web.Utils.beanFromLocalDate;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entrenamosuy.core.data.Email;
import com.entrenamosuy.core.exceptions.EmailParseException;
import com.entrenamosuy.web.publicar.BeanCrearProfesorArgs;
import com.entrenamosuy.web.publicar.BeanCrearSocioArgs;
import com.entrenamosuy.web.publicar.BeanProfesor;
import com.entrenamosuy.web.publicar.BeanSocio;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;
import com.entrenamosuy.web.publicar.UsuarioRepetidoException_Exception;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if (path.equals("/lista_usuarios")) {
            Set<BeanSocio> socios = port
                .getSocios()
                .stream()
                .map(port::getDataSocio)
                .collect(Collectors.toSet());

            Set<BeanProfesor> profes = port
                .getProfesores()
                .stream()
                .map(port::getDataProfesor)
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
                    List<String> instituciones = port.getInstituciones();
                    request.setAttribute("instituciones", instituciones);
                    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
                }
            }
        } else if(path.equals("/consulta_socio")) {
            String nick = request.getParameter("nickname");
            BeanSocio socio = port.getDataSocio(nick);

            request.setAttribute("nombre", socio.getNombre() + " " + socio.getApellido());
            request.setAttribute("mail", socio.getCorreo().toString());
            request.setAttribute("nacimiento", socio.getNacimiento());
            request.setAttribute("clases", socio.getClases());
            request.setAttribute("cuponeras", socio.getCuponeras());
            request.setAttribute("nickname", nick);

            HttpSession session = request.getSession();

            Object usr = session.getAttribute("usuario");
            List<String> seguidos = null;

            if (usr != null) {
                if ((boolean) session.getAttribute("es_profesor")) {
                    BeanProfesor p = (BeanProfesor) usr;
                    seguidos = p.getSeguidos();
                } else {
                    BeanSocio s = (BeanSocio) usr;
                    seguidos = s.getSeguidos();
                }

                if (seguidos.contains(nick)){
                    request.setAttribute("esSeguidor", 1);
                }
                else {
                    request.setAttribute("esSeguidor", 2);
                }
            } else {
                request.setAttribute("esSeguidor", 0);
            }

            request.setAttribute("seguidos", socio.getSeguidos());
            request.setAttribute("seguidores", socio.getSeguidores());

            request.getRequestDispatcher("/consulta_socio.jsp").forward(request, response);
        } else if(path.equals("/consulta_profesor")) {
            String nick = request.getParameter("nickname");
            BeanProfesor profe = port.getDataProfesor(nick);

            request.setAttribute("nombre", profe.getNombre());
            request.setAttribute("apellido", profe.getApellido());
            request.setAttribute("mail", profe.getCorreo().toString());
            request.setAttribute("nacimiento", profe.getNacimiento());
            request.setAttribute("clases", profe.getClases());
            request.setAttribute("actividades", profe.getAceptadas());
            request.setAttribute("nickname", nick);
            request.setAttribute("institucion", profe.getInstitucion());
            request.setAttribute("descripcion", profe.getDescripcion());
            request.setAttribute("biografia", profe.getBiografia());

            HttpSession session = request.getSession();

            Object usr = session.getAttribute("usuario");
            List<String> seguidos = null;

            if (usr != null) {
                if ((boolean) session.getAttribute("es_profesor")) {
                    BeanProfesor p = (BeanProfesor) usr;
                    seguidos = p.getSeguidos();
                } else {
                    BeanSocio p = (BeanSocio) usr;
                    seguidos = p.getSeguidos();
                }

                if (seguidos.contains(nick)){
                    request.setAttribute("esSeguidor", 1);
                }
                else {
                    request.setAttribute("esSeguidor", 2);
                }
            } else {
                request.setAttribute("esSeguidor", 0);
            }

            request.setAttribute("seguidos", profe.getSeguidos());
            request.setAttribute("seguidores", profe.getSeguidores());

            request.getRequestDispatcher("/consulta_profesor.jsp").forward(request, response);
        } else if (path.equals("/seguir_usuario")){
            String nick1 = request.getParameter("nickname");
            String nick2 = null;

            HttpSession session = request.getSession();

            if ((boolean) session.getAttribute("es_profesor")) {
                BeanProfesor p = (BeanProfesor) session.getAttribute("usuario");
                nick2 = p.getNickname();
            } else {
                BeanSocio s = (BeanSocio) session.getAttribute("usuario");
                nick2 = s.getNickname();
            }

            port.seguirUsuario(nick1, nick2);

            boolean b = (boolean) request.getSession().getAttribute("es_profesor");

            if(b) {
                session.setAttribute("usuario", port.getDataProfesor(nick2));
            } else {
                session.setAttribute("usuario", port.getDataSocio(nick2));
            }

            if (port.getProfesores().contains(nick1)){
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/consulta_profesor?nickname=" + nick1));
            } else {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/consulta_socio?nickname=" + nick1));
            }
        } else if (path.equals("/dejar_seguir_usuario")){
            String nick1 = request.getParameter("nickname");
            String nick2 = null;

            HttpSession session = request.getSession();

            if ((boolean) session.getAttribute("es_profesor")) {
                BeanProfesor p = (BeanProfesor) session.getAttribute("usuario");
                nick2 = p.getNickname();
            } else {
                BeanSocio s = (BeanSocio) session.getAttribute("usuario");
                nick2 = s.getNickname();
            }

            port.dejarDeSeguirUsuario(nick1, nick2);

            boolean b = (boolean) request.getSession().getAttribute("es_profesor");
            if(b){
                request.getSession().setAttribute("usuario", port.getDataProfesor(nick2));
            }
            else {
                request.getSession().setAttribute("usuario", port.getDataSocio(nick2));
            }

            if (port.getProfesores().contains(nick1)) {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/consulta_profesor?nickname=" + nick1));
            }
            else {
                response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/consulta_socio?nickname=" + nick1));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if (path.equals("/alta_socio")) {
            String nickname = (String) request.getParameter("nick");
            String nombre = (String) request.getParameter("nombre");
            String apellido = (String) request.getParameter("apellido");
            String emailStr = (String) request.getParameter("email");
            String nacimientoStr = (String) request.getParameter("nacimiento");
            LocalDate nacimiento = LocalDate.parse(nacimientoStr);
            String pass = (String) request.getParameter("pass");
            String passConfirm = (String) request.getParameter("pass_confirm");

            // TODO: mover esto a la logica de tarea2, parsear la string a un BeanEmail
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
            long size = imgPart.getSize();
            byte[] data = new byte[(int) size];
            is.read(data);

            BeanCrearSocioArgs args = new BeanCrearSocioArgs();

            args.setNickname(nickname);
            args.setNombre(nombre);
            args.setApellido(apellido);
            args.setCorreo(beanFromEmail(email));
            args.setPassword(pass);
            args.setImagen(data);
            args.setNacimiento(beanFromLocalDate(nacimiento));

            try {
                port.crearSocio(args);
            } catch (UsuarioRepetidoException_Exception e) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "usuario_repetido");
                request.getRequestDispatcher("/alta_socio.jsp").forward(request, response);
            }

            BeanSocio socio = port.getDataSocio(nickname);
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

            // TODO: mover esto a la logica de tarea2, parsear la string a un BeanEmail
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
            long size = imgPart.getSize();
            byte[] data = new byte[(int) size];
            is.read(data);

            BeanCrearProfesorArgs args = new BeanCrearProfesorArgs();

            args.setNickname(nickname);
            args.setNombre(nombre);
            args.setApellido(apellido);
            args.setCorreo(beanFromEmail(email));
            args.setPassword(pass);
            args.setImagen(data);
            args.setNacimiento(beanFromLocalDate(nacimiento));
            args.setBio(biografia);
            args.setDescripcion(descripcion);
            args.setLink(sitioWeb.toString());
            args.setInstitucion(institucion);

            try {
                port.crearProfesor(args);
            } catch (UsuarioRepetidoException_Exception e) {
                request.setAttribute("failed", true);
                request.setAttribute("reason", "usuario_repetido");
			    request.getRequestDispatcher("/alta_profesor.jsp").forward(request, response);
            }

            BeanProfesor profesor = port.getDataProfesor(nickname);
            request.getSession().setAttribute("usuario", profesor);
            request.getSession().setAttribute("es_profesor", true);

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        }
    }
}
