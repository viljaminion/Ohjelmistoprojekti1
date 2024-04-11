package ohjelmistoprojekti.ticketGuru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
    private Long ticket_id;

    @NotBlank(message = "Ticket number cannot be blank")
    private String ticketnumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "tickettype_id")
    private TicketType ticketType;

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

    public Ticket(String ticketnumber, Transaction transaction, TicketType ticketType) {
        this.ticketnumber = ticketnumber;
        this.transaction = transaction;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return ticket_id;
    }

    public void setId(Long id) {
        this.ticket_id = id;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    @Override
    public String toString() {
        return "Seller [ticketid=" + ticket_id + ",  ticketnumber=" + ticketnumber + ", transaction=" + transaction
                + ", ticketType=" + ticketType + "]";
    }

}
