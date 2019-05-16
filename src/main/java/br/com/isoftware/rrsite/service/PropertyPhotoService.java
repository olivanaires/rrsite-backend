package br.com.isoftware.rrsite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.isoftware.rrsite.model.PropertyPhoto;
import br.com.isoftware.rrsite.repository.PropertyPhotoRepository;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Service
public class PropertyPhotoService {
	
	@Autowired
	private PropertyPhotoRepository propertyPhotoRepository;
	
	public void save(PropertyPhoto entity) {
		propertyPhotoRepository.save(entity);
	}

}
