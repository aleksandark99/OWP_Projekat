package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import bioskop.model.Karta;

public class KarteDAO {
	
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
		try {		String query="insert into karte values(?,?,?,?,?)";
		pstmt = conn.prepareStatement(query);
		int index = 1;
		LocalDateTime date= LocalDateTime.now();
		String formattedDate = date.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));

		
		pstmt.setInt(index++,karta.getId());
		pstmt.setInt(index++,karta.getProjekcija());
      	pstmt.setString(index++, formattedDate);
		pstmt.setString(index++,karta.getUser());
		pstmt.setString(index++,karta.getSediste());

		return pstmt.executeUpdate() == 1;
			
		}finally {
	
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
		
		
	}
}
