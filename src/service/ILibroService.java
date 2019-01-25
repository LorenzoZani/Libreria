package service;

import java.util.List;

import models.Libro;

public interface ILibroService {
	
	public boolean create(Libro libro);
	public void update(Libro libro);
	public void delete(int libroId);
	List<Libro> getAll();
	public Libro get(int libroId);
	List<Libro> getLibroByAutoreId(int autoreId);

}
