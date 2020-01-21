package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import bioskop.model.Film;
import bioskop.model.Korisnik;
import bioskop.model.Role;

public class UsersDAO {

	
	public static List<Korisnik> getAll(String usernameP,String roleP) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			String query= "select * from users where username like ? and role like ?";
			pstmt = conn.prepareStatement(query);		
			int i=1;
			pstmt.setString(i++, "%" + usernameP + "%");
			pstmt.setString(i++, "%" + roleP + "%");
			
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				int index = 1;
				
				 String username=rset.getString(index++);
				 String password=rset.getString(index++);
				 Role uloga=Role.valueOf(rset.getString(index++));
				 
				 
				 String date =rset.getString(index++);
				 //format pre izmena
				 //SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM");  
				 
				 //format posle izmene
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  

				 
				 
				 
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
	
	public static Korisnik getUser(String korisnickoIme) throws Exception{
		
		Connection conn = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "select * from users where username = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, korisnickoIme);
			System.out.println(pstmt);
			
			
			rset = pstmt.executeQuery();

			if (rset.next()){
				int index = 1;
				
				 
				 String username=rset.getString(index++);
				 String password=rset.getString(index++);
				 Role uloga=Role.valueOf(rset.getString(index++));
				 
				 
				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM");  

				 Date datumRegistracije =formatter1.parse(date);
				 System.out.println(datumRegistracije);
		
				 Korisnik user = new Korisnik(username, password, datumRegistracije, uloga);
				
				 System.out.println(user);

				 return user;

			}
					
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		
		
	}
		return null;
	
	}
	
	public static boolean addUser(Korisnik korisnik) throws Exception{
		Connection conn =ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			//insert into users values('c','b','USER','2009-12-31 11:59:59') // username password role date
			String query="insert into users values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, korisnik.getUsername());
			pstmt.setString(index++, korisnik.getPassword());
			pstmt.setString(index++, korisnik.getUloga().toString());
			
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-m-dd hh:mm:ss");  
		//			DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");  
//			DateFormat dateFormat = new SimpleDateFormat("YYYY-dd-mm hh:mm:ss");  
//			Date date = korisnik.getDatumRegistracije();
//			System.out.println(date);
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(date);
			LocalDateTime date= LocalDateTime.now();
			date=date.plusYears(1);
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			String formattedDate = date.format(DateTimeFormatter.ofPattern("YYYY-dd-MM HH:mm:ss"));

			//String strDate=dateFormat.format(date);
			System.out.println("Datum u Dao"+formattedDate);
          	pstmt.setString(index++, formattedDate);
          
//			pstmt.setString(index++, korisnik.getDatumRegistracije().toString());

			System.out.println(pstmt);
			return pstmt.executeUpdate() == 1;

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
			
		}
		
		
		
		
		
	//	return false;
	}
}
