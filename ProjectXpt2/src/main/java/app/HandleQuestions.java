package app;



import data.Kysymykset;


import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * @author juuso
 * @author riku
 */

@WebServlet(urlPatterns = {"/addquestions", "/readquestions", "/deletequestions", "/readtoupdatequestions", "/updatequestions"})
public class HandleQuestions extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
		doGet(request, response);
}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws IOException, ServletException {
		String action = request.getServletPath();
		List<Kysymykset> list=null;
		switch (action) {
		case "/addquestions":
			list = addquestions(request);break;
		case "/updatequestions":
			  list=updatequestions(request);break;
		case "/readquestions":
			list = readquestions(request);break;
		case "/deletequestions":
			String kysymys_id=request.getParameter("kysymys_id");
			list = deletequestions(request);break;
		case "/readtoupdatequestions":
			Kysymykset k = readtoupdatequestions(request);
			request.setAttribute("kysymykset", k);
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/questiontoupdateform.jsp");
			rd.forward(request, response);
			return;
		}
		request.setAttribute("kysymyslista", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/questionform.jsp");
		rd.forward(request, response);
		
	}
	
	/**
	 * Juuson osuus kysymysten lukemisesta, lisäämisestä ja poistamisesta.
	 */
	
	
	/**
	 * Servletti kysymysten lukemista varten.
	 */
	private List<Kysymykset> readquestions(HttpServletRequest request) {
		String kysymys_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/readquestions/";
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		GenericType<List<Kysymykset>> gL = new GenericType<List<Kysymykset>>() {};
		
		List<Kysymykset> rL=b.get(gL);
		return rL;
	}
	
	
	/**
	 * Servletti kysymysten lisäämistä varten.
	 */
	private List<Kysymykset> addquestions(HttpServletRequest request) {
		Kysymykset k=new Kysymykset(request.getParameter("kysymys"));
		System.out.println(k);
		String uri = "http://localhost:8080/rest/questionservice/addquestions/";
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		Entity<Kysymykset> e = Entity.entity(k, MediaType.APPLICATION_JSON);
		GenericType<List<Kysymykset>> gL = new GenericType<List<Kysymykset>>() {};
		List<Kysymykset> rL=b.post(e, gL);
		return rL;
	}
	
	/**
	 * Servletti kysymysten poistamista varten.
	 */
	private List<Kysymykset> deletequestions(HttpServletRequest request) {
		String kysymys_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/deletequestions/"+kysymys_id;
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		GenericType<List<Kysymykset>> gL = new GenericType<List<Kysymykset>>() {};
		List<Kysymykset> rL=b.delete(gL);
		return rL;
	}
	
	/**
	 * Rikun osuus kysymysten lukemisesta muokkaamista varten ja kysymysten muokkaamisesta.
	 */
	
	/**
	 * Servletti kysymysten lukemisesta muokkaamista varten.
	 */
	private Kysymykset readtoupdatequestions(HttpServletRequest request) {
		String kysymys_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/readtoupdatequestions/"+kysymys_id;
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		Kysymykset kysymykset=b.get(Kysymykset.class);
		return kysymykset;
	}
	
	/**
	 * Servletti kysymysten päivittämistä varten.
	 */
	private List<Kysymykset> updatequestions(HttpServletRequest request) {
		//A Fish object to send to our web-service 
		Kysymykset k=new Kysymykset(request.getParameter("kysymys_id"), request.getParameter("kysymys"));
		System.out.println(k);
		String uri = "http://localhost:8080/rest/questionservice/updatequestions/";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a object as JSON string format
		Entity<Kysymykset> e=Entity.entity(k,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Kysymykset>> gL = new GenericType<List<Kysymykset>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Kysymykset> rL=b.put(e, gL);
		return rL;
	}
	
	


}