package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Libro;
import models.Recensione;
import service.ServiceFactory;

/**
 * Servlet implementation class LibroDettaglioServlet
 */
@WebServlet("/LibroDettaglioServlet")
public class LibroDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibroDettaglioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Libro libro = ServiceFactory.getLibroService().get(id);
		List<Recensione> recensioni=ServiceFactory.getRecensioneService().getRecensioneByLibroId(id);
		request.setAttribute("libro", libro);
		request.setAttribute("id", id);
		request.setAttribute("recensioni", recensioni);
		
		request.getRequestDispatcher("/WEB-INF/dettaglioLibro.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
