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
 * Servlet implementation class DeleteCandiInfo
 */
@WebServlet("/deletecandiinfo1")
public class DeleteCandiInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	/**
	 * Otetaan yhteys tietokantaan
	 */
	@Override
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
    
	public DeleteCandiInfo() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * Otetaan candidateInfo vastaan Dao.javasta ja poistetaan ehdokas_id:n mukaisen ehdokkaan tiedot tietokannasta.
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    	String ehdokas_id=request.getParameter("ehdokas_id");
        ArrayList<Candidates> p=null;
        
        if (dao.getConnection()) {
			p=dao.deleteEhdokasInfo(ehdokas_id);
        }
        
        request.setAttribute("ehdokas", p);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/deleted.jsp");
        dispatcher.forward(request, response);
    }
    
}