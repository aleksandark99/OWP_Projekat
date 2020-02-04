package bioskop.servlets;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.ProjekcijeDAO;
import bioskop.model.TipProjekcije;

public class TipProjekcijeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TipProjekcijeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Pogodjen servlet tipProjekcije");
		try {
			String strid = request.getParameter("id");
			TipProjekcije tp = ProjekcijeDAO.getTipProjekcije(strid);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			response.getWriter().write(om.writeValueAsString(tp));
			
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("tip", tp);
			request.setAttribute("data", data);
			response.getWriter().close();
			
		}catch (Exception e){
			System.out.println(e);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
