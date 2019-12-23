package bioskop.model;

import java.util.Date;


public class Karta {

	private int id;
	private Projekcija projekcija;
	private Sediste sediste;
	private Date datum;
	private Korisnik user;
	
	public Karta(int id, Projekcija projekcija, Sediste sediste, Date datum, Korisnik user) {
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

	public Projekcija getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(Projekcija projekcija) {
		this.projekcija = projekcija;
	}

	public Sediste getSediste() {
		return sediste;
	}

	public void setSediste(Sediste sediste) {
		this.sediste = sediste;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public Korisnik getUser() {
		return user;
	}

	public void setUser(Korisnik user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Karta [id=" + id + ", projekcija=" + projekcija.getId() + ", sediste=" + sediste.getRedniBroj() + ", datum=" + datum
				+ ", user=" + user.getUsername() + "]";
	}
	
	
	
	
	
}
