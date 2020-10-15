package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bioskop.model.Karta;
import bioskop.model.Sala;

public class KarteDAO {
	
	
	public static boolean removeKarta(String id) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("dosli ste na remove");
		try {
			conn.setAutoCommit(false); 
			conn.commit();

			String query = "delete from karte where id=?";
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, id);
			pstmt.executeUpdate() ;
			pstmt.close();
			conn.commit();
			System.out.println("remove je done ");

			return true;
			
	
			
		}finally {
		try {
			conn.setAutoCommit(true);} catch (Exception ex1) {ex1.printStackTrace();}
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();} 
			
		}
		
		
		
		
		
	}
	
	public static int getNextId()throws Exception {
		Connection conn = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "Select max(id) from karte";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()){
				int index = 1;
				int id=rset.getInt(index++);
				return id+1;

			}
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		return 0;

	}
	
	public static boolean addKarta(Karta karta)throws Exception{
		
		Connection conn =ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("SSS");
		try {		String query="insert into karte values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		int index = 1;
		LocalDateTime date= LocalDateTime.now();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));

		System.out.println(karta.getId());
		System.out.println(karta.getProjekcija());
		System.out.println(formattedDate);
		System.out.println(karta.getSediste());
		System.out.println(karta.getUser());

		pstmt.setInt(index++,karta.getId());
		pstmt.setInt(index++,karta.getProjekcija());
		pstmt.setString(index++,karta.getSediste());

      	pstmt.setString(index++, formattedDate);
		pstmt.setString(index++,karta.getUser());

		return pstmt.executeUpdate() == 1;
			
		}finally {
	
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
		
		
	}

	public static List<Karta> getAll(String idP)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Karta> karte = new ArrayList<Karta>();
		try {
			String query ="select * from karte where projekcija=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idP);
			rset = pstmt.executeQuery();
			while (rset.next()){
				int index=1;
				
				 int id = rset.getInt(index++);
				 int id_projekcije = rset.getInt(index++);

				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
				 Date datum =formatter1.parse(date);
				 
				 String username =rset.getString(index++);
				 String sediste =rset.getString(index++);
				 Karta karta = new Karta(id, id_projekcije, sediste, datum, username);
				 karte.add(karta);

			}
		

			
			
			return karte;

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
	}

	public static List<Karta> getAllKorisnik(String usernameK)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Karta> karte = new ArrayList<Karta>();
		try {
			String query ="select * from karte where username_kupca=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, usernameK);
			rset = pstmt.executeQuery();
			while (rset.next()){
				int index=1;
				
				 int id = rset.getInt(index++);
				 int id_projekcije = rset.getInt(index++);

				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
				 Date datum =formatter1.parse(date);
				 
				 String username =rset.getString(index++);
				 String sediste =rset.getString(index++);
				 Karta karta = new Karta(id, id_projekcije, sediste, datum, username);
				 karte.add(karta);

			}
		

			
			
			return karte;

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
	}
}
