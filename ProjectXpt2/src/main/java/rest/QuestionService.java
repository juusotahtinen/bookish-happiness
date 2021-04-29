package rest;

import data.Kysymykset;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





@Path ("/questionservice")
public class QuestionService {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
	
	@GET
	@Path("/readquestion")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Kysymykset> readQuestion() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Kysymykset> list = em.createQuery("select * from Kysymykset").getResultList();
		em.getTransaction().commit();
		return list;
	}
    
}
