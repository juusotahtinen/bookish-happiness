package app;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class ShowCandidates
 */
@WebServlet("/showcandidates")
public class ShowCandidates extends HttpServlet {
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
	 * Otetaan listCandidates vastaan Dao.javasta ja listataan kaikki ehdokkaat ja ehdokkaiden tiedot tietokannasta
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Candidates> listCandidates = null;
        if (dao.getConnection()) {
        	try {
				listCandidates=dao.listAllCandidates();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			System.out.println("No connection to database");
		}
        request.setAttribute("listCandidates", listCandidates);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/showcandidates.jsp");
        dispatcher.forward(request, response);
    }
    
}