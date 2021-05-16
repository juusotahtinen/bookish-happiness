package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.Account;
import util.Crypt;


/**
 * @author Juho
 * RESTful web servicen toteutus
 */
@Path("/accountservice")
public class Accountservice {
/**
 * Otetaan yhteys tietokantaan
 */
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
/**
 * Luetaan tietokannan account -taulusta tiedot listaan kayttaen GET -requestia
 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Account> readAllAccount() {

		EntityManager em = emf.createEntityManager();

		List<Account> list = em.createQuery("select a from Account a").getResultList();
		em.close();
		return list;
	}
/**
 * POST -requestilla lahetetaan kaytajan register.jsp formille syottamat tunnukset tietokantaan.
 */
	@POST
	@Path("/addaccount")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Account postAccount(Account account) {
/**
 * Kaytetaan util packagessa olevan Crypt.java -tiedoston crypt -metodia suojataksemme salasanan.
 */
		account.setPassword(Crypt.crypt(account.getPassword()));

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(account);
		em.getTransaction().commit();
		em.close();
		return account;
	}

}
