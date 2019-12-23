package bioskop.model;

import java.util.Date;

public class Korisnik {
	private String username;
	private String password;
	private Date datumRegistracije;
	private Role uloga;
	
	
	
	
	public Korisnik(String username, String password, Date datumRegistracije, Role uloga) {
		super();
		this.username = username;
		this.password = password;
		this.datumRegistracije = datumRegistracije;
		this.uloga = uloga;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatumRegistracije() {
		return datumRegistracije;
	}
	public void setDatumRegistracije(Date datumRegistracije) {
		this.datumRegistracije = datumRegistracije;
	}
	public Role getUloga() {
		return uloga;
	}
	public void setUloga(Role uloga) {
		this.uloga = uloga;
	}
	
	
	
	
}
