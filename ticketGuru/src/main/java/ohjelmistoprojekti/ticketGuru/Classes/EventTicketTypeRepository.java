package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

//ONKO TÄÄ OIKEIN?

public interface EventTicketTypeRepository extends CrudRepository<EventTicketType, Long> {
    TicketType findByEventTicketType(String eventTicketType);
}