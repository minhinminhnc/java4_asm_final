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

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/my-account/change-password")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
        userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("jsp", "change_password.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentPassword = request.getParameter("cp");
		String newPassword = request.getParameter("np");
		String confirmPassword = request.getParameter("cnp");
		HttpSession s = request.getSession();
		User u = (User) s.getAttribute("user");
		
		System.out.println(currentPassword);
		System.out.println(newPassword);
		System.out.println(confirmPassword);
		System.out.println(u.getPassword());

		if(currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
			request.setAttribute("message", "Cac truong khong duoc de trong!");
			doGet(request, response);
		}else if(!currentPassword.equals(u.getPassword())) {
			request.setAttribute("message", "Password hien tai khong dung!");
			doGet(request, response);
		}else if(!newPassword.equals(confirmPassword)) {
			request.setAttribute("message", "New Password va Confirm Password khong dung!");
			doGet(request, response);
		}else {
			u.setPassword(newPassword);
			userDAO.update(u);
			s.setAttribute("user", u);
			response.sendRedirect("/java4_asm_final/my-account/my-favorites");
		}
	}

}
