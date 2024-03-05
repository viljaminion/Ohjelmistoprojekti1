package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;

	private LocalDate transactiondate;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customerid")
	private List<Customer> customers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerid")
	private List<Seller> sellers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketid")
	private Ticket ticket;

	public Transaction() {

	}

	public Transaction(Long id, LocalDate transactiondate, List<Customer> customers, List<Seller> sellers, Ticket ticket) {
		super();
		this.transactiondate = transactiondate;

	}

	public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

	public Long getId() {
		return transactionid;
	}

	public void setId(Long transactionid) {
		this.transactionid = transactionid;
	}

	public LocalDate getTransactiondate() {
		return transactiondate;
	}

	public void setTransactiondate(LocalDate transactiondate) {
		this.transactiondate = transactiondate;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Seller> getSellers() {
		return sellers;
	}

	public void setSellers(List<Seller> sellers) {
		this.sellers = sellers;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiondate=" + transactiondate + "]";
	}

}
