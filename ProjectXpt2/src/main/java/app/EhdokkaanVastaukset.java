package app;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DaoAnswers;
import data.Candidates;
import data.Vastaukset;

/**
 * 
 * @author Leevi Palo
 * @author Juho Hamalainen
 *
 */


@WebServlet(
	name = "EhdokkaanVastaukset", 
	urlPatterns = { "/ehdokkaanvastaukset"}
)

public class EhdokkaanVastaukset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
		ArrayList<Integer> kayttajanVastaukset = new ArrayList<>();
		
		HttpSession session=request.getSession(false);
		int size = (int) session.getAttribute("pituus");
		int vastaus = 0;
		
		/**
		 * Luodaan for loop jolla saadaan kayttajan vastaukset tallenettua ArrayListiin
		 */
		
		for (int i=0;i<size;i++) {
			
			/**
			 * Looppi pyorii kysymysten maaran verran ja vastaanottaa GUI.jsp:lta kayttajan vastaukset 
			 * Sen jalkeen ne lisataan ArrayListiin
			 */
			
			String param = "radios" + i; 
			String vastausString = request.getParameter(param);
			if (vastausString == null) {
				
				vastaus = 0;
				kayttajanVastaukset.add(vastaus);
				
			}
			else {
				
				vastaus = Integer.parseInt(vastausString);
				kayttajanVastaukset.add(vastaus);
				
			}

		}
		
		request.setAttribute("kayttajanVastaukset", kayttajanVastaukset);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/rest/candidatesanswersservice/addanswers");
	    rd.forward(request, response);
		
	   }
	}

