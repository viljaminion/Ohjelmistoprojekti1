package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.transaction_id = ?1")
    Transaction findByTransactionId(Long transactionId);
}
