package rmi.wordsaver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import rmi.wordsaver.filter.CustomAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    public static class UserWebSecurity extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
			/*
			We need to decide where in the filter chain our filter is tested. For our example we still want to support
			 the default session functionality, so we put our own filter after the session filter. That way the
			 authentication by session is done before our own filter.
			 */
            http.addFilterAfter(new CustomAuthenticationFilter(), ConcurrentSessionFilter.class);
            http.csrf().disable();
            http.requestMatchers().antMatchers("/words/**");
            http .authorizeRequests().anyRequest().authenticated();
        }

    }


}
