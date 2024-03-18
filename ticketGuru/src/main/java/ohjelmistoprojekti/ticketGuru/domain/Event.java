package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;


@Entity
public class Event {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventId;
    
    @NotBlank(message = "Event name cannot be blank")
    @Size(min = 2, message = "Event name cannot be less than 2 letters")
    private String eventname;

    @NotBlank(message = "Address cannot be blank")
    @Size(min = 2, message = "Address cannot be less than 2 letters")
    private String address;

    @NotNull(message = "Showtime cannot be null")
    private LocalDateTime showtime;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @Min(value =1, message = "maxTickets cannot be less than 1")
    @Max(10000)
    private int maxTickets;

    @Min(value =1, message = "Duration cannot be less than 1")
    @Max(500)
    private int duration;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes = new ArrayList<>();

	public List<TicketType> getTicketTypes() {
		return ticketTypes;
	}

	public void setTicketTypes(List<TicketType> ticketTypes) {
		this.ticketTypes = ticketTypes;
	}

	public Event(String eventname, String address, LocalDateTime showtime, String description, int maxTickets, int duration) {
        this.eventname = eventname;
        this.address = address;
        this.showtime = showtime;
        this.description = description;
        this.maxTickets = maxTickets;
        this.duration = duration;
        
    }

    public Event () {

    }

    public Long getId() {
        return eventId;
    }

    public void setId(Long eventId) {
        this.eventId = eventId;
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
		return "Event [eventId=" + eventId + ", eventname=" + eventname + ", address=" + address + ", showtime=" + showtime
				+ ", description=" + description + ", maxTickets=" + maxTickets + ", duration=" + duration
				+ "]";
	}

}
