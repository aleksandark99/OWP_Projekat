package bioskop.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AddProjekcija extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddProjekcija() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub

		try {	
			String datum = request.getParameter("datum");
		System.out.println("datum:"+datum);
		 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
		 Date date3=formatter1.parse(datum);  
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
         String strDate = dateFormat.format(date3); 
   		 System.out.println("str formatiran:"+strDate);

	}
			
		catch (Exception e) {
			System.out.println(e);
			
	
	
}
}
}