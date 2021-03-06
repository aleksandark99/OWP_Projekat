package bioskop.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bioskop.dao.UsersDAO;
import bioskop.model.Role;


public class UlogaKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UlogaKorisnikaServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}
		try {
			 String username=request.getParameter("username");
			 String uloga=request.getParameter("uloga");
			 UsersDAO.UpdateUloguUsera(username, uloga);
			 request.getRequestDispatcher("./SuccessServlet").forward(request, response);
			 
			 ServletContext sc = request.getSession( ).getServletContext();
			 HashMap<String,HttpSession> mapa_sesija = (HashMap<String, HttpSession>) sc.getAttribute("sesije");
			 
			 HttpSession session = mapa_sesija.get(username);				
			 if (session != null) {
					mapa_sesija.remove(username); 
					session.invalidate();
				}
			 
		} catch (Exception e) {
			System.out.println(e);
		}

	
	
	}

}
