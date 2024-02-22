package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ohjelmistoprojekti.ticketGuru.Classes.Event;
import ohjelmistoprojekti.ticketGuru.Classes.EventRepository;
import ohjelmistoprojekti.ticketGuru.Classes.PostalCodeRepository;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PostalCodeRepository postalCodeRepository;

    
//Listanäkymä
    
    @RequestMapping("/eventlist")
    public String eventList(Model model) {
        model.addAttribute("events", eventRepository.findAll());
        return "eventList";
    }
    
//Tapahtuman lisäys
    
    @GetMapping("/events/add")
    public String addEvent(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("postalCodes", postalCodeRepository.findAll());
        return "addEvent";
    }

//Tapahtuman tallennus H2:een (vaihtuu oikeaan tietokantaan myöhemmin)
    
    @PostMapping("/events/save")
    public String saveEvent(@ModelAttribute Event event, Model model) {
        eventRepository.save(event);
        return "redirect:/eventlist";
    }

//Tapahtuman poisto
    
    @GetMapping("/events/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
        return "redirect:/eventlist";
    }
    
    
//Tapahtuman muokkaus
    
    @GetMapping("/events/edit/{id}")
    public String editEvent(@PathVariable("id") Long eventid, Model model) {
    	
        Event existingEvent = eventRepository.findById(eventid).orElse(null);
        
        if (existingEvent != null) {
            model.addAttribute("event", existingEvent);
            model.addAttribute("postalCode", postalCodeRepository.findAll());
            return "editEvent";
        } else {
            return "error";
        }
    }

//Muokatun tapahtuman tallennus
    
    @PostMapping("/events/edit/{id}")
    public String updateEvent(@PathVariable("id") Long eventid, @ModelAttribute Event updatedEvent) {
        Event existingEvent = eventRepository.findById(eventid).orElse(null);
        
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
}
