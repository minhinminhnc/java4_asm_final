package controller;

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
 * Servlet implementation class VideoDetailServlet
 */
@WebServlet("/video-detail")
public class VideoDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
        videoDAO = new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idd = request.getParameter("id");
		try {
			int id = Integer.parseInt(idd);
			Video v = videoDAO.findVideoById(id);
			request.setAttribute("video", v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Video> list = videoDAO.getVideoAll();
		request.setAttribute("videoList", list);
		request.setAttribute("jsp", "video_detail_1.jsp");
		request.getRequestDispatcher("/views/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
