package bioskop.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.UsersDAO;
import bioskop.model.Korisnik;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			try {
				
				
				Korisnik user = UsersDAO.getUser(username, password);
				if(user == null) {
					request.getRequestDispatcher("./FailureServlet").forward(request, response);
					return;

				}
				request.getSession().setAttribute("loggedUsername", user.getUsername());
				request.getSession().setAttribute("Uloga", user.getUloga());

				request.getRequestDispatcher("./SuccessServlet").forward(request, response);


				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		
		
		
	}

}
