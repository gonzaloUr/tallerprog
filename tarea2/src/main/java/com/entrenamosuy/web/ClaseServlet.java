package com.entrenamosuy.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataUsuario;
import com.entrenamosuy.core.data.DescProfesor;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class ClaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if(path.equals("/registrarse_a_clase_1")) {
            Set<String> inst = Facades
                .getFacades()
                .getFacadeInstitucion()
                .getInstituciones();

            Set<String> cats = Facades
                .getFacades()
                .getFacadeActividad()
                .getCategorias();

            request.setAttribute("instituciones", inst);
            request.setAttribute("categorias", cats);

            request.getRequestDispatcher("/registrarse_a_clase_1.jsp")
                .forward(request, response);

        } else if (path.equals("/registrarse_a_clase_2")){
            String inst = request.getParameter("institucion");
            String cat = request.getParameter("categoria");
            Set<String> acts;
            if (cat == null) {
                acts = Facades
                    .getFacades()
                    .getFacadeActividad()
                    .getActividadesDeInstitucion(inst);
            }
            else {
                acts = Facades
                    .getFacades()
                    .getFacadeActividad()
                    .getActividadesDeCategoria(cat);
            }

            request.setAttribute("actividades", acts);

            request.getRequestDispatcher("/registrarse_a_clase_2.jsp")
                .forward(request, response);

        } else if (path.equals("/registrarse_a_clase_3")){
            String acti = request.getParameter("actividad");

            Set<String> clases = Facades
                .getFacades()
                .getFacadeClase()
                .getClases(acti);

            request.setAttribute("clases", clases);

            request.getRequestDispatcher("/registrarse_a_clase_3.jsp")
                .forward(request, response);


        } else if(path.equals("/confirmar_registro_clase")) {

            String act = request.getParameter("actividad");
            //String cla = request.getParameter("clase");

            HttpSession session = request.getSession();

            DataUsuario usr = (DataUsuario) session.getAttribute("usuario");
            String nickname = usr.getNickname();

            Set<String> cupos = Facades
                .getFacades()
                .getFacadeCuponera()
                .cuponerasUsables(act, nickname);

            request.setAttribute("cuponeras", cupos);
            request.getRequestDispatcher("/confirmar_registro_clase.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_dictado_clase")){
            String claseNombre = request.getParameter("clase");

            DataClase clase = Facades
                .getFacades()
                .getFacadeClase()
                .getDataClase(claseNombre);

            String nombre = clase.getNombre();
            LocalDateTime inicio = clase.getInicio();
            int cantMin = clase.getCantMin();
            int cantMax = clase.getCantMax();
            URL url = clase.getAccesoURL();
            String acti= clase.getActividad().getNombre();

            Set<String> profesorNom = clase.getProfesores()
                .stream()
                .map(DescProfesor::getNombre)
                .collect(Collectors.toSet());

            Set<String> profesorApe = clase.getProfesores()
                .stream()
                .map(DescProfesor::getApellido)
                .collect(Collectors.toSet());

            String apellido = profesorApe.iterator().next();

            request.setAttribute("nombre", nombre);
            request.setAttribute("inicio", inicio);
            request.setAttribute("cantMin", cantMin);
            request.setAttribute("cantMax", cantMax);
            request.setAttribute("url", url);
            request.setAttribute("acti", acti);
            request.setAttribute("profesorNom", profesorNom);
            request.setAttribute("profesorApe", profesorApe);
            request.setAttribute("apellido", apellido);

            request.getRequestDispatcher("/consulta_dictado_clase.jsp")
                .forward(request, response);

        } else if (path.equals("/alta_dictado_clase")) {
            Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

            if (esProfesor == null || !esProfesor)
                throw new IllegalArgumentException("profesor no logeado");

            DataProfesor profesor = (DataProfesor) request.getSession().getAttribute("usuario");
            String institucion = profesor.getInstitucion();
            Set<String> actividadesSet = Facades.getFacades().getFacadeActividad().getActividadesDeInstitucion(institucion);

            List<String> actividades = new ArrayList<>(actividadesSet.size());

            actividades.addAll(actividadesSet);

            request.setAttribute("institucion", institucion);
            request.setAttribute("actividades", actividades);
            request.setAttribute("profe", profesor.getNickname());

            request.getRequestDispatcher("/alta_dictado_clase.jsp").forward(request, response);
        }
    }



    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/confirmar_registro_clase")) {

            HttpSession session = request.getSession();

            DataUsuario usr = (DataUsuario) session.getAttribute("usuario");
            String nickname = usr.getNickname();

            String cla = request.getParameter("clase");
            String cup = request.getParameter("cuponera");
            LocalDate fecha = LocalDate.now();
            response.getWriter().println("antes if");
            if (cup == null) {
                response.getWriter().println("cup null");
                try {
                    Facades
                        .getFacades()
                        .getFacadeActividad()
                        .registarseSinCuponera(nickname, cla, fecha);


                    Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

                    if (esProfesor != null) {
                        DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");
                        String nick = usuario.getNickname();

                        if (esProfesor)
                            request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataProfesor(nick));
                        else
                            request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataSocio(nick));
                    }

                } catch (RegistroInconsistenteException e) {
                    request.setAttribute("reg_exito", false);
                    request.getRequestDispatcher("confirmar_registro_clase.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("reg_exito", true);

            }
            else {
                response.getWriter().println("cup != null");
                try {
                    Facades
                        .getFacades()
                        .getFacadeActividad()
                        .registraseConCuponera(nickname , cla, cup, fecha);

                    Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

                    if (esProfesor != null) {
                        DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");
                        String nick = usuario.getNickname();

                        if (esProfesor)
                            request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataProfesor(nick));
                        else
                            request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataSocio(nick));
                    }

                } catch (RegistroInconsistenteException e) {
                    e.printStackTrace(response.getWriter());
                    request.setAttribute("reg_exito", false);
                    request.getRequestDispatcher("confirmar_registro_clase.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("reg_exito", true);
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));

        } else if (path.equals("/alta_dictado_clase")) {
            String actividad = request.getParameter("actividad");
            String nombre = request.getParameter("nombre");
            LocalDateTime inicio = LocalDateTime.parse(request.getParameter("inicio"));
            int cantMin = Integer.parseInt(request.getParameter("cant_min"));
            int cantMax = Integer.parseInt(request.getParameter("cant_max"));
            URL acceso = new URL(request.getParameter("acceso"));
            LocalDate registro = LocalDate.parse(request.getParameter("fecha_registro"));

            Set<String> profes = new HashSet<String>();
            DataUsuario u = (DataUsuario) request.getSession().getAttribute("usuario");
            profes.add(u.getNickname());

            Part imgPart = request.getPart("img");
            InputStream is = imgPart.getInputStream();

            File tmp = File.createTempFile("img_", null);
            OutputStream os = new FileOutputStream(tmp);

            pipe(is, os);
            os.close();

            try {
                Facades.getFacades().getFacadeClase().crearClase()
                    .setNombreActividad(actividad)
                    .setNombre(nombre)
                    .setInicio(inicio)
                    .setNicknameProfesores(profes)
                    .setCantMin(cantMin)
                    .setCantMax(cantMax)
                    .setAcceso(acceso)
                    .setFechaRegistro(registro)
                    .setImagen(tmp)
                    .invoke();

                Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

                if (esProfesor != null) {
                    DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");
                    String nickname = usuario.getNickname();

                    if (esProfesor)
                        request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataProfesor(nickname));
                    else
                        request.getSession().setAttribute("usuario", Facades.getFacades().getFacadeUsuario().getDataSocio(nickname));
                }
            } catch (ClaseInconsistenteException e) {
                ClaseInconsistenteException.Restriccion r = e.getInconsistencias().get(0);
                switch (r) {
                    case NOMBRE_REPETIDO:
                        request.setAttribute("error", "Nombre no disponible");
                        break;
                    case CANT_MAX_MENOR_MIN:   
                        request.setAttribute("error","La cantidad minima de socios debe ser menor a la cantidad maxima.");
                        break;
                    case INICIO_MENOR_REGISTRO:
                        request.setAttribute("error","La fecha de inicio debe ser posterior a la de registro.");
                        break;
                    case REGISTRO_MENOR_REGISTRO_ACTIVIDAD:
                        request.setAttribute("error", "La fecha de registro de la clase debe ser posterior a la de registro de la actividad.");
                        break;
                }
                DataProfesor profesor = (DataProfesor) request.getSession().getAttribute("usuario");
                String institucion = profesor.getInstitucion();
                Set<String> actividadesSet = Facades.getFacades().getFacadeActividad().getActividadesDeInstitucion(institucion);
                List<String> actividades = new ArrayList<>(actividadesSet.size());

                actividades.addAll(actividadesSet);
                request.setAttribute("institucion", institucion);
                request.setAttribute("actividades", actividades);
                request.setAttribute("profe", profesor.getNickname());
                request.getRequestDispatcher("/alta_dictado_clase.jsp")
                    .forward(request, response);
                //e.printStackTrace(response.getWriter());
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        }
    }

    private static void pipe(InputStream is, OutputStream os) throws IOException {
        int n;
        byte[] buff = new byte[1024];

        while ((n = is.read(buff)) > -1)
            os.write(buff, 0, n);
    }
}
