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
import bioskop.model.Sala;

public class SaleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SaleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Sala> sale;
		try {
			sale = ProjekcijeDAO.getSale();
			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
				
				Map<String, Object> data = new LinkedHashMap<>();
				data.put("sale", sale);
//				request.setAttribute("data", data);
				
				
				System.out.println(data.get("sale"));

				
				response.getWriter().write(om.writeValueAsString(data));
				response.getWriter().close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
