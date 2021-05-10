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


@Path("/candidatesanswersservice")
public class CandidatesAnswersService {
	
	@Context HttpServletRequest request;
	@Context HttpServletResponse response;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)//Method returns object as a JSON string
	@Path("/addanswers")
	public void postVastaus() {
		
		int ehdokas_id = 3;
		int kysymys_id = 1;
		int vastaus;
		

		HttpSession session=request.getSession(false);
		ArrayList<Integer> kayttajanVastaukset = (ArrayList<Integer>) request.getAttribute("kayttajanVastaukset");
		int size = (int) session.getAttribute("pituus");
		
		for (int i = 0;i<size;i++) {
		
		vastaus = kayttajanVastaukset.get(i);	
		
		
		
		Vastaukset ehdokkaanVastaus = new Vastaukset(ehdokas_id, kysymys_id, vastaus);
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ehdokkaanVastaus);
		em.getTransaction().commit();		
		em.close();
		
		kysymys_id++;
		
		}
		
		}

}





