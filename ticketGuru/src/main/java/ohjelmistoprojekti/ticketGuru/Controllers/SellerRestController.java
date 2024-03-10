package ohjelmistoprojekti.ticketGuru.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.Classes.Seller;
import ohjelmistoprojekti.ticketGuru.Classes.SellerRepository;


@RestController
public class SellerRestController {
	
	@Autowired
    private SellerRepository sellerrepository;

	
//Kaikki tiedot JSON-muodossa
	
	
    @RequestMapping(value="/sellers", method = RequestMethod.GET)
    public List<Seller> SellerListRest() {	
        return (List<Seller>) sellerrepository.findAll();
    }    

//ID:n avulla haettavat tiedot tietystä myyjästä
    
    @RequestMapping(value="/seller/{id}", method = RequestMethod.GET)
    public Optional<Seller> findSellerRest(@PathVariable("id") Long sellerid) {	
    	return sellerrepository.findById(sellerid);
    }
    
//Myyjän lisääminen Postmanissa
    
//@Valid annotaatio ennen @RequestBody annotaatiota mahdollistaa validoinnin

    @RequestMapping (value= "/sellers", method = RequestMethod.POST)
    public Seller addSeller(@Valid @RequestBody Seller seller) {
         return sellerrepository.save(seller);
            
}
    
//Myyjän poisto ID:llä Postmanissa
    
    @RequestMapping(value = "/seller/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteSeller(@PathVariable("id") Long sellerid) {
        Optional<Seller> seller = sellerrepository.findById(sellerid);
        if (seller.isPresent()) {
            sellerrepository.deleteById(sellerid);
            return new ResponseEntity<>("Seller with ID " + seller + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Seller with ID " + seller + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}