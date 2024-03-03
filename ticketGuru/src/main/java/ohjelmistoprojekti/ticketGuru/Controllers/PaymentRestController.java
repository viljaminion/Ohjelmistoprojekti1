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

import ohjelmistoprojekti.ticketGuru.Classes.Payment;
import ohjelmistoprojekti.ticketGuru.Classes.PaymentRepository;

public class PaymentRestController {

    @Autowired
    private PaymentRepository paymentRepository;

    // JSON

    @RequestMapping(value = "/payments", method = RequestMethod.GET)
    public List<Payment> PaymentListRest() {
        return (List<Payment>) paymentRepository.findAll();
    }

    // Tiedot maksutapahtumasta

    @RequestMapping(value = "/payment/{id}", method = RequestMethod.GET)
    public Optional<Payment> findPaymentRest(@PathVariable("id") Long paymentid) {
        return paymentRepository.findById(paymentid);
    }

    // Lisäys

    @RequestMapping(value = "/addpayment", method = RequestMethod.POST)
    public Payment addPayment(@RequestBody Payment payment) {
        return paymentRepository.save(payment);

    }

    // Poisto

    @RequestMapping(value = "/payment/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePayment(@PathVariable("id") Long paymentid) {
        Optional<Payment> payment = paymentRepository.findById(paymentid);
        if (payment.isPresent()) {
            paymentRepository.deleteById(paymentid);
            return new ResponseEntity<>("Payment with ID " + payment + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Payment with ID " + payment + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
