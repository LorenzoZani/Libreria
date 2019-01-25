package dao;

import java.util.List;

import models.Libro;

public interface ILibroDAO {
	
	public List<Libro> getAllLibri();
	public Libro getLibro (int libroId);
	public void createLibro (Libro Libro);
	public void updateLibro (Libro Libro);
	public void deleteLibro(int libroId);
}
