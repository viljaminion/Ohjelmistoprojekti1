package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

public interface SeatsRepository extends CrudRepository<Seats, Long> {
    Seats findByTicketType(String seats);
}
