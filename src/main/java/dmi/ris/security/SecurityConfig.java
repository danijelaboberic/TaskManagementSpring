package dmi.ris.security;

import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter.HeaderValue;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        //ovo je opciono za zastitu od XSS napada
        /*.headers(headers -> headers
				.xssProtection(xss -> xss
						.headerValue(HeaderValue.ENABLED_MODE_BLOCK)
				)
			)*/
        .authorizeHttpRequests(requests -> requests
                                .requestMatchers("/projects/admin/**").hasRole("ADMIN")
                                .requestMatchers("/users/manager/**").hasAnyRole("ADMIN","MANAGER")
                                .requestMatchers("/home","language/**").permitAll()
                                .requestMatchers("/jsp/home.jsp").permitAll()
                                .anyRequest().authenticated())
                		.formLogin(form -> form
	                        .loginPage("/jsp/login.jsp").permitAll()
	                        .loginProcessingUrl("/login")
	                        .defaultSuccessUrl("/jsp/home.jsp"))
                		.logout(logout -> logout
                			 .logoutSuccessUrl("/jsp/home.jsp"))
                		.exceptionHandling(handling -> handling.accessDeniedPage("/jsp/access_denied.jsp"))
                		.csrf(csrf -> csrf.disable());
		return http.build();
			
	}
	


	/*@Bean
	UserDetailsService userDetailsService() {
		UserDetails admin = User.withUsername("dboberic@uns.ac.rs")
			.password("111111")
			.roles("ADMIN")
			.build();
		
		 UserDetails employee = User.withUsername("markisa@gmail.com")
			        .password("147852")
			        .roles("EMPLOYEE")
			        .build();
		 
		 UserDetails manager = User.withUsername("nikola@gmail.com")
			        .password("123456")
			        .roles("MANAGER")
			        .build();

		return new InMemoryUserDetailsManager(admin, employee, manager);
	}*/
   
	
	@Bean
	 AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	  }

    @Bean
    PasswordEncoder passwordEncoder() {
	        // NoOpPasswordEncoder koristi običan tekst, samo za testiranje!
	        return NoOpPasswordEncoder.getInstance();
	 }
	
	/*@Bean
	 PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
    //ako zelimo da podesimo SameSite programski
   /* @Bean
     CookieSameSiteSupplier applicationCookieSameSiteSupplier() {
        return CookieSameSiteSupplier.ofStrict();
    }*/

	



	

	
	

}