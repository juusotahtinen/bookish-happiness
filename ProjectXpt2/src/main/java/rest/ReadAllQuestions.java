package rest;


import data.Question;


import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;





@Path ("/readallquestions")
public class ReadAllQuestions {
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
			String uri = "http://localhost:8080/rest/handlequestions/getquestions";

			Client asiakas=ClientBuilder.newClient();
			WebTarget wt=asiakas.target(uri);
			Builder b=wt.request();
			
			//Create a GenericType to be able to get List of objects
			//This will be the second parameter of post method
			GenericType<List<Question>> genericList = new GenericType<List<Question>>() {};
			
			//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
			List<Question> returnedList=b.get(genericList);
		    request.setAttribute("questionlist", returnedList);
		    RequestDispatcher rd=request.getRequestDispatcher("/jsp/readallquestions.jsp");
			rd.forward(request, response);
	}
}
