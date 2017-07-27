package vom.imk.springBootUserService.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import vom.imk.springBootUserService.model.User;
import vom.imk.springBootUserService.repo.UserRepository;

@Component
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * ----- @Cacheable(value = "user") : save User as user in cashing
	 * 		* The first time spring call service to create user and save it in cashing
	 *      * The second time (and more) spring call only the controller because "user" is stored in cashing
	 * 
	 *  ----- @CacheEvict(value = "user", key = "#user.getId()")  delete the data from existing cache
	 *  	* Spring call always the service to create a new user
	 *  
	 */
	 @Cacheable(value = "user")
	// @CacheEvict annotation will be used to delete the data from existing cache.
	//@CacheEvict(value = "user", key = "#user.getId()")
	public User addUser(User user) {
		User result = null;
		if (!userRepository.exists(user.getId())) {
			logger.info("addUser service called ..." +user);
			result = this.userRepository.save(user);
		}
		return result;

	}

	@Cacheable(value = "user")
	public User getUser(Long id) {
		logger.info("getUser service called ..." +id);
		if(userRepository.exists(id)) {
			User user = userRepository.findOne(id);
			logger.info("getUser service called ... returned user : " +user);
			return user;
		}
		 
		return null;
	}
	
	@CachePut(value="user", key="#id")
	public User updateUser(Long id , User user) {
		User result = null;
		if (userRepository.exists(user.getId())) {
			result = this.userRepository.save(user);
		}
		return result;

	}
	
	@CacheEvict(value = "user", key = "#id")
	public boolean deleteUser(Long id) {
		logger.info("deleteUser service called ..." +id);
		boolean deleted = false;
		if (userRepository.exists(id)) {
			  this.userRepository.delete(id);
			  deleted = true;
		}
		return deleted;

	}

	

}
