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
import bioskop.dao.UsersDAO;
import bioskop.model.Karta;
import bioskop.model.Korisnik;

public class GetKarteProjekcije extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetKarteProjekcije() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {			
			String id_projekcije = request.getParameter("id_projekcije");
		List<Karta> karte = KarteDAO.getAll(id_projekcije);

		ObjectMapper om = new ObjectMapper();
		response.setContentType("application/json; utf-8");


		
		
			
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("karte", karte);
			response.getWriter().write(om.writeValueAsString(data));

			System.out.println(data);

		response.getWriter().close();
	
		System.out.println("try izvrsen");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
