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

/**
 * Servlet implementation class FilmServlet
 */
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FilmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		System.out.println("Pogodjen servlet");
		try {
			String strid = request.getParameter("id");
			Film film= FilmoviDAO.getFilm(strid);
			System.out.println("ID sa fronta je "+ strid);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");

			//int id = Integer.parseInt(strid);
			
			
			response.getWriter().write(om.writeValueAsString(film));
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("film", film);
				request.setAttribute("data", data);
				System.out.println(data);

//			response.getWriter().write(om.writeValueAsString(filmovi));
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
