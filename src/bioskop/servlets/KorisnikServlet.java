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
import bioskop.model.Role;

public class KorisnikServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public KorisnikServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		String korisnickoIme = request.getParameter("username");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		} else if (!korisnickoIme.equals(loggedUsername))
			if (!Uloga.equals(Role.ADMIN)) {
				request.getRequestDispatcher("./LogoutServlet").forward(request, response);
				return;
			}
		try {
			Korisnik user = UsersDAO.getUser(korisnickoIme);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			response.getWriter().write(om.writeValueAsString(user));

			Map<String, Object> data = new LinkedHashMap<>();
			data.put("user", user);
			request.setAttribute("data", data);
			response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
