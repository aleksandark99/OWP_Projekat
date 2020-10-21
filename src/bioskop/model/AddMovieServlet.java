package bioskop.model;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bioskop.dao.FilmoviDAO;

public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddMovieServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loggedUsername = (String) request.getSession().getAttribute("loggedUsername");
		Role Uloga = (Role) request.getSession().getAttribute("Uloga");
		if (loggedUsername == null || !Uloga.equals(Role.ADMIN)) {
			request.getRequestDispatcher("./LogoutServlet").forward(request, response);
			return;
		}
		try {
			 String naziv=request.getParameter("naziv");
			 String reziser=request.getParameter("reziser");
			 String glumci=request.getParameter("glumci");
			 String zanrovi=request.getParameter("zanrovi");
			 String trajanje=request.getParameter("trajanje");
			 String distributer=request.getParameter("distributer");
			 String zemljaPorekla=request.getParameter("zemljaPorekla");
			 String godina=request.getParameter("godina");
			 String opis=request.getParameter("opis");
			 int id = FilmoviDAO.getNextId();
			 int intTrajanje;
			 int intGodina;

			 if(naziv.equals("")|| naziv == null) 
				 throw new Exception("naziv mora postojati");
			 if(trajanje.equals("") || trajanje==null)
				 throw new Exception("trajanje mora postojati");
			 try {
				 System.out.println(trajanje);
				  intTrajanje =Integer.parseInt(trajanje);
			 }catch (Exception e) {throw new Exception("trajanje mora bit int");}
			 if(distributer.equals("") || distributer==null)
				 throw new Exception("distributer mora postojati");
			 if(zemljaPorekla.equals("") || zemljaPorekla==null)
				 throw new Exception("zemljaPorekla mora postojati");
			 
			 if(godina.equals("") || godina==null)
				 throw new Exception("trajanje mora postojati");
			 try {
				  intGodina =Integer.parseInt(godina);
			 }catch (Exception e) {throw new Exception("trajanje mora bit int");}
			
			 if(opis==null)
			 opis="";
			 if(reziser==null)
				 reziser="";
			 if(glumci==null)
				 glumci="";
			 if(zanrovi==null)
				 zanrovi="";
			 
			 Film film = new Film(id, naziv, reziser, glumci, zanrovi, intTrajanje, distributer, zemljaPorekla, intGodina, opis);
			 
			 FilmoviDAO.addFilm(film);
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
