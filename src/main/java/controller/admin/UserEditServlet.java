package controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/admin/user-edit")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
       
    public UserEditServlet() {
        super();
        userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = userDAO.getTenUser();
		int id = Integer.parseInt(request.getParameter("id"));
		User u = userDAO.findById(id);
		if(list != null) {
			request.setAttribute("u", u);
			request.setAttribute("user", list);
			request.setAttribute("jsp", "user_edition.jsp");
			request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
			return;
		}
		response.sendRedirect("users");
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			User u = userDAO.findById(id);
			BeanUtils.populate(u, request.getParameterMap());
			u.setId(id);
			userDAO.update(u);
			response.sendRedirect("users");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
		return;
	}

}
