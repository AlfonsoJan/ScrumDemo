package nl.woensdag.janbusker.model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description = "";

    private boolean isCompleted = false;

    @ManyToOne
    private UserStory userStory;

    public Task() { }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public UserStory getUserStory() {
        return userStory;
    }

    public void setUserStory(UserStory userStory) {
        this.userStory = userStory;
    }
}
