package ohjelmistoprojekti.ticketGuru.web;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.Event;
import ohjelmistoprojekti.ticketGuru.domain.EventRepository;
import ohjelmistoprojekti.ticketGuru.domain.Ticket;
import ohjelmistoprojekti.ticketGuru.domain.TicketRepository;
import ohjelmistoprojekti.ticketGuru.domain.TicketType;
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

    @Autowired
    private EventRepository eventRepository;

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
        model.addAttribute("ticketTypes", ticketTypeRepository.findAll());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "addticket";
    }

    // Tallennus

    @PostMapping("/tickets/save")
    public String saveTickets(@RequestParam("eventId") Long eventId,
            @RequestParam("ticketTypeIds") List<Long> ticketTypeIds,
            @RequestParam("ticketQuantities") List<Integer> ticketQuantities) {
        Event event = eventRepository.findById(eventId).orElse(null);
        if (event != null) {
            for (int i = 0; i < ticketTypeIds.size(); i++) {
                TicketType ticketType = ticketTypeRepository.findById(ticketTypeIds.get(i)).orElse(null);
                if (ticketType != null && ticketQuantities.get(i) > 0) {
                    for (int j = 0; j < ticketQuantities.get(i); j++) {
                        Ticket ticket = new Ticket();
                        ticket.setUsed(null);
                        ticket.setTicketType(ticketType);
                        ticketRepository.save(ticket);
                    }
                }
            }
        }
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

    @PostMapping("tickets/markUsed/{id}")
    public String markTicketAsUsed(@PathVariable("id") Long ticketId) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isPresent()) {
            Ticket ticket = optionalTicket.get();
            ticket.setUsed(LocalDateTime.now());
            ticketRepository.save(ticket);
        }
        return "redirect:/ticketlist";
    }

    // Päivitys

    @PostMapping("/tickets/update/{id}")
    public String updateTicket(@PathVariable("id") Long ticketId, @Valid @ModelAttribute Ticket updatedTicket,
            Model model) {
        Ticket ticket = ticketRepository.findById(ticketId).orElse(null);

        if (ticket == null) {
            return "error";
        }

        ticket.setUsed(updatedTicket.getUsed());

        ticketRepository.save(ticket);

        return "redirect:/ticketlist";
    }

}
