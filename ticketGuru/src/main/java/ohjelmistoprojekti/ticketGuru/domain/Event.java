package ohjelmistoprojekti.ticketGuru.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "event_seq", allocationSize = 1)
    private Long event_id;

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

    @Min(value = 1, message = "maxtickets cannot be less than 1")
    @Max(10000)
    private int maxtickets;

    @Min(value = 1, message = "Duration cannot be less than 1")
    @Max(500)
    private int duration;

    @JsonIgnore
    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<TicketType> ticketTypes = new ArrayList<>();

    public List<TicketType> getTicketTypes() {
        return ticketTypes;
    }

    public void setTicketTypes(List<TicketType> ticketTypes) {
        this.ticketTypes = ticketTypes;
    }

    public Event(String eventname, String address, LocalDateTime showtime, String description, int maxtickets,
            int duration) {
        this.eventname = eventname;
        this.address = address;
        this.showtime = showtime;
        this.description = description;
        this.maxtickets = maxtickets;
        this.duration = duration;

    }

    public Event() {

    }

    public Long getId() {
        return event_id;
    }

    public void setId(Long event_id) {
        this.event_id = event_id;
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

    public int getMaxtickets() {
        return maxtickets;
    }

    public void setMaxtickets(int maxtickets) {
        this.maxtickets = maxtickets;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Event [event_id=" + event_id + ", eventname=" + eventname + ", address=" + address + ", showtime="
                + showtime
                + ", description=" + description + ", maxtickets=" + maxtickets + ", duration=" + duration
                + "]";
    }

}
