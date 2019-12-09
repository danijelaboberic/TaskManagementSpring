package dim.ris.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
 	UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
/*	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.inMemoryAuthentication().
	   withUser("profa").
	   password("{noop}123456").
	   roles("MANAGER").and().
	   withUser("test").
	   password("{noop}654321").
	   roles("EMPLOYEE");
	}*/

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	   auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	   http.authorizeRequests().
	   antMatchers("/","/loginPage").permitAll().
	   antMatchers("/admin/**").hasRole("MANAGER").
	   antMatchers("/users/**").hasAnyRole("EMPLOYEE","MANAGER").
	   and().formLogin().
	   loginPage("/pages/login.jsp").
	   loginProcessingUrl("/login").
	   defaultSuccessUrl("/pages/home.jsp").and().
	   exceptionHandling().accessDeniedPage("/pages/access_denied.jsp").
	   and().rememberMe().
	   and().csrf().disable();
	}



	

	
	

}
