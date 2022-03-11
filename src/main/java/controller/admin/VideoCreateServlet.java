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
 * Servlet implementation class VideoCreateServlet
 */
@WebServlet("/admin/video-create")
public class VideoCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VideoDAO videoDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoCreateServlet() {
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
		request.setAttribute("jsp", "video_edition.jsp");
		request.getRequestDispatcher("/views_admin/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String delete = request.getParameter("delete");
		if(delete != null) {
			Video v = videoDAO.findVideoById(Integer.parseInt(delete));
			videoDAO.delete(v);
			response.sendRedirect("videos");
			return;
		}
		
		String update = request.getParameter("update");
		if(update != null) {
			Video video = videoDAO.findVideoById(Integer.parseInt(request.getParameter("update")));
			try {
				BeanUtils.populate(video, request.getParameterMap());
				this.videoDAO.update(video);
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.sendRedirect( request.getContextPath() + "/admin/videos" );
			return;
		}
		
		String url = request.getParameter("url");
		String title = request.getParameter("title");
		String poster = request.getParameter("poster");
		String views = request.getParameter("views");
		String active = request.getParameter("active");
		String description = request.getParameter("description");
		
		if(url == null || title == null || poster == null || views == null || active == null || description == null) {
			request.setAttribute("message", "Cac muc khong duoc de trong!");
			request.setAttribute("button", "disabled");
			doGet(request, response);
		}else {
			int a = Integer.parseInt(active);
			try {
				int viewss = Integer.parseInt(views);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "Views phai la so!");
				doGet(request, response);
			}
			int viewss = Integer.parseInt(views);
			Video v = new Video(a, description, poster, title, url, viewss);
			videoDAO.insert(v);
			response.sendRedirect("videos");
		}
	}

}
