package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.repository.CrudRepository;

public interface TicketTypeRepository extends CrudRepository<TicketType, Long> {
    TicketType findByTickettypename(String tickettypename);
}