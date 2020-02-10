package bioskop.model;

public class Izvestaj {

	private Film film ;
	private String brojProjekcija;
	private String brojKarata;
	private String ukupnaCena;
	public Izvestaj(Film film, String brojProjekcija, String brojKarata, String ukupnaCena) {
		super();
		this.film = film;
		this.brojProjekcija = brojProjekcija;
		this.brojKarata = brojKarata;
		this.ukupnaCena = ukupnaCena;
	}
	public Film getFilm() {
		return film;
	}
	public void setFilm(Film film) {
		this.film = film;
	}
	public String getBrojProjekcija() {
		return brojProjekcija;
	}
	public void setBrojProjekcija(String brojProjekcija) {
		this.brojProjekcija = brojProjekcija;
	}
	public String getBrojKarata() {
		return brojKarata;
	}
	public void setBrojKarata(String brojKarata) {
		this.brojKarata = brojKarata;
	}
	public String getUkupnaCena() {
		return ukupnaCena;
	}
	public void setUkupnaCena(String ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
	
	
	
	
	
}
