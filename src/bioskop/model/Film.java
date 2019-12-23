package bioskop.model;

import java.util.ArrayList;

public class Film {
	private int id;
	private String naziv;
	private String reziser;
	private ArrayList<String> glumci;
	private ArrayList<String> zanrovi;
	private int trajanje;
	private String distributer;
	private String zemljaPorekla;
	private int godina;
	private String opis;
	public Film(int id, String naziv, String reziser, ArrayList<String> glumci, ArrayList<String> zanrovi, int trajanje,
			String distributer, String zemljaPorekla, int godina, String opis) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.reziser = reziser;
		this.glumci = glumci;
		this.zanrovi = zanrovi;
		this.trajanje = trajanje;
		this.distributer = distributer;
		this.zemljaPorekla = zemljaPorekla;
		this.godina = godina;
		this.opis = opis;
	}
	
	public Film() {
		this.id = 0;
		this.naziv = null;
		this.reziser = null;
		this.glumci = null;
		this.zanrovi = null;
		this.trajanje = 0;
		this.distributer = null;
		this.zemljaPorekla = null;
		this.godina = 0;
		this.opis = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getReziser() {
		return reziser;
	}

	public void setReziser(String reziser) {
		this.reziser = reziser;
	}

	public ArrayList<String> getGlumci() {
		return glumci;
	}

	public void setGlumci(ArrayList<String> glumci) {
		this.glumci = glumci;
	}

	public ArrayList<String> getZanrovi() {
		return zanrovi;
	}

	public void setZanrovi(ArrayList<String> zanrovi) {
		this.zanrovi = zanrovi;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public String getDistributer() {
		return distributer;
	}

	public void setDistributer(String distributer) {
		this.distributer = distributer;
	}

	public String getZemljaPorekla() {
		return zemljaPorekla;
	}

	public void setZemljaPorekla(String zemljaPorekla) {
		this.zemljaPorekla = zemljaPorekla;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", naziv=" + naziv + ", reziser=" + reziser + ", glumci=" + glumci + ", zanrovi="
				+ zanrovi + ", trajanje=" + trajanje + ", distributer=" + distributer + ", zemljaPorekla="
				+ zemljaPorekla + ", godina=" + godina + ", opis=" + opis + "]";
	}
	
	
}
