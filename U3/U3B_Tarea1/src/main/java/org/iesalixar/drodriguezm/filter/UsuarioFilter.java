package org.iesalixar.drodriguezm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iesalixar.drodriguezm.model.Usuario;

/**
 * Servlet Filter implementation class UsuarioFilter
 */
@WebFilter(filterName = "UsuarioFilter", servletNames={"OficinaServelet"})
public class UsuarioFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UsuarioFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
			
		if( session.getAttribute("usuario") != null ) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			
			if ("usuario".equals(usuario.getRol()))
				chain.doFilter(request,response);
			else 
				res.sendRedirect(req.getContextPath()+"/");
			
		} else
			res.sendRedirect(req.getContextPath()+"/");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
