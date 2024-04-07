package ohjelmistoprojekti.ticketGuru.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity(name = "appuser")
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appuser_seq")
	@SequenceGenerator(name = "appuser_seq", sequenceName = "appuser_seq", allocationSize = 1)
	private Long id;
	
	@NotBlank(message = "Username cannot be blank")
	private String username;
	
	@NotBlank(message = "Password cannot be blank")
	private String passwordhash;
	
	@NotBlank(message = "Role cannot be blank")
	private String role;

	@NotBlank(message = "First name cannot be blank")
	private String firstname;

	@NotBlank(message = "Surname name cannot be blank")
	private String surname;

	@NotBlank(message = "Address cannot be blank")
	private String address;

	@NotBlank(message = "Phone cannot be blank")
	private String phone;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Email must be valid")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
	@JsonIgnore
	private List<Transaction> transactions = new ArrayList<>();

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public AppUser() {

	}

	public AppUser(String username, String passwordhash, String role, String firstname, String surname, String address, String phone,
	String email) {
		this.username = username;
		this.passwordhash = passwordhash;
		this.role = role;
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordhash() {
		return passwordhash;
	}

	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		if (this.transactions != null)

			return "User [id=" + id + ", username=" + username + ", passwordhash=" + passwordhash + ", role=" + role + ", firstname=" + firstname + ", surname="
					+ surname + ", useraddress=" + address + ", userphone=" + phone
					+ ", useremail=" + email + ", transactions=" + transactions
					+ "]";

		else
			return "User [id=" + id + ", username=" + username + ", passwordhash=" + passwordhash + ", role=" + role + ", firstname=" + firstname + ", usersurname="
					+ surname + ", address=" + address + ", phone=" + phone
					+ ", email=" + email + ", transactions= " + transactions + "]";
	}
}