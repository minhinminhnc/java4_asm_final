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
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/admin/*")
public class LoginAdminFilter implements Filter {


    public LoginAdminFilter() {
        
    }


	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		if(user == null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/java4_asm_final/login/admin");
			return;
		}else {
			chain.doFilter(request, response);
		}
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
