package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.RecensioneDAO;
import models.Recensione;
import service.IRecensioneService;

public class RecensioneService implements IRecensioneService{
	RecensioneDAO recensioneDao = new RecensioneDAO();

	@Override
	public void update(Recensione recensione) {
		String testo = recensione.getTesto();
		if (testo.length() < 200) {
			recensioneDao.updateRecensione(recensione);
		}
	}

	@Override
	public void delete(int id) {

		recensioneDao.deleteRecensione(id);
	}

	@Override
	public List<Recensione> getAll() {

		return recensioneDao.getAllRecensione();
	}

	@Override
	public void create(Recensione recensione) {

		recensioneDao.createRecensione(recensione);

    }

	@Override
	public Recensione getRecensione(int id) {
		
		return recensioneDao.getRecensione(id);
	}

	@Override
	public List<Recensione> getRecensioneByLibroId(int libro_Id) {
		List<Recensione> lista=recensioneDao.getAllRecensione();
		List<Recensione> result= new ArrayList<>();
		for(Recensione recensione: lista) {
			if(recensione.getLibro_id()==libro_Id) {
				result.add(recensione);
			}
		}
		return result;
	}

}
