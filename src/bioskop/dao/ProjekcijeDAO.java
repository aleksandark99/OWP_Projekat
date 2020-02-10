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
import java.util.concurrent.ExecutionException;

import bioskop.model.Film;
import bioskop.model.Izvestaj;
import bioskop.model.Korisnik;
import bioskop.model.Projekcija;
import bioskop.model.Sala;
import bioskop.model.Sediste;
import bioskop.model.TipProjekcije;

public class ProjekcijeDAO {
	
	public static List<Projekcija> getProjekcije(String movie,String odDate,String doDate,String tip,String sala,int odCena,int DoCena ) throws Exception{
		Connection conn = ConnectionManager.getConnection();
		List<Projekcija> projekcije = new ArrayList<Projekcija>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println(movie+"||"+odDate+"||"+doDate+"||"+tip+"||"+sala+"||"+odCena+"||"+DoCena);
		try {
			String query ="select * from projekcije where id_filma in(select id from movies where naziv like ?) and id_tipa like ? and datum >? and datum <? and id_sale like ? and cena >= ? and cena <=?";
//			String query ="select * from projekcije";

			pstmt = conn.prepareStatement(query);
			System.out.println("sss");

			int i =1;
			pstmt.setString(i++,"%" + movie +"%"  );
			pstmt.setString(i++,"%" + tip +"%"  );
			pstmt.setString(i++,odDate );
			pstmt.setString(i++,doDate );
			pstmt.setString(i++,"%" + sala+"%"  );
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
//				 Sala salasad = new Sala(1,"SDSD",new ArrayList<TipProjekcije>() );
				 int idSALE=rset.getInt(index++);
				 Sala sala1=getSala(idSALE);
				 
				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
				 Date datum =formatter1.parse(date);
				 int cenaKarte=rset.getInt(index++);
				 Korisnik user=UsersDAO.getUser(rset.getString(index++));
//				
				 Projekcija projekcija = new Projekcija(id, film, tipProjekcije, sala1, datum, cenaKarte, user);
				 projekcije.add(projekcija);
				 System.out.println("SS");
				 System.out.println(projekcija);
				
				
				
				
				
			}

			return projekcije;
			
			
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
	}

	public static Projekcija getProjekcija(String idProjekcije) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		System.out.println("dosli ste na projekcijeDAO getAll");
		System.out.println(rset);
		try {
			String query ="select * from projekcije where id = ?";
			pstmt = conn.prepareStatement(query);
			System.out.println("sss");

			int i =1;
			pstmt.setString(i++,idProjekcije  );


			rset = pstmt.executeQuery();

			if (rset.next()) {
				int index = 1;
					
				 int id=rset.getInt(index++);
				 int idFilma =rset.getInt(index++);
				 String strIdFilma=Integer.toString(idFilma);
				 Film film =FilmoviDAO.getFilm(strIdFilma);
				 TipProjekcije tipProjekcije = getTipProjekcije(Integer.toString(rset.getInt(index++)));
//				 Sala salasad = new Sala(1,"SDSD",new ArrayList<TipProjekcije>() );
				 int idSALE=rset.getInt(index++);
				 Sala sala1=getSala(idSALE);
				 
				 String date =rset.getString(index++);
				 SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");  
				 Date datum =formatter1.parse(date);
				 int cenaKarte=rset.getInt(index++);
				 Korisnik user=UsersDAO.getUser(rset.getString(index++));
//				
				 Projekcija projekcija = new Projekcija(id, film, tipProjekcije, sala1, datum, cenaKarte, user);
				 
					return projekcija;

				
				
				
				
			}
			return null;
			
			
			
			
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

	public static Sala getSala(int id) throws SQLException {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query ="select * from sala where id = ?";
			pstmt = conn.prepareStatement(query);
			int i =1;
			pstmt.setInt(i++,id );
			rset = pstmt.executeQuery();
			if (rset.next()){
				
				int index = 1;
				int idSale=rset.getInt(index++);
				String naziv =rset.getString(index++);

				Sala sala=new Sala(idSale, naziv, new ArrayList<TipProjekcije>() );
				return sala;
			}
		
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		return null;

	}
	
	public static TipProjekcije getTip (String id)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query ="select * from tip_projekcije where id = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,id );
			
			rset = pstmt.executeQuery();
			if (rset.next()) {
				int index = 1;
					
				 int idTipa=rset.getInt(index++);
				 String  naziv =rset.getString(index++);
				 TipProjekcije p = new TipProjekcije(idTipa, naziv);
				 return p;
			}
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		return null;
	}
	
