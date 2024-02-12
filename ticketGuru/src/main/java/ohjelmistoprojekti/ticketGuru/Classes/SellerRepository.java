package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

public interface SellerRepository extends CrudRepository<Seller, Long> {
	Seller findBySeller (String seller);

}