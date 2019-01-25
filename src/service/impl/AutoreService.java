package service.impl;

import java.util.List;

import dao.impl.AutoreDAO;
import models.Autore;
import service.IAutoreService;

public class AutoreService implements IAutoreService {
	AutoreDAO autoreDAO = new AutoreDAO();

	@Override
	public boolean create(Autore autore) {
		boolean esisteGia = false;
		for (Autore a : autoreDAO.getAllAutori()) {
			if (a.getNome().equals(autore.getNome()) && a.getCognome().equals(autore.getCognome())) {
				esisteGia = true;
			}
		}
		if (!esisteGia) {
			autoreDAO.createAutore(autore);
			return true;
		}
		return false;
	}

	@Override
	public void update(Autore autore) {
		boolean esisteGia = false;
		for (Autore a : autoreDAO.getAllAutori()) {
			if (a.getNome().equals(autore.getNome()) && a.getCognome().equals(autore.getCognome())) {
				esisteGia = true;
			}
		}
		if (!esisteGia) {
			autoreDAO.updateAutore(autore);
		}
	}

	@Override
	public void delete(int id) {
		autoreDAO.deleteAutore(id);
	}

	public List<Autore> getAll() {
		return autoreDAO.getAllAutori();
	}

	@Override
	public Autore getAutore(int id) {
		
		return autoreDAO.getAutore(id);
	}
	

}
