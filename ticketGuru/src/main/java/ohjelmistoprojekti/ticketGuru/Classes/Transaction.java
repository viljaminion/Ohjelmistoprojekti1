package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;

	private LocalDate transactiondate;


	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerid")
	private List<Seller> sellers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticketid")
	private List<Ticket> tickets;

	public Transaction() {

	}

	public Transaction(Long id, LocalDate transactiondate, List<Seller> sellers, Ticket ticket) {
		super();
		this.transactiondate = transactiondate;

	}


	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
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
