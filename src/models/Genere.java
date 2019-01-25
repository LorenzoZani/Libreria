package models;

public class Genere {
	private int id;
	private String nome;
	
	
	public Genere(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
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
	
	

}
