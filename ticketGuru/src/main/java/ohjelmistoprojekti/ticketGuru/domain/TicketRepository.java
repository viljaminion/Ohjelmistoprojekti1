package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    @Query("SELECT t FROM Ticket t WHERE t.ticket_id = ?1")
    Ticket findByTicketId(Long ticketId);
}