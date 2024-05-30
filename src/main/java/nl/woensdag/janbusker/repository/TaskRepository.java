package nl.woensdag.janbusker.repository;

import nl.woensdag.janbusker.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TaskRepository extends CrudRepository<Task, Long> {
}
