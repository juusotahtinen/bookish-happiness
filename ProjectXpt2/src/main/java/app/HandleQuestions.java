package app;

import data.Kysymykset;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;







/**
 * @author juuso
 */

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/readquestion"})
public class HandleQuestions extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getServletPath();
		List<Kysymykset> list = null;
		switch (action) {
		case "/readquestion":
			list = readquestion(request);break;
		}
		request.setAttribute("questionlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestions.jsp");
		rd.forward(request, response);
	}
	


	private List<Kysymykset> readquestion(HttpServletRequest request) {
		@SuppressWarnings("unused")
		String id = request.getParameter("kysymys_id");
		String uri = "http://localhost:8080/rest/questionservice/readquestion";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(uri);
		Builder b = wt.request();
		
		GenericType<List<Kysymykset>> genericList = new GenericType<List<Kysymykset>>( ) {};
		
		List<Kysymykset> returnedList = b.get(genericList);
		return returnedList;
	}
    
}
