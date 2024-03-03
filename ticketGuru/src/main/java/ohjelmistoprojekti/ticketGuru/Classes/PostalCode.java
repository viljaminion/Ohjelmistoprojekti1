package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;



@Entity
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String postalCode;

    private String district;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name= "event")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "seller")
    private Seller seller;

    //PITÄÄ TEHDÄ VIELÄ OneToMany LIPUN MYYJÄLLE

    public PostalCode(String postalCode, String district, Customer customer, Event event, Seller seller) {
        this.postalCode = postalCode;
        this.district = district;
        this.customer = customer;
        this.event = event;
        this.seller = seller;
    }

    public PostalCode () {

    }

    public String getPostalCodeId() {
        return postalCode;
    }

    public void setPostalCodeId(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomers(Customer customer) {
        this.customer = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSellers(Seller seller) {
        this.seller = seller;
    }

    @Override
    public String toString() {
        return "PostalCode [postalCodeId=" + postalCode + ", district=" + district + "]";
    }

    

    
   
	
    

    
}
