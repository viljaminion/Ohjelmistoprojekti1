package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Payment findByPayment(String payment);
}
