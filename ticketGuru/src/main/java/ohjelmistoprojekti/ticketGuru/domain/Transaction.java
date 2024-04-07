package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
	@SequenceGenerator(name = "transaction_seq", sequenceName = "transaction_seq", allocationSize = 1)
	private Long transactionid;

	@Past
	@NotNull(message = "Transaction must have a date")
	private LocalDate transactiondate;

	@NotNull(message = "Ticket sum cannot be null")
	private Double ticketsum;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "appuser_id")
	private AppUser user;

	@JsonIgnore
	@OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
	private List<Ticket> tickets;

	public Transaction() {

	}

	public Transaction(Long id, LocalDate transactiondate, Double ticketsum, AppUser user, List<Ticket> tickets) {
		super();
		this.transactiondate = transactiondate;
		this.ticketsum = ticketsum;
		this.user = user;
		this.tickets = tickets;
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

	public Double getTicketsum() {
		return ticketsum;
	}

	public void setTicketsum(Double ticketsum) {
		this.ticketsum = ticketsum;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiondate=" + transactiondate + ", ticketsum="
				+ ticketsum + ", seller="
				+ user + ", tickets=" + tickets + "]";
	}
}
