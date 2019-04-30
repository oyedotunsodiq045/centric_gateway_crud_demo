/*
 * @author sodiq oyedotun stark
 */
package god.stark.centricgateway.service;

import java.util.List;

import god.stark.centricgateway.domain.User;

public interface UserService {
	
	public List<User> findAll();
	
	public User findById(Long theId);
	
	public void save(User theUser);
	
	public void deleteById(Long theId);

}
