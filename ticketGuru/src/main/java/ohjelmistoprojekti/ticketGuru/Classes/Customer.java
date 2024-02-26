package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerid;
	
	private String firstname;
	private String surname;
	private String address;
	private String phone;
	private String email;
	
	@OneToMany
	@JoinColumn(name = "transactionid")
	private Transaction transaction;
	
	@ManyToOne
    @JoinColumn(name = "postalCode")
    private PostalCode postalCode;
	
	public Customer(String firstname, String surname, String address, PostalCode postalCode, String phone,
			String email) {
		super();
		this.firstname = firstname;
		this.surname = surname;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.email = email;
	}
	
	public Customer () {};
	
	public Customer(Long id) {
		super();
		this.customerid = id;
	}

	public Long getId() {
		return customerid;
	}
	public void setId(Long id) {
		this.customerid = id;
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
	public PostalCode getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
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
		
		if (this.transaction != null)
		
		return "Customer [id=" + customerid + ", firstname=" + firstname + ", surname=" + surname + ", address=" + address
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", email=" + email + ", transaction=" + transaction
				+ "]";
		else
		return "Customer [id=" + customerid + ", firstname=" + firstname + ", surname=" + surname + ", address=" + address
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	
	
}
