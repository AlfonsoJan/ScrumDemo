package nl.woensdag.janbusker.model;

import jakarta.persistence.*;

@Entity
public class UserStory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

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
}
