package ar.com.marcos;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet(description = "Testing TomEE with a Servlet", urlPatterns = { "/TestServlet" })
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	TestSessionBean exampleBean;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("I'm servlet and this is "+exampleBean.getRegard()+": ").append(request.getContextPath());
		
	}



}
