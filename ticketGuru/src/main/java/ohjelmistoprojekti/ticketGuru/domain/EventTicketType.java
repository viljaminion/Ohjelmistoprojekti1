package ohjelmistoprojekti.ticketGuru.domain;
/*package ohjelmistoprojekti.ticketGuru.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EventTicketType {

    //ONKO TÄÄ OIKEIN?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long eventtickettypeid;
    private String eventTicketType;

    @ManyToOne
	@JoinColumn(name = "eventid")
	private Event event;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public EventTicketType() {

    }

    public EventTicketType(Event event) {

    }

    public Long getId() {
        return eventtickettypeid;
    }

    public void setId(Long eventtickettypeid) {
		this.eventtickettypeid = eventtickettypeid;
    }

    public String getEventTicketType() {
        return eventTicketType;
    }

    public void setEventTicketType(String eventTicketType) {
		this.eventTicketType = eventTicketType;
    }  


}*/