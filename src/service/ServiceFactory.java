package service;

import service.impl.AutoreService;

public class ServiceFactory {
	
	
	private final static IAutoreService AUTORE_SERVICE = new AutoreService();
	
	
	public static IAutoreService getAutoreService() {
		return AUTORE_SERVICE;
		
	}
	
	
	
}
