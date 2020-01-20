package bioskop.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
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


public class KorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public KorisnikServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Pogodjen servlet KorisnikServlet");
		try {
			String korisnickoIme = request.getParameter("username");
			Korisnik user = UsersDAO.getUser(korisnickoIme);
			System.out.println("korisnickoIme sa fronta je "+ korisnickoIme);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

			//int id = Integer.parseInt(strid);
			
			
			response.getWriter().write(om.writeValueAsString(user));
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("user", user);
				request.setAttribute("data", data);
				System.out.println(data);

			response.getWriter().close();
		
			System.out.println("try izvrsen");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
