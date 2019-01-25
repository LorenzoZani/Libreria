package models;

public class Libro {
	private String titolo;
	private String descrizione;
	private int id;
	private int autoreId;
	
	
	public Libro(String titolo, String descrizione, int autoreId) {
		this.setTitolo(titolo);
		this.setDescrizione(descrizione);
		this.setAutoreId(autoreId);
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAutoreId() {
		return autoreId;
	}
	
	public void setAutoreId(int autoreId) {
		this.autoreId = autoreId;
	}
}
