package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.ticketGuru.Classes.Seller;
import ohjelmistoprojekti.ticketGuru.Classes.SellerRepository;
import ohjelmistoprojekti.ticketGuru.Classes.TransactionRepository;

@Controller
public class SellerController {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/sellerlist")
    public String sellerList(Model model) {
        model.addAttribute("sellers", sellerRepository.findAll());
        return "sellerlist";
    }

    @GetMapping("/sellers/add")
    public String addSeller(Model model) {
        model.addAttribute("seller", new Seller());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "addSeller";
    }

    @PostMapping("/sellers/save")
    public String saveSeller(@ModelAttribute Seller seller, Model model) {
        sellerRepository.save(seller);
        return "redirect:/sellerlist";
    }

    @GetMapping("/editSeller/{id}")
    public String editSeller(@PathVariable("id") Long id, Model model) {
        model.addAttribute("editSeller", sellerRepository.findById(id));
        return "editSeller";
    }

    @GetMapping("/sellers/delete/{id}")
    public String deleteSeller(@PathVariable Long id) {
        sellerRepository.deleteById(id);
        return "redirect:/sellerlist";
    }

}