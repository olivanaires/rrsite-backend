package br.com.isoftware.rrsite.model.vo;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.isoftware.rrsite.model.enums.Interest;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
public class SignUpRequestVO {
	
	@NotNull
	@Size(max = 10)
	private String firstName;

	@NotNull
	@Size(max = 10)
	private String lastName;

	@NotNull
	@Column(unique = true)
	private String cpf;

	@Email
	private String email;

	@NotNull
	private String contactOne;

	private String contactTwo;

	@Enumerated(EnumType.STRING)
	private Interest interest;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactOne() {
		return contactOne;
	}

	public void setContactOne(String contactOne) {
		this.contactOne = contactOne;
	}

	public String getContactTwo() {
		return contactTwo;
	}

	public void setContactTwo(String contactTwo) {
		this.contactTwo = contactTwo;
	}

	public Interest getInterest() {
		return interest;
	}

	public void setInterest(Interest interest) {
		this.interest = interest;
	}

}
