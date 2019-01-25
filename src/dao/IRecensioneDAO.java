package dao;

import java.util.List;

import models.Recensione;

public interface IRecensioneDAO {
public List<Recensione> getAllRecensione();
	
	public Recensione getRecensione(int id);
	
	public void createRecensione(Recensione recensione);
	
	public void updateRecensione(Recensione recensione);
	
	public void deleteRecensione(int id);

}
