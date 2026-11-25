
package com.example.keka.service;

// Import the Task model.
import com.example.keka.model.Task;

// Import the TaskRequest DTO.
import com.example.keka.model.TaskRequest;

// Import Spring's @Service annotation.
import org.springframework.stereotype.Service;

// Import AtomicLong for thread-safe ID generation.
import java.util.concurrent.atomic.AtomicLong;

// Import ConcurrentHashMap for thread-safe storage.
import java.util.concurrent.ConcurrentHashMap;

// Import Map interface.
import java.util.Map;

// Import exception used when a task does not exist.
import java.util.NoSuchElementException;

// Import logging classes.
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// @Service tells Spring that this class contains business logic.
// Spring creates and manages an instance of this class.
@Service
public class TaskService {

    // Creates a logger associated with this class.
    private static final Logger log =
            LoggerFactory.getLogger(TaskService.class);

    // Stores tasks as key-value pairs.
    // Key = Task ID, Value = Task object.
    private final Map<Long, Task> tasks = new ConcurrentHashMap<>();

    // Maintains the counter used to generate unique IDs.
    private final AtomicLong idCounter = new AtomicLong(0);

    // Creates a new task and stores it in memory.
    public Task createTask(TaskRequest request) {

        // Generate the next unique task ID.
        Long id = idCounter.incrementAndGet();

        // Create a Task object using the request data.
        // Every newly created task starts as incomplete.
        Task task = new Task(
                id,
                request.getTitle(),
                request.getDescription(),
                false
        );

        // Store the task using its ID as the key.
        tasks.put(id, task);

        // Print an informational log message.
        log.info("Task created successfully with ID: {}", id);

        // Return the newly created task.
        return task;
    }

    // Retrieves a task using its ID.
    public Task getTask(Long id) {

        // Search for the task using the supplied ID.
        Task task = tasks.get(id);

        // If no task exists with this ID, throw an exception.
        if (task == null) {
            log.warn("Task not found with ID: {}", id);

            throw new NoSuchElementException(
                    "Task not found with ID: " + id
            );
        }

        // Log successful retrieval.
        log.info("Task retrieved successfully with ID: {}", id);

        // Return the requested task.
        return task;
    }
}