	public static List<Sala> getSaleSaTipom(String id_tipa)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Sala> sale = new ArrayList<Sala>();
		try {
			String query ="select * from sala where id in (select id_sale from sala_projekcija where id_tip =?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id_tipa);
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				int index = 1;
				int idSale=rset.getInt(index++);
				String naziv =rset.getString(index++);
				List<String> tipoviProjekcija=gettipoviSale(Integer.toString(idSale));
				ArrayList<TipProjekcije> t=new ArrayList<TipProjekcije>();
				for (String string : tipoviProjekcija) {
					TipProjekcije pp= getTip(string);
					t.add(pp);
				}
//				Sala sala=new Sala(idSale, naziv, new ArrayList<TipProjekcije>() );
				Sala sala=new Sala(idSale, naziv, t );

				sale.add(sala);
				
			}
		return sale;
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
	}
	public static List<Sala> getSale()throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Sala> sale = new ArrayList<Sala>();
		try {
			String query ="select * from sala";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				int index = 1;
				int idSale=rset.getInt(index++);
				String naziv =rset.getString(index++);
				List<String> tipoviProjekcija=gettipoviSale(Integer.toString(idSale));
				ArrayList<TipProjekcije> t=new ArrayList<TipProjekcije>();
				for (String string : tipoviProjekcija) {
					TipProjekcije pp= getTip(string);
					t.add(pp);
				}
//				Sala sala=new Sala(idSale, naziv, new ArrayList<TipProjekcije>() );
				Sala sala=new Sala(idSale, naziv, t );

				sale.add(sala);
				
			}
		return sale;
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
	}

	public static int getNextId()throws Exception {
		Connection conn = ConnectionManager.getConnection();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query= "Select max(id) from projekcije";
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

	public static List<String> gettipoviSale(String id)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> tipoviSale = new ArrayList<String>();
		try {
			String query ="select * from sala_projekcija where id_sale =?";
			pstmt = conn.prepareStatement(query);
			int i =1;
			pstmt.setString(i++,id );
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				int index = 1;
				int idSale=rset.getInt(index++);
				String idTipa =rset.getString(index++);

				tipoviSale.add(idTipa);

				
			}
		return tipoviSale;
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
	}
	
	public static List<Sediste> getSedista(String id)throws Exception{
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Sediste> sedista = new ArrayList<Sediste>();
		try {
			String query ="select * from sedista where id_sale = ?";
			pstmt = conn.prepareStatement(query);
			int i =1;
			pstmt.setString(i++,id );
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				int index = 1;
				int idSale=rset.getInt(index++);
				String brSedista =rset.getString(index++);
				
				Sediste s =new Sediste(brSedista,Integer.toString(idSale));
				sedista.add(s);
		
				
			}
		return sedista;
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
	}
	
	public static List<String> getZauzetaSedista(String id_projekcije)throws Exception{
		
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<String> zauzetaSedista = new ArrayList<String>();
		try {
			String query ="select sediste from karte where id_projekcije=?";
			pstmt = conn.prepareStatement(query);
			int i =1;
			pstmt.setString(i++,id_projekcije );
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				String sediste=rset.getString(1);

				zauzetaSedista.add(sediste);

				
			}
		return zauzetaSedista;
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
	}
	
	public static boolean addProjekcija(String id_filma,String id_tipa,String id_sale,String date,String cena,String username_admina) throws Exception {
		Connection conn =ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {
			String query="insert into projekcije values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			int index = 1;
			int id=getNextId();
			pstmt.setInt(index++, id);
			pstmt.setString(index++,id_filma);
			pstmt.setString(index++,id_tipa);
			pstmt.setString(index++,id_sale);
			pstmt.setString(index++,date);
			pstmt.setString(index++,cena);
			pstmt.setString(index++,username_admina);



			return pstmt.executeUpdate() == 1;
			
			

		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
			
		}
//		return true;
	}

	public static List<Izvestaj> izvestaj()throws Exception{
		
		Connection conn = ConnectionManager.getConnection();
		List<Izvestaj> izvestaji = new ArrayList<Izvestaj>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query ="select movies.id ,movies.naziv ,count(distinct projekcije.id)as brojProjekcija,count( karte.id) as brojKarata ,sum(projekcije.cena) as ukupno from movies left join projekcije on projekcije.id_filma = movies.id left join karte on projekcije.id = karte.id_projekcije group by movies.id;";
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while (rset.next()){
				
				int index = 1;
				String idfilma=rset.getString(index++);
				Film film = FilmoviDAO.getFilm(idfilma);
				String naziv =rset.getString(index++);
				String brProjekcija =rset.getString(index++);
				String prodateKarte =rset.getString(index++);
				String ukupno =rset.getString(index++);
				
				Izvestaj izvestaj= new Izvestaj(film, brProjekcija, prodateKarte, ukupno);

				izvestaji.add(izvestaj);
//				Sala sala=new Sala(idSale, naziv, new ArrayList<TipProjekcije>() );
//				Sala sala=new Sala(idSale, naziv, t );
//
//				sale.add(sala);
				
			}
		return izvestaji;

			
			
			
			
		}finally {
			try {pstmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {conn.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}
		
		
	}
}
