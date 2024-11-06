package dmi.ris.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dim.ris.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Integer>{

}
