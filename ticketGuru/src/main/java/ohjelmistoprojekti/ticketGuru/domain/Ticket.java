package ohjelmistoprojekti.ticketGuru.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
	@SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
    private Long ticketid;

    @NotBlank(message = "Ticket number cannot be blank")
    @Size(min = 1, message = "Ticket number should not be less than 1")
    @Size(max = 999999, message = "Ticket number should not be greater than 999999")
    private String ticketnumber;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "tickettype_id")
    private TicketType ticketType;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventid")
    private Event event;

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

    public Ticket(String ticketnumber, Transaction transaction, TicketType ticketType) {
        this.ticketnumber = ticketnumber;
        this.transaction = transaction;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return ticketid;
    }

    public void setId(Long id) {
        this.ticketid = id;
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber;
    }

    @Override
    public String toString() {
        return "Seller [ticketid=" + ticketid + ",  ticketnumber=" + ticketnumber + ", transaction=" + transaction
                + ", ticketType=" + ticketType + "]";
    }

}
