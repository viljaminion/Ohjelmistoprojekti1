package ohjelmistoprojekti.ticketGuru.Classes;

import org.springframework.data.repository.CrudRepository;

public interface PostalCodeRepository extends CrudRepository<PostalCode, Long> {
    PostalCode findByPostalCode(String postalCode);
}
