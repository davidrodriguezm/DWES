package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.iesalixar.drodriguezm.model.Reserva;

/**
 * Servlet implementation class Confirmar
 */
@WebServlet("/Confirmar")
public class Confirmar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Reservar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirmar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		if (!sesion.isNew() && sesion.getAttribute("usuario") != null ) {
			
			if (sesion.getAttribute("inicio")!=null && sesion.getAttribute("fin")!=null && 
					sesion.getAttribute("personas")!=null && sesion.getAttribute("servicio")!=null) {
				
				Reserva reserva = new Reserva();
				
				reserva.setInicio((String)sesion.getAttribute("inicio"));
				reserva.setFin((String)sesion.getAttribute("fin"));
				reserva.setPersonas(Integer.valueOf((String)sesion.getAttribute("personas")));
//				reserva.setServicio((List<String>)sesion.getAttribute("servicio"));
				
				sesion.setAttribute("reserva",reserva);
			
				request.getRequestDispatcher("confirmar.jsp").forward(request,response);
				
			} else {
				logger.error("Faltan parámetros");	
				response.sendRedirect(request.getContextPath()+"/Reservar");			
			}
			
		} else {
			logger.error("Intento de entrar en Seleccionar sin tener sesión");
			sesion.invalidate();
			
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
