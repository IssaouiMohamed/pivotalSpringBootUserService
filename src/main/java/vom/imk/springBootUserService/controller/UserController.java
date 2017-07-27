package vom.imk.springBootUserService.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vom.imk.springBootUserService.model.User;
import vom.imk.springBootUserService.services.UserService;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Value("${welcome.message}")
	private String welcomeMessage;

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index() {
		return " ============ " + welcomeMessage + "!    ============== ";
	}

	@GetMapping("/getUserById/{id}")
	public ResponseEntity<Object> getUserById(@PathVariable Long id) {
		logger.info(" getUserById called ....");
		User user = userService.getUser(id);
		return user != null ? ResponseEntity.status(HttpStatus.OK).body(user)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOND !");
	}

	@PostMapping("/addUser")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		logger.info(" addUser called ....");

		if (user != null) {
			userService.addUser(user);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}

		return ResponseEntity.status(HttpStatus.CONFLICT).body("PROBLEM TO ADD USER !");

	}

	@GetMapping("/deleteUserById/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable Long id) {
		logger.info("deleteUserById called ....");
		boolean res = userService.deleteUser(id);
		return res ? ResponseEntity.status(HttpStatus.OK).body("USER DELETED !")
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT DELETED !");

	}

	@PostMapping("/updateUser")
	public ResponseEntity<Object> updateUser(@RequestBody User user) {
		logger.info("updateUser called ....");
		User res = userService.updateUser(user);
		return res != null ? ResponseEntity.status(HttpStatus.OK).body(user)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT UPDATED !");

	}

}
