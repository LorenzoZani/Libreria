package models;

public class Recensione {
	private int valutazione;
	private String testo;
	private int id;
	private int libro_id;

	public Recensione(int valutazione, String testo, int libro_id) {
		super();
		this.valutazione = valutazione;
		this.testo = testo;
		this.libro_id = libro_id;
	}


	public Recensione(int valutazione, String testo, int id, int libro_id) {
		
		this.setValutazione(valutazione);
		this.setTesto(testo);
		this.setId(id);
		
	}


	public int getLibro_id() {
		return libro_id;
	}


	public void setLibro_id(int libro_id) {
		this.libro_id = libro_id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
		this.valutazione = valutazione;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
}
