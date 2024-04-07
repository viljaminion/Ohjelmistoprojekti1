package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDate;
// import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionid;

	@Past
	@NotNull(message = "Transaction must have a date")
	private LocalDate transactiondate;

	@NotNull(message = "Ticket sum cannot be null")
	private Double ticketSum;

	@ManyToOne
	@JsonIgnore
	private AppUser user;

	@OneToMany
	private List<Ticket> tickets;

	public Transaction() {

	}

	public Transaction(Long id, LocalDate transactiondate, Double ticketSum, AppUser user, List<Ticket> tickets) {
		super();
		this.transactiondate = transactiondate;
		this.ticketSum = ticketSum;
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

	public Double getTicketSum() {
		return ticketSum;
	}

	public void setTicketSum(Double ticketSum) {
		this.ticketSum = ticketSum;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiondate=" + transactiondate + ", ticketSum="
				+ ticketSum + ", seller="
				+ user + ", tickets=" + tickets + "]";
	}
}
