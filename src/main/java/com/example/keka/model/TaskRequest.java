
package com.example.keka.model;

// Import the annotation used to validate string fields.
import jakarta.validation.constraints.NotBlank;

// Represents the data received from the client
// when creating a new task.
public class TaskRequest {

    // @NotBlank ensures that the title is not null,
    // empty ("") or whitespace-only ("   ").
    // If validation fails, the specified message is returned.
    @NotBlank(message = "Task title cannot be empty")
    private String title;

    // Stores the description provided by the client.
    private String description;

    // Default constructor.
    // Allows an empty TaskRequest object to be created.
    public TaskRequest() {
    }

    // Parameterised constructor.
    // Allows us to initialise both fields while creating an object.
    public TaskRequest(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // Getter method: returns the task title.
    public String getTitle() {
        return title;
    }

    // Setter method: updates the task title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter method: returns the task description.
    public String getDescription() {
        return description;
    }

    // Setter method: updates the task description.
    public void setDescription(String description) {
        this.description = description;
    }
}
