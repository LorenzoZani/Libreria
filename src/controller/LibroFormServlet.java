package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Autore;
import models.Libro;
import service.ServiceFactory;

/**
 * Servlet implementation class LibroFormServlet
 */
@WebServlet("/LibroFormServlet")
public class LibroFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Autore> autori = ServiceFactory.getAutoreService().getAll();
		request.setAttribute("autori", autori);
		
		request.getRequestDispatcher("/WEB-INF/libroForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro libro = new Libro(request.getParameter("titolo"), request.getParameter("descrizione"), Integer.parseInt(request.getParameter("autoreId")));
		Autore autore = ServiceFactory.getAutoreService().getAutore(Integer.parseInt(request.getParameter("autoreId")));
		boolean check = ServiceFactory.getLibroService().create(libro);
		request.setAttribute("libro", libro);
		request.setAttribute("autore", autore );
		if(check) {
			request.getRequestDispatcher("/WEB-INF/creazioneLibroSuccesso.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/creazioneLibroFallimento.jsp").forward(request, response);
		}
	}

}
