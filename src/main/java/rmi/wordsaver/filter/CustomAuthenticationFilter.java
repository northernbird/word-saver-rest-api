package rmi.wordsaver.filter;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import rmi.wordsaver.security.CustomAuthentication;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

		/*
		For our example we simply read the user and password information from the header and check if against our
		internal user store.
		IMPORTANT: THIS IS NOT A SECURE WAY TO DO AUTHENTICATION AND JUST FOR DEMONSTRATION PURPOSE!
		 */
        // First read the custom headers
        String user = request.getHeader("Authorization");

        // When they are present we authenticate the user in the SecurityContextHolder
        if (user != null && !user.isEmpty()) {
            SecurityContextHolder.getContext().setAuthentication(new CustomAuthentication(user));
        }

        // In either way we continue the filter chain to also apply filters that follow after our own.
        chain.doFilter(request, response);

    }

}
