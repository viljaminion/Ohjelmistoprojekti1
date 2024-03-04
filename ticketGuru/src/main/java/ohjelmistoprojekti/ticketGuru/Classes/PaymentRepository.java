package ohjelmistoprojekti.ticketGuru.Classes;

import java.time.LocalDateTime;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Payment findByDatetime(LocalDateTime datetime);
}
