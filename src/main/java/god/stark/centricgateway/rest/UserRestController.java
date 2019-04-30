/*
 * @author sodiq oyedotun stark
 */
package god.stark.centricgateway.rest;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import god.stark.centricgateway.domain.User;
import god.stark.centricgateway.service.UserService;

/**
 * REST controller for managing User.
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
	
	private UserService userService;
	
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}

    /**
     * GET  /users : get all the users.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of users in body
     */
	@GetMapping("/users")
	public List<User> findAll() {
		return userService.findAll();
	}

    /**
     * GET  /users/:userId : get the "id" user.
     *
     * @param userId the id of the user to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the user, or with status 404 (Not Found)
     */
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable Long userId) {
		User theUser = userService.findById(userId);
		if(theUser == null) {
			throw new RuntimeException("User ID not found - " + userId);
		}
		return theUser;
	}

    /**
     * POST  /users : Create a new user.
     *
     * @param theUser the user to create
     * @return the ResponseEntity with status 201 (Created) and with body the new user, or with status 400 (Bad Request) if the user has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		// set id to 0
		theUser.setId(0L);
		// save the user
		userService.save(theUser);
		// return the user
		return theUser;
	}

    /**
     * PUT  /users : Updates an existing user.
     *
     * @param theUser the user to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated user,
     * or with status 400 (Bad Request) if the user is not valid,
     * or with status 500 (Internal Server Error) if the user couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}

    /**
     * DELETE  /users/:userId : delete the "id" user.
     *
     * @param userId the id of the user to delete
     * @return the ResponseEntity with status 200 (OK)
     */
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		
		User tempUser = userService.findById(userId);
		
		// throw exception if null
		
		if (tempUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		
		return "Deleted User id - " + userId;
	}

}
