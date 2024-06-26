package ohjelmistoprojekti.ticketGuru.web;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ohjelmistoprojekti.ticketGuru.domain.AppUser;
import ohjelmistoprojekti.ticketGuru.domain.AppUserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final AppUserRepository repository;

	public UserDetailServiceImpl(AppUserRepository userRepository) {
		this.repository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser curruser = repository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username,
				curruser.getPasswordhash(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}

}