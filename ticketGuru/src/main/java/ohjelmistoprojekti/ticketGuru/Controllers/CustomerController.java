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

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


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
    @GetMapping("/editCustomer/{id}")
    public String editCustomer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editCustomer", customerRepository.findById(id));
        return "editCustomer";
    }

}
