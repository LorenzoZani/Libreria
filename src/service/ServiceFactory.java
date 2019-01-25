package service;

import service.impl.AutoreService;
import service.impl.LibroService;

public class ServiceFactory {
	
	
	private final static IAutoreService AUTORE_SERVICE = new AutoreService();
	private static final ILibroService LIBRO_SERVICE = new LibroService();
	
	public static IAutoreService getAutoreService() {
		return AUTORE_SERVICE;
		
	}
	
	public static ILibroService getLibroService() {
		return LIBRO_SERVICE;
		
	}
	
	
	
}
