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

import bioskop.dao.ProjekcijeDAO;
import bioskop.dao.UsersDAO;
import bioskop.model.Izvestaj;
import bioskop.model.Korisnik;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
		List<Izvestaj> izvestaji= ProjekcijeDAO.izvestaj();
			for (Izvestaj izvestaj : izvestaji) {
				if(izvestaj.getBrojKarata().equals("0")) {
					izvestaj.setUkupnaCena("0");
							
							
				}
			}
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

//			for(Korisnik korisnik : korisnici) {
//				System.out.println(korisnik.getUsername());
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("izvestaji", izvestaji);
				request.setAttribute("data", data);
				
				

				
				
				
			//}
			response.getWriter().write(om.writeValueAsString(izvestaji));
			response.getWriter().close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
