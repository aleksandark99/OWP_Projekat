package bioskop.servlets;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;

import bioskop.dao.ConnectionManager;


public class InitListener implements ServletContextListener {


    public InitListener() {
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("otvaranje konekcije...");

    	ConnectionManager.open();
    	
    	ServletContext context = arg0.getServletContext();
    	
    	context.setAttribute("sesije", new HashMap<String,HttpSession>() );
    	

		System.out.println("Uspesno");
    }
	
}
