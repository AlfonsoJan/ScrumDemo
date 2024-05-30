package nl.woensdag.janbusker.view;

import nl.woensdag.janbusker.model.Project;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.ProjectRepository;
import nl.woensdag.janbusker.service.ProjectService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        var optionalProject = projectRepository.findById(id);
        if (optionalProject.isEmpty())
            return null;

        return optionalProject.get().getUserStories();
    }

    @PostMapping(value = "/{id}/userstories")
    public UserStory addUserStory(@PathVariable("id") Long id, @RequestBody AddUserStoryRequest request) {
        return projectService.addUserStory(id, request.title, request.description);
    }

    @GetMapping("test")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Project> test() {
        return projectRepository.findAllProjects();
    }
}
