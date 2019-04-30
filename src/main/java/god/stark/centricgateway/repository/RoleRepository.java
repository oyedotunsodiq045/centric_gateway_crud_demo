package god.stark.centricgateway.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import god.stark.centricgateway.domain.Role;
import god.stark.centricgateway.domain.enumeration.RoleName;

/**
 * Spring Data REST repository for the Role model.
 * 
 * @Repository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(RoleName roleName);

}
