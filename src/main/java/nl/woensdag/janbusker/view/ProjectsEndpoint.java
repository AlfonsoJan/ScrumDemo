package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Project;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.ProjectRepository;
import nl.woensdag.janbusker.repository.UserStoryRepository;
import nl.woensdag.janbusker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectsEndpoint {
    @Autowired
    public ProjectRepository projectRepository;

    @Autowired
    public ProjectService projectService;

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
    public Project create(@RequestBody CreateProjectRequest request) {
        return projectService.createProject(request.name, request.description);
    }

    @GetMapping(value = "/{id}/userstories")
    public Iterable<UserStory> getAllUserStories(@PathVariable("id") Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.<Iterable<UserStory>>map(Project::getUserStories).orElse(null);
    }

    @PostMapping(value = "/{id}/userstories")
    public UserStory addUserStory(@PathVariable("id") Long id, @RequestBody AddUserStoryRequest request) {
        return projectService.addUserStory(id, request.title, request.description);
    }
}
