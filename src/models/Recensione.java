package models;

public class Recensione {
	private int id,valutazione;
	private String testo ;
	

	
	
	public Recensione(int id, int valutazione, String testo) {
		this.id = id;
		this.valutazione = valutazione;
		this.testo = testo;
	}
	
	


	public Recensione(int id, int valutazione) {
		this.id = id;
		this.valutazione = valutazione;
	}




	//GETTER & SETTER
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTesto() {
		return testo;
	}


	public void setTesto(String testo) {
		this.testo = testo;
	}


	public int getValutazione() {
		return valutazione;
	}


	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}
	
	
	
	
	
	
	


}
