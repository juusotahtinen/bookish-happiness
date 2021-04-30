package app;

import data.Question;
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
	EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");

	
	@GET
	@Path("/getquestions")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Question> getQuestions(){
	    EntityManager em=emf.createEntityManager();
	    em.getTransaction().begin();
	    List<Question> list=em.createQuery("select a from Kysymykset a").getResultList();
	    em.getTransaction().commit();
		return list;
	}
    
}
