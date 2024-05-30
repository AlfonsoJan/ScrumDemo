package nl.woensdag.janbusker.view;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectsEndpoint {
    @GetMapping(value = "/")
    public void getAll() {

    }

    @GetMapping(value = "/{id}")
    public void getById(@PathVariable("id") String id) {

    }

    @PostMapping(value = "/")
    public void create() {

    }

    @GetMapping(value = "/{id}/userstories")
    public void getAllUserStories() {

    }

    @PostMapping(value = "/{id}/userstories")
    public void addUserStory() {

    }
}
