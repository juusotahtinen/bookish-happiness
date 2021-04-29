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
	@Path("/addanswers")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Vastaukset postRiista(@FormParam("breed") String breed, @FormParam("weight") int wait) {
		Vastaukset vastaukset=new Vastaukset(breed, wait);
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("hunterappi");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(prey);
		em.getTransaction().commit();
		return prey;
	}


public ArrayList<Integer> ehdokkaaVastaukset(){
	
	ArrayList<Integer> kayttajanVastaukset = new ArrayList<>();
	
	HttpSession session=request.getSession(false);
	int size = (int) session.getAttribute("pituus");
	int vastaus = 0;
	
	
	for (int i=0;i<size;i++) {
		
		
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
	
	return null;
	
}

}


