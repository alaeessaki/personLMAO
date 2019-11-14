package Controllers;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Person;
import Model.PersonDAO;

/**
 * Servlet implementation class UpdaePersonController
 */
@WebServlet("/UpdatePersonController")
public class UpdatePersonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PersonDAO personDAO = new PersonDAO();
		Person person = personDAO.getPerson(id);
		
		System.out.println(person);
		
		request.setAttribute("person", person);
		
		this.getServletContext().getRequestDispatcher("/update-person.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int age= Integer.parseInt(request.getParameter("age"));
		
		Person person = new Person(id, nom, prenom, age);
		PersonDAO personDAO = new PersonDAO();
		
		personDAO.updatePerson(person);
		
		response.sendRedirect("PersonController");
	}

}
