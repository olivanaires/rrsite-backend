package br.com.isoftware.rrsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isoftware.rrsite.model.User;
import br.com.isoftware.rrsite.model.vo.LoginRequestVO;
import br.com.isoftware.rrsite.security.JwtTokenProvider;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController extends BaseController {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequestVO loginRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsernameOrEmail(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		User user = (User) authentication.getPrincipal();
		String token = tokenProvider.generateToken(user);
		user.setToken(token);
		
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/signout")
	public void deauthorizeUser() {
		SecurityContextHolder.getContext().setAuthentication(null);
	}
	
}
