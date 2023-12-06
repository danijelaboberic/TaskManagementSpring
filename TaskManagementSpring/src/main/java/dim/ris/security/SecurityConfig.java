package dim.ris.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                                .requestMatchers(new AntPathRequestMatcher("/admin/**")).hasRole("MANAGER")
                                .requestMatchers(new AntPathRequestMatcher("/users/**")).hasAnyRole("EMPLOYEE", "MANAGER")
                                .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()
                                .anyRequest().authenticated())
                		.formLogin(form -> form
                        .loginPage("/pages/login.jsp").permitAll()
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/pages/home.jsp"))
                		.exceptionHandling(handling -> handling.accessDeniedPage("/pages/access_denied.jsp"))
                .csrf(csrf -> csrf.disable());

		return http.build();
			
	}
	


/*	@Bean
	UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withUsername("admin")
			.password(getPasswordEncoder().encode("123456"))
			.roles("MANAGER")
			.build();

		return new InMemoryUserDetailsManager(userDetails);
	}*/
	
/*	@Bean
	UserDetailsService customUserDetailsService() {
		return new CustomUserDetailService();
	}*/
	
	 @Bean
	 AuthenticationManager authenticationManager(UserDetailsService userDetailsService,PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	  }
	
	@Bean
	 PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	


	



	

	
	

}
