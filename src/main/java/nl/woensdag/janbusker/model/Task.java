package nl.woensdag.janbusker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id()
    @GeneratedValue
    public Long id;
}
