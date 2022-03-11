package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
       
    public LoginServlet() {
        super();
        userDAO = new UserDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		if(s.getAttribute("email") == null) {
			request.setAttribute("jsp", "login.jsp");
			request.getRequestDispatcher("/views/index.jsp").forward(request, response);
		}else {
			response.sendRedirect("my-account/my-favorites");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		if(s.getAttribute("user") != null) {
			response.sendRedirect("my-account/my-favorites");
			return;
		}
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email.isEmpty() || password.isEmpty()) {
			request.setAttribute("message", "Email va Password khong duoc de trong!");
			doGet(request, response);
		}else {
			User user = userDAO.getUser2(email, password);
			if(user == null) {
				request.setAttribute("message", "Sai email hoac mat khau!");
				doGet(request, response);
			}else {
				String remember = request.getParameter("remember");
				if(remember == null) {
					s.setAttribute("user", user);
					response.sendRedirect("my-account/my-favorites");
				}else {
					s.setAttribute("user", user);
					s.setMaxInactiveInterval(60*60*60);
					response.sendRedirect("my-account/my-favorites");
				}
			}
		}
	}

}
