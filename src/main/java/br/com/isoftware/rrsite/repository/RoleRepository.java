package br.com.isoftware.rrsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.isoftware.rrsite.model.Role;
import br.com.isoftware.rrsite.model.enums.RoleName;

/**
 * Created by @author olivanaires on 11/05/2019.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
    Role findByName(RoleName roleName);
    
}
