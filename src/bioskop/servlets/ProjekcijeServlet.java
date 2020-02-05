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
			String od1 = odDate.format(DateTimeFormatter.ofPattern("YYYY-dd-MM HH:mm:ss"));
			String do1 = "9999-12-31 23:59:59.997";
			String sala="";
			String tip ="";
			int min =0;
			int max =99999999;
			
			try {
				if(request.getParameter("movie") != null) {
					movie=request.getParameter("movie");
				}
				if(request.getParameter("sala") != null) {
					sala=request.getParameter("sala");
				}
				if(request.getParameter("tip") != null) {
					tip=request.getParameter("tip");
				}
				if(request.getParameter("min") != null) {
					try {
					min=Integer.parseInt(request.getParameter("min"));
					System.out.println(min);
				}catch (Exception e) {
					// TODO: handle exception
				}
					}
				if(request.getParameter("max") != null) {
					try {
						max = Integer.parseInt(request.getParameter("max"));
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
				}finally {
					
				}
			


			List<Projekcija> projekcije =ProjekcijeDAO.getProjekcije(movie, od1, do1, sala, tip, min, max);
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
