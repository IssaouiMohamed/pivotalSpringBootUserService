package com.imk.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.imk.demo.exception.MyException;
import com.imk.demo.model.Car;
import com.imk.demo.services.WelcomeService;

@RestController
public class DemoControler {

	@Autowired
	private WelcomeService services;
	
	
	 private static final Logger logger = LoggerFactory.getLogger(DemoControler.class);

	@RequestMapping("/")
	public String index() {
		return " ============ " + services.getWelcomeMessage() + "!    ============== ";
	}

	@GetMapping("getAll")
	public List<Car> getAllCars() {
		return services.getCarList();
	}

	@GetMapping("all")
	public ResponseEntity<List<Car>> getAll() {
		return new ResponseEntity<>(services.getCarList(), HttpStatus.ACCEPTED);
	}

	@GetMapping("getCarById/{id}")
	public ResponseEntity<?> getCarById(@PathVariable int id) { // we can use @PathVariable("id") int id
		{
			for (Car car : services.getCarList()) {
				if (car.getId() == id) {
					return ResponseEntity.status(HttpStatus.OK).body(car);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body("Car Id doesn't found !");
		}
	}

	/**
	 * Enter String value to call NumberFormatException global level See
	 * RestfulResponseExceptionHandler
	 * 
	 * @throws NumberFormatException
	 */
	@GetMapping("getMyCarById/{id}")
	public ResponseEntity<?> getMyCarById(@PathVariable int id) throws NumberFormatException {
		{

			for (Car car : services.getCarList()) {
				if (car.getId() == id) {
					return ResponseEntity.status(HttpStatus.OK).body(car);
				}
			}
			return ResponseEntity.status(HttpStatus.OK).body("Car Id doesn't found !");
		}
	}

	/**
	 * Enter String value to call NullPointerException global level See
	 * RestfulResponseExceptionHandler
	 * 
	 * @throws NulPointerException
	 */

	@GetMapping("callNPException")
	public ResponseEntity<?> callNPException() // we can add : throws NullPointerException
	{
		logger.info("callNPException method is called ......");
		Car car = null;
		return ResponseEntity.status(HttpStatus.OK).body(car.getBrand());
	}
	
	
	@GetMapping("callException")
	public ResponseEntity<Object>  callException() throws MyException 
	{
		logger.info("callException method is called ......");
		 
		 throw new MyException("blaaaaaaaabla exception");
		   
	}

	/**
	 * 
	 * The @RequestParam annotation binds a web request parameter (i.e. query
	 * string) to a method parameter in a controller. * To test it use this syntax:
	 * http://localhost:8080/test?id=65
	 */
	@GetMapping("test")
	public @ResponseBody ResponseEntity<?> test(@RequestParam int id) {

		return new ResponseEntity<>("RequestParam = " + id, HttpStatus.OK);
	}

}
