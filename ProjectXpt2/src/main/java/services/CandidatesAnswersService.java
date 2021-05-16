package services;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.Vastaukset;

/**
 * 
 * @author Leevi Palo
 *
 */

@Path("/candidatesanswersservice")
public class CandidatesAnswersService {
	
	/**
	 * Otetaan käyttöön HttpServletRequest ja response
	 */
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	/**
	 * Seuraavaksi vastaanotetaan servletilta ehdokkaan vastaukset ja tallennetaan ne tietokantaan JPA:lla
	 */
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/addanswers")
	public void postVastaus() {
	
		/**
		 * Ensiksi joudumme kovokoodaamaan ehdokas id:n aikarajoitteista johtuen
		 * Lisaksi kysymys id on tavallaan kovokoodattuna nousemaan 1 kysymysten maksimimaaraan asti
		 */
		
		int ehdokas_id = 3;
		int kysymys_id = 1;
		int vastaus;
		
		/**
		 * Otetaan vastaan sessioon tallennettu kysymyslistan pituus ja ehdokkaan vastaukset HttpServletRequestin avulla
		 */

		HttpSession session=request.getSession(false);
		ArrayList<Integer> ehdokkaanVastaukset = (ArrayList<Integer>) request.getAttribute("ehdokkaanVastaukset");
		int size = (int) session.getAttribute("pituus");
		
		/**
		 * Luodaan for looppi jossa haeteaan listasta aina yksi vastaus kerrallaan
		 */
		
		for (int i = 0;i<size;i++) {
		
		vastaus = ehdokkaanVastaukset.get(i);	
		
		/**
		 * Sitten luodaan Vastaukset tyyppinen olio joka tallennetaan tietokantaan
		 */
		
		Vastaukset ehdokkaanVastaus = new Vastaukset(ehdokas_id, kysymys_id, vastaus);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaanVastaus);
		em.getTransaction().commit();		
		em.close();
		
		/**
		 * Kasvatetaan kysymys id:ta aina yhdella
		 */
		
		kysymys_id++;
		
		}
		
	}

}





