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
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;







/**
 * @author juuso
 * @author riku
 */


@Path("/questionservice")
public class QuestionService {	
	//Reading all the rows from table kysymykset.
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		
		/**
		 * Juuson osuus kysymysten lukemisesta, lisäämisestä ja poistamisesta.
		 */
		
		
		/**
		 * Vastaanotetaan servletilta kysymykset ja luodaan lista tietokannassa olevista kysymyksistä.
		 */
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
		
		/**
		 * Vastaanotetaan servletilta kysymys id:n mukaisesti ja poistetaan kysymys tietokannasta.
		 */
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
		
		/**
		 * Lähetetään servletille uusi kysymys ja lisätään kysymys tietokantaan.
		 */
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
		
		/**
		 * Rikun osuus kysymysten lukemisesta muokkaamista varten ja kysymysten muokkaamisesta.
		 */
		
		/**
		 * Vastaanotetaan servletilta kysymykset ja luetaan kysymykset ID:n mukaan muokkaamista varten.
		 */
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
		
		
		/**
		 * Päivitetään kysymys uudella kysymyksellä ID:n mukaan.
		 */
		@PUT
		@Path("/updatequestions")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes(MediaType.APPLICATION_JSON)
		public List<Kysymykset> updateFish(Kysymykset kysymykset) {
			EntityManager em=emf.createEntityManager();
			em.getTransaction().begin();
			Kysymykset k=em.find(Kysymykset.class, kysymykset.getKysymys_id());
			if (k!=null) {
				em.merge(kysymykset);//The actual update line
			}
			em.getTransaction().commit();
			//Calling the method readFish() of this service
			List<Kysymykset> list=readQuestions();		
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
