package ohjelmistoprojekti.ticketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.Transaction;
import ohjelmistoprojekti.ticketGuru.domain.TransactionRepository;

@RestController
public class TransactionRestController {

    @Autowired
    private TransactionRepository transactionRepository;

    // JSON

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    public List<Transaction> TransactionListRest() {
        return (List<Transaction>) transactionRepository.findAll();
    }

    // Maksutapahtuman tietojen haku ID:llä

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.GET)
    public Optional<Transaction> findTransactionRest(@PathVariable("id") Long transaction_id) {
        return transactionRepository.findById(transaction_id);
    }

    // Maksutapahtuman lisääminen Postmanissa

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Transaction addTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);

    }

    // Maksutapahtuman poisto ID:llä Postmanissa

    @RequestMapping(value = "/transaction/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteTransaction(@PathVariable("id") Long transaction_id) {
        Optional<Transaction> transaction = transactionRepository.findById(transaction_id);
        if (transaction.isPresent()) {
            transactionRepository.deleteById(transaction_id);

            return new ResponseEntity<>("Transaction with ID " + transaction + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Transaction with ID " + transaction + " not found.", HttpStatus.NOT_FOUND);
        }
    }

}
