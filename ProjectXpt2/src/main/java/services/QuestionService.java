package services;
import data.Kysymykset;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;







/**
 * @author juuso
 */


@Path("/questionservice")
public class QuestionService {	
	//Reading all the rows from table kysymykset.
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		
		
		@GET
		@Path("/readquestions")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Kysymykset> readQuestions() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			List<Kysymykset> list=em.createQuery("select a from Kysymykset a").getResultList();
			em.getTransaction().commit();
			return list;
	}
		@DELETE
		@Path("/deletequestions/{kysymys_id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Kysymykset> deleteQuestions(@PathParam("kysymys_id") int kysymys_id) {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			Kysymykset k=em.find(Kysymykset.class, kysymys_id);
			if (k!=null) {
				em.remove(k);
			}
			em.getTransaction().commit();
			List<Kysymykset> list=readQuestions();
			return list;
		}
		
		@GET
		@Path("/readtoupdatequestions/{kysymys_id}")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public Kysymykset readToUpdateQuestions(@PathParam("kysymys_id") int kysymys_id) {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			Kysymykset k=em.find(Kysymykset.class, kysymys_id);
			em.getTransaction().commit();	
			return k;
		}
		
		@POST
		@Path("/addquestions")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Kysymykset> addQuestions(Kysymykset kysymykset) {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(kysymykset);
			em.getTransaction().commit();
			List<Kysymykset> list = readQuestions();
			return list;
		}
    
}


















//EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
////And then EntityManager, which can manage the entities.
//EntityManager em=emf.createEntityManager();
//
////Read all the rows from table prey. Here the Prey must start with capital, 
////because class's name starts. This returns a List of Prey objects.
//List<Kysymykset> list=em.createQuery("select a from Kysymykset a").getResultList();
//return list;
// HANDLEQUESTIONS
