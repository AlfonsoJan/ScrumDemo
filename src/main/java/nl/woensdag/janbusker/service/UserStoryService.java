package nl.woensdag.janbusker.service;

import nl.woensdag.janbusker.model.Task;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.UserStoryRepository;
import nl.woensdag.janbusker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserStoryService {
    @Autowired
    UserStoryRepository userStoryRepository;

    @Autowired
    TaskRepository taskRepository;

    public UserStory addTask(Long userStoryId, String description, boolean isCompleted) {
        Optional<UserStory> userStoryOptional = userStoryRepository.findById(userStoryId);
        if (userStoryOptional.isEmpty()) {
            return null;
        }
        UserStory userStory = userStoryOptional.get();
        Task task = new Task();
        task.setDescription(description);
        task.setCompleted(isCompleted);
        task.setUserStory(userStory);
        Task tasktemp = taskRepository.save(task);
        userStoryOptional.get().getTask().add(tasktemp);
        return userStoryRepository.save(userStoryOptional.get());
    }
}
