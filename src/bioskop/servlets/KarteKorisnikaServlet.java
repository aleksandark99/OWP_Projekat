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

import bioskop.dao.KarteDAO;
import bioskop.model.Karta;
import bioskop.model.Role;

public class KarteKorisnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KarteKorisnikaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		String korisnickoIme = request.getParameter("username");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");

		try {
			String username = request.getParameter("username");
			List<Karta> karte = KarteDAO.getAllKorisnik(username);

			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("karte", karte);
			response.getWriter().write(om.writeValueAsString(data));
			response.getWriter().close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
