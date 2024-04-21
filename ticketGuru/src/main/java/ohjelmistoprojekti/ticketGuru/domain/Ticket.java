package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
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
    private Long ticket_id;

    @Column(unique = true)
    private UUID ticketcode = UUID.randomUUID();

    private LocalDateTime used;

    @ManyToOne
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

    public Ticket(LocalDateTime used, Transaction transaction, TicketType ticketType) {
        this.used = used;
        this.transaction = transaction;
        this.ticketType = ticketType;
    }

    public Long getId() {
        return ticket_id;
    }

    public void setId(Long id) {
        this.ticket_id = id;
    }

    public UUID getTicketcode() {
        return ticketcode;
    }

    public void setTicketcode(UUID ticketcode) {
        this.ticketcode = ticketcode;
    }

    public LocalDateTime getUsed() {
        return used;
    }

    public void setUsed(LocalDateTime used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Seller [ticket_id=" + ticket_id + ", used=" + used + ", transaction=" + transaction
                + ", ticketType=" + ticketType + "]";
    }

}
