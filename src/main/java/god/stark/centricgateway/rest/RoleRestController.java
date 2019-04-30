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

import god.stark.centricgateway.domain.Role;
import god.stark.centricgateway.service.RoleService;

/**
 * REST controller for managing Role.
 */
@RestController
@RequestMapping("/api")
public class RoleRestController {
	
	private RoleService roleService;
	
	@Autowired
	public RoleRestController(RoleService theRoleService) {
		roleService = theRoleService;
	}

    /**
     * GET  /roles : get all the roles.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of roles in body
     */
	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

    /**
     * GET  /roles/:roleId : get the "id" role.
     *
     * @param roleId the id of the role to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the role, or with status 404 (Not Found)
     */
	@GetMapping("/roles/{roleId}")
	public Role getRole(@PathVariable Long roleId) {
		Role theRole = roleService.findById(roleId);
		if(theRole == null) {
			throw new RuntimeException("Role ID not found - " + roleId);
		}
		return theRole;
	}

    /**
     * POST  /roles : Create a new role.
     *
     * @param theRole the role to create
     * @return the ResponseEntity with status 201 (Created) and with body the new role, or with status 400 (Bad Request) if the role has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PostMapping("/roles")
	public Role addRole(@RequestBody Role theRole) {
		// set id to 0
		theRole.setId(0L);
		// save the role
		roleService.save(theRole);
		// return the role
		return theRole;
	}

    /**
     * PUT  /roles : Updates an existing role.
     *
     * @param theRole the role to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated role,
     * or with status 400 (Bad Request) if the role is not valid,
     * or with status 500 (Internal Server Error) if the role couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
	@PutMapping("/roles")
	public Role updateRole(@RequestBody Role theRole) {
		roleService.save(theRole);
		return theRole;
	}

    /**
     * DELETE  /roles/:roleId : delete the "id" role.
     *
     * @param roleId the id of the role to delete
     * @return the ResponseEntity with status 200 (OK)
     */
	@DeleteMapping("/roles/{roleId}")
	public String deleteRole(@PathVariable Long roleId) {
		
		Role tempRole = roleService.findById(roleId);
		
		// throw exception if null
		
		if (tempRole == null) {
			throw new RuntimeException("Role id not found - " + roleId);
		}
		
		roleService.deleteById(roleId);
		
		return "Deleted role id - " + roleId;
	}

}
