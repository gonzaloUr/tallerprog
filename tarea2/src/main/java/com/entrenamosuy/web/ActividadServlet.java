package com.entrenamosuy.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;


import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.entrenamosuy.core.FacadeActividad;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.data.DataProfesor;
import com.entrenamosuy.core.data.DataUsuario;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SinCategoriaException;


@MultipartConfig(fileSizeThreshold=1024*1024*10, maxFileSize=1024*1024*50, maxRequestSize=1024*1024*100)
public class ActividadServlet extends HttpServlet {
    


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
        if(path.equals("/lista_actividades")) {
            Set<DataActividad> acts = Facades
				.getFacades()
				.getFacadeActividad()
				.listarActividadesAceptadas();

			request.setAttribute("actividades", acts);
			request.getRequestDispatcher("/lista_actividades.jsp")
				.forward(request, response);

		} else if(path.equals("/consulta_actividad")) {
			String act = request.getParameter("nombre");
			DataActividad actividad = Facades.getFacades().getFacadeActividad().getDataActividad(act);

            String nombre = actividad.getNombre();
            String descripcion = actividad.getDescripcion();

            Set<String> clasesOfrecidas = actividad.getClases()
                .stream()
                .map(DataClase::getNombre)
                .collect(Collectors.toSet());

            Set<String> cuponerasAsociadas = actividad.getCuponeras()
                .stream()
                .map(DataCuponera::getNombre)
                .collect(Collectors.toSet());

            Set<String> categoriasAsociadas = actividad.getCategorias()
                .stream()
                .collect(Collectors.toSet());

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("clasesOfrecidas", clasesOfrecidas);
            request.setAttribute("cuponerasAsociadas", cuponerasAsociadas);
            request.setAttribute("categoriasAsociadas", categoriasAsociadas);

			request
				.getRequestDispatcher("/consulta_actividad.jsp")
				.forward(request, response);

		} else if(path.equals("/consulta_institucion")) {
            //QUEDO ACA INSTITUCION POR FACILIDAD

            String institucionNombre = request.getParameter("institucion");
            DataInstitucion institucion = Facades
                .getFacades()
                .getFacadeInstitucion()
                .getDataInstitucion(institucionNombre);

            String nombre = institucion.getNombre();
            String descripcion = institucion.getDescripcion();
            String url = institucion.getUrl().toString();
            Set<String> actividadesOfrecidas = Facades.getFacades().getFacadeActividad().getActividadesDeInstitucion(nombre);

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("actividadesOfrecidas", actividadesOfrecidas);

            request.getRequestDispatcher("/consulta_institucion.jsp")
                .forward(request, response);
                
		}
        else if (path=="/alta_actividad") { //Cuando quieren llenar el formulario para dar de alta la actividad.
            processRequest(request, response);
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
        HttpSession session = request.getSession();
        DataProfesor usr = (DataProfesor) session.getAttribute("usuario");
        String nick = usr.getNickname();
        String inst = usr.getInstitucion();
        String nombre = (String)request.getParameter("nombre_alta_act");
        String descripcion = (String)request.getParameter("descripcion_alta_act");
        Duration duracion = (Duration.ofMinutes(Long.parseLong(request.getParameter("duracion_alta_act"))));
        Float costo = Float.valueOf(request.getParameter("costo_alta_act"));
        Part imgPart = request.getPart("img");
        InputStream is = imgPart.getInputStream();

        File tmp = File.createTempFile("img_", null);
        OutputStream os = new FileOutputStream(tmp);

        pipe(is, os);
        os.close();
        Set<String> categorias = new HashSet<String>();
        String[] array = request.getParameterValues("select_categorias");
        if (array!=null && array.length!=0)
            Collections.addAll(categorias, array);
        try {
            Facades.getFacades().getFacadeActividad().crearActividad()
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setInstitucion(inst)
                .setDuracion(duracion)
                .setCosto(costo)
                .setRegistro(LocalDate.now())
                .setCategorias(categorias)
                .setCreador(nick)
                .setImagen(tmp)
                .invoke();
            request.setAttribute("error", "Alta exitosa. ");
            response.sendRedirect(response.encodeRedirectURL("/tarea2"));
            return;
        }
        catch(ActividadRepetidaException are){
            request.setAttribute("error", "Ya existe una actividad con ese nombre. ");
        }
        catch(InstitucionNoEncontradaException inee){
            request.setAttribute("error", "No existe una institucion con ese nombre. ");
        }
        catch(SinCategoriaException sce){
            request.setAttribute("error", "Debe seleccionar al menos una categoria. ");
        }
        processRequest(request, response);
        request.getRequestDispatcher("/alta_actividad.jsp")
			.forward(request, response);

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<String> categorias = Facades
            .getFacades()
            .getFacadeActividad()
            .getCategorias();

        request.setAttribute("categorias", categorias);
        request.getRequestDispatcher("/alta_actividad.jsp")
			.forward(request, response);
    }


}

