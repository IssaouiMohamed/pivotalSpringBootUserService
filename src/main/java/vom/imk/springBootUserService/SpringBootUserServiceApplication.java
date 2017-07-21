package vom.imk.springBootUserService;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserServiceApplication.class, args);
	}
	
	/**
	 * CommandLineRunner :  used When you want to execute some piece of code exactly before the application startup completes, 
	 * @param userepository
	 * @return
	 */
	@Bean
	CommandLineRunner commandLineRunner (UserRepository userepository) {
		return (args) -> {
			userepository.save(Arrays.asList(new User("Issaoui","Mohamed"),
												new User("Ali","Med"),
												new User("Jack","Jack")));
		};
	}
	
	
}
