package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import models.Recensione;
import service.ServiceFactory;

/**
 * Servlet implementation class FormRecensioneServlet
 */
@WebServlet("/FormRecensioneServlet")
public class FormRecensioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormRecensioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/recensioneForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Recensione recensione = new Recensione(Integer.parseInt(request.getParameter("valutazione")),
				request.getParameter("testo"),
				Integer.parseInt(request.getParameter("id")));
		request.setAttribute("recensione", recensione);
		
		if (recensione.getTesto().isEmpty()) {
			request.getRequestDispatcher("/WEB-INF/creazioneRecensioneFallimento.jsp").forward(request, response);
			
		} else {
			ServiceFactory.getRecensioneService().create(recensione);
			request.getRequestDispatcher("/WEB-INF/creazioneRecensioneSuccesso.jsp").forward(request, response);
			
		}
	}

}
