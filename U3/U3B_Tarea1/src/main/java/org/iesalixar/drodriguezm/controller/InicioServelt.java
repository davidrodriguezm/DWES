package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.drodriguezm.dao.UsuariosDao;
import org.iesalixar.drodriguezm.model.Usuario;

/**
 * Servlet implementation class InicioServelt
 */
@WebServlet(name = "InicioServelt", urlPatterns = { "/" })
public class InicioServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InicioServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/view/inicio.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("usuario") != null && request.getParameter("password") != null) {
			
			Usuario usuario = UsuariosDao.login(request.getParameter("usuario"),
												request.getParameter("password"));
			
			if(usuario != null) {
				request.getSession().setAttribute("usuario",usuario);
				
				response.sendRedirect(request.getContextPath()+"/");
				return;
			} 
		}  
		doGet(request,response);
	}

}
