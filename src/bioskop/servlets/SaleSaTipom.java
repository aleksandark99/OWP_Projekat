package bioskop.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import bioskop.dao.ProjekcijeDAO;
import bioskop.model.Sala;

/**
 * Servlet implementation class SaleSaTipom
 */
public class SaleSaTipom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public SaleSaTipom() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sala> sale = new ArrayList<Sala>();
		try {
			String s=request.getParameter("id_tipa");
			sale = ProjekcijeDAO.getSaleSaTipom(s);
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("sale", sale);
				
				
				System.out.println(data.get("sale"));

				
				response.getWriter().write(om.writeValueAsString(sale));
				response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
