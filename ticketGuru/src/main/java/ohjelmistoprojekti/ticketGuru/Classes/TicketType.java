package ohjelmistoprojekti.ticketGuru.Classes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class TicketType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long tickettypeid;

    private String tickettype;
    private String description;
    private double price;

    //LIPPUTYYPPI TÄHÄN

    @OneToMany
	(cascade = CascadeType.ALL, mappedBy = "ticket")
	private List<Ticket>tickets;

    public TicketType(){

    }

    public Long getId() {
        return tickettypeid;
    }

    public void setId(Long tickettypeid) {
		this.tickettypeid = tickettypeid;
    }

    public String getTickettype() {
        return tickettype;
    }

    public void setTickettype(String tickettype) {
		this.tickettype = tickettype;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
		this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
		this.price = price;
    }

    public List<Ticket> getTickets() {
		return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
    }

    @Override
		public String toString(){
            return "TicketType [tickettypeid=" + tickettypeid + ", tickettype=" + tickettype + ", description=" + description + ",price=" + price + "]";
        }

}