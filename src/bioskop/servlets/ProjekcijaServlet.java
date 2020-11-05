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
import bioskop.dao.ProjekcijeDAO;
import bioskop.model.Film;
import bioskop.model.Projekcija;
import bioskop.model.Sala;
import bioskop.model.Sediste;


public class ProjekcijaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ProjekcijaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String strid = request.getParameter("id");
			Projekcija projekcija= ProjekcijeDAO.getProjekcija(strid);
			Sala sala =ProjekcijeDAO.getSala(projekcija.getSala().getId());
			List<Sediste> sedista = ProjekcijeDAO.getSedista(sala.getNaizv());

			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("projekcija", projekcija);
				data.put("sedista", sedista);
				data.put("sala", sala);

				response.getWriter().write(om.writeValueAsString(data));
				response.getWriter().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
