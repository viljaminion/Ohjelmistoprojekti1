package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventid;
    
    private String eventname;
    private String address;
    private LocalDateTime showtime;
    private String description;
    private int maxTickets;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "postalCode")
    private PostalCode postalCode;

    public PostalCode getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(PostalCode postalCode) {
        this.postalCode = postalCode;
    }

    public Event(String eventname, String address, LocalDateTime showtime, String description, int maxTickets, int duration, PostalCode postalCode) {
        this.eventname = eventname;
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
        return eventid;
    }

    public void setId(Long id) {
        this.eventid = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getShowtime() {
        return showtime;
    }

    public void setShowtime(LocalDateTime showtime) {
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

	@Override
	public String toString() {
		return "Event [eventid=" + eventid + ", eventname=" + eventname + ", address=" + address + ", showtime=" + showtime
				+ ", description=" + description + ", maxTickets=" + maxTickets + ", duration=" + duration
				+ ", postalCode=" + postalCode + "]";
	}

}
