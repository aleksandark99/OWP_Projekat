package bioskop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bioskop.dao.FilmoviDAO;
import bioskop.model.Role;

/**
 * Servlet implementation class RemoveFilmServlet
 */
public class RemoveFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RemoveFilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}
	try {
		String strid = request.getParameter("id");
		FilmoviDAO.removeFilm(strid);
		request.getRequestDispatcher("./SuccessServlet").forward(request, response);

		
	}catch (Exception e) {
		System.out.println(e);
		request.getRequestDispatcher("./FailureServlet").forward(request, response);
	}	
	}

}
