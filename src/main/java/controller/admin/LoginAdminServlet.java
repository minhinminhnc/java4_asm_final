package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class LoginAdminServlet
 */
@WebServlet("/login/admin")
public class LoginAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAdminServlet() {
        super();
        // TODO Auto-generated constructor stub
        userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("jsp", "login.jsp");
		request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession();
		if(s.getAttribute("user") != null) {
			doGet(request, response);
			return;
		}
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if(email.isEmpty() || password.isEmpty()) {
			System.out.println("1");
			request.setAttribute("message", "Email va Password khong duoc de trong!");
			doGet(request, response);
		}else {
			User user = userDAO.getUser2(email, password);
			if(user == null) {
				System.out.println("2");
				request.setAttribute("message", "Sai email hoac mat khau!");
				doGet(request, response);
			}else {
				String remember = request.getParameter("remember");
				if(remember == null) {
					System.out.println("3");
					s.setAttribute("user", user);
					response.sendRedirect("/java4_asm_final/admin/videos");
				}else {
					System.out.println("4");
					s.setAttribute("user", user);
					s.setMaxInactiveInterval(60*60*60);
					response.sendRedirect("/java4_asm_final/admin/videos");
				}
			}
		}
	}

}
