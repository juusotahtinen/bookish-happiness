package services;
import data.Kysymykset;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;







/**
 * @author juuso
 */


@Path("/handlequestions")
public class HandleQuestions {	
	//Reading all the rows from table kysymykset.
		@GET
		@Path("/all")
		@Produces(MediaType.APPLICATION_JSON)
		public List<Kysymykset> readAllQuestions() {
		//Create an EntityManagerFactory with the settings from persistence.xml file
			EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
			//And then EntityManager, which can manage the entities.
			EntityManager em=emf.createEntityManager();
			
			//Read all the rows from table prey. Here the Prey must start with capital, 
			//because class's name starts. This returns a List of Prey objects.
			List<Kysymykset> list=em.createQuery("select a from Kysymykset a").getResultList();
			return list;
	}
    
}
