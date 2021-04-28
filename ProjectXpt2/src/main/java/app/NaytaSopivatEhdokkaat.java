package app;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAnswers;
import data.Candidates;
import data.Kysymykset;
import data.Vastaukset;

/**
 * Luodaan servlet NaytaSopivatEhdokkaat joka nayttaa kayttajalle kolme sopivinta ehdokasta
 */

@WebServlet(
    name = "NaytaSopivatEhdokkaat",
    urlPatterns = {"/naytasopivatehdokkaat"}
)
public class NaytaSopivatEhdokkaat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoAnswers dao = null; 
	
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");

    /**
     * Luodaan yhteys tietokantaan
     */
    dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
    
	/**
	 * Kaytetaan sessioon tallennettua atribuuttia nimeltaan ehdokas_id
	 */
    HttpSession session=request.getSession(false);
    ArrayList<Integer> top3_id = (ArrayList<Integer>) session.getAttribute("Ehdokas_id");
    
    /**
     * Laitetaan parhaatEhdokkaat listaan
     */
    Candidates sopivaEhdokas = null;
    ArrayList<Candidates> parhaatEhdokkaat = new ArrayList<>();
    
    /**
     * Haetaan ID:ll� top-3 ehdokkaat listaan
     */
    for(int i=0; i< top3_id.size(); i++) {
    	int id = top3_id.get(i);
    	
    	try {
			sopivaEhdokas = dao.EhdokkaanTiedot(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	parhaatEhdokkaat.add(sopivaEhdokas);
    }
    
    /**
     * L�hetet��n lista jsp:lle
     */
    
    request.setAttribute("parhaatEhdokkaat", parhaatEhdokkaat);
    
    RequestDispatcher rd = request.getRequestDispatcher("jsp/showbestcandidates.jsp");
    rd.forward(request,  response);
    
  }
}
