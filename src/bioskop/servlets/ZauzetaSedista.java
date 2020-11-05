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

public class ZauzetaSedista extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ZauzetaSedista() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String id = request.getParameter("id_projekcije");
			List<String> zauzetaSedista=ProjekcijeDAO.getZauzetaSedista(id);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("zauzetaSedista", zauzetaSedista);
			response.getWriter().write(om.writeValueAsString(data));
			response.getWriter().close();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	doGet(request, response);
		
		
		
	}

}
