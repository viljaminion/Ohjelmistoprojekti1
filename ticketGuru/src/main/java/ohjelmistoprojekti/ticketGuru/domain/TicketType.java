package ohjelmistoprojekti.ticketGuru.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "tickettype")
public class TicketType {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickettype_seq")
	@SequenceGenerator(name = "tickettype_seq", sequenceName = "tickettype_seq", allocationSize = 1)
  private Long tickettype_id;

  @NotBlank(message = "Must include a ticket type")
  private String tickettypename;

  @NotNull(message = "Price cannot be null")
  private double price;

  @OneToMany(mappedBy = "ticketType", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Ticket> tickets;

  @ManyToOne
  @JoinColumn(name = "event_id")
  private Event event;

  public TicketType() {

  }

  public Event getEvent() {
    return event;
  }

  public void setEvent(Event event) {
    this.event = event;
  }

  public TicketType(String tickettypename, double price) {
    this.tickettypename = tickettypename;
    this.price = price;
  }

  public Long getId() {
    return tickettype_id;
  }

  public void setId(Long tickettype_id) {
    this.tickettype_id = tickettype_id;
  }

  public String getTickettypename() {
    return tickettypename;
  }

  public void setTickettypename(String tickettypename) {
    this.tickettypename = tickettypename;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "TicketType [tickettype_id=" + tickettype_id + ", tickettypename=" + tickettypename + ", price=" + price + "]";
  }

  public void add(TicketType ticketType) {

  }

}