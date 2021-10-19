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

public class ActividadServlet extends HttpServlet {
    
    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
        
		if(path.equals("/lista_actividades")) {
            Set<DataActividad> acts = Facades
				.getFacades()
				.getFacadeActividad()
				.listarActividadesRegistradas();

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
		} else {
			// TODO: alta actividad			
		}
    }
    
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}