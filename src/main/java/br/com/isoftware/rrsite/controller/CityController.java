package br.com.isoftware.rrsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.isoftware.rrsite.model.City;
import br.com.isoftware.rrsite.service.CityService;

/**
 * Created by @author olivanaires on 21/05/2019.
 */
@RestController
@RequestMapping("/api/city")
public class CityController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/loadAll")
	public List<City> loadAll() {
		return cityService.loadAll();
	}

}
