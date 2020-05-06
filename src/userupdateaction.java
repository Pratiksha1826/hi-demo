

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.RegistrationBean;
import Dao.RegistrationDao;

/**
 * Servlet implementation class userupdateaction
 */
@WebServlet("/userupdateaction")
public class userupdateaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("id");
		int Id = Integer.parseInt(id);
		
		String name = request.getParameter("name");

		String address = request.getParameter("address");
		
		String contact = request.getParameter("contact");

		String email = request.getParameter("email");
		

		
		RegistrationBean rb = new RegistrationBean();
		rb.setName(name);
		rb.setAddress(address);
		rb.setContact(contact);
		rb.setEmail(email);
		
		int status = RegistrationDao.update(Id , rb);
		if(status > 0)
		{
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			System.out.println("user data update");
		}
		else
		{
			System.out.println("data is not updated.......");
		}
	}

}
