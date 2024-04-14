package ohjelmistoprojekti.ticketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.Ticket;
import ohjelmistoprojekti.ticketGuru.domain.TicketRepository;

@CrossOrigin
@RestController
public class TicketRestController {

    @Autowired
    private TicketRepository ticketRepository;

    // JSON

    @RequestMapping(value = "/tickets", method = RequestMethod.GET)
    public List<Ticket> TicketListRest() {
        return (List<Ticket>) ticketRepository.findAll();
    }

    // Tiedot lipusta

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.GET)
    public Optional<Ticket> findTicketRest(@PathVariable("id") Long ticketid) {
        return ticketRepository.findById(ticketid);
    }

    // Lisäys

    @RequestMapping(value = "/tickets", method = RequestMethod.POST)
    public Ticket addTicket(@Valid @RequestBody Ticket ticket) {
        return ticketRepository.save(ticket);

    }

    // Poisto

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTicket(@PathVariable("id") Long ticketid) {
        Optional<Ticket> ticket = ticketRepository.findById(ticketid);
        if (ticket.isPresent()) {
            ticketRepository.deleteById(ticketid);
            return new ResponseEntity<>("Ticket with ID " + ticket + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket with ID " + ticket + " not found.", HttpStatus.NOT_FOUND);
        }
    }

    // Päivitys

    @RequestMapping(value = "/tickets/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<?> updateTicket(@PathVariable("id") Long ticketId, @Valid @RequestBody Ticket updatedTicket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setUsed(updatedTicket.getUsed());
            // Update ticket properties with values from updatedTicket
            // Example: ticket.setName(updatedTicket.getName());
            // Example: ticket.setPrice(updatedTicket.getPrice());
            
            // Save the updated ticket
            ticketRepository.save(ticket);
            
            return ResponseEntity.ok().body("Ticket with ID " + ticketId + " has been updated.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
