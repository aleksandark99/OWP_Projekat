package bioskop.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bioskop.dao.UsersDAO;
import bioskop.model.Korisnik;
import bioskop.model.Role;

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditUserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Object> data = new LinkedHashMap<>();

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

			String staro = request.getParameter("staro");
			if (!korisnickoIme.equals(staro)) {
			} else {
			}

			if (!korisnickoIme.equals(staro)) {
				if (UsersDAO.getUser(korisnickoIme) != null) {
					throw new Exception("Korisnicko ime vec postoji!");
				}
			}

			if ("".equals(korisnickoIme) || korisnickoIme == null) {
				throw new Exception("Korisnicko ime je prazno!");
			}
			String password = request.getParameter("password");
			if ("".equals(password) || password == null) {
				throw new Exception("Lozinka je prazna!");

			}
			Date datumRegistracije = new Date();

			Korisnik korisnik = new Korisnik(korisnickoIme, password, datumRegistracije, Role.USER);

			UsersDAO.updateUser(korisnik, staro);
			request.getRequestDispatcher("./SuccessServlet").forward(request, response);
			data.put("us", korisnik);

		} catch (Exception e) {

			String message = e.getMessage();
			if (message == null) {
				message = "Nepredvidjena greska!";
				e.printStackTrace();
			}

			data.put("message", message);

			request.setAttribute("data", data);
			request.getRequestDispatcher("./FailureServlet").forward(request, response);

		}

	}

}
