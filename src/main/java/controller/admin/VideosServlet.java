package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VideoDAO;
import model.Video;

/**
 * Servlet implementation class VideosAdminServlet
 */
@WebServlet("/admin/videos")
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideosServlet() {
        super();
        // TODO Auto-generated constructor stub
        videoDAO = new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Video> list = videoDAO.getTenVideo();
		request.setAttribute("video", list);
		request.setAttribute("button", "disabled");
		request.setAttribute("jsp", "video_edition.jsp");
		request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
