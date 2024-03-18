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
import ohjelmistoprojekti.ticketGuru.domain.Ticket;
import ohjelmistoprojekti.ticketGuru.domain.TicketRepository;
import ohjelmistoprojekti.ticketGuru.domain.TicketTypeRepository;
import ohjelmistoprojekti.ticketGuru.domain.TransactionRepository;

@Controller
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    // Listanäkymä

    @RequestMapping("/ticketlist")
    public String ticketList(Model model) {
        model.addAttribute("tickets", ticketRepository.findAll());
        return "ticketlist";
    }

    // Lisäys

    @GetMapping("/tickets/add")
    public String addTicket(Model model) {
        model.addAttribute("ticket", new Ticket());
        model.addAttribute("transactions", transactionRepository.findAll());
        model.addAttribute("ticketTypes", ticketTypeRepository.findAll());
        return "addticket";
    }

    // Tallennus

    @PostMapping("/tickets/save")
    public String saveTicket(@Valid @ModelAttribute Ticket ticket, Model model) {
        ticketRepository.save(ticket);
        return "redirect:/ticketlist";
    }

    // Poisto

    @GetMapping("/tickets/delete/{id}")
    public String deleteTicket(@PathVariable Long id) {
        ticketRepository.deleteById(id);
        return "redirect:/ticketlist";
    }

    // Muokkaus

    @GetMapping("/tickets/edit/{id}")
    public String editTicket(@PathVariable("id") Long ticketid, Model model) {
        Ticket ticket = ticketRepository.findById(ticketid).orElse(null);

        if (ticket == null) {
            return "error";
        }

        model.addAttribute("ticket", ticket);
        return "editTicket";
    }
}
