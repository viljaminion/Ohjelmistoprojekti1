package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
    Ticket findByTicketid(Long ticket_id);
}