/*
 * @author sodiq oyedotun stark
 */
package god.stark.centricgateway.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import god.stark.centricgateway.domain.Role;
import god.stark.centricgateway.repository.RoleRepository;
import god.stark.centricgateway.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	private RoleRepository roleRepository;
	
	@Autowired
	public RoleServiceImpl (RoleRepository theRoleRepository) {
		roleRepository = theRoleRepository;
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long theId) {
		Optional<Role> result = roleRepository.findById(theId);
		
		Role theRole = null;
		if(result.isPresent()) {
			theRole = result.get();
		} else {
			throw new RuntimeException("Did not find Role id : " + theId);
		}
		return theRole;
	}

	@Override
	public void save(Role theRole) {
		roleRepository.save(theRole);
	}

	@Override
	public void deleteById(Long theId) {
		roleRepository.deleteById(theId);
	}

}
