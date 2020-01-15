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
import bioskop.model.Film;

public class FilmoviServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilmoviServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Pogodjen servlet FilmoviServlet");
		try {
			List<Film> filmovi= FilmoviDAO.getAll();
			
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

			for(Film film : filmovi) {
				System.out.println(film.getNaziv());
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("filmovi", filmovi);
				request.setAttribute("data", data);
				
				
				
				//response.getWriter().write(om.writeValueAsString(film));
			//	response.getWriter().append(om.writeValueAsString(film));
			//	response.getOutputStream().wr
			//	response.getWriter().close();
				
				
				
			}
			response.getWriter().write(om.writeValueAsString(filmovi));
			response.getWriter().close();
//			response.addHeader("Access-Control-Allow-Origin", "*");
		
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
