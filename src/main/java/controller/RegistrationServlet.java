package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
        userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("jsp", "registration.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		
		if(email.isEmpty() || password.isEmpty() || fullname.isEmpty()) {
			request.setAttribute("message", "Cac muc khong duoc de trong!");
			doGet(request, response);
		}else {
			User u = userDAO.findEmail(email);
			if(u != null) {
				request.setAttribute("message", "Email da ton tai!");
				doGet(request, response);
			}else {
				User user = new User((byte) 0, email, fullname, password);
				userDAO.insert(user);
				response.sendRedirect("home");
			}
		}
	}

}
