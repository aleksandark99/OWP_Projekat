package bioskop.model;

import java.util.ArrayList;

public class Sala {

	private int id;
	private String naizv;
	private ArrayList<TipProjekcije> tipoviProjekcije;
	public Sala(int id, String naizv, ArrayList<TipProjekcije>  tipoviProjekcije) {
		super();
		this.id = id;
		this.naizv = naizv;
		this.tipoviProjekcije = tipoviProjekcije;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNaizv() {
		return naizv;
	}
	public void setNaizv(String naizv) {
		this.naizv = naizv;
	}
	public ArrayList<TipProjekcije> getTipoviProjekcije() {
		return tipoviProjekcije;
	}
	public void setTipoviProjekcije(ArrayList<TipProjekcije> tipoviProjekcije) {
		this.tipoviProjekcije = tipoviProjekcije;
	}
	@Override
	public String toString() {
		return "Sala [id=" + id + ", naizv=" + naizv + ", tipoviProjekcije=" + tipoviProjekcije + "]";
	}
	

	
	
}
