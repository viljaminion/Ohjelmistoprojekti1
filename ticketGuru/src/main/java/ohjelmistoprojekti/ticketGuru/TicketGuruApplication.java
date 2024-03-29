package ohjelmistoprojekti.ticketGuru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.ticketGuru.domain.AppUser;
import ohjelmistoprojekti.ticketGuru.domain.AppUserRepository;

@SpringBootApplication
public class TicketGuruApplication {

	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean(name = "UserCommandLineRunner")
	public CommandLineRunner UserCommandLineRunner(AppUserRepository repository) {
		return (args) -> {
			AppUser user1 = new AppUser("maija", "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By" , "USER", "Matti", "Meikäläinen",
			"Postiosoite 1A", "0441234567", "mattimeikalainen@gmail.com"); //salasana user
			AppUser user2 = new AppUser("mikko", "$2a$10$/U9C/cQ7sudkeFkJS7OUwOfbIoWEzQPLeMd7cI8RgSfxChyKkNeVu" , "ADMIN", "Matti", "Meikäläinen",
			"Postiosoite 1A", "0447654321", "meikalainenmatti@gmail.com"); //salasana admin
			repository.save(user1);
			repository.save(user2);

			log.info("fetch * users");
			for (AppUser user : repository.findAll()) {
				log.info(user.toString());
			}
		};
	}

}
