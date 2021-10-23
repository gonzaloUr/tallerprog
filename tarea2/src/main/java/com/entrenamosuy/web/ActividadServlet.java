package com.entrenamosuy.web;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;
import com.entrenamosuy.core.data.DataCuponera;
import com.entrenamosuy.core.data.DataInstitucion;

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
            Set<String> actividadesOfrecidas = institucion.getActividadesOfrecidas()
                .stream()
                .map(DataActividad::getNombre)
                .collect(Collectors.toSet());

            request.setAttribute("nombre", nombre);
            request.setAttribute("descripcion", descripcion);
            request.setAttribute("url", url);
            request.setAttribute("actividadesOfrecidas", actividadesOfrecidas);

            request
				.getRequestDispatcher("/consulta_institucion.jsp")
				.forward(request, response);
        }
	}
}