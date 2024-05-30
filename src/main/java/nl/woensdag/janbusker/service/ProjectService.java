package nl.woensdag.janbusker.service;

import nl.woensdag.janbusker.model.Project;
import nl.woensdag.janbusker.model.UserStory;
import nl.woensdag.janbusker.repository.ProjectRepository;
import nl.woensdag.janbusker.repository.UserStoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserStoryRepository userStoryRepository;

    public Project createProject(String name, String description) {
        var project = new Project(name, description);
        projectRepository.save(project);
        return project;
    }

    public UserStory addUserStory(Long projectId, String title, String description) {
        var optionalProject = projectRepository.findById(projectId);
        if (optionalProject.isEmpty())
            return null;

        var project = optionalProject.get();

        var userStory = new UserStory(title, description, project);
        project.getUserStories().add(userStory);

        userStoryRepository.save(userStory);

        return userStory;
    }
}
