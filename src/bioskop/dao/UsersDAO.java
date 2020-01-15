package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bioskop.model.Film;
import bioskop.model.Korisnik;
import bioskop.model.Role;

public class UsersDAO {

	
	public static List<Korisnik> getAll() throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query= "select * from users";
			pstmt = conn.prepareStatement(query);						
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				int index = 1;
				
				 String username=rset.getString(index++);
				 String password=rset.getString(index++);
				 Role uloga=Role.valueOf(rset.getString(index++));
				 
				 
				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM");  

				 Date datumRegistracije =formatter1.parse(date);
				// Date datumRegistracije =formatter1.parse(formatter1.format(date));

				 System.out.println(datumRegistracije);
				// Date datumRegistracije =new SimpleDateFormat("YYYY-MM-DD").parse(rset.getString(index++)); Date datumRegistracije =new SimpleDateFormat("YYYY-MM-DD").parse(rset.getString(index++));
			//	 Date datumRegistracije =new SimpleDateFormat("yyyy-dd-mm").parse(rset.getString(index++));

//			     Calendar cal = Calendar.getInstance();
//			        cal.setTime(datumRegistracije);
//			        cal.set(Calendar.HOUR_OF_DAY, 0);
//			        cal.set(Calendar.MINUTE, 0);
//			        cal.set(Calendar.SECOND, 0);
//			        cal.set(Calendar.MILLISECOND, 0);
			        //cal.getTime();
				// java.sql.Date  datumRegistracije=rset.getDate(index++);
				 System.out.println(datumRegistracije);

				 Korisnik korisnik = new Korisnik(username, password, datumRegistracije, uloga);
			 
				 			
			 korisnici.add(korisnik);
		
			}
			return korisnici;

			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
			
			
		}
		
		
		
		
	}
	
	
	
	
}
