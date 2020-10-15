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
import bioskop.model.Projekcija;


public class SlobodnaSedistaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SlobodnaSedistaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			System.out.println("pogodjen slobodna sedista servlet");
//			String id_sale= request.getParameter("id_sale");
			String id_projekcije= request.getParameter("id_projekcije");
			
			System.out.println(id_projekcije);
			
			Projekcija p = ProjekcijeDAO.getProjekcija(id_projekcije);
			System.out.println(p.getSala().getId());

//			int br_sedista=ProjekcijeDAO.brojSedistaSale(Integer.toString(p.getSala().getId()));
			int br_sedista=ProjekcijeDAO.brojSedistaSale(p.getSala().getNaizv());
			System.out.println("SSSSSSSS "+p.getSala().getNaizv());
			int br_zuzetihSedista=ProjekcijeDAO.brojKarataZaSedistaSale(id_projekcije);
			int brojSlobodnih=br_sedista-br_zuzetihSedista;

			ObjectMapper om = new ObjectMapper();
			response.setContentType("application/json; utf-8");
			
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("br_sedista", br_sedista);
			data.put("br_zuzetihSedista", br_zuzetihSedista);
			data.put("brojSlobodnih", brojSlobodnih);

			response.getWriter().write(om.writeValueAsString(data));

			response.getWriter().close();
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
