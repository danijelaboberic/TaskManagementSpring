package dmi.ris.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import dim.ris.model.User;

public class CustomUserDetails implements UserDetails {

	private User u;

	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public CustomUserDetails(User user) {
		this.u = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_" + u.getRole().getName()));
		return authorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPassword();
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getUsername();
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


}