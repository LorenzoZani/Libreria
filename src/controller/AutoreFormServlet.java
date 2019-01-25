package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Autore;
import service.ServiceFactory;

/**
 * Servlet implementation class AutoreFormServlet
 */
@WebServlet("/AutoreFormServlet")
public class AutoreFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoreFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/autoreForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Autore autore = new Autore(request.getParameter("nome"), request.getParameter("cognome"));
		boolean check=ServiceFactory.getAutoreService().create(autore);
		request.setAttribute("autore", autore);
		if (check) {
			request.getRequestDispatcher("/WEB-INF/creazioneAutoreSuccesso.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/creazioneAutoreFallimento.jsp").forward(request, response);
		}
		
	}


}
