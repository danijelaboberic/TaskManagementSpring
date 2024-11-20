package dmi.ris.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dim.ris.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

List<Project> findByDescriptionContaining(String query);
}
