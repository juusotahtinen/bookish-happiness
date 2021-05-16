package app;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Account;
import util.Crypt;


/**
 * @author Juho
 * Servletin toteutus
 */
@WebServlet("/checkuser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public CheckUser() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/**
 * Jos "logout" -parametri on jotain muuta kuin null, siirrytään index -sivulle, jossa käyttäjä ei ole kirjautunut sisään.
 */
		if (request.getParameter("logout") != null) {
			HttpSession sessio = request.getSession(true);
			sessio.invalidate();
			sessio = null;
		}
		response.sendRedirect("/index.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/**
 * Otetaan vastaan user ja pass parametrit login.jsp formilta jossa käyttäjä syöttää tietonsa tekstiruutuihin kirjautuakseen sisään.
 */
		String user = request.getParameter("user");
/**
 * Käytetään util packagessa olevan Crypt.java -tiedoston crypt -metodia suojataksemme salasanan.
 */
		String pass = Crypt.crypt(request.getParameter("pass"));
		
/*
 * Otetaan yhteys tietokantaan.
 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em = emf.createEntityManager();
/**
 * Luodaan SQL kysely, jossa valitaan tietokannan account -taulusta email ja password.
 */
		Query q = em.createQuery("select a from Account a where a.email = :email and a.password = :password");
/**
 * Verrataan käyttäjän formille syöttämiä tunnuksia tietokannassa oleviin tunnuksiin.
 */
		q.setParameter("email", user);

		q.setParameter("password", pass);
/**
 * Asetetaan tiedot listaan ja tarkastellaan, mikäli listan koko on 1, kirjaudutaan sisään eli siirrytään loggedindex.html -sivulle, tai muussa tapauksessa (mikäli tunnukset ovat väärät) pysytään login.jsp -sivulla.
 */
		List<Account> list = q.getResultList();

		if (list.size() == 1) {
			HttpSession sessio = request.getSession(true);
			sessio.setAttribute("AuthOk", "ok");
			response.sendRedirect("/loggedindex.html");
		} else {
			response.sendRedirect("/jsp/login.jsp");
		}

	}

}