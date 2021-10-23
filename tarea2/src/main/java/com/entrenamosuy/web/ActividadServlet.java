package com.entrenamosuy.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collections;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.core.FacadeActividad;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.model.Profesor;
import com.entrenamosuy.core.exceptions.ActividadRepetidaException;
import com.entrenamosuy.core.exceptions.InstitucionNoEncontradaException;
import com.entrenamosuy.core.exceptions.SinCategoriaException;

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = (String)request.getParameter("nombre_alta_act");
        String descripcion = (String)request.getParameter("descripcion_alta_act");
        Duration duracion = (Duration.ofMinutes(Long.parseLong(request.getParameter("duracion_alta_act"))));
        Float costo = Float.valueOf(request.getParameter("costo_alta_act"));
        Set<String> categorias = new HashSet<String>();
        String[] array = request.getParameterValues("select_categorias");
        if (array!=null && array.length!=0)
            Collections.addAll(categorias, array);
        //response.getWriter().println(categorias.size());
        try {
            //String ins = ((Profesor)request.getSession().getAttribute("usuario")).getInstitucion().getNombre(); Esto es lo que se deberia hacer una vez loggeado.
            Facades.getFacades().getFacadeActividad().crearActividad()
                .setNombre(nombre)
                .setDescripcion(descripcion)
                .setInstitucion("Telon")
                .setDuracion(duracion)
                .setCosto(costo)
                .setRegistro(LocalDate.now())
                .setCategorias(categorias)
                .setCreador("Nelson")
                .invoke();
            request.setAttribute("error", "Alta exitosa. ");
            response.sendRedirect(response.encodeRedirectURL("/tarea2"));
            return;
        }
        catch(ActividadRepetidaException are){
            request.setAttribute("error", "Ya existe una actividad con ese nombre. ");
            //response.sendError(400, "Ya existe una actividad con ese nombre. ");
        }
        catch(InstitucionNoEncontradaException inee){
            request.setAttribute("error", "No existe una institucion con ese nombre. ");
        }
        catch(SinCategoriaException sce){
            request.setAttribute("error", "Debe seleccionar al menos una categoria. ");
        }
        //response.sendRedirect("/alta_actividad.jsp");
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

