package bioskop.servlets;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.ProjekcijeDAO;
import bioskop.model.Projekcija;


public class ProjekcijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProjekcijeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String movie="";
			LocalDateTime odDate = LocalDateTime.now();
			String formattedDate = odDate.format(DateTimeFormatter.ofPattern("YYYY-dd-MM HH:mm:ss"));
			
			
			List<Projekcija> projekcije =ProjekcijeDAO.getProjekcije("", "2020-06-12 11:00:59", "2021-06-12 11:00:59", 1, 1, 0, 9999);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("projekcije", projekcije);
			request.setAttribute("data", data);
			response.getWriter().write(om.writeValueAsString(projekcije));
			response.getWriter().close();
			
			
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
