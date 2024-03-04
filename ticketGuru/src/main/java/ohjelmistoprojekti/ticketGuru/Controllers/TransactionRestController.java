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

import ohjelmistoprojekti.ticketGuru.Classes.Transaction;
import ohjelmistoprojekti.ticketGuru.Classes.TransactionRepository;


@RestController
public class TransactionRestController {
	
	@Autowired
    private TransactionRepository transactionrepository;

	
//Kaikki tiedot JSON-muodossa
	
	
    @RequestMapping(value="/transactions", method = RequestMethod.GET)
    public List<Transaction> TransactionListRest() {	
        return (List<Transaction>) transactionrepository.findAll();
    }    

//ID:n avulla haettavat tiedot tietystä maksutapahtumasta
    
    @RequestMapping(value="/transaction/{id}", method = RequestMethod.GET)
    public Optional<Transaction> findTransactionRest(@PathVariable("id") Long transactionid) {	
    	return transactionrepository.findById(transactionid);
    }
    
//Maksutapahtuman lisääminen Postmanissa
    
    @RequestMapping (value= "/addtransaction", method = RequestMethod.POST)
    public Transaction addTransaction(@RequestBody Transaction transaction) {
         return transactionrepository.save(transaction);
            
}
    
//Maksutapahtuman poisto ID:llä Postmanissa
    
    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transactionid) {
        Optional<Transaction> transaction = transactionrepository.findById(transactionid);
        if (transaction.isPresent()) {
            transactionrepository.deleteById(transactionid);
            return new ResponseEntity<>("Transaction with ID " + transaction + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction with ID " + transaction + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
