package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidates;



/**
 * @author riku
 * Servlet implementation class EditCandidates1
 */
@WebServlet("/editcandidates1")
public class EditCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	/**
	 * Otetaan yhteys tietokantaan
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {

	}
	
	/**
	 * Otetaan listCandidates vastaan Dao.javasta ja p�ivitet��n tiedot "sukunimi", "etunimi" ja "puolue" ehdokas_id:n mukaan.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		     throws IOException, ServletException {
			

			String sukunimi=request.getParameter("sukunimi");
			String etunimi=request.getParameter("etunimi");
			String puolue=request.getParameter("puolue");
			String ehdokas_id=request.getParameter("ehdokas_id");
			int id = Integer.parseInt(ehdokas_id);
	
			
		
		ArrayList<Candidates> listCandidates=null;
		if (dao.getConnection()) {
			listCandidates=dao.updateCandis(sukunimi, etunimi, puolue, id);
		}
		
		
		response.sendRedirect("/showcandidates");
		
	}
}