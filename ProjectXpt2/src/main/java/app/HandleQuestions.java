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


@WebServlet(urlPatterns = {"/addquestions", "/readquestions", "/deletequestions", "/readtoupdatequestions"})
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
	private List<Kysymykset> deletequestions(HttpServletRequest request) {
		String kysymys_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/deletequestions/"+kysymys_id;
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		GenericType<List<Kysymykset>> gL = new GenericType<List<Kysymykset>>() {};
		List<Kysymykset> rL=b.get(gL);
		return rL;
	}
	private Kysymykset readtoupdatequestions(HttpServletRequest request) {
		String kysymys_id=request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/readtoupdatequestions/"+kysymys_id;
		Client asiakas=ClientBuilder.newClient();
		WebTarget wt=asiakas.target(uri);
		Builder b=wt.request();
		Kysymykset kysymykset=b.get(Kysymykset.class);
		return kysymykset;
	}
	
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
	
	


}








//<a href='../deletequestions?kysymys_id=${kysymykset.kysymys_id }'>Poista</a>

//@Path ("/readquestions")
//public class ReadAllQuestions {
//	public void doGet(HttpServletRequest request, HttpServletResponse response) 
//	      throws IOException, ServletException {
//			String uri = "http://localhost:8080/rest/handlequestions/all";
//
//			Client asiakas=ClientBuilder.newClient();
//			WebTarget wt=asiakas.target(uri);
//			Builder b=wt.request();
//			
//			//Create a GenericType to be able to get List of objects
//			//This will be the second parameter of post method
//			GenericType<List<Question>> genericList = new GenericType<List<Question>>() {};
//			
//			//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
//			List<Question> returnedList=b.get(genericList);
//		    request.setAttribute("questionlist", returnedList);
//		    RequestDispatcher rd=request.getRequestDispatcher("/readallquestions.jsp");
//			rd.forward(request, response);
//	}