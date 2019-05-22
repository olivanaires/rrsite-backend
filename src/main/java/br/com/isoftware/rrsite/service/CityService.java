package br.com.isoftware.rrsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isoftware.rrsite.model.City;
import br.com.isoftware.rrsite.repository.CityRepository;

/**
 * Created by @author olivanaires on 21/05/2019.
 */
@Service
public class CityService {

	@Autowired
	private CityRepository cityRepository;
	
	public List<City> loadAll() {
		return cityRepository.findAll();
	}
}
