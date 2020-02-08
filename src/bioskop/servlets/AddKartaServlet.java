package bioskop.servlets;

import java.io.Console;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import bioskop.dao.KarteDAO;
import bioskop.model.Karta;

public class AddKartaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;    

    public AddKartaServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				String id_projekcije=request.getParameter("id_projekcije");
				String sedista = request.getParameter("sedista");
				String[] lSedista=sedista.split("\\,");
				String username=(String) request.getSession().getAttribute("loggedUsername");
				System.out.println("DDDDD");
				System.out.println(request.getSession().getAttribute("loggedUsername"));
				System.out.println(request.getSession().getAttributeNames());
				
				System.out.println("Add karta servlet ==========");
				for (String string : lSedista) {
					int id =KarteDAO.getNextId();

					Karta karta = new Karta(id, Integer.parseInt(id_projekcije), string, new Date(), username);
					KarteDAO.addKarta(karta);

				}
				 request.getRequestDispatcher("./SuccessServlet").forward(request, response);

				System.out.println(id_projekcije);	
				System.out.println(username);


			}catch (Exception e) {
				System.out.println(e);
			}
		
		
		
		
	}

}