package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.LibroDAO;
import models.Libro;
import service.ILibroService;

public class LibroService implements ILibroService {

	LibroDAO libroDao = new LibroDAO();

	public boolean create(Libro libro) {
		boolean alreadyExist = false;
		for (Libro l : libroDao.getAllLibri()) {
			if (l.getTitolo().equalsIgnoreCase(libro.getTitolo())) {
				alreadyExist = true;
				return false;
			}
		}
		if (!alreadyExist) {
			libroDao.createLibro(libro);
		}
		return true;
	}

	public Libro get(int libroId) {
		return libroDao.getLibro(libroId);
	}

	public List<Libro> getAll() {
		return libroDao.getAllLibri();
	}

	@Override
	public void update(Libro libro) {
		libroDao.updateLibro(libro);

	}

	public void delete(int libroId) {
		libroDao.deleteLibro(libroId);
	}

	@Override
	public List<Libro> getLibroByAutoreId(int autoreId) {
		List<Libro> libri=libroDao.getAllLibri();
		List<Libro> libriAutore= new ArrayList<>();
		for(Libro libro:libri) {
			if(libro.getAutoreId()==autoreId) {
				libriAutore.add(libro);
			}
		}
		return libriAutore;
	}
}
