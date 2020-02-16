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

/**
 * Servlet Filter implementation class FilterAccessInstrutor
 */
@WebFilter( urlPatterns = { "/instrutor/*" }, servletNames = { "InstrutorController" })
public class FilterAccessInstrutor implements Filter {

    /**
     * Default constructor. 
     */
    public FilterAccessInstrutor() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;
		HttpSession session = httpReq.getSession();

		httpReq.setCharacterEncoding("UTF-8");
		httpResp.setCharacterEncoding("UTF-8");
		httpResp.setContentType("application/json");

		String email = (String) session.getAttribute("email");
		int tipoUser = (int) session.getAttribute("tipoUser");
		System.out.println(email);
		if (email == null && tipoUser == 2) {
			httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
		} else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
