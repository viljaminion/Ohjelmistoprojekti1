package ohjelmistoprojekti.ticketGuru.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
public class TicketType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long ticketTypeId;
  
  @NotBlank(message = "Must include a ticket type")
  private String ticketTypeName;

  @NotNull(message = "Price cannot be null")
  private double price;

  @ManyToOne
  @JsonIgnore
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
    return ticketTypeId;
  }

  public void setId(Long ticketTypeId) {
    this.ticketTypeId = ticketTypeId;
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
    return "TicketType [ticketTypeId=" + ticketTypeId + ", ticketTypeName=" + ticketTypeName + ", price=" + price + "]";
  }

public void add(TicketType ticketType) {
	
	
}

}