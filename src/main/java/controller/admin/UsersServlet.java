package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;


@WebServlet("/admin/users")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public UsersServlet() {
        super();
        userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = userDAO.getTenUser();
		if(list != null) {
			request.setAttribute("button", "disabled");
			request.setAttribute("user", list);
			request.setAttribute("jsp", "user_edition.jsp");
			request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
		}
		response.sendRedirect("users");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
