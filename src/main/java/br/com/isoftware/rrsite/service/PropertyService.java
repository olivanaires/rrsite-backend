package br.com.isoftware.rrsite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isoftware.rrsite.model.Property;
import br.com.isoftware.rrsite.repository.PropertyRepository;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Service
public class PropertyService {
	
	@Autowired
	private PropertyRepository propertyRepository;
	
	public Long save(Property entity) {
		Property property = propertyRepository.save(entity);
		return property.getId();
	}
	
	public Property findById(Long propertyId) {
		return propertyRepository.getOne(propertyId);
	}
	
	public List<Property> loadAll() {
		return propertyRepository.findAll();
	}
	

}
