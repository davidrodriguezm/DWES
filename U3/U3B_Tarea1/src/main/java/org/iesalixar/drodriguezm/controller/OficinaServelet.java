package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.drodriguezm.dao.OfficesDao;
import org.iesalixar.drodriguezm.model.Office;


/**
 * Servlet implementation class OficinaServelet
 */
@WebServlet(name = "OficinaServelet", urlPatterns = { "/Oficinas" })
public class OficinaServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OficinaServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Office> offices = (ArrayList<Office>) OfficesDao.getAllOffices();		
		request.setAttribute("offices",offices);
		
		request.getRequestDispatcher("WEB-INF/view/oficinas.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("office") != null) {
			
			ArrayList<Office> officesResul = (ArrayList<Office>) OfficesDao.buscarByCity((String)request.getParameter("office"));		
			request.setAttribute("officesResul",officesResul);
		}
		doGet(request, response);
	}

}
