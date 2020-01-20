package bioskop.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			
			
			String korisnickoIme = request.getParameter("username");
			System.out.println(request.getParameter("username"));
			if(UsersDAO.getUser(korisnickoIme) !=null) {
				throw new Exception("Korisnicko ime vec postoji!");
			}
			if ("".equals(korisnickoIme)) {
				throw new Exception("Korisnicko ime je prazno!");
			}
			String password = request.getParameter("password");
			if ("".equals(password))
				throw new Exception("Lozinka je prazna!");
            Date datumRegistracije = Calendar.getInstance().getTime();  
//            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
//            String strDate = dateFormat.format(date);  		
            
			Korisnik korisnik = new Korisnik(korisnickoIme, password, datumRegistracije, Role.USER);
			
			UsersDAO.addUser(korisnik);
			request.getRequestDispatcher("./SuccessServlet").forward(request, response);

			
		}catch (Exception e) {
			
			String message = e.getMessage();
			if (message == null) {
				message = "Nepredvidjena greska!";
				e.printStackTrace();
			}
			
			Map<String, Object> data = new LinkedHashMap<>();
			data.put("message", message);

			request.setAttribute("data", data);
			request.getRequestDispatcher("./FailureServlet").forward(request, response);
		
		}

		
	}

}
