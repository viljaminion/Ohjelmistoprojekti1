package ohjelmistoprojekti.ticketGuru;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ohjelmistoprojekti.ticketGuru.domain.User;
import ohjelmistoprojekti.ticketGuru.domain.UserRepository;

@SpringBootApplication
public class TicketGuruApplication {

	private static final Logger log = LoggerFactory.getLogger(TicketGuruApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TicketGuruApplication.class, args);
	}

	@Bean(name = "UserCommandLineRunner")
	public CommandLineRunner UserCommandLineRunner(UserRepository repository) {
		return (args) -> {
			User user1 = new User("user", "$2a$10$6KFw5bwNuXu1Mr80yXcglOCEI9cmSlQlSRJK.D6.XvKbaos5LC7By" , "USER"); //salasana user
			User user2 = new User("admin", "$2a$10$/U9C/cQ7sudkeFkJS7OUwOfbIoWEzQPLeMd7cI8RgSfxChyKkNeVu" , "ADMIN"); //salasana admin
			repository.save(user1);
			repository.save(user2);

			log.info("fetch * users");
			for (User user : repository.findAll()) {
				log.info(user.toString());
			}
		};
	}

}
