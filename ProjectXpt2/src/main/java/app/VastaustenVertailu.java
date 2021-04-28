package app;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoAnswers;
import data.Candidates;
import data.Vastaukset;

/**
 * 
 * @author Leevi Palo
 * @author Juho Hamalainen
 *
 */


@WebServlet(
	name = "VastaustenVertailu", 
	urlPatterns = { "/vastaustenVertailu"}
)

public class VastaustenVertailu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Luodaan yhteys tietokantaan kayttamalla DaoAnswers nimist� DAO ohjelmaa Data-paketista
     */
	
	private DaoAnswers dao = null; 


	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {

	response.setContentType("text/plain");
	response.setCharacterEncoding("UTF-8");
	
	
	/**
	 * Kayttajien vastausten tallennuksen ArrayListiin on kirjoittanut Leevi
	 * Loput on Juhon
	 */
	
	/**
	 * Luodaan Integer tyyppinen ArrayList johon tallennetaan kayttajan antamat vastukset
	 */
	
	ArrayList<Integer> kayttajanVastaukset = new ArrayList<>();
	
	/**
	 * Vastaanotetaan sessioon tallennettu listan koko
	 */
	
	HttpSession session=request.getSession(false);
	int size = (int) session.getAttribute("pituus");
	int vastaus = 0;
	
	/**
	 * Luodaan for loop jolla saadaan kayttajan vastaukset tallenettua ArrayListiin
	 */
	
	for (int i=0;i<size;i++) {
		
		/**
		 * Looppi pyorii kysymysten maaran verran ja vastaanottaa GUI.jsp:lta kayttajan vastaukset 
		 * Sen jalkeen ne lisataan ArrayListiin
		 */
		
		String param = "radios" + i;
		String vastausString = request.getParameter(param);
		if (vastausString == null) {
			
			vastaus = 0;
			kayttajanVastaukset.add(vastaus);
			
		}
		else {
			
			vastaus = Integer.parseInt(vastausString);
			kayttajanVastaukset.add(vastaus);
			
		}

	}
	
	/**
	 * Tasta alkaa Juhon koodi
	 */
	
	/**
	 *  Verrataan k�ytt�j�n vastauksia ehdokkaan vastauksiin
	 */
	
	/**
	 * Luodaan yhteys tietokantaan daoAnswers.java kautta ja toteutetaan metodi SelectEhdokkaat
	 */

	
	/**
	 * ArrayList joka palautuu metodista laittaan ArrayListaan
	 */
	dao = new DaoAnswers("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
    ArrayList<Vastaukset> list = dao.SelectEhdokkaanVastaukset();
    
    /**
     * Vertailua varten luodaan kaksi uutta listaa
     */
    ArrayList<ArrayList<Integer> > Ehdokkaat = new ArrayList<ArrayList<Integer> >();
    ArrayList<Integer> list2 = new ArrayList<>();
    
    /** 
     * K�ytet��n for-looppia ehdokkaiden vastausten hakemiseen
     */
    int ehdokasVastaus=0;
    

    	
			for (int j = 0; j < list.size(); j++) {

				Vastaukset v1 = list.get(j);

				ehdokasVastaus = v1.getVastaus();
				list2.add(ehdokasVastaus);
				
			}
					
			int sizeOfList = size;
			
			for (int i = 0; i < list2.size(); i += sizeOfList) {
				int end = Math.min(i + sizeOfList, list2.size());
				ArrayList<Integer> sublist = new ArrayList(list2.subList(i, end));
				Ehdokkaat.add(sublist);
				
			}
			

    /**
     * Luodaan lista tuloksia varten
     */
	ArrayList<List> tulokset = new ArrayList<List>();
	   
    
    for (int i =0; i< Ehdokkaat.size(); i++) {
    	ArrayList<Integer> current = Ehdokkaat.get(i);
    	ArrayList<Integer> tulos = new ArrayList<Integer>();
    	

    	 for (int j =0; j< current.size(); j++){
    	    	
    	    	int vertailu= Math.abs(kayttajanVastaukset.get(j) - current.get(j));
    	    	tulos.add(vertailu);
    	    }
    	tulokset.add(tulos);
    }
    
    /**
     * Luodaan lista siit� kuinka sopiva ehdokas on.
     * Ja toinen samanlainen jossa ne asetetaan j�rjestykseen sopivin ehdokas ensin
     */
    ArrayList<Integer> sopivuus = new ArrayList<Integer>();
    
    ArrayList<Integer> sopivuus2 = new ArrayList<Integer>();
    
    int sum=0;
    for (int i =0; i< tulokset.size(); i++){
    	ArrayList<Integer> current = (ArrayList<Integer>) tulokset.get(i);
    	
    	for (int j=0; j<current.size(); j++) {
    	
    		sum = current.stream().mapToInt(Integer::intValue).sum();
    		
    	}
    	sopivuus.add(sum);
    	sopivuus2.add(sum);
    	
    }
    
    /**
     * Listan j�rjest�minen
     */
    
    //response.getWriter().println(sopivuus);
    Collections.sort(sopivuus);
    //response.getWriter().println(sopivuus);
    //response.getWriter().println(sopivuus2);
    
    int eka = sopivuus.get(0);
    int toka = sopivuus.get(1);
    int kolmas = sopivuus.get(2);
    
    
    

    int ekaIndex =sopivuus2.indexOf(eka);
    int tokaIndex =sopivuus2.indexOf(toka);
    int kolmasIndex =sopivuus2.indexOf(kolmas);

    
    /**
     * Lista kolmen parhaan ehdokkaan ID:st�
     */
    ArrayList<Integer> paras_id = new ArrayList<Integer>();
    paras_id.add(ekaIndex);
    paras_id.add(tokaIndex);
    paras_id.add(kolmasIndex);
    
    
    /**
     * Haetaan vastaajan ID for-loopilla
     */
    int count = 0;
    ArrayList<Integer> ehdokas_id = new ArrayList<Integer>();
    
    for (int i=0; i<sopivuus.size(); i++) {
    Vastaukset g = list.get(count);
    ehdokas_id.add(g.getVastaaja_id());
    count = count + size;
    }
   
    /**
     * Top-3 ehdokkaat j�rjestyksess� alkaien sopivimmasta
     */
    ArrayList<Integer> top3_id = new ArrayList<Integer>();
    top3_id.add(ehdokas_id.get(paras_id.get(0)));
    top3_id.add(ehdokas_id.get(paras_id.get(1)));
    top3_id.add(ehdokas_id.get(paras_id.get(2)));
    
  
    /**
     * L�hetet��n servletille sopivimmat ehdokkaat
     */

	session.setAttribute("Ehdokas_id", top3_id);
	response.sendRedirect("/naytasopivatehdokkaat");
	
	}	
}
