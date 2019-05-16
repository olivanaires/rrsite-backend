package br.com.isoftware.rrsite.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by @author olivanaires on 14/05/2019.
 */
@Entity
@Table(name = "states")
public class State extends BaseClass {

	private static final long serialVersionUID = 1L;

	private String name;

	private String acronym;

	@JsonIgnore
	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<City> cities;

	public State() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

}
