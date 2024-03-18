package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
	private Seller seller;

	@ManyToOne
	private Ticket ticket;

	public Transaction() {

	}

	public Transaction(Long id, LocalDate transactiondate, Double ticketSum, Seller seller, Ticket ticket) {
		super();
		this.transactiondate = transactiondate;
		this.ticketSum = ticketSum;
		this.seller = seller;
		this.ticket = ticket;

	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket tickets) {
		this.ticket = tickets;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", transactiondate=" + transactiondate + ", ticketSum="
				+ ticketSum + ", seller="
				+ seller + ", ticket=" + ticket + "]";
	}

}
