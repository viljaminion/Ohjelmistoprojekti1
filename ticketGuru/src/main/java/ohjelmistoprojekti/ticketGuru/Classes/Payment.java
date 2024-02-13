package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	@Id
    private Long paymentid;
	private String payment;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Payment () {

    }

    public Payment (LocalDate date, Transaction transaction) {
        this.date = date;
        this.transaction = transaction;
    }

    public Long getId() {
        return paymentid;
    }

    public void setId(Long id) {
        this.paymentid = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}


}
