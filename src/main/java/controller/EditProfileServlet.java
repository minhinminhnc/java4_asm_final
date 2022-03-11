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
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/my-account/edit-profile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
        userDAO = new UserDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("jsp", "edit_profile.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fullname = request.getParameter("fullname");
		if(fullname.isEmpty()) {
			request.setAttribute("message", "Ten khong duoc de trong!");
			doGet(request, response);
		}else {
			HttpSession s = request.getSession();
			User u = (User) s.getAttribute("user");
			u.setFullname(fullname);
			userDAO.update(u);
			request.setAttribute("message", "Cap nhat thanh cong!");
			doGet(request, response);
		}
	}

}
