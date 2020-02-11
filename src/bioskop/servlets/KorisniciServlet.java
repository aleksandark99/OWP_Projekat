package bioskop.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.FilmoviDAO;
import bioskop.dao.UsersDAO;
import bioskop.model.Film;
import bioskop.model.Korisnik;
import bioskop.model.Role;

/**
 * Servlet implementation class KorisniciServlet
 */
public class KorisniciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public KorisniciServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}
		System.out.println("Pogodjen servlet KorisniciServlet");
		try {
			String username="";
			String uloga="";
			try {
				if(request.getParameter("username")!=null) {
					username = request.getParameter("username");
				}
			
				if(request.getParameter("uloga")!=null) {
					uloga = request.getParameter("uloga");
				}
			}finally {
					System.out.println("ss");
				}
			
			
			List<Korisnik> korisnici= UsersDAO.getAll(username,uloga);
			
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

//			for(Korisnik korisnik : korisnici) {
//				System.out.println(korisnik.getUsername());
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("korisnici", korisnici);
				request.setAttribute("data", data);
				
				

				
				
				
			//}
			response.getWriter().write(om.writeValueAsString(korisnici));
			response.getWriter().close();
		
			System.out.println("try izvrsen");
			System.out.println(korisnici.get(0).getDatumRegistracije());


		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
