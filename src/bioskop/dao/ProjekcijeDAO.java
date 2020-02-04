package bioskop.dao;

import java.io.Console;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.catalina.User;

import bioskop.model.Film;
import bioskop.model.Korisnik;
import bioskop.model.Projekcija;
import bioskop.model.Sala;
import bioskop.model.TipProjekcije;

public class ProjekcijeDAO {
	
	public static List<Projekcija> getProjekcije(String movie,String odDate,String doDate,int tip,int sala,int odCena,int DoCena ) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Projekcija> projekcije = new ArrayList<Projekcija>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("dosli ste na projekcijeDAO getAll");
		System.out.println(rset);
		try {
			String query ="select * from projekcije where id_filma in(select id from movies where naziv like ?) and id_tipa like ? and datum >? and datum <? and id_sale like ? and cena > ? and cena <?";
			pstmt = conn.prepareStatement(query);
			System.out.println("sss");

			int i =1;
			pstmt.setString(i++,"%" + movie +"%"  );
			pstmt.setString(i++,"%" + tip +"%"  );
			pstmt.setString(i++,odDate );
			pstmt.setString(i++,doDate );
			pstmt.setString(i++,"%" + Integer.toString(sala)+"%"  );
			pstmt.setInt(i++,odCena );
			pstmt.setInt(i++,DoCena );

			rset = pstmt.executeQuery();

			while (rset.next()) {
				int index = 1;
					
				 int id=rset.getInt(index++);
				 int idFilma =rset.getInt(index++);
				 String strIdFilma=Integer.toString(idFilma);
				 Film film =FilmoviDAO.getFilm(strIdFilma);
				 TipProjekcije tipProjekcije = getTipProjekcije(Integer.toString(rset.getInt(index++)));
				 Sala salasad = new Sala(1,"SDSD",new ArrayList<TipProjekcije>() );
				 index++;
				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
				 Date datum =formatter1.parse(date);
				 int cenaKarte=rset.getInt(index++);
				 Korisnik user=UsersDAO.getUser(rset.getString(index++));
//				
				 Projekcija projekcija = new Projekcija(id, film, tipProjekcije, salasad, datum, cenaKarte, user);
				 projekcije.add(projekcija);
				 
				
				
				
				
				
			}

			return projekcije;
			
			
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
	}

	public static TipProjekcije getTipProjekcije(String id) throws SQLException {
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query ="select * from tip_projekcije where id = ?";
			pstmt = conn.prepareStatement(query);
			int i =1;
					
			pstmt.setString(i++,id );
			rset = pstmt.executeQuery();

			if (rset.next()){
				
			int index = 1;
			int idTipa = rset.getInt(index++);
			String naziv =rset.getString(index++);
			
			TipProjekcije t= new TipProjekcije(idTipa, naziv);
			return t;
			
			}
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		return null;
	}

}
