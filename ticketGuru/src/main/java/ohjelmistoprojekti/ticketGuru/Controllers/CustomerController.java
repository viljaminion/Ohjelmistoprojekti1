package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.ticketGuru.Classes.Customer;
import ohjelmistoprojekti.ticketGuru.Classes.CustomerRepository;
import ohjelmistoprojekti.ticketGuru.Classes.PostalCodeRepository;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    // asiakkaan tiedot ???? EN TIEDÄ ONKO OIKEIN
    @RequestMapping("/customerlist")
    public String customerList(Model model) {
        model.addAttribute("customers", customerRepository.findAll());
        return "customerlist";
    }

    // asiakkaan lisäys
    @GetMapping("/customers/add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("postalCodes", postalCodeRepository.findAll());
        return "addCustomer";
    }

    // asiakkaan tallennus
    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute Customer customer, Model model) {
        customerRepository.save(customer);
        return "redirect:/customerlist";
    }

    // asiakkaan poisto 
    @GetMapping("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable Long customerid) {
        customerRepository.deleteById(customerid);
        return "redirect:/customerlist";
    }
    

    // asiakkaan muokkaus
    @GetMapping("/customers/edit/{id}")
    public String editCustomer(@PathVariable("id") Long customerid, Model model) {

        Customer existingCustomer = customerRepository.findById(customerid).orElse(null);

        if (existingCustomer != null) {
            model.addAttribute("customer", existingCustomer);
            model.addAttribute("postalCode", postalCodeRepository.findAll());
            return "editCustomer";
        } else {
            return "error";
        }
        
    }

    // muokatun asiakkaan tallennus

    @PostMapping("/customers/edit/{id}")
    public String updateCustomer(@PathVariable("id") Long customerid, @ModelAttribute Customer updatedCustomer) {
        Customer existingCustomer = customerRepository.findById(customerid).orElse(null);

        if(existingCustomer != null) {
            existingCustomer.setFirstname(updatedCustomer.getFirstname());
            existingCustomer.setSurname(updatedCustomer.getSurname());
            existingCustomer.setAddress(updatedCustomer.getAddress());
            existingCustomer.setPhone(updatedCustomer.getPhone());
            existingCustomer.setEmail(updatedCustomer.getEmail());

            customerRepository.save(existingCustomer);
        }
        return "redirect:/customerlist";
    }
}
