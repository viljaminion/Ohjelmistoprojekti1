package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.ticketGuru.Classes.Payment;
import ohjelmistoprojekti.ticketGuru.Classes.PaymentRepository;
import ohjelmistoprojekti.ticketGuru.Classes.TransactionRepository;

public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Listanäkymä

    @RequestMapping("/paymentlist")
    public String paymentList(Model model) {
        model.addAttribute("payments", paymentRepository.findAll());
        return "paymentList";
    }

    // Lisäys

    @GetMapping("/payments/add")
    public String addPayment(Model model) {
        model.addAttribute("payment", new Payment());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "addPayment";
    }

    // Tallennus

    @PostMapping("/payments/save")
    public String savePayment(@ModelAttribute Payment payment, Model model) {
        paymentRepository.save(payment);
        return "redirect:/paymentList";
    }

    // Poisto

    @GetMapping("/payments/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
        return "redirect:/paymentList";
    }

    // Muokkaus

    @GetMapping("/editPayment/{id}")
    public String editPayment(@PathVariable("id") Long paymentid, Model model) {
        Payment payment = paymentRepository.findById(paymentid).orElse(null);

        if (payment == null) {
            return "error";
        }

        model.addAttribute("payment", payment);
        return "editPayment";
    }

}
