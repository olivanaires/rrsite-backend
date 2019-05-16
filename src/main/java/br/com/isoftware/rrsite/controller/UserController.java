package br.com.isoftware.rrsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isoftware.rrsite.exception.ResourceNotFoundException;
import br.com.isoftware.rrsite.model.User;
import br.com.isoftware.rrsite.repository.UserRepository;
import br.com.isoftware.rrsite.security.CurrentUser;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('CLIENT')")
	public User getCurrentUser(@CurrentUser User currentUser) {
		return currentUser;
	}

	@GetMapping("/users/{username}")
	public User getUserProfile(@PathVariable(value = "username") String username) {
		User user = userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", "username", username));
		return user;
	}

}
