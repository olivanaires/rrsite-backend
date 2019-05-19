package br.com.isoftware.rrsite.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.isoftware.rrsite.model.File;
import br.com.isoftware.rrsite.model.Property;
import br.com.isoftware.rrsite.model.PropertyPhoto;
import br.com.isoftware.rrsite.model.enums.FileType;
import br.com.isoftware.rrsite.service.PropertyPhotoService;
import br.com.isoftware.rrsite.service.PropertyService;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@RestController
@RequestMapping("/api/property")
public class PropertyController extends BaseController {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private PropertyPhotoService propertyPhotoService; 

	@PostMapping("/create")
	@PreAuthorize("hasRole('ADMIN')")
	public Long save(@RequestBody Property property) {
		return propertyService.save(property);
	}

	@PostMapping("/uploadImage/{propertyId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void uploadImages(@PathVariable Long propertyId, @RequestParam("file") MultipartFile file) {
		try {
			Property property = propertyService.findById(propertyId);
			File dbFile = new File(file.getOriginalFilename(), file.getContentType(), FileType.PROPERTY, file.getBytes());
			PropertyPhoto propertyPhoto = new PropertyPhoto(property, dbFile);
			propertyPhotoService.save(propertyPhoto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/loadAll")
	public List<Property> loadAll() {
		return propertyService.loadAll();
	}

}
