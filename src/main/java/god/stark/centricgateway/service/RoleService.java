/*
 * @author sodiq oyedotun stark
 */
package god.stark.centricgateway.service;

import java.util.List;

import god.stark.centricgateway.domain.Role;

public interface RoleService {
	
	public List<Role> findAll();
	
	public Role findById(Long theId);
	
	public void save(Role theRole);
	
	public void deleteById(Long theId);

}
