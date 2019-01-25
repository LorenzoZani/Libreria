package service;

import java.util.List;

import models.Autore;

public interface IAutoreService {
	boolean create(Autore autore);
	void update(Autore autore);
	void delete(int id);
	List<Autore> getAll();
	Autore getAutore(int id);

}
