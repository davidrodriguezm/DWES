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
 * Servlet implementation class MostrarProductosServlet
 */
@WebServlet(name = "MostrarProductos", urlPatterns = { "/MostrarProductos" })
public class MostrarProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("productLine")!=null) {
			ArrayList<Product> products = (ArrayList<Product>)ProductsDao.getProductByProductLine(
																request.getParameter("productLine"));
			
			request.setAttribute("products",products);	
		} else 
			request.setAttribute("mensage","Categoría NO SELECCIONADA");
		
		request.getRequestDispatcher("WEB-INF/view/productsTabla.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
