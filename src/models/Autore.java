package models;

public class Autore {
	private int id;
	private String nome;
	private String cognome;
	


	public Autore( String nome, String cognome) {
		super();
		this.setNome(nome);
		this.setCognome(cognome);
	}
	
	
	
	
	
	





	//GETTER & SETTER	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	

}
