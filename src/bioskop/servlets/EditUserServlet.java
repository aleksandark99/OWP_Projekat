package bioskop.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bioskop.dao.UsersDAO;
import bioskop.model.Korisnik;
import bioskop.model.Role;


public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Object> data = new LinkedHashMap<>();
try {
			
			
			String staro = request.getParameter("staro");

			String korisnickoIme = request.getParameter("username");
			System.out.println(korisnickoIme+"|||"+staro);

			if(!korisnickoIme.equals(staro) ) {
				System.out.println("Razlicita");
			}else {
				System.out.println("ista");
			}
			
			if(!korisnickoIme.equals(staro)) {
				System.out.println("sss");
				if(UsersDAO.getUser(korisnickoIme) !=null) {
					throw new Exception("Korisnicko ime vec postoji!");
				}
			}
			
			System.out.println(request.getParameter("username")+"|||"+staro);
//			if(UsersDAO.getUser(korisnickoIme) !=null) {
//				throw new Exception("Korisnicko ime vec postoji!");
//			}
			// ovo null verovatno nece biti potrebno posle ali neka ostane ne skodi
			if ("".equals(korisnickoIme) || korisnickoIme== null) {
				throw new Exception("Korisnicko ime je prazno!");
			}
			String password = request.getParameter("password");
			if ("".equals(password) || password ==null) {
				throw new Exception("Lozinka je prazna!");

			}
//            Date datumRegistracije = Calendar.getInstance().getTime();  
			 Date datumRegistracije = new Date();
				
            System.out.println(datumRegistracije);
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//            String strDate = dateFormat.format(date);  		
            
			Korisnik korisnik = new Korisnik(korisnickoIme, password, datumRegistracije, Role.USER);
			
			UsersDAO.updateUser(korisnik, staro);
			request.getRequestDispatcher("./SuccessServlet").forward(request, response);
			data.put("us", korisnik);

			
		}catch (Exception e) {
			
			String message = e.getMessage();
			if (message == null) {
				message = "Nepredvidjena greska!";
				e.printStackTrace();
			}
			
//			Map<String, Object> data = new LinkedHashMap<>();
			data.put("message", message);


			request.setAttribute("data", data);
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
		
		}
	
	
	}

}
