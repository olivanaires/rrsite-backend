package br.com.isoftware.rrsite.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.isoftware.rrsite.model.User;
import br.com.isoftware.rrsite.repository.UserRepository;

/**
 * Created by @author olivanaires on 17/05/2019.
 */
public class AuditorAwareConfig implements AuditorAware<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return userRepository.findByUsername(authentication.getPrincipal().toString());
	}

}
