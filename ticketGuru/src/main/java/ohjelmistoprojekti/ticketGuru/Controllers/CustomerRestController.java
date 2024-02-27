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

import ohjelmistoprojekti.ticketGuru.Classes.Customer;
import ohjelmistoprojekti.ticketGuru.Classes.CustomerRepository;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerRepository customerrepository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> CustomerListRest() {
        return (List<Customer>) customerrepository.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Optional<Customer> findCustomerRest(@PathVariable("id") Long customerid) {
        return customerrepository.findById(customerid);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerrepository.save(customer);

    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerid) {
        Optional<Customer> customer = customerrepository.findById(customerid);
        if (customer.isPresent()) {
            customerrepository.deleteById(customerid);
            return new ResponseEntity<>("Customer with ID " + customer + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Customer with ID " + customer + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}
