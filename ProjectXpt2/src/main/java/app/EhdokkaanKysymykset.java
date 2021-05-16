package app;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoAnswers;
import data.Kysymykset;
import data.Vastaukset;

/**
 * 
 * @author Leevi Palo
 *
 */

@WebServlet(
    name = "EhdokkaanKysymykset",
    urlPatterns = {"/ehdokkaankysymykset"}
)
public class EhdokkaanKysymykset extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Initialisoidaan DaoAnswers tyyppinen muuttuja, jolla saadaan luotua yhteys tietokantaan
	 */
	private DaoAnswers dao = null; 
	
    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException, ServletException {

    response.setContentType("text/plain");
    response.setCharacterEncoding("UTF-8");
    
    /**
     * Luodaan yhteys tietokantaan kayttamalla DaoAnswers nimist� DAO ohjelmaa Data-paketista 
     */
    dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");

    /**
     * Lisataan DaoAnswerissa olevan metodin Select() palauttamat arvot ArrayListiin 
     */
    ArrayList<Kysymykset> list = dao.Select();
    
    /**
     * Asetetaan atribuutille "kysymykset" arvoksi ylla luotu ArrayList
     */
    
    request.setAttribute("kysymykset", list);
    
    /**
     * Seuraavaksi siirrytaan jps tiedostoon CandidateAnswersGUI.jsp
     */
    
    RequestDispatcher rd = request.getRequestDispatcher("jsp/CandidateAnswersGUI.jsp");
    rd.forward(request,  response);
    
    /**
     * Tarvitsemme myohemmin edella luodun listan kokoa, joten asetetaan sen arvo sessio atribuuttiin "pituus" 
     */
    
    HttpSession session = request.getSession();
    session.setAttribute("pituus", list.size());
    
        


  }
}
