package ohjelmistoprojekti.ticketGuru.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ohjelmistoprojekti.ticketGuru.Classes.TicketType;
import ohjelmistoprojekti.ticketGuru.Classes.TicketTypeRepository;

@Controller
public class TicketTypeController {
    
    @Autowired
    private TicketTypeRepository ticketTypeRepository;

    //Listanäkymä
    
    @RequestMapping("/tickettypelist")
    public String ticketTypeList(Model model) {
        model.addAttribute("tickettypes", ticketTypeRepository.findAll());
        return "ticketTypeList";
    }

    //Lisäys
    
    @GetMapping("/tickettypes/add")
    public String addTicketType(Model model) {
        model.addAttribute("tickettype", new TicketType());
        return "addTicketType";
    }

    //Tallennus

    @PostMapping("/tickettypes/save")
    public String saveTicketType(@ModelAttribute TicketType ticketType, Model model) {
        ticketTypeRepository.save(ticketType);
        return "redirect:/tickettypelist";
    }

    //Poisto

    @GetMapping("/tickettypes/delete/{id}")
    public String deleteTicketType(@PathVariable Long tickettypeid) {
        ticketTypeRepository.deleteById(tickettypeid);
        return "redirect:/tickettypelist";
    }

    //Muokkaus

    @GetMapping("/editTicketType/{id}")
	public String editTicketType(@PathVariable("id") Long tickettypeid, Model model) {
		model.addAttribute("editTicketType", ticketTypeRepository.findById(tickettypeid));
		return "editTicketType"; 
	}
}