package app;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.Dao;
import data.Candidates;






/**
 * @author juuso
 * Servlet implementation class InsertCandidates
 */
@WebServlet("/inserted")
public class InsertCandidates extends HttpServlet {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {

	}
	
	/**
	 * Otetaan listCandidates vastaan Dao.javasta ja lähetetään uuden ehdokkaan tiedot tietokantaan
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		

		String sukunimi=request.getParameter("sukunimi");
		String etunimi=request.getParameter("etunimi");
		String puolue=request.getParameter("puolue");
		String kotipaikkakunta=request.getParameter("kotipaikkakunta");
		int ika=Integer.parseInt(request.getParameter("ika"));
		String miksi_eduskuntaan=request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa=request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti=request.getParameter("ammatti");
		
		Candidates f=new Candidates(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
		
		ArrayList<Candidates> listCandidates=null;
		if (dao.getConnection()) {
			listCandidates=dao.insert(f);
		}
		
		request.setAttribute("added", listCandidates);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/inserted.jsp");
		rd.forward(request, response);
    
	}
}
