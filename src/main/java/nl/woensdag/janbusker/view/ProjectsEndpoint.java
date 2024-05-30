package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Project;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectsEndpoint {
    @Autowired
    public ProjectRepository projectRepository;

    @GetMapping(value = "/")
    public Iterable<Project> getAll() {
        return projectRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Project getById(@PathVariable("id") Long id) {
        var optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @PostMapping(value = "/")
    public void create() {

    }

    @GetMapping(value = "/{id}/userstories")
    public Iterable<UserStory> getAllUserStories(@PathVariable("id") Long id) {
        var optionalProject = projectRepository.findById(id);
        if (optionalProject.isEmpty())
            return null;

        return optionalProject.get().getUserStories();
    }

    @PostMapping(value = "/{id}/userstories")
    public void addUserStory() {

    }
}
