package bioskop.model;

public class Sediste {
	private String redniBroj;
	private String  sala;
	public Sediste(String redniBroj, String sala) {
		super();
		this.redniBroj = redniBroj;
		this.sala = sala;
	}
	public String getRedniBroj() {
		return redniBroj;
	}
	public void setRedniBroj(String redniBroj) {
		this.redniBroj = redniBroj;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	@Override
	public String toString() {
		return "Sediste redniBroj=" + redniBroj + ", sala=" + sala + "]";
	}
	
	
	

}
