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
 * Servlet implementation class CheckUser
 */
@WebServlet("/checkuser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("logout")!=null) {
			HttpSession sessio=request.getSession(true);
			sessio.invalidate();
			sessio=null;
		}
		response.sendRedirect("/jsp/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String user=request.getParameter("user");
		String pass=Crypt.crypt(request.getParameter("pass"));
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vaalikone");
		EntityManager em=emf.createEntityManager();
		
		Query q=em.createQuery("select a from Account a where a.email = :email and a.password = :password");

		 q.setParameter("email", user);

		 q.setParameter("password", pass);

		 List<Account> list=q.getResultList();
		 
		 
		 
		 if (list.size() == 1 ) {
			 HttpSession sessio=request.getSession(true);
				sessio.setAttribute("AuthOk", "ok");
				response.sendRedirect("/index.html");
			}
			else {
				response.sendRedirect("/jsp/login.jsp");//Or perhaps to register page
			}
	}

}
