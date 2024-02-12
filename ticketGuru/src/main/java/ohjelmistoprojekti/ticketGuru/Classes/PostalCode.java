package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class PostalCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long zipcode;

    private String district;

    public Long getZipId() {
        return zipcode;
    }

    public void setZipId(Long zipId) {
        this.zipcode = zipId;
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
