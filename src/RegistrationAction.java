

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
 * Servlet implementation class RegistrationAction
 */
@WebServlet("/RegistrationAction")
public class RegistrationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("registration action page");
		
		String name = request.getParameter("name");
		System.out.println("name :"+name);

		String address = request.getParameter("address");
		System.out.println("Address :"+address);
		
		String contact = request.getParameter("contact");
		System.out.println("Contact :"+contact);

		String email = request.getParameter("email");
		System.out.println("Email :"+email);

		
		RegistrationBean rb = new RegistrationBean();
		rb.setName(name);
		rb.setAddress(address);
		rb.setContact(contact);
		rb.setEmail(email);
		
		int status = RegistrationDao.insert(rb);
		if(status > 0)
		{
			System.out.println("data is inserted");
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("data not inserted");
		}
		
		
		
		
		
		
		
	}

}
