package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.iesalixar.drodriguezm.dao.UsuariosDao;
import org.iesalixar.drodriguezm.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(LoginServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("email") != null && request.getParameter("password") != null) {
			
			Usuario usuario = UsuariosDao.login(request.getParameter("email"),
												request.getParameter("password"));			
			
			if(usuario != null) {
				request.getSession().setAttribute("usuario",usuario);
				logger.info("Usuario logueado correctamente");
				response.sendRedirect(request.getContextPath()+"/Home");
				return;
			} else
				logger.error("Error al loguear");
		}  
		doGet(request,response);
	}

}