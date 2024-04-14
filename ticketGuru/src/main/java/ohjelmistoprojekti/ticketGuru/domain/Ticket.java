package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
    private Long ticketid;

    private LocalDateTime used;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "tickettype_id")
    private TicketType ticketType;

    // tietokantakaavion mukaan lipulla ei yhteyttä tapahtumiin

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Ticket() {

    }

    public Ticket(LocalDateTime used, Transaction transaction, TicketType ticketType) {
        this.used = used;
        this.transaction = transaction;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return ticketid;
    }

    public void setId(Long id) {
        this.ticketid = id;
    }

    public LocalDateTime getUsed() {
        return used;
    }

    public void setUsed(LocalDateTime used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Seller [ticketid=" + ticketid + ", used=" + used + ", transaction=" + transaction
                + ", ticketType=" + ticketType + "]";
    }

}
