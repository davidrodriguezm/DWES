package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.drodriguezm.dao.ProductLinesDao;
import org.iesalixar.drodriguezm.model.ProductLines;


/**
 * Servlet implementation class InicioServelt
 */
@WebServlet(name = "Inicio", urlPatterns = { "/Home" })
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
		ArrayList<ProductLines> productLinesList = (ArrayList<ProductLines>) ProductLinesDao.getAllProductLines();		
		
		request.setAttribute("productLines",productLinesList);
		
		request.getRequestDispatcher("WEB-INF/view/inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
