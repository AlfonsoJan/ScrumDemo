package nl.woensdag.janbusker.repository;

import nl.woensdag.janbusker.model.UserStory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserStoryRepository extends CrudRepository<UserStory, Long> {
}
