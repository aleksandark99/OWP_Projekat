package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bioskop.model.Film;
public class FilmoviDAO {
	
	public static List<Film> getAll() throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Film> filmovi = new ArrayList<Film>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "select * from movies";
			pstmt = conn.prepareStatement(query);
			
			
			rset = pstmt.executeQuery();

			while (rset.next()) {
				int index = 1;
				
				 int id=rset.getInt(index++);
				 String naziv=rset.getString(index++);
				 String reziser=rset.getString(index++);
				 String glumci=rset.getString(index++);
				 String zanrovi=rset.getString(index++);
				 int trajanje=rset.getInt(index++);
				 String distributer=rset.getString(index++);
				 String zemljaPorekla=rset.getString(index++);
				 int godina=rset.getInt(index++);
				 String opis=rset.getString(index++);
				 Film film = new Film(id, naziv, reziser, glumci, zanrovi, trajanje, distributer, zemljaPorekla, godina, opis);
				 filmovi.add(film);
				 
			}
					
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
		
		System.out.println(filmovi);
		return filmovi;
	}

}
