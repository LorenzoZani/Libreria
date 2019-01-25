package service;

import service.impl.AutoreService;
import service.impl.LibroService;
import service.impl.RecensioneService;

public class ServiceFactory {
	
	
	private final static IAutoreService AUTORE_SERVICE = new AutoreService();
	private static final ILibroService LIBRO_SERVICE = new LibroService();
	private static final IRecensioneService RECENSIONE_SERVICE = new RecensioneService();
	
	
	public static IAutoreService getAutoreService() {
		return AUTORE_SERVICE;
		
	}
	
	public static ILibroService getLibroService() {
		return LIBRO_SERVICE;
		
	}
	public static IRecensioneService getRecensioneService() {
		return RECENSIONE_SERVICE;
	}
	
	
	
}
