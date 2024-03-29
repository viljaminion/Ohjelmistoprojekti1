package ohjelmistoprojekti.ticketGuru.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ohjelmistoprojekti.ticketGuru.domain.AppUser;
import ohjelmistoprojekti.ticketGuru.domain.AppUserRepository;


@RestController
public class AppUserRestController {
	
	@Autowired
    private AppUserRepository appUserrepository;

	
//Kaikki tiedot JSON-muodossa
	
	
    @RequestMapping(value="/users", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<AppUser> UserListRest() {	
        return (List<AppUser>) appUserrepository.findAll();
    }    

//ID:n avulla haettavat tiedot tietystä myyjästä
    
    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<AppUser> findUserRest(@PathVariable("id") Long userid) {	
    	return appUserrepository.findById(userid);
    }
    
//Myyjän lisääminen Postmanissa
    
//@Valid annotaatio ennen @RequestBody annotaatiota mahdollistaa validoinnin

    @RequestMapping (value= "/users", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('ADMIN')")
    public AppUser addUser(@Valid @RequestBody AppUser user) {
         return appUserrepository.save(user);
            
}
    
//Myyjän poisto ID:llä Postmanissa
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userid) {
        Optional<AppUser> user = appUserrepository.findById(userid);
        if (user.isPresent()) {
            appUserrepository.deleteById(userid);
            return new ResponseEntity<>("User with ID " + user + " has been deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User with ID " + user + " not found.", HttpStatus.NOT_FOUND);
        }
    }
}