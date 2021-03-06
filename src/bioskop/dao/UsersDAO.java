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

	public static List<Korisnik> getAll(String usernameP, String roleP) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			String query = "select * from users where username like ? and role like ?";
			pstmt = conn.prepareStatement(query);
			int i = 1;
			pstmt.setString(i++, "%" + usernameP + "%");
			pstmt.setString(i++, "%" + roleP + "%");

			rset = pstmt.executeQuery();

			while (rset.next()) {
				int index = 1;

				String username = rset.getString(index++);
				String password = rset.getString(index++);
				Role uloga = Role.valueOf(rset.getString(index++));

				String date = rset.getString(index++);

				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

				Date datumRegistracije = formatter1.parse(date);

				Korisnik korisnik = new Korisnik(username, password, datumRegistracije, uloga);

				korisnici.add(korisnik);

			}
			return korisnici;

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				rset.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}

		}
	}

	public static Korisnik getUser(String korisnickoIme) throws Exception {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query = "select * from users where username = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, korisnickoIme);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				int index = 1;

				String username = rset.getString(index++);
				String password = rset.getString(index++);
				Role uloga = Role.valueOf(rset.getString(index++));

				String date = rset.getString(index++);
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-dd-MM");

				Date datumRegistracije = formatter1.parse(date);

				Korisnik user = new Korisnik(username, password, datumRegistracije, uloga);

				return user;

			}

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				rset.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}

		}
		return null;

	}

	public static boolean addUser(Korisnik korisnik) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement pstmt = null;
		try {

			String query = "insert into users values(?,?,?,?)";

			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, korisnik.getUsername());
			pstmt.setString(index++, korisnik.getPassword());
			pstmt.setString(index++, korisnik.getUloga().toString());

			LocalDateTime date = LocalDateTime.now();
//			date=date.plusYears(1); nije 2021 godina nego 2020 radi sve kako treba
//			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
			String formattedDate = date.format(DateTimeFormatter.ofPattern("YYYY-dd-MM HH:mm:ss"));
			pstmt.setString(index++, formattedDate);
			return pstmt.executeUpdate() == 1;

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}

		}

		// return false;
	}

	public static boolean updateUser(Korisnik korisnik, String staro) throws Exception {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "update  users set username =? ,password=? where username =?";
			pstmt = conn.prepareStatement(query);
			int index = 1;

			pstmt.setString(index++, korisnik.getUsername());
			pstmt.setString(index++, korisnik.getPassword());
			pstmt.setString(index++, staro);
			return pstmt.executeUpdate() == 1;

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}

	}

	public static Korisnik getUser(String korisnickoIme, String password1) throws Exception {

		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			String query = "select * from users where username = ? and password = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, korisnickoIme);
			pstmt.setString(2, password1);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				int index = 1;

				String username = rset.getString(index++);
				String password = rset.getString(index++);
				Role uloga = Role.valueOf(rset.getString(index++));

				String date = rset.getString(index++);
				SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-dd-MM");

				Date datumRegistracije = formatter1.parse(date);

				Korisnik user = new Korisnik(username, password, datumRegistracije, uloga);

				return user;

			}

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				rset.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}

		}
		return null;

	}

	public static boolean UpdateUloguUsera(String username, String uloga) throws Exception {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement pstmt = null;
		try {
			String query = "update  users set role=? where username =?";
			pstmt = conn.prepareStatement(query);
			int index = 1;

			pstmt.setString(index++, uloga);
			pstmt.setString(index++, username);

			return pstmt.executeUpdate() == 1;

		} finally {
			try {
				pstmt.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception ex1) {
				ex1.printStackTrace();
			}
		}
	}
}
