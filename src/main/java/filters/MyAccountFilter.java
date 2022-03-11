package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet Filter implementation class MyAccountFilter
 */
@WebFilter("/my-account/*")
public class MyAccountFilter implements Filter {

	public MyAccountFilter() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession s = req.getSession();
		User u = (User) s.getAttribute("user");
		if(u == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/java4_asm_final/login");
			return;
		}
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
