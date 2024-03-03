package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.ticketGuru.Classes.CustomerRepository;
import ohjelmistoprojekti.ticketGuru.Classes.SellerRepository;
import ohjelmistoprojekti.ticketGuru.Classes.Transaction;
import ohjelmistoprojekti.ticketGuru.Classes.TransactionRepository;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private CustomerRepository customerRepository;


    
    // näkymä

    @RequestMapping("/transactionlist")
    public String transactionList(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transactionlist";
    }

    // lisäys

    @GetMapping("/transactions/add")
    public String addTransaction(Model model) {
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("transactions", customerRepository.findAll());
        model.addAttribute("transactions", sellerRepository.findAll());
        return "addTransaction";
    }

    // tallennus

    @PostMapping("/transactions/save")
    public String saveTransaction(@ModelAttribute Transaction transaction, Model model) {
        transactionRepository.save(transaction);
        return "redirect:/transactionlist";
    }

    // muokkaus

    @GetMapping("/editTransaction/{id}")
    public String editTransaction(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editTransaction", transactionRepository.findById(id));
        return "editTransaction";
    }

    // poisto

    @GetMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
        return "redirect:/transactionlist";
    }

}
