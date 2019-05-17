package br.com.isoftware.rrsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import br.com.isoftware.rrsite.model.enums.PropertyType;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Audited
@Entity
@Table(name = "properties")
public class Property extends BaseClass {

	private static final long serialVersionUID = 1L;

	private String name;
	
	private String description;

	@Enumerated(EnumType.STRING)
	private PropertyType type;

	@NotAudited
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "property")
	private List<PropertyPhoto> photos;

	public Property() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PropertyType getType() {
		return type;
	}

	public void setType(PropertyType type) {
		this.type = type;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PropertyPhoto> getPhotos() {
		return photos;
	}

	public void setPhotos(List<PropertyPhoto> photos) {
		this.photos = photos;
	}

}
