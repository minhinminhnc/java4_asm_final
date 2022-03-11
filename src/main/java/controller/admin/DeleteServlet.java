package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/admin/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public DeleteServlet() {
        super();
        userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("user");
			return;
		}
		int id = Integer.parseInt(request.getParameter("id"));
		User u = userDAO.findById(id);
		userDAO.delete(u);
		response.sendRedirect("users");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
