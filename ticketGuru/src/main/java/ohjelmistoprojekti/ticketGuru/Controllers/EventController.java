package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.Classes.Event;
import ohjelmistoprojekti.ticketGuru.Classes.EventRepository;
import ohjelmistoprojekti.ticketGuru.Classes.TicketType;
import ohjelmistoprojekti.ticketGuru.Classes.TicketTypeRepository;
@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    // Listanäkymä

    @RequestMapping("/eventlist")
    public String eventList(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "eventList";
    }

    // Tapahtuman lisäys

    @GetMapping("/events/add")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        return "addEvent";
    }

    // Tapahtuman tallennus H2:een (vaihtuu oikeaan tietokantaan myöhemmin)

    @PostMapping("/events/save")
    public String saveEvent(@Valid @ModelAttribute Event event, Model model) {
        
        eventRepository.save(event);
        return "redirect:/eventlist";
    }

    // Tapahtuman poisto

    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/eventlist";
    }

    // Tapahtuman muokkaus

    @GetMapping("/events/edit/{id}")
    public String editEvent(@PathVariable("id") Long eventId, Model model) {

        Event existingEvent = eventRepository.findById(eventId).orElse(null);

        if (existingEvent != null) {
            model.addAttribute("event", existingEvent);
            return "editEvent";
        } else {
            return "error";
        }
    }

    // Muokatun tapahtuman tallennus

    @PostMapping("/events/edit/{id}")
    public String updateEvent(@PathVariable("id") Long eventId, @ModelAttribute Event updatedEvent) {
        Event existingEvent = eventRepository.findById(eventId).orElse(null);

        if (existingEvent != null) {
            existingEvent.setEventname(updatedEvent.getEventname());
            existingEvent.setAddress(updatedEvent.getAddress());
            existingEvent.setShowtime(updatedEvent.getShowtime());
            existingEvent.setDescription(updatedEvent.getDescription());
            existingEvent.setMaxTickets(updatedEvent.getMaxTickets());
            existingEvent.setDuration(updatedEvent.getDuration());

            eventRepository.save(existingEvent);
        }
        return "redirect:/eventlist";
    }

	//Lipputyypin lisääminen

	@GetMapping("/events/{eventId}/addTicketType")
	public String addTicketType(@PathVariable Long eventId, Model model) {
    	model.addAttribute("eventId", eventId);
        model.addAttribute("ticketType", new TicketType());
        return "addTicketType";
}
	//Lipputyypin tallentaminen
	
	
	@PostMapping("/events/{eventId}/saveTicketType")
	public String saveTicketType(@PathVariable Long eventId, @ModelAttribute TicketType ticketType) {
	    Event event = eventRepository.findById(eventId).orElse(null);
	    if (event != null) {
	        ticketType.setEvent(event);
	        ticketTypeRepository.save(ticketType);
	        event.getTicketTypes().add(ticketType); 
	        eventRepository.save(event);
	    }
	    return "redirect:/eventlist";
	}





}
