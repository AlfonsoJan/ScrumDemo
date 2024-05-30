package nl.woensdag.janbusker.repository;

import nl.woensdag.janbusker.model.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component()
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
