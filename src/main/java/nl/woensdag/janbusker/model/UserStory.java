package nl.woensdag.janbusker.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class UserStory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "userStory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> task;

    public UserStory() {

    }

    public UserStory(String title, String description, Project project) {
        this.title = title;
        this.description = description;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getProjectId() {
        return project.getId();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }
}
