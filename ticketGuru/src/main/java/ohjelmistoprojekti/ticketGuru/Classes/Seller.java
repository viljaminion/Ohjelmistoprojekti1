package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Seller {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long sellerid;
	
	private String sellerfirstname;
	private String sellersurname;
	private String selleraddress;
	private String sellerphone;
	private String selleremail;
	
	@ManyToOne
	@JoinColumn(name = "transactionid")
	private Transaction transaction;

	public Seller(String sellerfirstname, String sellersurname, String selleraddress,
			PostalCode postalCode, String sellerphone, String selleremail) {
		super();
		this.sellerfirstname = sellerfirstname;
		this.sellersurname = sellersurname;
		this.selleraddress = selleraddress;
		this.postalCode = postalCode;
		this.sellerphone = sellerphone;
		this.selleremail = selleremail;
	}
	
	public Seller () {};

	public Long getSellerid() {
		return sellerid;
	}

	public void setSellerid(Long sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellerfirstname() {
		return sellerfirstname;
	}

	public void setSellerfirstname(String sellerfirstname) {
		this.sellerfirstname = sellerfirstname;
	}

	public String getSellersurname() {
		return sellersurname;
	}

	public void setSellersurname(String sellersurname) {
		this.sellersurname = sellersurname;
	}

	public String getSelleraddress() {
		return selleraddress;
	}

	public void setSelleraddress(String selleraddress) {
		this.selleraddress = selleraddress;
	}

	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	public String getSellerphone() {
		return sellerphone;
	}

	public void setSellerphone(String sellerphone) {
		this.sellerphone = sellerphone;
	}

	public String getSelleremail() {
		return selleremail;
	}

	public void setSelleremail(String selleremail) {
		this.selleremail = selleremail;
	}

	@Override
	public String toString() {
		if (this.transaction != null)
			
		return "Seller [sellerid=" + sellerid + ", sellerfirstname=" + sellerfirstname + ", sellersurname="
				+ sellersurname + ", selleraddress=" + selleraddress + ", postalCode=" + postalCode + ", sellerphone=" + sellerphone + ", selleremail=" + selleremail + ", transaction=" + transaction
				+ "]";
		
		else 
		return
				"Seller [sellerid=" + sellerid + ", sellerfirstname=" + sellerfirstname + ", sellersurname="
				+ sellersurname + ", selleraddress=" + selleraddress + ", postalCode=" + postalCode + ", sellerphone=" + sellerphone + ", selleremail=" + selleremail + "]";
	}
	
	
}
