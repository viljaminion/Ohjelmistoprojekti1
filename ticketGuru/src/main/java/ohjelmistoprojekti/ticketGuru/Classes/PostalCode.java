package ohjelmistoprojekti.ticketGuru.Classes;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


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

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalCode")
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalCode")
    private List<Event> events;

    //PITÄÄ TEHDÄ VIELÄ OneToMany LIPUN MYYJÄLLE

    public PostalCode(String postalCode, String district) {
        this.postalCode = postalCode;
        this.district = district;
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

    @Override
    public String toString() {
        return "PostalCode [postalCodeId=" + postalCode + ", district=" + district + "]";
    }

    
   
	
    

    
}
