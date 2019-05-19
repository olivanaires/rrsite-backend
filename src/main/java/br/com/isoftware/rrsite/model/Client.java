package br.com.isoftware.rrsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;

import br.com.isoftware.rrsite.model.enums.Interest;
import br.com.isoftware.rrsite.model.vo.SignUpRequestVO;

/**
 * Created by @author olivanaires on 17/05/2019.
 */
@Audited
@Entity
@Table(name="clients")
public class Client extends BaseModel {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(max = 10)
	private String firstName;

	@NotNull
	@Size(max = 10)
	private String lastName;

	@Size(max = 11)
	@Column(unique = true)
	private String cpf;

	@Email
	private String email;

	@NotNull
	@Size(max = 11)
	private String contactOne;

	@Size(max = 11)
	private String contactTwo;

	@Enumerated(EnumType.STRING)
	private Interest interest;

	public Client() {
	}

	/**
	 * @param signUpRequest
	 */
	public Client(@Valid SignUpRequestVO signUpRequest) {
		this.firstName = signUpRequest.getFirstName();
		this.lastName = signUpRequest.getLastName();
		this.cpf = signUpRequest.getCpf();
		this.email = signUpRequest.getEmail();
		this.contactOne = signUpRequest.getContactOne();
		this.contactTwo = signUpRequest.getContactTwo();
	}

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
