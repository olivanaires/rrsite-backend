package br.com.isoftware.rrsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import br.com.isoftware.rrsite.model.enums.RoleName;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
@Entity
@Table(name = "roles")
public class Role extends BaseClass {
	
	private static final long serialVersionUID = 1L;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 60)
	private RoleName name;

	public Role() { }

	public Role(RoleName name) {
		this.name = name;
	}

	public RoleName getName() {
		return name;
	}

	public void setName(RoleName name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + "]";
	}
	
}
