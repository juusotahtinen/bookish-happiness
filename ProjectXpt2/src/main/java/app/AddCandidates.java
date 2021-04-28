package app;

import java.io.IOException;
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
 * Servlet implementation class AddCandidates
 */
@WebServlet("/addcandidates")
public class AddCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	/**
	 * Otetaan yhteys tietokantaan
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
	/**
	 * Otetaan readCandidates vastaan Dao.javasta ja valmistellaan tietokanta uuden ehdokkaan lisäämistä varten.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ehdokas_id=request.getParameter("ehdokas_id");
		Candidates f=null;
		if (dao.getConnection()) {
			f=dao.readCandidates(ehdokas_id);
		}
		request.setAttribute("ehdokas", f);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/addcandidates.jsp");
		rd.forward(request, response);
	}
    
}
