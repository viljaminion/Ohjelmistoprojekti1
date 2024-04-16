package ohjelmistoprojekti.ticketGuru.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.AppUser;
import ohjelmistoprojekti.ticketGuru.domain.AppUserRepository;
import ohjelmistoprojekti.ticketGuru.domain.TransactionRepository;

@Controller
public class AppUserController {

    @Autowired
    private AppUserRepository appUserRepository;
    
    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping("/appUserlist")
    public String appUserList(Model model) {
        model.addAttribute("appUsers", appUserRepository.findAll());
        return "appUserList";
    }

    @GetMapping("/appUsers/add")
    public String addAppUser(Model model) {
        model.addAttribute("AppUser", new AppUser());
        model.addAttribute("transactions", transactionRepository.findAll());
        return "addAppUser";
    }

    @PostMapping("/appUsers/save")
    public String saveAppUser(@Valid @ModelAttribute AppUser appUser, Model model) {
        appUserRepository.save(appUser);
        return "redirect:/appAppUserlist";
    }

    @GetMapping("/appUsers/edit/{id}")
	public String editAppUser(@PathVariable("id") Long id, Model model) {

        AppUser existingAppUser = appUserRepository.findById(id).orElse(null);
        
        if (existingAppUser != null) {
            model.addAttribute("AppUser", existingAppUser);
            return "editAppUser";
        } else {
            return "error";
        }
    }
    
    @PostMapping("/appUsers/edit/{id}")
    
    public String updateAppUser(@PathVariable("id") Long appUserid, @ModelAttribute AppUser updatedAppUser) {
        
    	AppUser existingAppUser = appUserRepository.findById(appUserid).orElse(null);
        
        if (existingAppUser != null) {
            existingAppUser.setUsername(updatedAppUser.getUsername());
            existingAppUser.setPasswordhash(updatedAppUser.getPasswordhash());
            existingAppUser.setRole(updatedAppUser.getRole());
            existingAppUser.setFirstname(updatedAppUser.getFirstname());
            existingAppUser.setSurname(updatedAppUser.getSurname());
            existingAppUser.setAddress(updatedAppUser.getAddress());
            existingAppUser.setPhone(updatedAppUser.getPhone());
            existingAppUser.setEmail(updatedAppUser.getEmail());
            
            
            appUserRepository.save(existingAppUser);
        }
        return "redirect:/appAppUserlist";
    }


	

    @GetMapping("/appAppUsers/delete/{id}")
    public String deleteAppUser(@PathVariable Long id) {
        appUserRepository.deleteById(id);
        return "redirect:/appAppUserlist";
    }

}