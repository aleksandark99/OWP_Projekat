package bioskop.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bioskop.dao.FilmoviDAO;
import bioskop.dao.KarteDAO;
import bioskop.model.Role;

/**
 * Servlet implementation class RemoveKartaFilm
 */
public class RemoveKartaFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveKartaFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dobrodosli na remove krata id");
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}
	try {
		String strid = request.getParameter("id");
		KarteDAO.removeKarta(strid);
		request.getRequestDispatcher("./SuccessServlet").forward(request, response);

		
	}catch (Exception e) {
System.out.println(e);	
request.getRequestDispatcher("./FailureServlet").forward(request, response);
	}	
	}
	

}
