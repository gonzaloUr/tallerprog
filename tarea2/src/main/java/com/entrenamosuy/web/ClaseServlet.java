package com.entrenamosuy.web;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.core.AbstractFacadeClase;
import com.entrenamosuy.core.AbstractFacadeCuponera;
import com.entrenamosuy.core.AbstractFacadeActividad;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.exceptions.RegistroInconsistenteException;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.data.DescProfesor;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;



public class ClaseServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            String cla = request.getParameter("clase");
			
            //HttpSession session = request.getSession();

            //String nickname = (String) session.getAttribute("nickname");

            Set<String> cupos = Facades
				.getFacades()
				.getFacadeCuponera()
				.cuponerasUsables(act, "Emi71");

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

		} else {

		}
    }
    

	
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/confirmar_registro_clase")) {
           
			//HttpSession session = request.getSession();
        	//String nickname = (String) session.getAttribute("nickname");

			//TODO CHEQUEAR QUE YA ESTÁ REGISTRADO A LA CLASE!!!!!
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
					.registarseSinCuponera("Emi71", cla, fecha);
				} catch (RegistroInconsistenteException e) { 
					e.printStackTrace(response.getWriter());
				}
			}
			else {
				response.getWriter().println("cup != null");
				try {
					Facades
					.getFacades()
					.getFacadeActividad()
					.registraseConCuponera("Emi71" , cla, cup, fecha);
				} catch (RegistroInconsistenteException e) {
					e.printStackTrace(response.getWriter());
				}
			}
			response.getWriter().println("hola");
			response.getWriter().println("clase" + cla);
			response.getWriter().println("cuponera" + cup);

        } 
    }
	
}











