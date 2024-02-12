package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seatId;

    private String seatNumber;


    // Tarvii vielä viittauksen "Ticket"-luokkaan

    public Seats(Long seatId, String seatNumber) {
        this.seatId = seatId;
        this.seatNumber = seatNumber;
    }

    public Seats() {
    };

    public Long getSeatId() {
        return seatId;
    }

    public void setSeatId(Long seatId) {
        this.seatId = seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public String toString() {
        return "Seats [seatId=" + seatId + ", seatNumber=" + seatNumber + "]";
    }

}
