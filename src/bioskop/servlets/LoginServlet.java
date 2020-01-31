package bioskop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				
				
				Korisnik korisnik = UsersDAO.getUser(username, password);
				if(korisnik == null) {
					request.getRequestDispatcher("./FailureServlet").forward(request, response);
					return;

				}
				request.getSession().setAttribute("loggedUsername", korisnik.getUsername());
				request.getSession().setAttribute("Uloga", korisnik.getUloga());

				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		
		
		
	}

}
