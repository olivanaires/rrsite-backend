package br.com.isoftware.rrsite.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Audited
@Entity
@Table(name = "propertyPhotos")
public class PropertyPhoto extends BaseModel {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE, CascadeType.DETACH })
	@JoinColumn(name = "property_id")
	private Property property;

	@NotAudited
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "file_id")
	private File file;

	public PropertyPhoto() {
	}

	public PropertyPhoto(Property property, File file) {
		this.property = property;
		this.file = file;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

}
