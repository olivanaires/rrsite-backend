package br.com.isoftware.rrsite.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isoftware.rrsite.model.Client;
import br.com.isoftware.rrsite.model.vo.DefaultResponseVO;
import br.com.isoftware.rrsite.model.vo.SignUpRequestVO;
import br.com.isoftware.rrsite.repository.ClientRepository;
import io.swagger.annotations.ApiOperation;

/**
 * Created by @author olivanaires on 17/05/2019.
 */
@RestController
@RequestMapping("/api/client")
public class ClientController extends BaseController {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientRepository clientRepository;

	@ApiOperation(value = "Create a new client.", response = String.class)
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequestVO signUpRequest) {
		clientRepository.save(new Client(signUpRequest));
		return ResponseEntity.ok(new DefaultResponseVO("Cliente registrado!"));
	}
}
