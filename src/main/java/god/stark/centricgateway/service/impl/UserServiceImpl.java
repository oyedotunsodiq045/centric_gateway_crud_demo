/*
 * @author sodiq oyedotun stark
 */
package god.stark.centricgateway.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import god.stark.centricgateway.domain.User;
import god.stark.centricgateway.repository.UserRepository;
import god.stark.centricgateway.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl (UserRepository theUserRepository) {
		userRepository = theUserRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(Long theId) {
		Optional<User> result = userRepository.findById(theId);
		
		User theUser = null;
		if(result.isPresent()) {
			theUser = result.get();
		} else {
			throw new RuntimeException("Did not find User id : " + theId);
		}
		return theUser;
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(Long theId) {
		userRepository.deleteById(theId);
	}

}
