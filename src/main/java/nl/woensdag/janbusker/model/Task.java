package nl.woensdag.janbusker.model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id()
    @GeneratedValue
    public Long id;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;
}
