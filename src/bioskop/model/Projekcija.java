package bioskop.model;

import java.util.Date;

import org.apache.catalina.User;

public class Projekcija {

	private int id;
	private Film film ;
	private TipProjekcije tipProjekcije;
	private Sala sala;
	private Date datum;
	private int cenaKarte;
	private User user;
	
	
	public Projekcija(int id, Film film, TipProjekcije tipProjekcije, Sala sala, Date datum, int cenaKarte, User user) {
		super();
		this.id = id;
		this.film = film;
		this.tipProjekcije = tipProjekcije;
		this.sala = sala;
		this.datum = datum;
		this.cenaKarte = cenaKarte;
		this.user = user;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Film getFilm() {
		return film;
	}


	public void setFilm(Film film) {
		this.film = film;
	}


	public TipProjekcije getTipProjekcije() {
		return tipProjekcije;
	}


	public void setTipProjekcije(TipProjekcije tipProjekcije) {
		this.tipProjekcije = tipProjekcije;
	}


	public Sala getSala() {
		return sala;
	}


	public void setSala(Sala sala) {
		this.sala = sala;
	}


	public Date getDatum() {
		return datum;
	}


	public void setDatum(Date datum) {
		this.datum = datum;
	}


	public int getCenaKarte() {
		return cenaKarte;
	}


	public void setCenaKarte(int cenaKarte) {
		this.cenaKarte = cenaKarte;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Projekcija [id=" + id + ", film=" + film.getNaziv() + ", tipProjekcije=" + tipProjekcije.getNaziv() + ", sala=" + sala.getNaizv()
				+ ", datum=" + datum + ", cenaKarte=" + cenaKarte + ", user=" + user.getName() + "]";
	}
	
	
	
	
	
	
}
