package dmi.ris.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import dim.ris.model.User;
import dmi.ris.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	UserRepository ur;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = ur.findByUsername(username);
		UserDetails ud = new CustomUserDetails(u);
		return ud;
	}
}
