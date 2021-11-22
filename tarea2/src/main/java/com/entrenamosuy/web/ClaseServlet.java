package com.entrenamosuy.web;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
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

import com.entrenamosuy.web.publicar.BeanClase;
import com.entrenamosuy.web.publicar.BeanCrearClaseArgs;
import com.entrenamosuy.web.publicar.BeanDescProfesor;
import com.entrenamosuy.web.publicar.BeanProfesor;
import com.entrenamosuy.web.publicar.BeanSocio;
import com.entrenamosuy.web.publicar.ClaseInconsistenteExceptionWrapper_Exception;
import com.entrenamosuy.web.publicar.Publicador;
import com.entrenamosuy.web.publicar.PublicadorService;
import com.entrenamosuy.web.publicar.RegistroInconsistenteExceptionWrapper_Exception;

@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class ClaseServlet extends HttpServlet {

    private void updateUsuario(Publicador port, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String nickname = null;

        if ((boolean) session.getAttribute("es_profesor")) {
            BeanProfesor p = (BeanProfesor) session.getAttribute("usuario");
            nickname = p.getNickname();
            request.getSession().setAttribute("usuario", port.getDataProfesor(nickname));
        } else {
            BeanSocio s = (BeanSocio) session.getAttribute("usuario");
            nickname = s.getNickname();
            request.getSession().setAttribute("usuario", port.getDataSocio(nickname));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if(path.equals("/registrarse_a_clase_1")) {
            Set<String> inst = port.getInstituciones()
            .stream()
            .collect(Collectors.toSet());

            Set<String> cats = port.getCategorias()
            .stream()
            .collect(Collectors.toSet());

            request.setAttribute("instituciones", inst);
            request.setAttribute("categorias", cats);

            request.getRequestDispatcher("/registrarse_a_clase_1.jsp")
                .forward(request, response);

        } else if (path.equals("/registrarse_a_clase_2")){
            String inst = request.getParameter("institucion");
            String cat = request.getParameter("categoria");
            Set<String> acts;
            if (cat == null) {
                acts = port.getActividadesDeInstitucion(inst)
                    .stream()
                    .collect(Collectors.toSet());
            }
            else {
                acts = port.getActividadesDeCategoria(cat)
                    .stream()
                    .collect(Collectors.toSet());
            }

            request.setAttribute("actividades", acts);

            request.getRequestDispatcher("/registrarse_a_clase_2.jsp")
                .forward(request, response);

        } else if (path.equals("/registrarse_a_clase_3")){
            String acti = request.getParameter("actividad");

            Set<String> clases = port.getClasesDeActividad(acti)
                .stream()
                .collect(Collectors.toSet());


            request.setAttribute("clases", clases);

            request.getRequestDispatcher("/registrarse_a_clase_3.jsp")
                .forward(request, response);


        } else if(path.equals("/confirmar_registro_clase")) {

            String act = request.getParameter("actividad");

            HttpSession session = request.getSession();

            BeanSocio usr = (BeanSocio) session.getAttribute("usuario");
            String nickname = usr.getNickname();

            Set<String> cupos = port.getCuponerasUsablesActividad(act, nickname)
                .stream()
                .collect(Collectors.toSet());

            request.setAttribute("cuponeras", cupos);
            request.getRequestDispatcher("/confirmar_registro_clase.jsp")
                .forward(request, response);

        } else if(path.equals("/consulta_dictado_clase")){
            String claseNombre = request.getParameter("clase");

            BeanClase clase = port.getDataClase(claseNombre);

            String nombre = clase.getNombre();
            LocalDateTime inicio = Utils.localDateTimeFromBean(clase.getInicio());
            int cantMin = clase.getCantMin();
            int cantMax = clase.getCantMax();
            URL url = new URL(clase.getAccesoURL());
            String acti= clase.getActividad().getNombre();

            Set<String> profesorNick = clase.getProfesores()
            .stream()
            .map(BeanDescProfesor::getNickname)
            .collect(Collectors.toSet());

            String nickname = profesorNick.iterator().next();

            boolean esDicta = false;

            HttpSession session = request.getSession();

            Object usr = session.getAttribute("usuario");


            if(usr != null){ //TODO revisar esto que da error consulta dictado a clase
                boolean b = (boolean) session.getAttribute("es_profesor");    
                if(b){
                    BeanProfesor profe = (BeanProfesor) usr;
                    esDicta = (b) && (profe.getNickname().equals(nickname));        
                }
            }
            
            Set<String> profesorNom = clase.getProfesores()
                .stream()
                .map(BeanDescProfesor::getNombre)
                .collect(Collectors.toSet());

            Set<String> profesorApe = clase.getProfesores()
                .stream()
                .map(BeanDescProfesor::getApellido)
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
            request.setAttribute("es_profesor_que_dicta", esDicta);
            request.setAttribute("cantPremios", clase.getCantPremios());

            request.getRequestDispatcher("/consulta_dictado_clase.jsp")
                .forward(request, response);

        } else if (path.equals("/realizar_sorteo")) {
        	String clase = request.getParameter("clase");
        	int estadoS = port.getEstadoSorteo(clase);
        	request.setAttribute("estadoSorteo", estadoS);
        	if (estadoS == 0) {
            	request.setAttribute("registrados", port.getRegistrados(clase));
        	}
        	else if (estadoS == 1) {
        		request.setAttribute("ganadores", port.getGanadores(clase));
        	}
        	request.setAttribute("clase", clase);
        	request.getRequestDispatcher("/realizar_sorteo.jsp").forward(request, response);
  
    	} else if (path.equals("/confirmar_sorteo")) {
    		String clase = (String) request.getParameter("clase");
    		port.realizarSorteo(clase);
    		request.setAttribute("ganadores", port.getGanadores(clase));
    		request.setAttribute("estadoSorteo", 1);
        	request.setAttribute("clase", clase);
        	request.getRequestDispatcher("/realizar_sorteo.jsp").forward(request, response);
        	
    	} else if (path.equals("/alta_dictado_clase")) {
            Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

            if (esProfesor == null || !esProfesor)
                throw new IllegalArgumentException("profesor no logeado");

            processRequest(request,response);

        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        if(path.equals("/confirmar_registro_clase")) {

            HttpSession session = request.getSession();

            String nickname = null;

            if ((boolean) session.getAttribute("es_profesor")) {
                BeanProfesor p = (BeanProfesor) session.getAttribute("usuario");
                nickname = p.getNickname();
            } else {
                BeanSocio s = (BeanSocio) session.getAttribute("usuario");
                nickname = s.getNickname();
            }

            String cla = request.getParameter("clase");
            String cup = request.getParameter("cuponera");
            LocalDate fecha = LocalDate.now();

            if (cup == null) {
                response.getWriter().println("cup null");
                try {
                    port.registrarseSinCuponera(nickname, cla, Utils.beanFromLocalDate(fecha));

                    Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");
                    if (esProfesor != null)
                        updateUsuario(port, request);

                } catch (RegistroInconsistenteExceptionWrapper_Exception e) {
                    request.setAttribute("reg_exito", false);
                    request.getRequestDispatcher("confirmar_registro_clase.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("reg_exito", true);

            }
            else {
                response.getWriter().println("cup != null");
                try {
                    port.registrarseConCuponera(nickname, cla, cup, Utils.beanFromLocalDate(fecha));

                    Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");
                    if (esProfesor != null)
                        updateUsuario(port, request);

                } catch (RegistroInconsistenteExceptionWrapper_Exception e) {
                    e.printStackTrace(response.getWriter());
                    request.setAttribute("reg_exito", false);
                    request.getRequestDispatcher("confirmar_registro_clase.jsp").forward(request, response);
                    return;
                }
                request.setAttribute("reg_exito", true);
            }
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));

        } else if (path.equals("/alta_dictado_clase")) {
            Boolean bool1 = request.getParameter("nombre").equals("");
            Boolean bool2 = request.getParameter("cant_min").equals("");
            Boolean bool3 = request.getParameter("cant_max").equals("");
            Boolean bool4 = request.getParameter("acceso").equals("");
            if (bool1||bool2||bool3||bool4){
                request.setAttribute("error", "Por favor llene los campos");
                processRequest(request, response);
                return;
            }

            String actividad = request.getParameter("actividad");
            String nombre = request.getParameter("nombre");
            LocalDateTime inicio = LocalDateTime.parse(request.getParameter("inicio"));
            int cantMin = Integer.parseInt(request.getParameter("cant_min"));
            int cantMax = Integer.parseInt(request.getParameter("cant_max"));
            URL acceso = new URL(request.getParameter("acceso"));
            LocalDate registro = LocalDate.parse(request.getParameter("fecha_registro"));

            Set<String> profes = new HashSet<String>();

            HttpSession session = request.getSession();
            String nickname;
            if ((boolean) session.getAttribute("es_profesor")) {
                BeanProfesor p = (BeanProfesor) session.getAttribute("usuario");
                nickname = p.getNickname();
            } else {
                BeanSocio s = (BeanSocio) session.getAttribute("usuario");
                nickname = s.getNickname();
            }

            profes.add(nickname);

            Part imgPart = request.getPart("img");
            InputStream is = imgPart.getInputStream();
            long size = imgPart.getSize();
            byte[] data = new byte[(int) size];
            is.read(data);

            BeanCrearClaseArgs args = new BeanCrearClaseArgs();

            args.setActividad(actividad);
            args.setNombre(nombre);
            args.setInicio(Utils.beanFromLocalDateTime(inicio));
            args.getNicknameProfesores().addAll(profes);
            args.setCantMin(cantMin);
            args.setCantMax(cantMax);
            args.setAcceso(acceso.toString());
            args.setRegistro(Utils.beanFromLocalDate(registro));
            args.setImagen(data);

            try {
                port.crearClase(args);

                Boolean esProfesor = (Boolean) request.getSession().getAttribute("es_profesor");

                if (esProfesor != null)
                    updateUsuario(port, request);

            } catch (ClaseInconsistenteExceptionWrapper_Exception e) {
                String r = e.getFaultInfo().getInconsistencias().get(0);
                switch (r) {
                    case "NOMBRE_REPETIDO":
                        request.setAttribute("error", "Nombre no disponible");
                        break;
                    case "CANT_MAX_MENOR_MIN":
                        request.setAttribute("error","La cantidad minima de socios debe ser menor a la cantidad maxima.");
                        break;
                    case "INICIO_MENOR_REGISTRO":
                        request.setAttribute("error","La fecha de inicio debe ser posterior a la de registro.");
                        break;
                    case "REGISTRO_MENOR_REGISTRO_ACTIVIDAD":
                        request.setAttribute("error", "La fecha de registro de la clase debe ser posterior a la de registro de la actividad.");
                        break;
                }
                processRequest(request, response);
                //e.printStackTrace(response.getWriter());
            }

            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PublicadorService service = new PublicadorService();
        Publicador port = service.getPublicadorPort();

        BeanProfesor profesor = (BeanProfesor) request.getSession().getAttribute("usuario");
        String institucion = profesor.getInstitucion();
        List<String> actividades = port.getActividadesDeInstitucion(institucion);

        request.setAttribute("institucion", institucion);
        request.setAttribute("actividades", actividades);
        request.setAttribute("profe", profesor.getNickname());

        request.getRequestDispatcher("/alta_dictado_clase.jsp").forward(request, response);
    }
}
