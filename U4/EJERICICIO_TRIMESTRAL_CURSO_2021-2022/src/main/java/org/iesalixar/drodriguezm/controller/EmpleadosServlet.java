package org.iesalixar.drodriguezm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iesalixar.drodriguezm.dao.EmployeesDao;
import org.iesalixar.drodriguezm.dao.OfficesDao;
import org.iesalixar.drodriguezm.model.Employee;
import org.iesalixar.drodriguezm.model.Office;

/**
 * Servlet implementation class EmpleadosServlet
 */
@WebServlet(name = "Empleados", urlPatterns = { "/Admin/Empleados" })
public class EmpleadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpleadosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Employee> employees = (ArrayList<Employee>) EmployeesDao.getAllEmployees();				
		request.setAttribute("employees",employees);
		
		ArrayList<Office> offices = (ArrayList<Office>) OfficesDao.getAllOffices();		
		
		request.setAttribute("offices",offices);
		
		request.getRequestDispatcher("WEB-INF/view/employeesTabla.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
