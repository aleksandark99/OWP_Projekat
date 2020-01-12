package bioskop.servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bioskop.dao.ConnectionManager;


public class InitListener implements ServletContextListener {


    public InitListener() {
    }


    public void contextDestroyed(ServletContextEvent arg0)  { 
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("otvaranje konekcije...");

    	ConnectionManager.open();
    	

		System.out.println("Uspesno");
    }
	
}
