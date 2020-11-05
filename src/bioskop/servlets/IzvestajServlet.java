package bioskop.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.ProjekcijeDAO;
import bioskop.dao.UsersDAO;
import bioskop.model.Izvestaj;
import bioskop.model.Korisnik;
import bioskop.model.Role;

/**
 * Servlet implementation class IzvestajServlet
 */
public class IzvestajServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IzvestajServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}

		String od1 = "0";

		String do1 = "9999-12-31 23:59:59.997";
		try {

			if (request.getParameter("doDate") != null && request.getParameter("doDate") != "") {
				try {
					String o = request.getParameter("doDate");
					SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
					Date date3 = formatter1.parse(o);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String strDate = dateFormat.format(date3);
					do1 = strDate;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			if (request.getParameter("odDate") != null && request.getParameter("odDate") != "") {
				try {
					String o = request.getParameter("odDate");
					SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");
					Date date3 = formatter1.parse(o);
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String strDate = dateFormat.format(date3);
					od1 = strDate;
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

			List<Izvestaj> izvestaji = ProjekcijeDAO.izvestaj(od1, do1);
			for (Izvestaj izvestaj : izvestaji) {
				if (izvestaj.getBrojKarata().equals("0")) {
					izvestaj.setUkupnaCena("0");

				}
			}
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

			Map<String, Object> data = new LinkedHashMap<>();
			data.put("izvestaji", izvestaji);
			request.setAttribute("data", data);

			response.getWriter().write(om.writeValueAsString(izvestaji));
			response.getWriter().close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
