package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByEventname(String eventname);
}
