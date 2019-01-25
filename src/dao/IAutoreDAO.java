package dao;

import java.util.List;

import models.Autore;

public interface IAutoreDAO {
	List<Autore> getAllAutori();
	Autore getAutore(int autoreId );
	void createAutore(Autore autore);
	void updateAutore(Autore autore);
	void deleteAutore(int id);
	
	

}
