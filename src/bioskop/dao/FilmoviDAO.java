package bioskop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bioskop.model.Film;
import bioskop.model.Korisnik;
public class FilmoviDAO {
	
	public static List<Film> getAll(String nazivFilma,int trajanjefilma,String zemljaPoreklaFilma,String Zanr,String Distributter,int godinaIzdavanja) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Film> filmovi = new ArrayList<Film>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("dosli ste na filmovidao");
		System.out.println(rset);

		System.out.println("dosli ste na filmovidao");

		try {
//			String query= "select * from movies WHERE "
//					+"naziv LIKE ?";
			
		//	String query ="select * from movies where naziv like ?  and distributer like ? and zemljaProekla like ? and zanrovi like ? or godina = ? or trajanje = ?";
		//	String query ="select * from movies where naziv like ?  and distributer like ? and zemljaProekla like ? and zanrovi like ? or godina = ? or trajanje = ?";
			String query ="select * from movies where naziv like ?  and distributer like ? and zemljaProekla like ? and zanrovi like ?";
			
			String a="";
			String b="";

			
//			if(trajanjefilma ==0) {
//				 a=" or godina = ?";
//			}else {
//				 a=" and godina = ?";
//			}
//			
//			if(godinaIzdavanja==0) {
//				b=" or trajanje = ?";
//			}else {
//				b=" and trajanje = ?";
//			}
//			query=query + a +b;
//
			
			if(godinaIzdavanja !=0) {
				 a=" and godina = ?";
				 query=query+a;
				 
			}
			
			if(trajanjefilma!=0) {
				b=" and trajanje = ?";
				 query=query+b;
			}
			pstmt = conn.prepareStatement(query);
			int i =1;
			System.out.println(query+"%");
			
			
			pstmt.setString(i++, "%" + nazivFilma + "%");
			pstmt.setString(i++, "%" + Distributter + "%");
			pstmt.setString(i++, "%" + zemljaPoreklaFilma + "%");
			pstmt.setString(i++, "%" + Zanr + "%");
//			pstmt.setInt(i++, godinaIzdavanja);
//			pstmt.setInt(i++, trajanjefilma);
			
			if(godinaIzdavanja !=0) {

				 
				 pstmt.setInt(i++, godinaIzdavanja);
			}
			
			if(trajanjefilma!=0) {

				 pstmt.setInt(i++, trajanjefilma);
			}
			//query=query + a +b;

	//		pstmt = conn.prepareStatement(query);
			
			

//			pstmt.setString(i++, "%" + nazivFilma + "%");

			
			System.out.println(query+"SS");

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
	
	public static Film getFilm(String idfilma) throws Exception{
		//
		Connection conn = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "select * from movies where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idfilma);
			System.out.println(pstmt);
			
			
			rset = pstmt.executeQuery();

			if (rset.next()){
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
				
				 System.out.println(film);

				 return film;

			}
					
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
		
		return null;
	}

	public static int getNextId()throws Exception {
		Connection conn = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "Select max(id) from movies";
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

	public static boolean addFilm(Film film) throws Exception {
		Connection conn =ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			String query="insert into movies values(?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, Integer.toString(film.getId()));
			pstmt.setString(index++,film.getNaziv());
			pstmt.setString(index++,film.getReziser());
			pstmt.setString(index++,film.getGlumci());
			pstmt.setString(index++,film.getZanrovi());
			pstmt.setString(index++, Integer.toString(film.getTrajanje()));
			pstmt.setString(index++,film.getDistributer());
			pstmt.setString(index++,film.getZemljaPorekla());
			pstmt.setString(index++, Integer.toString(film.getGodina()));
			pstmt.setString(index++,film.getOpis());

			return pstmt.executeUpdate() == 1;
			
			

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
			
		}
//		return true;
	}

	public static boolean removeFilm(String id) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		System.out.println("dosli ste na remove");
		try {
			conn.setAutoCommit(false); 
			conn.commit();

			String query = "delete from movies where id=?";
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

	public static boolean update(Film film)throws Exception{
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			System.out.println("update dao");
			String query ="update  movies set naziv = ? ,godina = ?, trajanje = ?,zemljaProekla = ?,distributer = ?,zanrovi = ? where id =?";
			pstmt = conn.prepareStatement(query);
			int index = 1;
			
			pstmt.setString(index++, film.getNaziv());
			pstmt.setInt(index++, film.getGodina());
			pstmt.setInt(index++, film.getTrajanje());
			pstmt.setString(index++, film.getZemljaPorekla());
			pstmt.setString(index++, film.getDistributer());
			pstmt.setString(index++, film.getZanrovi());
			pstmt.setInt(index++, film.getId());
			System.out.println("update gotov");




			
			
			
			
			return pstmt.executeUpdate() == 1;

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
		
	}

}
