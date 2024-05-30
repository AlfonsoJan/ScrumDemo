package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Schip;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.service.SchipService;
import nl.woensdag.janbusker.service.UserStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStoryEndpoint {
    @Autowired
    private SchipService userStoryService;

    @GetMapping("getUserStory")
    public Iterable<Schip> getUserStory() {
        return userStoryService.allShips();
    }
}
