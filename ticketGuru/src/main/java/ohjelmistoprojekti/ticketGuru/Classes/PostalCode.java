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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String zipcode;

    private String district;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalcode")
    private List<Customer> customers;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postalcode")
    private List<Event> events;

    //PITÄÄ TEHDÄ VIELÄ OneToMany LIPUN MYYJÄLLE

    public PostalCode(String zipcode, String district) {
        this.zipcode = zipcode;
        this.district = district;
    }

    public PostalCode () {

    }

    public String getZipId() {
        return zipcode;
    }

    public void setZipId(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "PostalCode [zipId=" + zipcode + ", district=" + district + "]";
    }

    
   
	
    

    
}
