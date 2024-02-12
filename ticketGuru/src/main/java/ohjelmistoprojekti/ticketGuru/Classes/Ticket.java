package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eventid")
    private Event event;

    @ManyToOne
	@JoinColumn(name = "transactionid")
	private Transaction transaction;

    @ManyToOne
	@JoinColumn(name = "seatId")
	private Seats seat;

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction, Seats seat) {
        this.transaction = transaction;
        this.seat = seat;
    }

    public Ticket() {

    }

    public Ticket(Transaction transaction) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
