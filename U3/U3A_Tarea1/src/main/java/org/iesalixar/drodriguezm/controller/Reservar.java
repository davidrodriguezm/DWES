package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Reservar
 */
@WebServlet("/Reservar")
public class Reservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Reservar.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		if (!sesion.isNew() && sesion.getAttribute("usuario") != null && sesion.getAttribute("sesion") != null) {
			request.getRequestDispatcher("reservar.jsp").forward(request,response);
			
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
		HttpSession sesion = request.getSession();
		request.setCharacterEncoding("UTF-8");
		
		if (!sesion.isNew() && sesion.getAttribute("usuario") != null) {
			
			if (request.getParameter("inicio")!=null && request.getParameter("fin")!=null
					&& request.getParameter("personas")!=null 
					&& request.getParameterValues("servicio")!=null) {
				
				sesion.setAttribute("inicio", request.getParameter("inicio"));
				sesion.setAttribute("fin", request.getParameter("fin"));
				sesion.setAttribute("personas", request.getParameter("personas"));
				sesion.setAttribute("servicio", request.getParameterValues("servicio"));
			
				response.sendRedirect(request.getContextPath()+"/Confirmar");
				
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

}
