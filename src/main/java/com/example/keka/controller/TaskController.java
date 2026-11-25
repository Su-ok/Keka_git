package com.example.keka.controller;

// Import the Task model.
import com.example.keka.model.Task;

// Import the TaskRequest DTO.
import com.example.keka.model.TaskRequest;

// Import the service layer.
import com.example.keka.service.TaskService;

// Import validation annotations.
import jakarta.validation.Valid;

// Import Spring HTTP status codes.
import org.springframework.http.HttpStatus;

// Import ResponseEntity to control HTTP responses.
import org.springframework.http.ResponseEntity;

// Import REST controller annotations.
import org.springframework.web.bind.annotation.*;

// @RestController marks this class as a REST API controller.
@RestController

// All endpoints in this class start with /tasks.
@RequestMapping("/tasks")
public class TaskController {

    // Reference to the service layer.
    private final TaskService taskService;

    // Constructor injection.
    // Spring automatically provides the TaskService object.
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Handles HTTP POST requests sent to /tasks.
    @PostMapping

    // @Valid triggers validation of the incoming request.
    // @RequestBody converts incoming JSON into TaskRequest.
    // ResponseEntity lets us specify the HTTP response status.
    public ResponseEntity<Task> createTask(
            @Valid @RequestBody TaskRequest request) {

        // Call the service layer to execute business logic.
        Task createdTask = taskService.createTask(request);

        // Return the created task with HTTP status 201 Created.
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdTask);
    }

    // Handles HTTP GET requests sent to /tasks/{id}.
    @GetMapping("/{id}")

    // @PathVariable extracts the ID from the URL.
    // Returns the requested Task with HTTP status 200 OK.
    public ResponseEntity<Task> getTask(@PathVariable Long id) {

        // Ask the service layer to retrieve the task.
        Task task = taskService.getTask(id);

        // Return the task with HTTP status 200 OK.
        return ResponseEntity.ok(task);
    }
}

