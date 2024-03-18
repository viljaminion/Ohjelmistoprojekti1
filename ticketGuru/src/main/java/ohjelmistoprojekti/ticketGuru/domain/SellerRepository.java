package ohjelmistoprojekti.ticketGuru.domain;

import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
	Seller findBySellerid (Long sellerid);

}
