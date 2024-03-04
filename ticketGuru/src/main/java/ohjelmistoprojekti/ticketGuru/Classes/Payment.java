package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentid;
    private String payment;
    private LocalDateTime datetime;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Payment() {

    }

    public Payment(LocalDateTime datetime, Transaction transaction) {
        this.datetime = datetime;
        this.transaction = transaction;
    }

    public Long getId() {
        return paymentid;
    }

    public void setId(Long id) {
        this.paymentid = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDateTime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Payment [paymentid=" + paymentid + ",  datetime=" + datetime + ", transaction=" + transaction + "]";
    }

}
