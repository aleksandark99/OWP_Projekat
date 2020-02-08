package bioskop.model;

import java.util.Date;


public class Karta {

	private int id;
	private int projekcija;
	private String sediste;
	private Date datum;
	private String user;
	
	public Karta(int id, int projekcija, String sediste, Date datum, String user) {
		super();
		this.id = id;
		this.projekcija = projekcija;
		this.sediste = sediste;
		this.datum = datum;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(int projekcija) {
		this.projekcija = projekcija;
	}

	public String getSediste() {
		return sediste;
	}

	public void setSediste(String sediste) {
		this.sediste = sediste;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", projekcija=" + projekcija + ", sediste=" + sediste + ", datum=" + datum
				+ ", user=" + user + "]";
	}
	
	
	
	
	
}
