package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String event;
    private String address;
    private LocalDate showtime;
    private String description;
    private int maxTickets;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "zipcodeid")
    private PostalCode postalCode;

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Event(String event, String address, LocalDate showtime, String description, int maxTickets, int duration, PostalCode postalCode) {
        this.event = event;
        this.address = address;
        this.showtime = showtime;
        this.description = description;
        this.maxTickets = maxTickets;
        this.duration = duration;
        this.postalCode = postalCode;
    }

    public Event () {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getShowtime() {
        return showtime;
    }

    public void setShowtime(LocalDate showtime) {
        this.showtime = showtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(int maxTickets) {
        this.maxTickets = maxTickets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
