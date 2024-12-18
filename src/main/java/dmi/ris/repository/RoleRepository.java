package dmi.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import dim.ris.model.Role;

@RepositoryRestResource(collectionResourceRel = "roles", path = "role")
public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
