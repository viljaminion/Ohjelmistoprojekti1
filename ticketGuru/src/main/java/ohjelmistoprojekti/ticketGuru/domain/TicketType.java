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
import jakarta.validation.constraints.NotNull;

@Entity(name = "tickettype")
public class TicketType {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickettype_seq")
	@SequenceGenerator(name = "tickettype_seq", sequenceName = "tickettype_seq", allocationSize = 1)
  private Long tickettype_id;

  @NotBlank(message = "Must include a ticket type")
  private String ticketTypeName;

  @NotNull(message = "Price cannot be null")
  private double price;

  @ManyToOne
  @JsonIgnore
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

  public TicketType(String ticketTypeName, double price) {
    this.ticketTypeName = ticketTypeName;
    this.price = price;
  }

  public Long getId() {
    return tickettype_id;
  }

  public void setId(Long tickettype_id) {
    this.tickettype_id = tickettype_id;
  }

  public String getTicketTypeName() {
    return ticketTypeName;
  }

  public void setTicketTypeName(String ticketTypeName) {
    this.ticketTypeName = ticketTypeName;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "TicketType [tickettype_id=" + tickettype_id + ", ticketTypeName=" + ticketTypeName + ", price=" + price + "]";
  }

  public void add(TicketType ticketType) {

  }

}