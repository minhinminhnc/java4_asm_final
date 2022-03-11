package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.VideoDAO;
import model.Video;

/**
 * Servlet implementation class VideoEditServlet
 */
@WebServlet("/admin/video-edit")
public class VideoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
        videoDAO = new VideoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		if(id != null) {
			Video v = videoDAO.findVideoById(Integer.parseInt(id));
			if(v != null) {
				List<Video> list = videoDAO.getTenVideo();
				request.setAttribute("video", list);
				request.setAttribute("v", v);
				request.setAttribute("button", "enable");
				request.setAttribute("button2", "disabled");
				request.setAttribute("jsp", "video_edition.jsp");
				request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
			}
		}
		response.sendRedirect("videos");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Video v = videoDAO.findVideoById(Integer.parseInt(request.getParameter("id")));
		try {
			BeanUtils.populate(v, request.getParameterMap());
			this.videoDAO.update(v);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect( request.getContextPath() + "/admin/videos" );
	}

}
