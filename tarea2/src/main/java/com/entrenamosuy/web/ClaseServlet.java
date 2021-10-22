package com.entrenamosuy.web;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entrenamosuy.core.AbstractFacadeClase;
import com.entrenamosuy.core.exceptions.ClaseInconsistenteException;
import com.entrenamosuy.core.data.DataInstitucion;
import com.entrenamosuy.core.data.DataActividad;
import com.entrenamosuy.core.data.DataClase;



public class ClaseServlet extends HttpServlet {
    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
        
		if(path.equals("/registrarse_a_clase")) {
            Set<String> inst = Facades
				.getFacades()
				.getFacadeInstitucion()
				.getInstituciones();

			request.setAttribute("instituciones", inst);
			request.getRequestDispatcher("/registrarse_a_clase.jsp")
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

		} else {
			// TODO: alta actividad			
		}
    }
    

	/*
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if(path.equals("/confirmar_registro_clase")) {
            String cup = request.getParameter("cuponera");
            
        }    
    }
	*/
}











