package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	Transaction findByTransactionid (Long transactionid);

}
