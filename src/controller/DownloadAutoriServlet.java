package controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Autore;
import service.ServiceFactory;

/**
 * Servlet implementation class DownloadAutoriServlet
 */
@WebServlet("/DownloadAutoriServlet")
public class DownloadAutoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadAutoriServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=\"listaAutori.csv\"");
		try {
			OutputStream outputStream = response.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream, true);
			for (Autore autore : ServiceFactory.getAutoreService().getAll()) {
				printWriter.print(autore.getId());
				printWriter.print(",");
				printWriter.print(autore.getNome());
				printWriter.print(",");
				printWriter.println(autore.getCognome());

			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
