package ohjelmistoprojekti.ticketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.TicketType;
import ohjelmistoprojekti.ticketGuru.domain.TicketTypeRepository;

@RestController
public class TicketTypeRestController {

    @Autowired
    private TicketTypeRepository tickettyperepository;

    // JSON

    @RequestMapping(value = "/tickettypes", method = RequestMethod.GET)
    public List<TicketType> TicketTtypeListRest() {
        return (List<TicketType>) tickettyperepository.findAll();
    }

    // Tiedot lipputyypistä

    @RequestMapping(value = "/tickettype/{id}", method = RequestMethod.GET)
    public Optional<TicketType> findTicketTypeRest(@PathVariable("id") Long tickettypeid) {
        return tickettyperepository.findById(tickettypeid);
    }

    // Lisäys

    @RequestMapping(value = "/tickettypes", method = RequestMethod.POST)
    public TicketType addTicketType(@Valid @RequestBody TicketType ticketType) {
        return tickettyperepository.save(ticketType);
    }

    // Poisto

    @RequestMapping(value = "/tickettype/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTicketType(@PathVariable("id") Long tickettypeid) {
        Optional<TicketType> ticketType = tickettyperepository.findById(tickettypeid);
        if (ticketType.isPresent()) {
            tickettyperepository.deleteById(tickettypeid);
            return new ResponseEntity<>("Ticket type with ID " + ticketType + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Ticket type with ID " + ticketType + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
