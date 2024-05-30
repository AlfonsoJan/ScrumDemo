package nl.woensdag.janbusker.repository;

import nl.woensdag.janbusker.model.Task;
import nl.woensdag.janbusker.model.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component()
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
    Optional<Task> findTaskById(Long taskId);
}
