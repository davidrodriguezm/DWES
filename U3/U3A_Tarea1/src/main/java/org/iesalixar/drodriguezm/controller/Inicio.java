package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Inicio
 */
@WebServlet("/")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(Inicio.class);
	
	// 8-16 characters password with at least one digit, one lowercase letter,
    // one uppercase letter, one special character with no whitespaces
	// ejemplo A12345h123=fh
	private static final String PASSWORD_REGEX =
	        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";
	 
	private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("inicio.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		if (request.getParameter("usuario") != null && request.getParameter("password") != null 
				&& request.getParameter("confirmar") != null && request.getParameter("email") != null 
				&& PASSWORD_PATTERN.matcher(request.getParameter("password")).matches()
				&& request.getParameter("password").equals(request.getParameter("confirmar"))) {
			
			HttpSession sesion = request.getSession();			
			
			sesion.setAttribute("usuario",request.getParameter("usuario"));
			sesion.setAttribute("sesion",new Date(sesion.getCreationTime()));
			
			logger.info("El usuario ha entrado en sesión");
			response.sendRedirect(request.getContextPath()+"/Reservar");
			
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

}
