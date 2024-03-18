package ohjelmistoprojekti.ticketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.SellerRepository;
import ohjelmistoprojekti.ticketGuru.domain.TicketRepository;
import ohjelmistoprojekti.ticketGuru.domain.Transaction;
import ohjelmistoprojekti.ticketGuru.domain.TransactionRepository;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired 
    private TicketRepository ticketRepository;

    
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
        model.addAttribute("transactions", sellerRepository.findAll());
        model.addAttribute("tickets", ticketRepository.findAll());
        return "addTransaction";
    }

    // tallennus

    @PostMapping("/transactions/save")
    public String saveTransaction(@Valid @ModelAttribute Transaction transaction, Model model) {
        transactionRepository.save(transaction);
        return "redirect:/transactionlist";
    }

    // muokkaus

    @GetMapping("/transactions/edit/{id}")
    public String editTransaction(@PathVariable("id") Long transactionid, Model model) {
    	
        Transaction existingTransaction = transactionRepository.findById(transactionid).orElse(null);
        
        if (existingTransaction != null) {
            model.addAttribute("transaction", existingTransaction);
            model.addAttribute("seller", sellerRepository.findAll());
            model.addAttribute("tickets", ticketRepository.findAll());
       
            return "editTransaction";
        } else {
            return "error";
        }
    }
    
    // muokkauksen tallennus
    @PostMapping("/transaction/edit/{id}")
    public String updateTransaction(@PathVariable("id") Long transactionid, @ModelAttribute Transaction updatedTransaction) {
        Transaction existingTransaction = transactionRepository.findById(transactionid).orElse(null);
        
        if (existingTransaction != null) {
            existingTransaction.setTransactiondate(updatedTransaction.getTransactiondate());
            existingTransaction.setSeller(updatedTransaction.getSeller());

            
            transactionRepository.save(existingTransaction);
        }
        return "redirect:/transactionlist";
    }

    // poisto

    @GetMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
        return "redirect:/transactionlist";
    }

}
