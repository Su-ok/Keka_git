package com.example.keka.model;

public class Task {
    // Unique identifier for every task.
    private Long id;

    // Title of the task.
    private String title;

    // Detailed description of the task.
    private String description;

    // Indicates whether the task is completed.
    private boolean completed;

    // Default constructor.
    public Task() {
    }

    // Constructor to initialise all four fields.
    public Task(Long id, String title, String description, boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    // Returns the task ID.
    public Long getId() {
        return id;
    }

    // Updates the task ID.
    public void setId(Long id) {
        this.id = id;
    }

    // Returns the task title.
    public String getTitle() {
        return title;
    }

    // Updates the task title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Returns the task description.
    public String getDescription() {
        return description;
    }

    // Updates the task description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Returns whether the task is completed.
    public boolean isCompleted() {
        return completed;
    }

    // Updates the completion status.
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
