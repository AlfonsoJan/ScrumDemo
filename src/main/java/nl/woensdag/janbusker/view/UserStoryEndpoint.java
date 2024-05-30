package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userstories")
public class UserStoryEndpoint {
    @Autowired
    private UserStoryRepository userStoryRepository;

    @GetMapping(value = "/")
    public Iterable<UserStory> getAll() {
        return userStoryRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserStory getById(@PathVariable("id") Long id) {
        var optionalUserStory = userStoryRepository.findById(id);
        return optionalUserStory.orElse(null);
    }
}
