package br.com.isoftware.rrsite.model.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
public class PropertyImageVO {

	private Long propertyId;
	private MultipartFile file;

	public PropertyImageVO() {
	}

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

}
