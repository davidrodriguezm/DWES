package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.drodriguezm.dao.ProductsDao;
import org.iesalixar.drodriguezm.model.Product;

/**
 * Servlet implementation class AdminInicioServlet
 */
@WebServlet(name = "AdminInicioServlet", urlPatterns = { "/Admin/Inicio" })
public class AdminInicioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInicioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> products = (ArrayList<Product>)ProductsDao.getAllProducts();
		request.setAttribute("products",products);
		
		request.getRequestDispatcher("/WEB-INF/view/admin/adminInicio.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
